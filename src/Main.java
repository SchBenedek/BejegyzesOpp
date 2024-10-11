import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Bejegyzes> lista1=new ArrayList<>();

        lista1.add(new Bejegyzes("Sjosfi", "Az emberek az erdőben"));
        lista1.add(new Bejegyzes("KISSBSajtok", "Sajtok világa"));

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Írj egy számot:");
        try {
            int szam = scanner.nextInt();

            for (int i = 0; i < szam; i++) {
                System.out.println("Egy bejegyzést");
                System.out.println("Szerző:");
                scanner.nextLine();
                String szer = scanner.nextLine();
                System.out.println("Tartalom:");
                String tart = scanner.nextLine();
                lista1.add(new Bejegyzes(szer, tart));
            }
        } catch (InputMismatchException e) {
            System.out.println("Egész számot adjon meg!");
        }

        String csvFile="bejegyzesek.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 2) {
                    String szerzo = data[0].trim();
                    String tartalom = data[1].trim();
                    lista1.add(new Bejegyzes(szerzo, tartalom));
                } else {
                    System.err.println("Invalid CSV format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        for(Bejegyzes bejegyzes:lista1){
            System.out.println(bejegyzes);
        }


        int likokSzama=(lista1.toArray().length)*20;
        Random random=new Random();
        int randomSzam=random.nextInt();
        for(Bejegyzes bejegyzes:lista1)
            {while (likokSzama>0)
                {
                    bejegyzes.like();
                    likokSzama--;
                }
            }
        System.out.println("Egy szöveget: ");
        String sor=scanner.nextLine();
        lista1.get(2).setTartalom(sor);

        for(Bejegyzes bejegyzes:lista1)
        {
            System.out.println(bejegyzes);
        }

        int legTobb=0;
        boolean igazE=false;
        int kisebb=0;
        for (Bejegyzes bejegyzes:lista1){
            if(bejegyzes.getLikok()>legTobb)
            {
                legTobb=bejegyzes.getLikok();
            }
            if(bejegyzes.getLikok()>35)
            {
                igazE=true;
            }
            if(bejegyzes.getLikok()<15)
            {
                kisebb++;
            }
        }
        System.out.println("Legtöbb like: "+legTobb+"\nVan-e: "+igazE+"\nKisebb mint15: "+kisebb);

        lista1.sort(Comparator.comparingInt(Bejegyzes::getLikok).reversed());
        for(Bejegyzes bejegyzes:lista1){
            System.out.println(bejegyzes);
        }
    }
}