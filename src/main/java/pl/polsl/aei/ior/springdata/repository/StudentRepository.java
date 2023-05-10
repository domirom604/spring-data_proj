package pl.polsl.aei.ior.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.aei.ior.springdata.entity.Student;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll();

    List<Student> findByNazwiskoAndPlec(String nazwisko, String plec);

    List<Student> findDistinctByNazwiskoAndPlec(String nazwisko, String plec);

    List<Student> findDistinctByNazwiskoAndPlec(String nazwisko, String plec, Pageable pageable);

    List<Student> findByNazwiskoLikeIgnoreCase(String nazwiskoPrefix);
    
    @Query("SELECT s FROM Student s WHERE LENGTH(s.nazwisko) >= :length")
    List<Student> findStudentsWhereNameGraterThan(@Param("length") int length);

    @Transactional
    void deleteById(int id);
}
