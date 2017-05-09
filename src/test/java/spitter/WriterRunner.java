package spitter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spitter.web.services.writer.IWriter;

/**
 * Created by nkim on 5/9/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WriterTestConfig.class})
public class WriterRunner {
    private IWriter writer;

    @Autowired
    public void setWriter(IWriter writer){
        this.writer = writer;
    }

    public void run(){
        String s = "This is my test";
        writer.writer(s);
    }

    @Test
    public void test_string(){
        this.run();
    }

}
