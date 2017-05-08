package spitter.web.controllers;

import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spitter.web.models.AccountModel;
import spitter.web.services.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nttao on 5/4/2017.
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService service;

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public ModelAndView LoginPage(Model model) {
        ModelAndView view = new ModelAndView("account/login");
        AccountModel account = new AccountModel();
        model.addAttribute("account", account);
        return view;
    }

    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public ModelAndView RegisterPage(Model model) {
        ModelAndView view = new ModelAndView("account/register");
        AccountModel ac = new AccountModel();
        model.addAttribute("account", ac);
        return view;
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("account") AccountModel account, HttpSession session) {
        ModelAndView view = new ModelAndView();
        if(service.login(account)){
            session.setAttribute("user", account.getStrID());
            view.setViewName("redirect:../spitter/");
        }
        else{
            view.setViewName("account/login");
        }
        return view;
    }

    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("account") AccountModel account, HttpServletRequest request) {
        String strbirhtDay = request.getParameter("date") + "/" + request.getParameter("month") + "/" + request.getParameter("year");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ModelAndView view = new ModelAndView();
        try {
            Date date = (Date) df.parse(strbirhtDay);
            account.setdBirthDay(date);
            if (service.register(account)) {
                view.setViewName("account/login");
            } else {
                view.setViewName("account/register");
            }
            return view;
        }catch (Exception ex){
            view.setViewName("account/register");
            return view;
        }
    }
}
