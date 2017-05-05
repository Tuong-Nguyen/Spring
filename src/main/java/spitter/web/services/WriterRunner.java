package spitter.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lnthao on 5/4/2017.
 */
@Configuration
@ComponentScan
public class WriterRunner {
    private IWriter writer;

    @Autowired
    public WriterRunner(IWriter writer) {
        this.writer = writer;
    }

    public IWriter getWriter() {
        return this.writer;
    }

    public void run(){
        String s = "This is my test";
        this.writer.write(s);
    }
}
