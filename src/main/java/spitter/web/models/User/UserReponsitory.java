package spitter.web.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by nttao on 5/30/2017.
 */
@Repository
public interface UserReponsitory extends JpaRepository<User, String> {
    //@Query(value = "SELECT U FROM USER U WHERE U.EMAIL = ?1", nativeQuery = true)
    public User findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update User u set u.userName = :username, u.password = :password, u.email = :email," +
            " u.gender = :gender, u.birthday = :birthday where u.userId = :id")
    public int update(@Param("id") String id,@Param("username") String userName, @Param("password")String password,
                       @Param("email")String email, @Param("gender")String gender, @Param("birthday")Date birthday);
}
