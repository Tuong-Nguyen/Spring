package spitter.web.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spitter.web.models.AccountModel;
import spitter.web.models.Course;
import spitter.web.models.EnrollStatus;
import spitter.web.models.Enrollment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nttao on 5/5/2017.
 */
@Service
@Component
public class AccountService {
    private List<AccountModel> users;
    private List<Enrollment> encrollments;
    public AccountService(){
        users = new ArrayList<>();
        AccountModel account = new AccountModel();
        account.setId("qwe");
        account.setPass("qwe");
        account.setName("asd");
        account.setEmail("qwe@qwe.com");
        users.add(account);
        encrollments = new ArrayList<Enrollment>();
        encrollments.add(new Enrollment(1,account,new Course(1, "JavaScript", "JavaScript is a programming language used to make web pages interactive. ")));
        encrollments.add(new Enrollment(2,account, new Course(2, "HTML", "HTML is a computer language devised to allow website creation.")));
        encrollments.add(new Enrollment(3,account, new Course(3, "JQuery", "JQuery is a programming language used to make web pages interactive")));
        encrollments.add(new Enrollment(4,account, new Course(4, "CSS", "CSS is a computer language devised to allow website creation.")));
        encrollments.get(0).setStatus(EnrollStatus.APPROVED);
        encrollments.get(3).setStatus(EnrollStatus.APPROVED);
    }

    public Boolean login(AccountModel account) {
        //readListUserFromFile();
        if (account.getId() != null && !account.getId().isEmpty()) {
            for (AccountModel user : users) {
                if (account.getId().equals(user.getId()) && account.getPass().equals(user.getPass())) {
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
        if (account.getId() != null && !account.getId().isEmpty()) {
            for (AccountModel user : users) {
                if (account.getId().equals(user.getId())) {
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
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public boolean updateUserProfile(AccountModel account){
        for (AccountModel user : users) {
            if (user.getId().equals(account.getId())) {
                user.setName(account.getName());
                user.setBirthDay(account.getBirthDay());
                user.setGender(account.getGender());
                user.setPass(account.getPass());
                return true;
            }
        }
        return false;
    }

    public List<Enrollment> getUserEnrollments(AccountModel user){
        List<Enrollment> enrollments = new ArrayList<Enrollment>();
        for (Enrollment cr: encrollments) {
            if(cr.getUser().getId().equals(user.getId()))
            {
                enrollments.add(cr);
            }
        }
        return enrollments;
    }

    public List<Enrollment> getUserAprrovedEnrollments(AccountModel user){
        List<Enrollment> enrollments = new ArrayList<Enrollment>();
        for (Enrollment cr: encrollments) {
            if(cr.getUser().getId().equals(user.getId())&& (cr.getStatus() == EnrollStatus.APPROVED))
            {
                enrollments.add(cr);
            }
        }
        return enrollments;
    }

    public List<Enrollment> getPendingEnrollments(AccountModel user){
        List<Enrollment> enrollments = new ArrayList<Enrollment>();
        for (Enrollment cr: encrollments) {
            if(cr.getUser().getId().equals(user.getId()) && (cr.getStatus() == EnrollStatus.NONE))
            {
                enrollments.add(cr);
            }
        }
        return enrollments;
    }

    public boolean updateEncrollStatus(List<Enrollment> list){
        for (Enrollment item: list) {
            for (Enrollment temp:encrollments) {
                if(temp.getID() == item.getID()){
                    temp.setStatus(item.getStatus());
                }
            }
        }
        return true;
    }
}