package spitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.core.io.Resource;
import spitter.config.views.JsonViewResolver;

/**
 * Created by lnthao on 4/28/2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("spitter.web")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureContentNegotiation
            (ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(MediaType.TEXT_HTML)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
        ContentNegotiatingViewResolver cnViewResolver = new ContentNegotiatingViewResolver();
        cnViewResolver.setContentNegotiationManager(manager);
        return cnViewResolver;
    }

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

    @Bean
    public ViewResolver jsonViewResolver(){
        JsonViewResolver resolver = new JsonViewResolver();
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
