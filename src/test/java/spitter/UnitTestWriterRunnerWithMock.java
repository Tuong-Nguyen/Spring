package spitter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.Verifier;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spitter.web.services.writer.IWriter;
import spitter.web.services.writer.Writer;
import spitter.web.services.writer.WriterRunner;
import spitter.web.services.writer.WriterRunnerWithMock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by nkim on 5/9/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UnitTestWriterRunnerWithMock {

    @Mock
    private IWriter iwriter;

    @InjectMocks
    private WriterRunnerWithMock writerRunner;

    @Test
    public void run_MockWriter_WriteWasCalled(){
        writerRunner.run();
        verify(iwriter, times(1)).writer("This is my test");
    }
}
