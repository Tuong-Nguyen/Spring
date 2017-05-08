package spitter.web.services;

import org.springframework.stereotype.Service;
import spitter.web.models.AccountModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nttao on 5/5/2017.
 */
@Service
public class AccountService {
    private List<AccountModel> users = new ArrayList<AccountModel>();
    public Boolean login(AccountModel account){
        if(account.getStrID() != null && !account.getStrID().isEmpty())
        {
            for (AccountModel user: users) {
                if(account.getStrID().equals(user.getStrID()) && account.getStrPass().equals(user.getStrPass())){
                    return true;
                }
            }
        }
        return false;
    }
    public Boolean register(AccountModel account){
        if(account.getStrID() != null && !account.getStrID().isEmpty()) {
            for (AccountModel user: users) {
                if (account.getStrID().equals(user.getStrID())) {
                    return false;
                }
            }
            users.add(account);
            return true;
        }
        return false;
    }
}
