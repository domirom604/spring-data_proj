package pl.polsl.aei.ior.springdata;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="studenci")
public class Student {

    @Id long nrStud;
    private String nazwisko;
    private Date dataUr;
    private String plec;
    private long nrKier; 
    
    public Student() {
    }

    public Student(String nazwisko, Date dataUr, String plec, long nrKier) {
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
        this.plec = plec;
        this.nrKier = nrKier;
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
