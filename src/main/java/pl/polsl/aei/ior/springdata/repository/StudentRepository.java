package pl.polsl.aei.ior.springdata.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.aei.ior.springdata.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
