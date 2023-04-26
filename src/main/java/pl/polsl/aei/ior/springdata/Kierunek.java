package pl.polsl.aei.ior.springdata;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="kierunki")

public class Kierunek {
    @Id long nrKierunku;
    private String nazwaKierunku;
    private long nrInstytucji; 
    
    public Kierunek() {
    }
    
    public long getId() {
        return nrKierunku;
    }

    public void setId(long nrKierunku) {
        this.nrKierunku = nrKierunku;
    }
    
    public String getNazwaKierunku() {
        return nazwaKierunku;
    }

    public void setNazwaKierunku(String nazwaKierunku) {
        this.nazwaKierunku = nazwaKierunku;
    }
    
    public long getNrInstytucji() {
        return nrInstytucji;
    }

    public void setNrInstytucji(long nrInstytucji) {
        this.nrInstytucji = nrInstytucji;
    }
}
