package spitter.web.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import spitter.web.models.Account;
import spitter.web.models.EnrollStatus;
import sun.util.locale.provider.DateFormatSymbolsProviderImpl;

import java.util.Date;

/**
 * Created by nttao on 5/25/2017.
 */
@ControllerAdvice
public class HttpExceptionHandler {
//    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Page not found")
//    @ExceptionHandler(Exception.class)
//    public ModelAndView pageNotFound(){
//        System.out.println("page not found handler");
//        ModelAndView view = new ModelAndView("exceptions/globalExceptionHandler");
//        return view;
//    }

    @ExceptionHandler(Exception.class)
    public String exceptionControl1(){
        System.out.println("runtime exception handler");
        return "exceptions/controllerExceptionHandler";
    }
}
