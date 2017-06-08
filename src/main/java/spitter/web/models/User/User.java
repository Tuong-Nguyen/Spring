package spitter.web.models.User;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import spitter.web.models.Enrollment;
import spitter.web.validators.CheckPass;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by nttao on 5/30/2017.
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @NotBlank
    //@Size(min = 5, max = 25)
    private String userId;
    @NotBlank
    //@CheckPass
    private  String password;

    private String retypePassWord;
    @NotBlank
    private String userName;
    @NotBlank
    private String email;
    @NotBlank
    private String gender;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-ddd")
    private Date birthday;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Enrollment.class, mappedBy = "user")
    private List<Enrollment> enrollments;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassWord() {
        return retypePassWord;
    }

    public void setRetypePassWord(String retypePassWord) {
        this.retypePassWord = retypePassWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", retypePassWord='" + retypePassWord + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
