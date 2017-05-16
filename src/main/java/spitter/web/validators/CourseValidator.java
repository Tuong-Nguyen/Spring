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
        return Course.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Course course = (Course) o;
        if(course.getTitle().trim().length() == 0 ){
            errors.rejectValue("title","course.title", "The title is required!.");
        } else if (course.getTitle().trim().length() > 255){
            errors.rejectValue("title","course.title", "The length of title exceeds 255 characters!");
        }

        if(course.getDescription().trim().length() == 0){
            errors.rejectValue("description", "course.description", "The description is required!");
        }

        if(course.getDescription().trim().length() == 0){
            errors.rejectValue("description", "course.description", "The description is required!");
        }

        if(course.getStartDate().toString().length() == 0){
            errors.rejectValue("startDate", "course.startDate", "The Start Date is required!");
        }

        if(course.getEndDate().toString().length() == 0){
            errors.rejectValue("endDate", "course.endDate", "The End Date is required!");
        }
    }
}
