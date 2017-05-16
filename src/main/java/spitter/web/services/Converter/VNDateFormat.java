package spitter.web.services.Converter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by nkim on 5/16/2017.
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface VNDateFormat {
    public static final String PATTERN_DEFAULT = "dd/MM/yyyy";
    String pattern() default PATTERN_DEFAULT;
}
