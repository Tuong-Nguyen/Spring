package spitter.web.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spitter.config.DataConfiguration;
import spitter.config.DataConfigurationTest;
import spitter.web.models.User.User;
import spitter.web.models.User.UserReponsitory;

/**
 * Created by nttao on 6/7/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfigurationTest.class})
public class UserRepositoryTest {
    @Autowired
    private UserReponsitory userReponsitory;

    @Test
    public void UserRepositoryTest(){
        Assert.assertNotNull(userReponsitory);
    }
    @Test
    public void saveUserTest(){
        User user = new User();
        user.setUserId("asd");
        user.setPassword("asd");
        user.setUserName("qwe");
        user.setEmail("asd@asd.com");
        Assert.assertNotNull(userReponsitory.save(user));
    }
    @Test
    public void getUserTest(){
        User user = userReponsitory.findOne("qwe");
        Assert.assertNotNull(user);
    }
    @Test
    public void getAllUserTest(){
        Assert.assertEquals(userReponsitory.findAll().size(), 5);
    }


}
