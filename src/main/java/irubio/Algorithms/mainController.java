package irubio.Algorithms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class mainController {
    private String name;

    public mainController(String name) {
        this.name = name;
    }

    @RequestMapping("/cont")
    public String example(){
        return "main";
    }

    public String testIvonne(){
        return "hello world, this is html";
    }

}
