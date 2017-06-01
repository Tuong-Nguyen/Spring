package spitter.web.models.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nttao on 5/30/2017.
 */
@Repository
public interface UserReponsitory extends JpaRepository<User, String> {
//    User findOne(String id);
//    User findOne(String id, String email);
//    List<User> findAll();
//    User save(User user);
//    User update(User user);
}
