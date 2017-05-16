package spitter.web.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import spitter.web.models.Course;

/**
 * Created by nkim on 5/16/2017.
 */
public class CourseValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        //return Course.class.equals(aClass);
        return true;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Course course = (Course) o;
        if(course.getTitle().length() < 5){
            errors.rejectValue("title","course.title", "The title is too short");
        }
    }
}
