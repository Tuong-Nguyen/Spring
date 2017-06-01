package spitter.web.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import spitter.web.models.User.User;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nttao on 5/16/2017.
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getBirthday() != null){
            Calendar cal = Calendar.getInstance();
            int currnetYear = cal.get(Calendar.YEAR);
            cal.setTime(user.getBirthday());
            int age = currnetYear - cal.get(Calendar.YEAR);
            if(age < 13)
                errors.rejectValue("birthDay","account.birthDay", "The age must be then 13 years old!");
        }
    }
}
