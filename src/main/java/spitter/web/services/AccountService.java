package spitter.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spitter.web.models.Account;
import spitter.web.models.EnrollStatus;
import spitter.web.models.Enrollment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nttao on 5/5/2017.
 */
@Service
public class AccountService {
    private DataBaseService dataBaseService;

    private List<Account> users;
    private List<Enrollment> encrollments;
    @Autowired
    public AccountService(DataBaseService dataBaseService){
        this.dataBaseService = dataBaseService;
        users = dataBaseService.getUsers();
        encrollments = dataBaseService.getEncrollments();
    }

    public Boolean login(Account account) {
        //readListUserFromFile();
        if (account.getId() != null && !account.getId().isEmpty()) {
            for (Account user : users) {
                if (account.getId().equals(user.getId()) && account.getPass().equals(user.getPass())) {
                    account.setName(user.getName());
                    account.setEnrollmentList(getUserEnrollments(account));
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean register(Account account) {
        //readListUserFromFile();
        if (account.getId() != null && !account.getId().isEmpty()) {
            for (Account user : users) {
                if (account.getId().equals(user.getId())) {
                    return false;
                }
            }
            users.add(account);
            return true;
        }
        return false;
    }

    public Account getUserProfile(String id){
        for (Account user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public boolean updateUserProfile(Account account){
        for (Account user : users) {
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

    public List<Enrollment> getUserEnrollments(Account user){
        List<Enrollment> enrollments = new ArrayList<Enrollment>();
        for (Enrollment cr: encrollments) {
            if(cr.getUser().getId().equals(user.getId()))
            {
                enrollments.add(cr);
            }
        }
        return enrollments;
    }

    public List<Enrollment> getUserAprrovedEnrollments(Account user){
        List<Enrollment> enrollments = new ArrayList<Enrollment>();
        for (Enrollment cr: encrollments) {
            if(cr.getUser().getId().equals(user.getId())&& (cr.getStatus() == EnrollStatus.APPROVED))
            {
                enrollments.add(cr);
            }
        }
        return enrollments;
    }

    public List<Enrollment> getPendingEnrollments(Account user){
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