package pl.polsl.aei.ior.springdata.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.aei.ior.springdata.entity.Kierunek;

import java.util.List;

public interface KierunekRepository extends JpaRepository<Kierunek, Long> {
    List<Kierunek> findAll();
    List<Kierunek> findByNazwaKierAndNrInst(String nazwaKier, int nrInst);
    List<Kierunek> findByNazwaKierAndNrInst(String nazwaKier, int nrInst, Pageable pageable);
    List<Kierunek> findByNazwaKierLikeIgnoreCase(String nazwaKierPrefix);
    @Query("SELECT k FROM Kierunek k WHERE LENGTH(nazwaKier) >= :length")
    List<Kierunek> findKierunkiWhereNameGreaterThan(@Param("length")int length);

    @Transactional
    void deleteById(int id);
}

