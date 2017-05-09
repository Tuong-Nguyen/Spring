package spitter.web.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spitter.web.services.NiceWriter;
import spitter.web.services.Writer;
import spitter.web.services.WriterRunner;

/**
 * Created by nttao on 5/9/2017.
 */
@Configuration
@Import({NiceWriter.class, WriterRunner.class})
public class NiceWriterConfig {
//    @Bean
//    public IWriter writer(){
//        return  new Writer();
//    }
//    @Bean
//    public WriterRunner1 runner(){
//        return new WriterRunner1();
//    }

}
