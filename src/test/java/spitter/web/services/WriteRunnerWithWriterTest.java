package spitter.web.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spitter.config.WriterConfig;
import spitter.web.services.Interfaces.IWriter;

/**
 * Created by nttao on 5/9/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WriterConfig.class})
public class WriteRunnerWithWriterTest {
    @Autowired
    private WriterRunner runner;

    @Autowired
    private IWriter writer;

    @Test
    public void initialize_WritterRunner_Success(){
        Assert.assertNotNull(runner);
    }
    @Test
    public void  initialize_IWriter_Success(){
        Assert.assertNotNull(writer);
    }
    @Test
    public void initialize_IWriter_IsWriter(){
        Assert.assertEquals(writer.getClass(), Writer.class);
    }
    @Test
    public void getWriter_WriterRunner_IsWriter(){
        Assert.assertEquals(runner.getWriter().getClass(), writer.getClass());
    }
}
