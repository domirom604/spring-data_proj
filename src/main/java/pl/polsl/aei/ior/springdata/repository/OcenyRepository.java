package pl.polsl.aei.ior.springdata.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.aei.ior.springdata.entity.Ocena;

public interface OcenyRepository extends JpaRepository<Ocena, Long>{
    
}

