package spitter.web.controllers;

import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import spitter.web.models.AccountModel;
import spitter.web.services.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nttao on 5/4/2017.
 */
@Controller
@SessionAttributes("account")
public class AccountController {
    @Autowired
    private AccountService service;

    @ModelAttribute("account")
    public AccountModel getAccount(){
        return new AccountModel();
    }

    @ModelAttribute("gender")
    public List<String> getGender(){
        List<String> gender = new LinkedList<String>(Arrays.asList(new String[]{"Male", "FeMale"}));
        return gender;
    }


    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public ModelAndView LoginPage(Model model) {
        ModelAndView view = new ModelAndView("account/login");
        return view;
    }

    @RequestMapping(value = "/logout/", method = RequestMethod.GET)
    public String logout(Model model,SessionStatus session) {
        session.setComplete();
        return "redirect:../spitter/";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public ModelAndView RegisterPage(Model model) {
        ModelAndView view = new ModelAndView("account/register");
        return view;
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public String login(@ModelAttribute("account") AccountModel account) {
        ModelAndView view = new ModelAndView();
        if (service.login(account)) {
            return "redirect: /spitter/";
        } else {
            return "/account/login";
        }
    }

    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("account") AccountModel account, HttpServletRequest request, SessionStatus status) {
        String strbirhtDay = request.getParameter("date") + "/" + request.getParameter("month") + "/" + request.getParameter("year");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ModelAndView view = new ModelAndView();
        try {
            Date date = (Date) df.parse(strbirhtDay);
            account.setdBirthDay(date);
            if (service.register(account)) {
                view.setViewName("redirect: /login/");
            } else {
                view.setViewName("account/register");
            }
            status.setComplete();
            return view;
        } catch (Exception ex) {
            view.setViewName("account/register");
            return view;
        }
    }

    @RequestMapping(value = "/profile/", method = RequestMethod.GET)
    public String getUserProfile(@ModelAttribute("account") AccountModel account){
        return "account/userprofile";
    }
}