package spitter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spitter.web.models.Account;
import spitter.web.models.Course;
import spitter.web.services.CourseService;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * Created by lnthao on 4/28/2017.
 */
@Controller
@RequestMapping("/courses")
public class HomeController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String index(@ModelAttribute("account") Account account, Model model, HttpSession session){
        boolean isLogin = false;
        if(session.getAttribute("account") != null){
            account = (Account)session.getAttribute("account");
            model.addAttribute("userName", account.getName());
            model.addAttribute("userId", account.getId());
            isLogin = true;
        }
        List<Course> coursesList = courseService.getCourses();
        model.addAttribute("list", coursesList);
        model.addAttribute("isLogin", isLogin);
        return "home";
    }

    @RequestMapping(value="/{id}/get", method = RequestMethod.GET)
    public String show(@PathVariable("id") int id, Model model){
        Course cs = courseService.getCourseById(id);
        model.addAttribute("courseForm", cs);
        return "detailCourse";
    }

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String create(Model model){
        Course cs = new Course();
        model.addAttribute("courseForm", cs);
        return "courseAddForm";
    }

    @RequestMapping(value="/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Model model){
        Course cs = courseService.getCourseById(id);
        model.addAttribute("courseForm", cs);
        return "courseEditForm";
    }

    @RequestMapping(value="/{id}/delete", method = RequestMethod.GET)
    public String destroy(@PathVariable("id") int id){
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("courseForm") Course cs){
        courseService.updateCourse(cs);
        return "redirect:/courses";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String store(@ModelAttribute("courseForm") Course cs){
        courseService.addCourse(cs);
        return "redirect:/courses";
    }
}
