package pl.polsl.aei.ior.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.aei.ior.springdata.entity.Ocena;

import java.util.List;
import org.springframework.data.domain.Pageable;


public interface OcenaRepository extends JpaRepository<Ocena, Long> {
    List<Ocena> findAll();

    List<Ocena> findByOcenaAndTermin(int ocena, int termin);

    List<Ocena> findDistinctByOcenaAndTermin(int ocena, int termin);

    List<Ocena> findDistinctByOcenaAndTermin(int ocena, int termin, Pageable pageable);

    List<Ocena> findByNrPrzedmLikeIgnoreCase(String nrPrzedPrefix);
    
    @Query("SELECT o FROM Ocena o WHERE o.ocena >= :ocena")
    List<Ocena> findGradesWhereOcenaGraterThan(@Param("ocena") int ocena);

    @Transactional
    void deleteById(int id);
}

