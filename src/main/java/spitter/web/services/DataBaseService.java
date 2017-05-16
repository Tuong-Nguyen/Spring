package spitter.web.services;

import org.springframework.stereotype.Service;
import spitter.web.models.Account;
import spitter.web.models.Course;
import spitter.web.models.EnrollStatus;
import spitter.web.models.Enrollment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nttao on 5/16/2017.
 */
@Service
public class DataBaseService {
    private List<Account> users;
    private List<Enrollment> encrollments;

    public DataBaseService(){
        users = new ArrayList<>();
        Account account = new Account();
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

    public List<Account> getUsers() {
        return users;
    }

    public void setUsers(List<Account> users) {
        this.users = users;
    }

    public List<Enrollment> getEncrollments() {
        return encrollments;
    }

    public void setEncrollments(List<Enrollment> encrollments) {
        this.encrollments = encrollments;
    }
}
