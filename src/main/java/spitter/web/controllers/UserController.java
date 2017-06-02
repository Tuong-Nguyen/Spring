package spitter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import spitter.web.models.User.User;
import spitter.web.services.User.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nttao on 5/31/2017.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User initUser(){
        return new User();
    }

    @ModelAttribute("gender")
    public List<String> getGender(){
        List<String> gender = new LinkedList<String>(Arrays.asList(new String[]{"Male", "FeMale"}));
        return gender;
    }

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public String login() {
        return "/user/login";
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, HttpSession session, SessionStatus status) {
        if (userService.login(user)) {
            session.setAttribute("user", user);
            return "redirect: /courses";
        } else {
            status.setComplete();
            return "/user/login/";
        }
    }

    @RequestMapping(value = "/logout/", method = RequestMethod.GET)
    public String logout(HttpSession session, SessionStatus status) {
        if(session.getAttribute("user") != null) {
            session.removeAttribute("user");
            status.setComplete();
            return "redirect: /user/login/";
        }
        status.setComplete();
        return "redirect: /courses";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public String register(){
        User user = userService.findOne("qwe");
        if(user != null)
            System.out.println(user.toString());
        return "user/register";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpServletRequest request, SessionStatus status) {
        if(result.hasErrors()){
            return "account/register";
        }
        String strbirhtDay = request.getParameter("date") + "/" + request.getParameter("month") + "/" + request.getParameter("year");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = (Date) df.parse(strbirhtDay);
            if (userService.save(user) != null) {
                status.setComplete();
                return "redirect: /login/";
            } else {
                status.setComplete();
                return "user/register";
            }
        } catch (Exception ex) {
            throw new RuntimeException("datetime get error");
            //return "account/register";
        }
    }

    @RequestMapping(value = "/profile/", method = RequestMethod.GET)
    public String userProfile(Model model, @RequestParam("id") String id){
        User user = userService.findOne(id);
        User temp = userService.finfByEmail(user.getEmail());
        model.addAttribute("user", user);
        return "/user/profile";
    }

    @RequestMapping(value = "/profile/", method = RequestMethod.POST)
    public String userProfile(@ModelAttribute User user, SessionStatus status){
        userService.updateUserProfile(user);
        status.setComplete();
        return "/user/profile";
    }
}
