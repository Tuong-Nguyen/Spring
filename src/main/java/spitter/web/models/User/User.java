package spitter.web.models.User;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import spitter.web.models.Enrollment;
import spitter.web.validators.CheckPass;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by nttao on 5/30/2017.
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "ID")
    @NotBlank
    //@Size(min = 5, max = 25)
    private String userId;
    @Column(name = "PASS")
    @NotBlank
    //@CheckPass
    private  String password;

    private String retypePassWord;
    @Column(name = "NAME")
    @NotBlank
    private String userName;
    @Column(name = "EMAIL")
    @NotBlank
    private String email;
    @Column(name = "GENDER")
    @NotBlank
    private String gender;
    @Column(name = "BIRTHDAY")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-ddd")
    private Date birthday;
    //@OneToMany(cascade = CascadeType.ALL)
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
