package spitter.web.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import spitter.web.models.HitCounter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nkim on 5/23/2017.
 */
@Component
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if (e instanceof RuntimeException){
            System.out.println("Null Pointer Exception");
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("global_error");
        return mav;
    }
}
