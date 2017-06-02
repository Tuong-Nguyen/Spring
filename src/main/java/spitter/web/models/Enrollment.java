package spitter.web.models;


import spitter.web.models.User.User;

import javax.persistence.*;

/**
 * Created by nttao on 5/12/2017.
 */
//@Entity
//@Table(name = "Enrolment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @Column(name = "USERID")
    private String userID;
    @Column(name = "COURSEID")
    private int courseID;
    @Column(name = "STATUS")
    private EnrollStatus status;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public EnrollStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollStatus status) {
        this.status = status;
    }
}
