package spitter.web.models;


import spitter.web.models.User.User;

import javax.persistence.*;

/**
 * Created by nttao on 5/12/2017.
 */
@Entity
@Table(name = "Enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
//    private String userID;
//    private int courseID;
    @Column(name = "STATUS")
    private EnrollStatus status;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "USERID")
    private User user;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Course.class)
    @JoinColumn(name = "COURSEID")
    private Course course;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

//    public String getUserID() {
//        return userID;
//    }
//
//    public void setUserID(String userID) {
//        this.userID = userID;
//    }
//
//    public int getCourseID() {
//        return courseID;
//    }
//
//    public void setCourseID(int courseID) {
//        this.courseID = courseID;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public EnrollStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollStatus status) {
        this.status = status;
    }

}
