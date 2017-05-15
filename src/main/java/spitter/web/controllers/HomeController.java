package spitter.web.controllers;

import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spitter.web.models.AccountModel;
import spitter.web.models.Course;
import spitter.web.services.CourseService;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by lnthao on 4/28/2017.
 */
@Controller
public class HomeController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value="/spitter/", method= RequestMethod.GET)
    public String index(@ModelAttribute("account") AccountModel account, Model model, HttpSession session){
        boolean isLogin = false;
        if(session.getAttribute("account") != null){
            account = (AccountModel)session.getAttribute("account");
            model.addAttribute("user", account.getName());
            isLogin = true;
        }
        List<Course> coursesList = courseService.getCourses();
        model.addAttribute("list", coursesList);
        model.addAttribute("isLogin", isLogin);
        return "home";
    }

    @RequestMapping(value="/spitter/addCourse", method = RequestMethod.GET)
    public String addCourse(Model model){
        Course cs = new Course();
        model.addAttribute("courseForm", cs);
        return "courseAddForm";
    }

    @RequestMapping(value="/spitter/editCourse/{id}", method = RequestMethod.GET)
    public String showCourseEditForm(@PathVariable("id") int id, Model model){
        Course cs = courseService.getCourseById(id);
        model.addAttribute("courseForm", cs);
        return "courseEditForm";
    }

    @RequestMapping(value="/spitter/deleteCourse/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable("id") int id){
        courseService.deleteCourse(id);
        return "redirect:/spitter/";
    }

    @RequestMapping(value="/editSave", method = RequestMethod.POST)
    public String saveEditCourse(@ModelAttribute("courseForm") Course cs){
        courseService.updateCourse(cs);
        return "redirect:/spitter/";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("courseForm") Course cs, Model model){
        courseService.addCourse(cs);
        return "redirect:/spitter/";
    }
}
