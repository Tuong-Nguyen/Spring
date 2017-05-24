package spitter.web.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import spitter.web.models.HitCounter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by nkim on 5/23/2017.
 */

public class GlobalInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HitCounter counter;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        counter.setHits(counter.getHits() + 1);
        System.out.println("Hits :" + counter.getHits());
        return super.preHandle(request, response, handler);
    }
}
