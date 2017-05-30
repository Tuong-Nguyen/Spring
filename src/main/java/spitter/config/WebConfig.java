package spitter.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
import spitter.web.InterceptorHandler.GlobalInterceptor;
import spitter.web.converters.DateTimeConverter;
import sun.font.StandardGlyphVector;

import javax.servlet.annotation.MultipartConfig;
import java.util.*;

/**
 * Created by lnthao on 4/28/2017.
 */
@Configuration
@EnableWebMvc
@MultipartConfig
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
    public ViewResolver xmlViewResolver(){
        XmlViewResolver resolver = new XmlViewResolver();
        resolver.setLocation(new ClassPathResource("/view.xml"));
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public ViewResolver jsonViewResolver(){
        return new JsonViewResolver();
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        List<ViewResolver> resolvers = new ArrayList<>();
        resolvers.add(viewResolver());
        resolvers.add(jsonViewResolver());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }

//    @Bean
//    public ConversionService conversionService(){
//        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
//        Set<Converter> converters = new HashSet<Converter>();
//        converters.add(new DateTimeConverter());
//        bean.setConverters(converters);
//        bean.afterPropertiesSet();
//        ConversionService service = bean.getObject();
//        return service;
//    }

    @Bean
    public StandardServletMultipartResolver standardServletMultipartResolver(){
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
        return  resolver;
    }

    @Bean
    @Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public GlobalInterceptor globalInterceptor(){
        return new GlobalInterceptor();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
    }
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalInterceptor()).addPathPatterns("/user/**");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateTimeConverter());
    }
}
