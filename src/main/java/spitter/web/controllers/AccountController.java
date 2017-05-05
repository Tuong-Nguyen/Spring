package spitter.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nttao on 5/4/2017.
 */
@Controller
public class AccountController {
    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public ModelAndView LoginPage() {
        ModelAndView view = new ModelAndView("account/login");
        return view;
    }

    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public ModelAndView RegisterPage() {
        ModelAndView view = new ModelAndView("account/register");
        return view;
    }

}
