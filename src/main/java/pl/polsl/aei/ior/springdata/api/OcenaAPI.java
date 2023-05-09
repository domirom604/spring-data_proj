package pl.polsl.aei.ior.springdata.api;

import org.springframework.beans.factory.annotation.Autowired;
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
}
