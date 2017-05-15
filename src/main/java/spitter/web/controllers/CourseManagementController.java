package spitter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spitter.web.models.AccountModel;
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
    public AccountModel getAccount(){
        return new AccountModel();
    }

    @RequestMapping(value = "/course/encrollrequest/", method = RequestMethod.GET)
    public String getUserCourses(@ModelAttribute("account") AccountModel account, HttpSession session){
        if(session.getAttribute("account") != null){
            account = (AccountModel) session.getAttribute("account");
            account.setListCourse(accountService.getUserCourseWaitApprove(account));
        }
        return "courseEncrollManager";
    }
    @RequestMapping(value = "/course/approve/", method = RequestMethod.POST)
    public  String approveCourse(@ModelAttribute("account") AccountModel account){
        return "courseEncrollManager";
    }

    @RequestMapping(value = "/course/reject/", method = RequestMethod.POST)
    public  String rejectCourse(@ModelAttribute("account") AccountModel account){
        return "courseEncrollManager";
    }
}
