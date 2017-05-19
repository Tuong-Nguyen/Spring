package spitter.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nttao on 5/19/2017.
 */
public class CheckPassValidator implements ConstraintValidator<CheckPass, String> {
    private boolean upcase;
    private boolean lowcase;
    private boolean specialcharacter;

    @Override
    public void initialize(CheckPass constraintAnnotation) {
        this.upcase = constraintAnnotation.upcase();
        this.lowcase = constraintAnnotation.lowcase();
        this.specialcharacter = constraintAnnotation.specialcharacter();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        boolean isValid = true;
        //The password must contain numberic character, lowcase character, upcase character, special character, and more then 8 chararcters
        //String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        String regex = "^(?=.*[0-9])(?=.*[a-z]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if(lowcase)
        {
            if(!matcher.matches())
                isValid = false;
        }
        regex = "^(?=.*[0-9])(?=.*[A-Z]).{8,}$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(value);
        if(upcase){
            if(!matcher.matches())
                isValid = false;
        }
        regex = "^(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(value);
        if(specialcharacter){
            if(!matcher.matches())
                isValid = false;
        }
        return isValid;
    }
}
