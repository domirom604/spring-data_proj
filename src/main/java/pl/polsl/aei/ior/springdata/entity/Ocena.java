package pl.polsl.aei.ior.springdata.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="oceny")

public class Ocena {
    @Id long nrStud;
    @ManyToMany(
        cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
        name = "oceny_studenci",
        joinColumns = @JoinColumn(name = "oceny_id"),
        inverseJoinColumns = @JoinColumn(name = "studenci_id")
    )
    private Set<Student> studenci = new HashSet<>();
    
    private long nrPrzedmiotu;
    private Date dataZaliczenia;
    private int termin; 
    private boolean zalEgzaminu;
    private int ocena;
    
    public Ocena() {
    }
    
    public Set<Student> getStudenci() {
        return studenci;
    }

    public void setStudenci(Set<Student> studenci) {
        this.studenci = studenci;
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
