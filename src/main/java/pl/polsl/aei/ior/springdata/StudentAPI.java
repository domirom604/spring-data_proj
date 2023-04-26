package pl.polsl.aei.ior.springdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentAPI {
     
    @GetMapping("/getStud")
    String hello()
    {  
        return "Hello tutaj sa studenci!!!";
    }
}
