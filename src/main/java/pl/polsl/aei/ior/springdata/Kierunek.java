package pl.polsl.aei.ior.springdata;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="kierunki")

public class Kierunek {
    
    @Id long nrKierunku;
    @ManyToMany(
        cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
        name = "kierunki_studenci",
        joinColumns = @JoinColumn(name = "kierunki_id"),
        inverseJoinColumns = @JoinColumn(name = "studenci_id")
    )
    private Set<Student> studenci = new HashSet<>();
    
    private String nazwaKierunku;
    private long nrInstytucji; 
    
    public Kierunek() {
    }
    public Set<Student> getStudenci() {
        return studenci;
    }

    public void setStudenci(Set<Student> studenci) {
        this.studenci = studenci;
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
