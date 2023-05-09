package pl.polsl.aei.ior.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "studenci")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NR_STUD", nullable = false)
    private int nrStud;

    private String nazwisko;
    private Date dataUr;
    private String plec;

    @ManyToOne
    @JoinColumn(name = "NR_KIER")
    @JsonIgnore
    private Kierunek kierunek;

    @OneToMany(mappedBy = "student")
    private Set<Ocena> oceny = new HashSet<>();

    public Student() {
    }

    public Student(String nazwisko, String plec) {
        this.nazwisko = nazwisko;
        this.plec = plec;
    }

    @Override
    public String toString() {
        return ("Nazwisko: " + nazwisko + " " + "plec:" + plec);
    }

    public long getId() {
        return nrStud;
    }

    public void setId(int nrStud) {
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

    public Kierunek getKierunek() {
        return kierunek;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }

    public int getNrStud() {
        return nrStud;
    }

    public void setNrStud(int nrStud) {
        this.nrStud = nrStud;
    }

    public Set<Ocena> getOceny() {
        return oceny;
    }

    public void setOceny(Set<Ocena> oceny) {
        this.oceny = oceny;
    }

}
