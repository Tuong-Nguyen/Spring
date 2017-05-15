package spitter.web.models;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by nttao on 5/5/2017.
 */
@Component
public class AccountModel {

    private String id;
    private String pass;
    private String name;
    private String email;
    private Date birthDay;
    private String gender;
    private List<Enrollment> enrollmentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public void setEnrollmentList(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) {  this.gender = gender; }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
