package spitter.web.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by lnthao on 5/5/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=NiceWriterConfig.class)
public class WriterRunnerAutoWiredWithNiceWriterConfigTest {
    @Autowired
    private IWriter writer;

    @Autowired
    private WriterRunner writerRunner;

    @Test
    public void writerShouldNotBeNull() {
        assertNotNull(writerRunner.getWriter());
    }

    @Test
    public void writerRunnerShouldNotBeNull() {
        assertNotNull(writerRunner);
    }

    @Test
    public void writerRunner_getWriter_isInstanceOfWriter(){
        Assert.assertTrue(writerRunner.getWriter() instanceof NiceWriter);
    }

    @Test
    public void writerIsInjectedToRunnerSuccessfully(){
        Assert.assertEquals(writer, writerRunner.getWriter());
    }
}
