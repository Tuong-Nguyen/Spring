package spitter.web.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import spitter.web.models.AccountModel;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by nttao on 5/5/2017.
 */
@Service
public class AccountService {
    private List<AccountModel> users;
    public AccountService(){
        users = new ArrayList<>();
        AccountModel acc = new AccountModel();
        acc.setStrID("1");
        acc.setStrName("lnthao");
        acc.setStrPass("lnthao");
        users.add(acc);
    }

    public Boolean login(AccountModel account) {
        //readListUserFromFile();
        if (account.getStrID() != null && !account.getStrID().isEmpty()) {
            for (AccountModel user : users) {
                if (account.getStrID().equals(user.getStrID()) && account.getStrPass().equals(user.getStrPass())) {
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

    private void readListUserFromFile() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("D:\\LocalGit\\Spring\\src\\main\\java\\spitter\\web\\resource\\accounts.json"));
            JSONObject jsonObj = (JSONObject) obj;
            JSONArray list = (JSONArray) jsonObj.getOrDefault("accounts", null );
            for(int i=0; i<list.size(); i++){
                users.add((AccountModel) list.get(i));
            }
        } catch (Exception ex) {
        }
    }
    private void writeListUserFromFile(){
        JSONObject jsonObj = new JSONObject();
    }

    public AccountModel getAccount(String id) {
        return users.stream().filter(acc -> acc.getStrID().equals(id)).findFirst().get();
    }
}