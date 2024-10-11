import java.time.LocalDateTime;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private Integer likok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }

    public String getSzerzo() {
        return this.szerzo;
    }

    public String getTartalom() {
        return this.tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }

    public Integer getLikok() {
        return likok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }
    public void like(){
        this.likok++;
    }

    @Override
    public String toString() {
        return this.szerzo+" - "+this.likok+" - "+this.letrejott.toString()+"\nSzerkesztve: "+this.szerkesztve.toString()+"\n"+this.tartalom;
    }
}
