package pl.polsl.aei.ior.springdata;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="oceny")

public class Ocena {
    @Id long nrStud;
    private long nrPrzedmiotu;
    private Date dataZaliczenia;
    private int termin; 
    private boolean zalEgzaminu;
    private int ocena;
    
    public Ocena() {
    }
    
    public long getId() {
        return nrStud;
    }

    public void setId(long nrStud) {
        this.nrStud = nrStud;
    }

    public long getNrPrzedmiotu() {
        return nrPrzedmiotu;
    }

    public void setNrPrzedmiotu(long nrPrzedmiotu) {
        this.nrPrzedmiotu = nrPrzedmiotu;
    }

    public Date getDataZaliczenia() {
        return dataZaliczenia;
    }

    public void setDataZaliczenia(Date dataZaliczenia) {
        this.dataZaliczenia = dataZaliczenia;
    }

    
    public int getTermin() {
        return termin;
    }

    public void setTermin(int termin) {
        this.termin = termin;
    }
    
    public boolean getZalEgzaminu() {
        return zalEgzaminu;
    }

    public void setZalEgzaminu(boolean zalEgzaminu) {
        this.zalEgzaminu = zalEgzaminu;
    }
    
     public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
