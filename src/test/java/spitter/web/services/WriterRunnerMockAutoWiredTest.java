package spitter.web.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by lnthao on 5/5/2017.
 */
public class WriterRunnerMockAutoWiredTest {
    @Mock
    private IWriter writer;

    @InjectMocks
    private WriterRunner writerRunner;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void writerShouldNotBeNull() {
        assertNotNull(writer);
    }

    @Test
    public void writerRunnerShouldNotBeNull() {
        assertNotNull(writerRunner);
    }

    @Test
    public void mockWriterIsInjectedToRunnerSuccessfully(){
        Assert.assertEquals(writer, writerRunner.getWriter());
    }

    @Test
    public void run_MockWriter_WriteWasCalled(){
        writerRunner.run();
        verify(writer, times(1)).write("This is my test");
    }

    @Test
    public void run_MockWriter_WriteWasNotCalled_WithWrongParameter(){
        writerRunner.run();
        verify(writer, times(0)).write("This is my wrong test ");
    }
}
