package pl.polsl.aei.ior.springdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uczelnia")
public class OcenaAPI {
     
    @GetMapping("/getOceny")
    String hello()
    {  
        return "Hello tutaj sa fajne oceny!!!";
    }
    
    @GetMapping("/delOcena")
    String delete()
    {  
        return "Usuwam ocene!!!";
    }
}
