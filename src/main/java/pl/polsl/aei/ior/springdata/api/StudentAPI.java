package pl.polsl.aei.ior.springdata.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uczelnia")
public class StudentAPI {
     
    @GetMapping("/getStudenci")
    String hello()
    {  
        return "Hello tutaj sa studenci!!!";
    }
    
    @GetMapping("/delStudent")
    String delete()
    {  
        return "Usuwam studenta!!!";
    }
}
