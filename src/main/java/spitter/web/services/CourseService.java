package spitter.web.services;

import org.springframework.stereotype.Service;
import spitter.web.models.Course;
import spitter.web.models.Lesson;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by nkim on 5/5/2017.
 */
@Service
public class CourseService {
    private List<Course> coursesList;

    public CourseService() {

        coursesList = new ArrayList<Course>();
        coursesList.add( new Course(1, "JavaScript_1", "JavaScript is a programming language used to make web pages interactive. ",
                "01/01/2017","02/01/2017" , 10, true,
                new ArrayList<Lesson>(){{
                    add(new Lesson(1,"Example A", 20));
                    add(new Lesson(2,"Example B", 20));
                    add(new Lesson(3,"Example C", 20));
                }}));
        coursesList.add( new Course(2, "JavaScript_2", "JavaScript is a programming language used to make web pages interactive. ",
                "01/01/2017","02/01/2017", 10, true,
                new ArrayList<Lesson>(){{
                    add(new Lesson(1,"Example D", 20));
                    add(new Lesson(2,"Example E", 20));
                    add(new Lesson());
                }}));
        coursesList.add( new Course(3, "JavaScript_3", "JavaScript is a programming language used to make web pages interactive. ",
                "01/01/2017","02/01/2017", 10, true,
                new ArrayList<Lesson>(){{
                    add(new Lesson(1,"Example G", 20));
                    add(new Lesson());
                    add(new Lesson());
                }}));
        coursesList.add( new Course(4, "JavaScript_4", "JavaScript is a programming language used to make web pages interactive. ",
                "01/01/2017","02/01/2017", 10, true,
                new ArrayList<Lesson>(){{
                    add(new Lesson());
                    add(new Lesson());
                    add(new Lesson());
                }}));
        coursesList.add( new Course(5, "JavaScript_5", "JavaScript is a programming language used to make web pages interactive. ",
                "01/01/2017","02/01/2017", 10, false,
                new ArrayList<Lesson>(){{
                    add(new Lesson(1,"Example A", 20));
                    add(new Lesson());
                    add(new Lesson());
                }}));
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
        cs.setStartDate(course.getStartDate());
        cs.setEndDate(course.getEndDate());
        cs.setPax(course.getPax());
        cs.setActive(course.isActive());
        cs.setLessons(course.getLessons());
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

