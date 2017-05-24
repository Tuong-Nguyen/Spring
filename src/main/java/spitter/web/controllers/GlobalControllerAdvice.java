package spitter.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by nkim on 5/24/2017.
 */
@ControllerAdvice(annotations=Controller.class)
public class GlobalControllerAdvice {
    @ModelAttribute("currentDate")
    public Date getCurrentDate(){
        return new Date();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String handleRunTimeError(HttpServletRequest request){
        return "Null Pointer Error";
    }
}
