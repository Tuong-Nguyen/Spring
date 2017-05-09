package spitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spitter.web.services.writer.IWriter;
import spitter.web.services.writer.NiceWriter;

/**
 * Created by nkim on 5/9/2017.
 */
@Configuration
public class WriterTestConfig {
    @Bean
    IWriter writer(){
        return new NiceWriter();
    }
}
