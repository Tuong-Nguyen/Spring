package spitter.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by nkim on 5/26/2017.
 */
@ControllerAdvice(annotations=Controller.class)
public class TestControllerAdvice {
    @ModelAttribute("testDate")
    public Date getCurrentDate(){
        return new Date();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleRunTimeError(HttpServletRequest request){
        return "Handle by TestControllerAdvice";
    }
}
