package spitter.web.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import spitter.config.NiceWriterConfig;
import spitter.web.services.Interfaces.IWriter;

/**
 * Created by nttao on 5/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {NiceWriterConfig.class})
public class WriterRunnerWithNiceWriterMockitoTest {
    @Mock
    private IWriter mockWriter;
    @InjectMocks
    private  WriterRunner mockRunner;

    @Test
    public void write_WritterRunner_CallSuccess(){
        mockRunner.write();
        Mockito.verify(mockWriter, Mockito.times(1)).Write();
    }
}
