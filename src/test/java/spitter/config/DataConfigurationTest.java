package spitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by nttao on 6/7/2017.
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryTest", basePackages = "spitter.web")
@EnableTransactionManagement
@ComponentScan("spitter.web")
public class DataConfigurationTest {
    @Bean
    public DataSource dataSourceTest(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .addScript("createDatabse.sql")
                .addScript("insertUser.sql")
                .build();
    }
    @Bean
    public EntityManagerFactory entityManagerFactoryTest(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        jpaProperties.put("hibernate.hbm2ddl.import_files", "init.sql");

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSourceTest());
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        //use hibernate generate database or database form datasource script file.
        //factoryBean.setJpaProperties(jpaProperties);
        factoryBean.setPackagesToScan("spitter.web.models");
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryTest());
        return transactionManager;
    }
}
