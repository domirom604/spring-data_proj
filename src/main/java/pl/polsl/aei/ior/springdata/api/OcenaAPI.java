package pl.polsl.aei.ior.springdata.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.aei.ior.springdata.entity.Ocena;
import pl.polsl.aei.ior.springdata.repository.OcenaRepository;

import java.util.List;

@RestController
@RequestMapping("/uczelnia/oceny")
public class OcenaAPI {

    @Autowired
    OcenaRepository ocenaRepository;

    //http://localhost:8083/uczelnia/oceny
    @GetMapping()
    List<Ocena> getAllOceny() {
        return ocenaRepository.findAll();
    }
    
    //http://localhost:8083/uczelnia/oceny/ocena/4/termin/1
    @GetMapping("/ocena/{ocena}/termin/{termin}")
    List<Ocena> getGradesByOcenaAndTermin(@PathVariable int ocena, @PathVariable int termin) {
        return ocenaRepository.findByOcenaAndTermin(ocena, termin);
    }

    //http://localhost:8083/uczelnia/oceny/distinct/ocena/4/or/termin/1
    @GetMapping("/distinct/ocena/{ocena}/or/termin/{termin}")
    List<Ocena> getDistinctGradesByOcenaAndTermin(@PathVariable int ocena, @PathVariable int termin) {
        return ocenaRepository.findDistinctByOcenaAndTermin(ocena, termin);
    }

    //http://localhost:8083/uczelnia/oceny/v2/ocena/3/termin/2?page=0&size=5&sort=id,DESC
    @GetMapping(value = "/v2/ocena/{ocena}/termin/{termin}", params = {"page", "size", "sort"})
    List<Ocena> getGradesByOcenaAndTerminWithPaginationAndSorting(@PathVariable int ocena,
                                                                       @PathVariable int termin,
                                                                       @RequestParam("page") int page,
                                                                       @RequestParam("size") int size,
                                                                       @RequestParam("sort") String sort) {

        SortBuilder sortBuilder = new SortBuilder(sort);
        Pageable pageable = PageRequest.of(page, size, sortBuilder.getSort());
        return ocenaRepository.findDistinctByOcenaAndTermin(ocena, termin, pageable);
    }

    //http://localhost:8083/uczelnia/oceny/nrPrzedPrefix/2
    @GetMapping("/nrPrzedPrefix/{nrPrzedPrefix}")
    List<Ocena> getGradesByNrPrzedmiotuPrefix(@PathVariable String nrPrzedPrefix) {
        nrPrzedPrefix = nrPrzedPrefix + "%";
        return ocenaRepository.findByNrPrzedmLikeIgnoreCase(nrPrzedPrefix);
    }
    
    //http://localhost:8083/uczelnia/oceny/ocena/4
    @GetMapping(value = "/ocena/{ocena}")
    List<Ocena> findGradesByQuery(@PathVariable int ocena) {
        return ocenaRepository.findGradesWhereOcenaGraterThan(ocena);
    }

    //Delete!!!
    //http://localhost:8083/uczelnia/oceny/deleteOcena/id/1
    @DeleteMapping(value = "/deleteOcena/id/{id}")
    void deleteOcenaById(@PathVariable int id) {
        ocenaRepository.deleteById(id);
    }
}
