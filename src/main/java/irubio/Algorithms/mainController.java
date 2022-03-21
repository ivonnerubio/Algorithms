package irubio.Algorithms;

import com.vaadin.flow.component.html.Main;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class mainController {
    @RequestMapping("/")
    public String start(){
        return "index";
    }

}
