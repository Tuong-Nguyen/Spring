package spitter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spitter.web.services.writer.IWriter;
import spitter.web.services.writer.WriterRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by nkim on 5/9/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class WriterRunnerWithMockTest {

    @Mock
    private IWriter iwriter;

    @InjectMocks
    private WriterRunner writerRunner;

    @Test
    public void run_MockWriter_WriteWasCalled(){
        writerRunner.run();
        verify(iwriter, times(1)).writer("This is my test");
    }
}
