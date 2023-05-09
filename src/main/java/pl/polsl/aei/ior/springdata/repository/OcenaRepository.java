package pl.polsl.aei.ior.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.aei.ior.springdata.entity.Ocena;

import java.util.List;

public interface OcenaRepository extends JpaRepository<Ocena, Long> {
    List<Ocena> findAll();
}

