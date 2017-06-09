package spitter.web.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spitter.web.models.AccountModel;
import spitter.web.models.Course;
import spitter.web.models.EncrollStatus;
import spitter.web.models.Encrollment;

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
    private List<Encrollment> encrollments;
    public AccountService(){
        users = new ArrayList<>();
        AccountModel account = new AccountModel();
        account.setID("qwe");
        account.setPass("qwe");
        account.setName("asd");
        account.setEmail("qwe@qwe.com");
        users.add(account);
        encrollments = new ArrayList<Encrollment>();
        encrollments.add(new Encrollment(1,account,new Course(1, "JavaScript", "JavaScript is a programming language used to make web pages interactive. ")));
        encrollments.add(new Encrollment(2,account, new Course(2, "HTML", "HTML is a computer language devised to allow website creation.")));
        encrollments.add(new Encrollment(3,account, new Course(3, "JQuery", "JQuery is a programming language used to make web pages interactive")));
        encrollments.add(new Encrollment(4,account, new Course(4, "CSS", "CSS is a computer language devised to allow website creation.")));
        encrollments.get(0).setStatus(EncrollStatus.APPROVED);
        encrollments.get(3).setStatus(EncrollStatus.APPROVED);
    }

    public Boolean login(AccountModel account) {
        //readListUserFromFile();
        if (account.getID() != null && !account.getID().isEmpty()) {
            for (AccountModel user : users) {
                if (account.getID().equals(user.getID()) && account.getPass().equals(user.getPass())) {
                    account.setName(user.getName());
                    account.setBirthDay(user.getBirthDay());
                    account.setEmail(user.getEmail());
                    account.setGender(user.getGender());
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean register(AccountModel account) {
        //readListUserFromFile();
        if (account.getID() != null && !account.getID().isEmpty()) {
            for (AccountModel user : users) {
                if (account.getID().equals(user.getID())) {
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
            if (user.getID().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public boolean updateUserProfile(AccountModel account){
        for (AccountModel user : users) {
            if (user.getID().equals(account.getID())) {
                user.setName(account.getName());
                user.setBirthDay(account.getBirthDay());
                user.setGender(account.getGender());
                user.setPass(account.getPass());
                return true;
            }
        }
        return false;
    }

    public List<Encrollment> getUserCourseRegister(AccountModel user){
        List<Encrollment> userCourse = new ArrayList<Encrollment>();
        for (Encrollment cr: encrollments) {
            if(cr.getUser().getID().equals(user.getID()))
            {
                userCourse.add(cr);
            }
        }
        return userCourse;
    }

    public List<Encrollment> getUserCourseIsApprove(AccountModel user){
        List<Encrollment> userCourse = new ArrayList<Encrollment>();
        for (Encrollment cr: encrollments) {
            if(cr.getUser().getID().equals(user.getID())&& (cr.getStatus() == EncrollStatus.APPROVED))
            {
                userCourse.add(cr);
            }
        }
        return userCourse;
    }

    public List<Encrollment> getUserCourseWaitApprove(AccountModel user){
        List<Encrollment> userCourse = new ArrayList<Encrollment>();
        for (Encrollment cr: encrollments) {
            if(cr.getUser().getID().equals(user.getID()) && (cr.getStatus() == EncrollStatus.NONE))
            {
                userCourse.add(cr);
            }
        }
        return userCourse;
    }

    public boolean saveEncrollStatus(List<Encrollment> list){
        for (Encrollment item: list) {
            for (Encrollment temp:encrollments) {
                if(temp.getID() == item.getID()){
                    temp.setStatus(item.getStatus());
                }
            }
        }
        return true;
    }
}