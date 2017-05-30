package spitter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spitter.web.ExceptionHandler.PageNotFoundExceprtion;
import spitter.web.models.Account;
import spitter.web.models.EnrollStatus;
import spitter.web.services.AccountService;
import spitter.web.validators.AccountValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by nttao on 5/4/2017.
 */
@Controller
@SessionAttributes("account")
public class AccountController {
    @Autowired
    private AccountService service;


    @ModelAttribute("account")
    public Account getAccount(){
        return new Account();
    }

    @ModelAttribute("gender")
    public List<String> getGender(){
        List<String> gender = new LinkedList<String>(Arrays.asList(new String[]{"Male", "FeMale"}));
        return gender;
    }

    @ExceptionHandler(NullPointerException.class)
    public String exceptionControl(){
        return "exceptions/controllerExceptionHandler";
    }

//    @ExceptionHandler(Exception.class)
//    public String exceptionControl1(){
//        return "exceptions/controllerExceptionHandler";
//    }

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public String LoginPage() {
        return "account/login";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public String RegisterPage() {
        return "account/register";
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public String login(@ModelAttribute("account") Account account, HttpSession session, RedirectAttributes redirectAttributes) {
        if (service.login(account)) {
            session.setAttribute("account", account);
            return "redirect: /courses";
        } else {
            return "/account/login";
        }
    }

    @RequestMapping(value = "/logout/", method = RequestMethod.GET)
    public String logout(Model model,SessionStatus status, HttpSession session) {
        session.removeAttribute("account");
        status.setComplete();
        return "redirect:../courses";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("account") Account account, BindingResult result, HttpServletRequest request, SessionStatus status) {
        //new AccountValidator().validate(account, result); //use with validate annotation
        if(result.hasErrors()){
            return "account/register";
        }
        String strbirhtDay = request.getParameter("date") + "/" + request.getParameter("month") + "/" + request.getParameter("year");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = (Date) df.parse(strbirhtDay);
            account.setBirthDay(date);
            new AccountValidator().validate(account, result);
            if (service.register(account)) {
                status.setComplete();
                return "redirect: /login/";
            } else {
                return "account/register";
            }
        } catch (Exception ex) {
            throw new RuntimeException("datetime get error");
            //return "account/register";
        }
    }

    @RequestMapping(value = "/user/profile/{id}", method = RequestMethod.GET)
    public String getUserProfile(@ModelAttribute("account") Account account, @PathVariable("id") String id, Model model){
        account = service.getUserProfile(id);
        if(account == null || account.getId() == null)
            throw new RuntimeException();
        model.addAttribute("statuses", EnrollStatus.values());
        return "account/userprofile";
    }

//    @RequestMapping(value = "/user/profile/{id}", method = RequestMethod.GET)
//    public @ResponseBody Account getUserProfile(@ModelAttribute("account") Account account, @PathVariable("id") String id, Model model){
//        account = service.getUserProfile(id);
//        if(account == null || account.getId() == null)
//            throw new RuntimeException();
//        return account;
//    }

    @RequestMapping(value = "/user/profile/", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("account") Account account, HttpServletRequest request, HttpSession session, SessionStatus status){
        boolean isPWChange = false;
        String currentPass = request.getParameter("CurrentPass");
        String newPass = request.getParameter("NewPass");
        String retypeNewPass = request.getParameter("RetypeNewPass");
        if(currentPass.equals(account.getPass()) && newPass.equals(retypeNewPass)) {
            account.setPass(newPass);
            isPWChange = true;
        }
//        String strbirhtDay = request.getParameter("date") + "/" + request.getParameter("month") + "/" + request.getParameter("year");
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        ModelAndView view = new ModelAndView();
//        try {
//            Date date = (Date) df.parse(strbirhtDay);
//            account.setBirthDay(date);
//        }catch (Exception ex){
//            throw new RuntimeException();
//        }
        if(service.updateUserProfile(account) == true){
            if(isPWChange){
                session.removeAttribute("account");
                status.setComplete();
                return "redirect: /login/";
            }
            return ("redirect: /user/profile/" + account.getId() + "");
        }
        return "redirect: /user/profile/";
    }
    @RequestMapping(value = "/file/upload/", method = RequestMethod.POST)
    @ResponseBody
    public String updateProfile(@RequestParam("file")MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return file.getOriginalFilename();
    }


//    @InitBinder //Ignore the validation annotation
//    public void initBinder(WebDataBinder binder){
//        binder.setValidator(new AccountValidator());
//    }
}