package spitter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.core.io.Resource;

/**
 * Created by lnthao on 4/28/2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("spitter.web")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Bean
    public ViewResolver xmlViewResolverDefault() {
        XmlViewResolver resolver = new XmlViewResolver();
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public ViewResolver xmlViewResolver() {
        XmlViewResolver resolver = new XmlViewResolver();
        Resource resource = new ClassPathResource("/views.xml"); // src/main/resources/views.xml
        resolver.setLocation(resource);
        resolver.setOrder(2);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
