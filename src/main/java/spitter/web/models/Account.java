package spitter.web.models;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import spitter.web.validators.CheckPass;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by nttao on 5/5/2017.
 */
@Component
@XmlRootElement(name = "user")
public class Account {
    @NotBlank(message = "You must insert your account id!")
    @Size(min = 5, max = 25)
    private String id;
    @NotBlank(message = "You must insert your password!")
    @CheckPass(message = "The password must contain numberic character, lowcase character, upcase character, special character, and more then 8 chararcters")
    private String pass;
    @NotBlank
    private String retypePass;
    @NotBlank(message = "You must insert your name!")
    private String name;
    @NotBlank(message = "You must insert your email!")
    private String email;
    @NotBlank(message = "You must insert your birtday!")
    private Date birthDay;
    @NotBlank(message = "You must select your gender!")
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

    public String getRetypePass() {
        return retypePass;
    }

    public void setRetypePass(String retypePass) {
        this.retypePass = retypePass;
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
