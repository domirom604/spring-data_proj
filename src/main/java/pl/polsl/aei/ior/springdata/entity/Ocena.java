package pl.polsl.aei.ior.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "oceny")

public class Ocena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "NR_STUD")
    @JsonIgnore
    private Student student;

    private String nrPrzedm;
    private Date dataZal;
    private int termin;
    private boolean zalEgz;
    private int ocena;

    public Ocena() {
    }

    public String getNrPrzedm() {
        return nrPrzedm;
    }

    public void setNrPrzedm(String nrPrzedm) {
        this.nrPrzedm = nrPrzedm;
    }

    public Date getDataZal() {
        return dataZal;
    }

    public void setDataZal(Date dataZal) {
        this.dataZal = dataZal;
    }


    public int getTermin() {
        return termin;
    }

    public void setTermin(int termin) {
        this.termin = termin;
    }

    public boolean getZalEgz() {
        return zalEgz;
    }

    public void setZalEgz(boolean zalEgz) {
        this.zalEgz = zalEgz;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
