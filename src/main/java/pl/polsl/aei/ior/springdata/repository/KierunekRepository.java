package pl.polsl.aei.ior.springdata.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.aei.ior.springdata.entity.Kierunek;

public interface KierunekRepository extends JpaRepository<Kierunek, Long>{
    
}

