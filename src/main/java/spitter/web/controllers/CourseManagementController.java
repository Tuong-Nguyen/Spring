package spitter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spitter.web.models.EnrollStatus;
import spitter.web.models.User.User;
import spitter.web.services.User.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by nttao on 5/12/2017.
 */
@Controller
@SessionAttributes("account")
public class CourseManagementController {
    @Autowired
    private UserService userService;

    @ModelAttribute("account")
    public User getAccount(){
        return new User();
    }

    @RequestMapping(value = "/course/encrollrequest/", method = RequestMethod.GET)
    public String getUserCourses(@ModelAttribute("account") User user, HttpSession session, Model model){
        if(session.getAttribute("account") != null){
            user = (User) session.getAttribute("account");
            //user.setEnrollmentList(userService.getPendingEnrollments(account));
            model.addAttribute("statuses", EnrollStatus.values());
        }
        return "courseEncrollManager";
    }
    @RequestMapping(value = "/course/save/", method = RequestMethod.POST)
    public  String approveCourse(@ModelAttribute("account") User user){
        //userService.updateEncrollStatus(account.getEnrollmentList());
        return "redirect: /course/encrollrequest/";
    }
}
