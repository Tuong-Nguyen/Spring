package spitter.web.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by lnthao on 5/5/2017.
 */
@Configuration
@Import({Writer.class, WriterRunner.class})
public class WriterConfig {
}
