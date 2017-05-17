package spitter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import spitter.web.models.AccountModel;
import spitter.web.models.Course;
import spitter.web.services.CourseService;
import spitter.web.validators.CourseValidator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by nkim on 5/16/2017.
 */
@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String index(Model model){
        List<Course> coursesList = courseService.getCourses();
        model.addAttribute("list", coursesList);
        return "Courses";
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

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String destroy(@PathVariable("id") int id){
        courseService.deleteCourse(id);
        return "Delete Course";
    }

    @RequestMapping(value="/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute("courseForm") Course cs){
        courseService.updateCourse(cs);
        return "redirect:/courses";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String store(@ModelAttribute("courseForm") @Valid Course cs, BindingResult result){
        new CourseValidator().validate(cs, result);
        if (!result.hasErrors()){
            System.out.println("Validated");
        } else
        {
            return "courseAddForm";
        }
        courseService.addCourse(cs);
        return "redirect:/courses";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.addValidators(new CourseValidator());
//    }

}
