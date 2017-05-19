package spitter.web.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by nttao on 5/19/2017.
 */
//Defines the supported target element types. Where the annotation can be use
@Target({FIELD,METHOD,PARAMETER, ANNOTATION_TYPE})
//Specifies, that annotations of this type will be available at runtime by the means of reflection
@Retention(RUNTIME)
//Marks the annotation type as constraint annotation and specifies the validator to be used to validate elements annotated
@Constraint(validatedBy = CheckPassValidator.class)
//Says, that the use of @CheckPass will be contained in the JavaDoc of elements annotated with it
@Documented
public @interface CheckPass {
    //define the default message.
    String message() default "The password is not enought strong!";
    //Attribute anable to set groupt that the annotation belong.
    Class<?>[] groups() default {};
    //Attribute anable to set load level of the annotation.
    Class<? extends Payload>[] payload() default{};
    //Custom attributes
    boolean upcase() default true;
    boolean lowcase() default true;
    boolean specialcharacter() default true;

}
