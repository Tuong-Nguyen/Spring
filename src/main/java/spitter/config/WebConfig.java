package spitter.config;

import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.SpringDataWebConfiguration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
import spitter.web.InterceptorHandler.GlobalInterceptor;
import spitter.web.converters.DateTimeConverter;

import javax.persistence.EntityManagerFactory;
import javax.servlet.annotation.MultipartConfig;
import javax.sql.DataSource;
import java.util.*;

/**
 * Created by lnthao on 4/28/2017.
 */
@Configuration
@EnableWebMvc
@MultipartConfig
@ComponentScan("spitter.web")
@Import(DataConfiguration.class)
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

    @Bean
    public SpringDataWebConfiguration springDataWebConfiguration()
    {
        return new SpringDataWebConfiguration();
    }

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
        //registry.addInterceptor(globalInterceptor()).addPathPatterns("/user/**");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateTimeConverter());
    }
}
