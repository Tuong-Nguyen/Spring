package spitter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.annotation.WebListener;

/**
 * Created by nkim on 5/23/2017.
 */
@WebListener
public class MyRequestContextListener extends RequestContextListener {
}
