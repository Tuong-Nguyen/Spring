package spitter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spitter.web.models.Account;
import spitter.web.models.EnrollStatus;
import spitter.web.services.AccountService;

import javax.servlet.http.HttpSession;

/**
 * Created by nttao on 5/12/2017.
 */
@Controller
@SessionAttributes("account")
public class CourseManagementController {
    @Autowired
    private AccountService accountService;

    @ModelAttribute("account")
    public Account getAccount(){
        return new Account();
    }

    @RequestMapping(value = "/course/encrollrequest/", method = RequestMethod.GET)
    public String getUserCourses(@ModelAttribute("account") Account account, HttpSession session, Model model){
        if(session.getAttribute("account") != null){
            account = (Account) session.getAttribute("account");
            account.setEnrollmentList(accountService.getPendingEnrollments(account));
            model.addAttribute("statuses", EnrollStatus.values());
        }
        return "courseEncrollManager";
    }
    @RequestMapping(value = "/course/save/", method = RequestMethod.POST)
    public  String approveCourse(@ModelAttribute("account") Account account){
        accountService.updateEncrollStatus(account.getEnrollmentList());
        return "redirect: /course/encrollrequest/";
    }
}
