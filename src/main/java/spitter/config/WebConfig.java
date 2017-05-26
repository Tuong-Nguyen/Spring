package spitter.config;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import spitter.web.interceptors.GlobalInterceptor;
import spitter.web.interceptors.TestInterceptor;
import spitter.web.models.Course;
import spitter.web.models.HitCounter;
import spitter.web.resolver.Jaxb2MarshallingXmlViewResolver;
import spitter.web.resolver.JsonViewResolver;
import spitter.web.services.Converter.CourseConverter;
import spitter.web.services.Converter.VNDateConverter;
import spitter.web.services.Converter.VNDateFormatAnnotationFormatterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lnthao on 4/28/2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("spitter.web")
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Bean
//    public RequestContextListener requestContextListener(){
//        return new RequestContextListener();
//    }

    @Bean
    public CourseConverter courseConverter(){
        return new CourseConverter();
    }

    @Bean
    public VNDateConverter vnDateConverter(){
        return new VNDateConverter();
    }
    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HitCounter hitCounter(){
        return new HitCounter();
    }


    @Bean
    @Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public GlobalInterceptor globalInterceptor(){
        return new GlobalInterceptor();
    }

    @Bean
    @Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public TestInterceptor testInterceptor(){
        return new TestInterceptor();
    }

    @Override
    public void  addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor( testInterceptor()).addPathPatterns("/courses/**");
        registry.addInterceptor( globalInterceptor()).addPathPatterns("/courses/**");
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
    public ViewResolver xmlViewResolver(){
        XmlViewResolver resolver = new XmlViewResolver();
        resolver.setLocation(new ClassPathResource("views.xml"));
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public ViewResolver jsonViewResolver(){
        return new JsonViewResolver();
    }

    @Bean
    public ViewResolver jaxb2MarshallingXmlViewResolver(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Course.class);
        return new Jaxb2MarshallingXmlViewResolver(marshaller);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        configurer.ignoreAcceptHeader(true)
                .defaultContentType(MediaType.TEXT_HTML);
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
        resolvers.add(viewResolver());
        resolvers.add(jsonViewResolver());
        resolvers.add(jaxb2MarshallingXmlViewResolver());
        resolver.setViewResolvers(resolvers);

        return resolver;
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        VNDateFormatAnnotationFormatterFactory factory = new
                VNDateFormatAnnotationFormatterFactory();

        registry.addFormatterForFieldAnnotation(factory);
        registry.addConverter(vnDateConverter());
        registry.addConverter(courseConverter());
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
