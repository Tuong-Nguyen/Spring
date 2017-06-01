package spitter.web.models;


import spitter.web.models.User.User;

/**
 * Created by nttao on 5/12/2017.
 */
public class Enrollment {
    private int ID;
    private User user;
    private Course course;
    private EnrollStatus status;


    public Enrollment(User user, Course course){
        this.user = user;
        this.course = course;
        this.status = EnrollStatus.NONE;
    }
    public Enrollment(int id, User user, Course course){
        this.ID = id;
        this.user = user;
        this.course = course;
        this.status = EnrollStatus.NONE;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public EnrollStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollStatus status) {
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
