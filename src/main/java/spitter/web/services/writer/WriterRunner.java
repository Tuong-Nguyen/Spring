package spitter.web.services.writer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spitter.web.services.writer.IWriter;

/**
 * Created by nkim on 5/9/2017.
 */
@Component
public class WriterRunner {
    private IWriter writer;

    @Autowired
    public void setWriter(IWriter writer){
        this.writer = writer;
    }

    public IWriter getWriter() {
        return this.writer;
    }

    public void run(){
        String s = "This is my test";
        writer.writer(s);
    }

}
