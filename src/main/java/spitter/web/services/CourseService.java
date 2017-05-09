package spitter.web.services;

import org.springframework.stereotype.Service;
import spitter.web.models.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nkim on 5/5/2017.
 */
@Service
public class CourseService {
    private List<Course> coursesList;
    public CourseService() {
        coursesList = new ArrayList<Course>();
        coursesList.add( new Course(1, "JavaScript", "JavaScript is a programming language used to make web pages interactive. "));
        coursesList.add( new Course(2, "HTML", "HTML is a computer language devised to allow website creation."));
        coursesList.add( new Course(3, "CSS", "CSS is a style language that defines layout of HTML documents. "));
    }

    public List<Course> getCourses(){
        return coursesList;
    }

    public void addCourse(Course course){
        coursesList.add(course);
    }

    public void updateCourse(Course course){
        Course cs = getCourseById(course.getId());
        cs.setTitle(course.getTitle());
        cs.setDescription(course.getDescription());
    }

    public void deleteCourse(int id){
        Course deletingCourse = getCourseById(id);
        coursesList.remove(deletingCourse);
    }

    public Course getCourseById(int id){
        Course cs = new Course();
        for (Course temp: coursesList){
            if (temp.getId() == id){
                cs = temp;
                break;
            }
        }
        return cs;

    }
}

