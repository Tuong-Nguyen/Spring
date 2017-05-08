package spitter.web.controllers;

import com.sun.webkit.Timer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spitter.web.models.Course;
import spitter.web.services.CourseService;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by lnthao on 4/28/2017.
 */
@Controller
public class HomeController {
    List<Course> list = Arrays.asList(
            new Course(1, "JavaScript", "JavaScript is a programming language used to make web pages interactive. "),
            new Course(2, "HTML", "HTML is a computer language devised to allow website creation."),
            new Course(3, "CSS", "CSS is a style language that defines layout of HTML documents. ")
            );

    CourseService courseService = new CourseService(list);

    @RequestMapping(value="/spitter/", method= RequestMethod.GET)
    public String index(Model model, HttpSession session){
        String welcome = "Spitter";
        if(session.getAttribute("user") != null) {
            welcome = session.getAttribute("user").toString();
        }
            List<Course> coursesList = courseService.getCourses();
            model.addAttribute("list", coursesList);
        model.addAttribute("welcome", welcome);
        return "home";
    }

    @RequestMapping(value="/spitter/addCourse", method = RequestMethod.GET)
    public String addCourse(Model model){
            return "redirect:/spitter/";
    }

    @RequestMapping(value="/spitter/editCourse/{id}", method = RequestMethod.GET)
    public String showCourseEditForm(@PathVariable("id") int id, Model model){
        Course cs = courseService.getCourseById(id);
        model.addAttribute("courseForm", cs);
        return "courseEditForm";
    }

    @RequestMapping(value="/spitter/deleteCourse/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable("id") int id, Model model){
        courseService.deleteCourse(id);
        return "redirect:/spitter/";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("courseForm") Course cs, Model model){
        courseService.updateCourse(cs);
        return "redirect:/spitter/";
    }
}
