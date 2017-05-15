package spitter.web.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spitter.web.models.AccountModel;
import spitter.web.models.Course;
import spitter.web.models.CourseRegister;

import java.io.FileReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by nttao on 5/5/2017.
 */
@Service
@Component
public class AccountService {
    private List<AccountModel> users;
    private List<CourseRegister> courseRegisters;
    public AccountService(){
        users = new ArrayList<>();
        AccountModel account = new AccountModel();
        account.setStrID("qwe");
        account.setStrPass("qwe");
        account.setStrName("asd");
        account.setStrEmail("qwe@qwe.com");
        users.add(account);
        courseRegisters = new ArrayList<CourseRegister>();
        courseRegisters.add(new CourseRegister(account,new Course(1, "JavaScript", "JavaScript is a programming language used to make web pages interactive. ")));
        courseRegisters.add(new CourseRegister(account, new Course(2, "HTML", "HTML is a computer language devised to allow website creation.")));
        courseRegisters.add(new CourseRegister(account, new Course(3, "JQuery", "JQuery is a programming language used to make web pages interactive")));
        courseRegisters.add(new CourseRegister(account, new Course(4, "CSS", "CSS is a computer language devised to allow website creation.")));
        courseRegisters.get(0).setApproved(true);
        courseRegisters.get(3).setApproved(true);
    }

    public Boolean login(AccountModel account) {
        //readListUserFromFile();
        if (account.getStrID() != null && !account.getStrID().isEmpty()) {
            for (AccountModel user : users) {
                if (account.getStrID().equals(user.getStrID()) && account.getStrPass().equals(user.getStrPass())) {
                    account.setStrName(user.getStrName());
                    account.setdBirthDay(user.getdBirthDay());
                    account.setStrEmail(user.getStrEmail());
                    account.setStrGender(user.getStrGender());
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean register(AccountModel account) {
        //readListUserFromFile();
        if (account.getStrID() != null && !account.getStrID().isEmpty()) {
            for (AccountModel user : users) {
                if (account.getStrID().equals(user.getStrID())) {
                    return false;
                }
            }
            users.add(account);
            return true;
        }
        return false;
    }

    public AccountModel getUserProfile(String id){
        for (AccountModel user : users) {
            if (user.getStrID().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public boolean updateUserProfile(AccountModel account){
        for (AccountModel user : users) {
            if (user.getStrID().equals(account.getStrID())) {
                user.setStrName(account.getStrName());
                user.setdBirthDay(account.getdBirthDay());
                user.setStrGender(account.getStrGender());
                user.setStrPass(account.getStrPass());
                return true;
            }
        }
        return false;
    }

    public List<CourseRegister> getUserCourseRegister(AccountModel user){
        List<CourseRegister> userCourse = new ArrayList<CourseRegister>();
        for (CourseRegister cr: courseRegisters) {
            if(cr.getUser().getStrID().equals(user.getStrID()))
            {
                userCourse.add(cr);
            }
        }
        return userCourse;
    }

    public List<CourseRegister> getUserCourseIsApprove(AccountModel user){
        List<CourseRegister> userCourse = new ArrayList<CourseRegister>();
        for (CourseRegister cr: courseRegisters) {
            if(cr.getUser().getStrID().equals(user.getStrID())&& cr.isApproved())
            {
                userCourse.add(cr);
            }
        }
        return userCourse;
    }

    public List<CourseRegister> getUserCourseWaitApprove(AccountModel user){
        List<CourseRegister> userCourse = new ArrayList<CourseRegister>();
        for (CourseRegister cr: courseRegisters) {
            if(cr.getUser().getStrID().equals(user.getStrID()) && !cr.isApproved())
            {
                userCourse.add(cr);
            }
        }
        return userCourse;
    }
}