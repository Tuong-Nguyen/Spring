package spitter.web.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import spitter.web.models.HitCounter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nkim on 5/25/2017.
 */
public class TestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HitCounter counter;

    public TestInterceptor(){
        System.out.println("Instantiate TestInterceptor");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        counter.setHits(counter.getHits() + 2);
        System.out.println("Hits :" + counter.getHits());
        return super.preHandle(request, response, handler);
    }
}
