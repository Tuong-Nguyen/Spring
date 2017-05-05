package spitter.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lnthao on 4/28/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/spitter/", method= RequestMethod.GET)
    public String index(){
        return "home";
    }
}
