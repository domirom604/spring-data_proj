package pl.polsl.aei.ior.springdata;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studenci")
public class Student {

    @Id long id;
    
    
}
