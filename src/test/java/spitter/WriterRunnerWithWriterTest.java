package spitter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.IRObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spitter.web.services.writer.IWriter;
import spitter.web.services.writer.NiceWriter;
import spitter.web.services.writer.Writer;
import spitter.web.services.writer.WriterRunner;

/**
 * Created by nkim on 5/9/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WriterTestConfig.class})
public class WriterRunnerWithWriterTest {
    @Autowired
    private WriterRunner writerRunner;

    @Autowired
    private IWriter iwriter;

    @Test
    public void getWriterRunnerObject_ReturnObject(){
        Assert.assertNotNull(writerRunner.getWriter());
    }

    @Test
    public void checkIWriter_returnObject(){
        Assert.assertNotNull(iwriter);
    }

    @Test
    public void checkIWriter_returnInstanceWriter(){
        Assert.assertTrue(iwriter instanceof Writer);
    }

    @Test
    public void getWriterMethod_returnIWriter(){
        Assert.assertEquals(writerRunner.getWriter(), iwriter);
    }

    @Test
    public void getWriterMethod_ReturnWriterObject(){
        Assert.assertTrue(writerRunner.getWriter() instanceof Writer);
    }



}
