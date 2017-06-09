package spitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spitter.web.services.writer.IWriter;
import spitter.web.services.writer.NiceWriter;
import spitter.web.services.writer.Writer;
import spitter.web.services.writer.WriterRunner;

/**
 * Created by nkim on 5/9/2017.
 */
@Configuration
@Import({Writer.class, WriterRunner.class})
//@ComponentScan("spitter.web.services.writer")
public class WriterTestConfig {

}
