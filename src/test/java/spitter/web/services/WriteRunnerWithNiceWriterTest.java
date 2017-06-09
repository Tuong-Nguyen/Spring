package spitter.web.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spitter.config.NiceWriterConfig;
import spitter.web.services.Interfaces.IWriter;

/**
 * Created by nttao on 5/9/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NiceWriterConfig.class})
public class WriteRunnerWithNiceWriterTest {
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
    public void initialize_IWriter_IsNiceWriter(){
        Assert.assertEquals(writer.getClass(), NiceWriter.class);
    }
    @Test
    public void getWriter_WriterRunner_IsWriter(){
        Assert.assertEquals(runner.getWriter().getClass(), writer.getClass());
    }
}
