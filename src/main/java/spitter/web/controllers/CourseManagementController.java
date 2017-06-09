package spitter.web.controllers;

import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spitter.web.models.AccountModel;
import spitter.web.models.EncrollStatus;
import spitter.web.services.AccountService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    public String getUserCourses(@ModelAttribute("account") AccountModel account, HttpSession session, Model model){
        if(session.getAttribute("account") != null){
            account = (AccountModel) session.getAttribute("account");
            account.setListCourse(accountService.getUserCourseWaitApprove(account));
            model.addAttribute("statuses", EncrollStatus.values());
        }
        return "courseEncrollManager";
    }
    @RequestMapping(value = "/course/save/", method = RequestMethod.POST)
    public  String approveCourse(@ModelAttribute("account") AccountModel account){
        accountService.saveEncrollStatus(account.getListCourse());
        return "redirect: /course/encrollrequest/";
    }
}
