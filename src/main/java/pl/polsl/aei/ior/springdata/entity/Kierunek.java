package pl.polsl.aei.ior.springdata.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "kierunki")

public class Kierunek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NR_KIER", nullable = false)
    private int id;

    @OneToMany(mappedBy = "kierunek")
    private Set<Student> studenci = new HashSet<>();

    private String nazwaKier;
    private int nrInst;

    public Kierunek() {
    }

    public Set<Student> getStudenci() {
        return studenci;
    }

    public void setStudenci(Set<Student> studenci) {
        this.studenci = studenci;
    }

    public String getNazwaKier() {
        return nazwaKier;
    }

    public void setNazwaKier(String nazwaKier) {
        this.nazwaKier = nazwaKier;
    }

    public long getNrInstytucji() {
        return nrInst;
    }

    public void setNrInst(int nrInst) {
        this.nrInst = nrInst;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return ("nr_kier: " + id + " "
                + "nazwa kierunku: " + nazwaKier + " "
                + "studenci: " + studenci);
    }
}
