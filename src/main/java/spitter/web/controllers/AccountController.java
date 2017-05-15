package spitter.web.controllers;

import com.sun.tracing.dtrace.ModuleAttributes;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import spitter.web.models.AccountModel;
import spitter.web.models.EncrollStatus;
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
    public String LoginPage(Model model) {
        return "account/login";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public String RegisterPage(Model model) {
        return "account/register";
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public String login(@ModelAttribute("account") AccountModel account, HttpSession session) {
        if (service.login(account)) {
            session.setAttribute("account", account);
            return "redirect: /spitter/";
        } else {
            return "/account/login";
        }
    }

    @RequestMapping(value = "/logout/", method = RequestMethod.GET)
    public String logout(Model model,SessionStatus status, HttpSession session) {
        session.removeAttribute("account");
        status.setComplete();
        return "redirect:../spitter/";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    public String register(@ModelAttribute("account") AccountModel account, HttpServletRequest request, SessionStatus status) {
        String strbirhtDay = request.getParameter("date") + "/" + request.getParameter("month") + "/" + request.getParameter("year");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = (Date) df.parse(strbirhtDay);
            account.setBirthDay(date);
            if (service.register(account)) {
                status.setComplete();
                return "redirect: /login/";
            } else {
                return "account/register";
            }
        } catch (Exception ex) {
            return "account/register";
        }
    }

    @RequestMapping(value = "/user/profile/", method = RequestMethod.GET)
    public String getUserProfile(@ModelAttribute("account") AccountModel account, Model model){
        if(account == null || account.getID() == null)
            return "redirect: ../spitter/";
        account.setListCourse(service.getUserCourseRegister(account));
        model.addAttribute("statuses", EncrollStatus.values());
        return "account/userprofile";
    }

    @RequestMapping(value = "/user/profile/", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("account") AccountModel account, HttpServletRequest request, HttpSession session, SessionStatus status){
        boolean isPWChange = false;
        String strCurrentPass = request.getParameter("strCurrentPass");
        String strNewPass = request.getParameter("strNewPass");
        String strRetypeNewPass = request.getParameter("strRetypeNewPass");
        if(strCurrentPass.equals(account.getPass()) && strNewPass.equals(strRetypeNewPass)) {
            account.setPass(strNewPass);
            isPWChange = true;
        }
        String strbirhtDay = request.getParameter("date") + "/" + request.getParameter("month") + "/" + request.getParameter("year");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ModelAndView view = new ModelAndView();
        try {
            Date date = (Date) df.parse(strbirhtDay);
            account.setBirthDay(date);
        }catch (Exception ex){

        }
        if(service.updateUserProfile(account) == true){
            if(isPWChange){
                session.removeAttribute("account");
                status.setComplete();
                return "redirect: /login/";
            }
            return "redirect: /user/profile/";
        }
        return "redirect: /user/profile/";
    }
}