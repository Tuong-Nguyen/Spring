package spitter.web.services;

import spitter.web.models.Course;

import java.util.List;

/**
 * Created by nkim on 5/5/2017.
 */
public class CourseService {
    List<Course> coursesList;

    public CourseService(List<Course> list) {
        this.coursesList = list;
    }

    public void setCourses(List<Course> list){
        this.coursesList = list;
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
        coursesList.remove(getCourseById(id));
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
