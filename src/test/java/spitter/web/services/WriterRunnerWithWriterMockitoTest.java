package spitter.web.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import spitter.web.controllers.WriterConfig;
import spitter.web.services.Interfaces.IWriter;

/**
 * Created by nttao on 5/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {WriterConfig.class})
public class WriterRunnerWithWriterMockitoTest {
    @Mock
    private IWriter mockIWriter;
    @InjectMocks
    private WriterRunner mockRunner;
    //    @Test
//    public void IWrite_CallWriteTest(){
//        IWriter mockIWriter = Mockito.mock(IWriter.class);
//        WriterRunner runner = new WriterRunner(mockIWriter);
//        runner.write();
//        Mockito.verify(mockIWriter, Mockito.times(1)).Write();
//    }
    @Test
    public void write_WritterRunner_CallSuccess(){
        mockRunner.write();
        Mockito.verify(mockIWriter, Mockito.times(1)).Write();
    }
}
