package spitter.web.models;


/**
 * Created by nttao on 5/12/2017.
 */
public class Enrollment {
    private int ID;
    private Account user;
    private Course course;
    private EnrollStatus status;


    public Enrollment(Account account, Course course){
        this.user = account;
        this.course = course;
        this.status = EnrollStatus.NONE;
    }
    public Enrollment(int id, Account account, Course course){
        this.ID = id;
        this.user = account;
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


    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }
}
