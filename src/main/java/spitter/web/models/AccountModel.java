package spitter.web.models;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by nttao on 5/5/2017.
 */
@Component
public class AccountModel {
    private String ID;
    private String Pass;
    private String Name;
    private String Email;
    private Date BirthDay;
    private String Gender;
    private List<Encrollment> listCourse;

    public List<Encrollment> getListCourse() {
        return listCourse;
    }

    public void setListCourse(List<Encrollment> listCourse) {
        this.listCourse = listCourse;
    }


    public String getGender() { return Gender; }

    public void setGender(String Gender) {  this.Gender = Gender; }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date BirthDay) {
        this.BirthDay = BirthDay;
    }
}
