package spitter.web.models;

import java.util.List;

/**
 * Created by nttao on 5/12/2017.
 */
public class CourseRegister {
    private AccountModel user;
    private Course course;
    private boolean isApproved;

    public CourseRegister(AccountModel ac, Course cour){
        this.user = ac;
        this.course = cour;
        this.isApproved = false;
    }
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }


    public AccountModel getUser() {
        return user;
    }

    public void setUser(AccountModel user) {
        this.user = user;
    }
}
