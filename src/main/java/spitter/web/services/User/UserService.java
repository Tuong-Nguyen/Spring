package spitter.web.services.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spitter.web.models.User.User;
import spitter.web.models.User.UserReponsitory;

import java.util.List;

/**
 * Created by nttao on 5/30/2017.
 */
@Service
public class UserService {
    @Autowired
    private UserReponsitory reponsitory;

    public List<User> findAll(){
        return reponsitory.findAll();
    }
    public User findOne(String id){
        return reponsitory.findOne(id);
    }
    public User save(User user){
        return reponsitory.save(user);
    }

    public boolean login(User user){
        User login = findOne(user.getUserId());
        if(login != null){
            if(login.getPassword().equals(user.getPassword())){
                user.setUserName(login.getUserName());
                return true;
            }
        }
        return false;
    }

    public User finfByEmail(String email){
        return reponsitory.findByEmail(email);
    }
    public User updateUserProfile(User user){
        return save(user);
//        int rs =  reponsitory.update(user.getUserId(), user.getUserName(), user.getPassword(),
//                user.getEmail(), user.getGender(), user.getBirthday());
//        return user;
    }
}
