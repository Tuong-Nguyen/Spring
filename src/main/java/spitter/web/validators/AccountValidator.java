package spitter.web.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import spitter.web.models.Account;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nttao on 5/16/2017.
 */
public class AccountValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Account.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Account account = (Account) target;
        if (account.getBirthDay() != null){
            Calendar cal = Calendar.getInstance();
            int currnetYear = cal.get(Calendar.YEAR);
            cal.setTime(account.getBirthDay());
            int age = currnetYear - cal.get(Calendar.YEAR);
            if(age < 13)
                errors.rejectValue("birthDay","account.birthDay", "The age must be then 13 years old!");
        }
    }
}
