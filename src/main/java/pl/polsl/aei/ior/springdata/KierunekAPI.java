package pl.polsl.aei.ior.springdata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kierunki")
public class KierunekAPI {
     
    @GetMapping("/getKierunki")
    String hello()
    {  
        return "Hello tsą kierunki stud!!!";
    }
}
