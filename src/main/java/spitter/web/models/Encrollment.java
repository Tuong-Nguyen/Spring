package spitter.web.models;

import java.util.List;

/**
 * Created by nttao on 5/12/2017.
 */
public class Encrollment {
    private int ID;
    private AccountModel user;
    private Course course;
    private EncrollStatus status;


    public Encrollment(AccountModel ac, Course cour){
        this.user = ac;
        this.course = cour;
        this.status = EncrollStatus.NONE;
    }
    public Encrollment(int id, AccountModel ac, Course cour){
        this.ID = id;
        this.user = ac;
        this.course = cour;
        this.status = EncrollStatus.NONE;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public EncrollStatus getStatus() {
        return status;
    }

    public void setStatus(EncrollStatus status) {
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public AccountModel getUser() {
        return user;
    }

    public void setUser(AccountModel user) {
        this.user = user;
    }
}
