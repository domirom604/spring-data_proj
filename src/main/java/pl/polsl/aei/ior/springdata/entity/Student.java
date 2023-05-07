package pl.polsl.aei.ior.springdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="studenci")
public class Student {

    @Id long nrStud;
    private String nazwisko;
    private Date dataUr;
    private String plec;
    private long nrKier; 
    
    @ManyToMany(mappedBy = "studenci")
    private Set<Kierunek> kierunki = new HashSet<>();
    
    @ManyToMany(mappedBy = "studenci")
    private Set<Ocena> oceny = new HashSet<>();
    
    public Student() {
    }

    public Student(String nazwisko, Date dataUr, String plec, long nrKier) {
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
        this.plec = plec;
        this.nrKier = nrKier;
    }
    
    public Set<Kierunek> getKierunki() {
        return kierunki;
    }

    public void setKierunki(Set<Kierunek> kierunki) {
        this.kierunki = kierunki;
    }
    
     public Set<Ocena> getOceny() {
        return oceny;
    }

    public void setOceny(Set<Ocena> oceny) {
        this.oceny = oceny;
    }
    @Override
    public String toString() {
        return ("Nazwisko: "+ nazwisko  + " " + "plec:" + plec + " " + "numer kierunku:" + nrKier + "/");
    }

    public long getId() {
        return nrStud;
    }

    public void setId(long nrStud) {
        this.nrStud = nrStud;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getDataUr() {
        return dataUr;
    }

    public void setDataUr(Date dataUr) {
        this.dataUr = dataUr;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String street) {
        this.plec = plec;
    }
    
    public long getNrKierunku() {
        return nrKier;
    }

    public void setNrKierunku(String country) {
        this.nrKier = nrKier;
    }
}
