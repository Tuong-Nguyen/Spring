package spitter.web.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spitter.web.controllers.WriterConfig;
import spitter.web.services.Interfaces.IWriter;

/**
 * Created by nttao on 5/9/2017.
 */
@Service
public class WriterRunner {
    @Autowired
    private IWriter writer;

    public WriterRunner(IWriter writer){
        this.writer = writer;
    }
//    @Autowired
//    public void setWriter(IWriter writer) {
//        this.writer = writer;
//    }
    public IWriter getWriter(){
        return this.writer;
    }
    @Test
    public void write(){
        writer.Write();
    }
}
