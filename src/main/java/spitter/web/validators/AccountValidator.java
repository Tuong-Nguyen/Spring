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
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(account.getPass());
        if(!m.matches()){
            errors.rejectValue("pass","account.pass", "The password must contain at least one lower case letter, one upper case letter, one digit and one of these special characters ~!@#$%^&*()_+");
        }
        if(!account.getPass().equals(account.getRetypePass())){
            errors.rejectValue("retypePass","account.retypePass", "Retype password is not valid password!");
        }
        else if (account.getBirthDay() != null){
            Calendar cal = Calendar.getInstance();
            int currnetYear = cal.get(Calendar.YEAR);
            cal.setTime(account.getBirthDay());
            int age = currnetYear - cal.get(Calendar.YEAR);
            if(age < 13)
                errors.rejectValue("birthDay","account.birthDay", "The age must be then 13 years old!");
        }
    }
}
