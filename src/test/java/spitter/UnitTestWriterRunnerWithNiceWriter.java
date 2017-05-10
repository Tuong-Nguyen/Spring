package spitter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@ContextConfiguration(classes = {NiceWriterTestConfig.class})
public class UnitTestWriterRunnerWithNiceWriter {
    @Autowired
    private WriterRunner writerRunner;

    @Autowired
    private IWriter iwriter;

    @Test
    public void getWriterRunnerObject_ReturnObject(){
        Assert.assertNotNull(writerRunner.getWriter());
    }

    @Test
    public void IWriterNotNull(){
        Assert.assertNotNull(iwriter);
    }

    @Test
    public void checkIWriter_isInstanceNiceWriter(){
        Assert.assertTrue(iwriter instanceof NiceWriter);
    }

    @Test
    public void GetWriterMethod_returnIWriter(){
        Assert.assertEquals(writerRunner.getWriter(), iwriter);
    }

    @Test
    public void getWriter_ReturnNiceWriterObject(){
        Assert.assertTrue(writerRunner.getWriter() instanceof NiceWriter);
    }

}