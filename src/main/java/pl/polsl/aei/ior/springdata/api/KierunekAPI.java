package pl.polsl.aei.ior.springdata.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uczelnia")
public class KierunekAPI {
     
    @GetMapping("/getKierunki")
    String hello()
    {  
        return "Hello tu są kierunki stud!!!";
    }
    
    @GetMapping("/delKierunek")
    String delete()
    {  
        return "Usuwam kierunek stud!!!";
    }
}
