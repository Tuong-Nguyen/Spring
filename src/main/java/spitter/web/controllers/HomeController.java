package spitter.web.controllers;

import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spitter.web.models.AccountModel;
import org.springframework.web.bind.annotation.*;
import spitter.web.models.Course;
import spitter.web.services.CourseService;
import java.util.List;
import spitter.web.validators.CourseValidator;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by lnthao on 4/28/2017.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value="", method= RequestMethod.GET)
    public String index(@ModelAttribute("account") AccountModel account, Model model, HttpSession session){
        boolean isLogin = false;
        if(session.getAttribute("account") != null){
            account = (AccountModel)session.getAttribute("account");
            model.addAttribute("user", account.getName());
            isLogin = true;
        }
        model.addAttribute("isLogin", isLogin);
        return "home";
    }

}
