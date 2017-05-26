package spitter.web.services.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import spitter.web.models.Course;
import spitter.web.services.CourseService;

/**
 * Created by nkim on 5/26/2017.
 */
public class CourseConverter implements Converter<String, Course> {

    @Autowired
    private CourseService courseService;

    @Override
    public Course convert(String courseId) {
        System.out.println("Converting Course ID :");
        System.out.println(new Integer(courseId));
        return courseService.getCourseById(new Integer(courseId));
    }
}
