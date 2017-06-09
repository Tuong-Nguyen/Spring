package spitter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spitter.web.services.writer.IWriter;
import spitter.web.services.writer.NiceWriter;
import spitter.web.services.writer.WriterRunner;

/**
 * Created by nkim on 5/9/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NiceWriterTestConfig.class})
public class WriterRunnerWithNiceWriterTest {
    @Autowired
    private WriterRunner writerRunner;

    @Autowired
    private IWriter writer;

    @Test
    public void getWriterRunnerObject_ReturnObject(){
        Assert.assertNotNull(writerRunner.getWriter());
    }

    @Test
    public void checkIWriter_returnObject(){
        Assert.assertNotNull(writer);
    }

    @Test
    public void checkIWriter_returnInstanceNiceWriter(){
        Assert.assertTrue(writer instanceof NiceWriter);
    }

    @Test
    public void getWriterMethod_returnIWriter(){
        Assert.assertEquals(writerRunner.getWriter(), writer);
    }

    @Test
    public void getWriter_ReturnNiceWriterObject(){
        Assert.assertTrue(writerRunner.getWriter() instanceof NiceWriter);
    }

}
