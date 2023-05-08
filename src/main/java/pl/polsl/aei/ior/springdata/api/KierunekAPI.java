package pl.polsl.aei.ior.springdata.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.aei.ior.springdata.entity.Kierunek;
import pl.polsl.aei.ior.springdata.repository.KierunekRepository;
import pl.polsl.aei.ior.springdata.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/uczelnia")
public class KierunekAPI {

    @Autowired
    KierunekRepository kierunekRepository;
    @GetMapping("/kierunki")
    List<Kierunek> getAllKierunki() {
        return kierunekRepository.findAll();
    }
}
