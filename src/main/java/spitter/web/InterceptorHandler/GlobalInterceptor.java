package spitter.web.InterceptorHandler;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by nttao on 5/25/2017.
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {

    public GlobalInterceptor(){
        System.out.println("Initialize GlobalInterceptor");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(checkLoginStatus(session)){
            System.out.println("co session");
            return true;
        }
        System.out.println("ko co session");
        return false;
    }

    private boolean checkLoginStatus(HttpSession session)
    {
        if (session.getAttribute("account") != null)
            return  true;
        return  false;
    }
}
