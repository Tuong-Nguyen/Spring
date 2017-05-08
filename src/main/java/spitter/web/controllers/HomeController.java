package spitter.web.controllers;

import com.sun.webkit.Timer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by lnthao on 4/28/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/spitter/", method= RequestMethod.GET)
    public String index(Model model, HttpSession session){
        String welcome = "Spitter";
        if(session.getAttribute("user") != null) {
            welcome = session.getAttribute("user").toString();
        }
        model.addAttribute("welcome", welcome);
        return "home";
    }
}
