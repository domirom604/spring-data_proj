package pl.polsl.aei.ior.springdata.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.polsl.aei.ior.springdata.entity.Kierunek;
import pl.polsl.aei.ior.springdata.repository.KierunekRepository;

import java.util.List;

@RestController
@RequestMapping("/uczelnia/kierunki")
public class KierunekAPI {

    @Autowired
    KierunekRepository kierunekRepository;

    //http://localhost:8083/uczelnia/kierunki
    @GetMapping()
    List<Kierunek> getAllKierunki() {
        return kierunekRepository.findAll();
    }

    //http://localhost:8083/uczelnia/kierunki/nazwaKierunku/EUC/nrInstytutu/3
    @GetMapping("/nazwaKierunku/{nazwaKier}/nrInstytutu/{nrInst}")
    List<Kierunek> getKierunekByNazwaKierAndNrInst(@PathVariable String nazwaKier, @PathVariable int nrInst) {
        return kierunekRepository.findByNazwaKierAndNrInst(nazwaKier, nrInst);
    }

    //http://localhost:8083/uczelnia/kierunki/v2/nazwaKierunku/EUC/nrInstytutu/3?page=0&size=5&sort=studenci.id,ASC
    @GetMapping(value = "/v2/nazwaKierunku/{nazwaKier}/nrInstytutu/{nrInst}", params = {"page", "size", "sort"})
    List<Kierunek> getKierunekByNazwaKierAndNrInstWithPaginationAndSorting(@PathVariable String nazwaKier,
                                                                           @PathVariable int nrInst,
                                                                           @RequestParam("page") int page,
                                                                           @RequestParam("size") int size,
                                                                           @RequestParam("sort") String sort) {
        SortBuilder sortBuilder = new SortBuilder(sort);
        Pageable pageable = PageRequest.of(page, size, sortBuilder.getSort());
        return kierunekRepository.findByNazwaKierAndNrInst(nazwaKier, nrInst, pageable);
    }

    //http://localhost:8083/uczelnia/kierunki/nazwaKierPrefix/OPROGR
    @GetMapping("/nazwaKierPrefix/{nazwaKierPrefix}")
    List<Kierunek> getKierunekByNazwaKierPrefix(@PathVariable String nazwaKierPrefix){
        nazwaKierPrefix = nazwaKierPrefix + "%";
        return kierunekRepository.findByNazwaKierLikeIgnoreCase(nazwaKierPrefix);
    }

    @GetMapping("/kierunekGratherThan/{length}")
    List<Kierunek> getKierunkiWhereNameGreaterThan(@PathVariable int length){
        return kierunekRepository.findKierunkiWhereNameGreaterThan(length);
    }

    //Delete!!!
    //http://localhost:8083/uczelnia/kierunki/deleteKierunekById/id/1
    @DeleteMapping(value = "/deleteKierunekById/id/{id}")
    void deleteKierunekById(@PathVariable int id) {
        kierunekRepository.deleteById(id);
    }

}
