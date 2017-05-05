package spitter.web.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by lnthao on 5/5/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WriterConfig.class)
public class WriterRunnerAutoWiredTest {
    @Autowired
    private IWriter writer;

    @Autowired
    private WriterRunner writerRunner;

    @Test
    public void writerShouldNotBeNull() {
        assertNotNull(writer);
    }

    @Test
    public void writerRunnerShouldNotBeNull() {
        assertNotNull(writerRunner);
    }

    @Test
    public void writerRunner_getWriter_isInstanceOfWriter(){
        Assert.assertTrue(writerRunner.getWriter() instanceof Writer);
    }

    @Test
    public void writerIsInjectedToRunnerSuccessfully(){
        Assert.assertEquals(writer, writerRunner.getWriter());
    }
}
