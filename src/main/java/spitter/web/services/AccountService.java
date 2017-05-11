package spitter.web.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spitter.web.models.AccountModel;

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
    public AccountService(){
        users = new ArrayList<>();
        AccountModel account = new AccountModel();
        account.setStrID("qwe");
        account.setStrPass("qwe");
        account.setStrEmail("qwe@qwe.com");
        users.add(account);
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

    public AccountModel getUser(String id){
        for (AccountModel user : users) {
            if (user.getStrID().equals(id)) {
                return user;
            }
        }
        return null;
    }
}