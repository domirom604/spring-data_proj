package pl.polsl.aei.ior.springdata.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.polsl.aei.ior.springdata.entity.Student;
import pl.polsl.aei.ior.springdata.repository.StudentRepository;


import java.util.List;

@RestController
@RequestMapping("/uczelnia/studenci")
public class StudentAPI {

    @Autowired
    StudentRepository studentRepository;

    //http://localhost:8083/studenci
    @GetMapping()
    List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //http://localhost:8083/uczelnia/studenci/nazwisko/Marczak/plec/M
    @GetMapping("/nazwisko/{nazwisko}/plec/{plec}")
    List<Student> getStudentsByNazwiskoAndPlec(@PathVariable String nazwisko, @PathVariable String plec) {
        return studentRepository.findByNazwiskoAndPlec(nazwisko, plec);
    }

    //http://localhost:8083/uczelnia/studenci/distinct/nazwisko/Marczak/or/plec/M
    @GetMapping("distinct/nazwisko/{nazwisko}/or/plec/{plec}")
    List<Student> getDistinctStudentsByNazwiskoAndPlec(@PathVariable String nazwisko, @PathVariable String plec) {
        return studentRepository.findDistinctByNazwiskoAndPlec(nazwisko, plec);
    }

    //http://localhost:8083/uczelnia/studenci/v2/nazwisko/MILIONER/plec/K?page=0&size=5&sort=id,DESC
    @GetMapping(value = "v2/nazwisko/{nazwisko}/plec/{plec}", params = {"page", "size", "sort"})
    List<Student> getStudentsByNazwiskoAndPlecWithPaginationAndSorting(@PathVariable String nazwisko,
                                                                       @PathVariable String plec,
                                                                       @RequestParam("page") int page,
                                                                       @RequestParam("size") int size,
                                                                       @RequestParam("sort") String sort) {

        SortBuilder sortBuilder = new SortBuilder(sort);
        Pageable pageable = PageRequest.of(page, size, sortBuilder.getSort());
        return studentRepository.findDistinctByNazwiskoAndPlec(nazwisko, plec, pageable);
    }

    //http://localhost:8083/uczelnia/studenci/nazwiskoPrefix/MI
    @GetMapping("nazwiskoPrefix/{nazwiskoPrefix}")
    List<Student> getStudentsByNazwiskoPrefix(@PathVariable String nazwiskoPrefix) {
        nazwiskoPrefix = nazwiskoPrefix + "%";
        return studentRepository.findByNazwiskoLikeIgnoreCase(nazwiskoPrefix);
    }

}
