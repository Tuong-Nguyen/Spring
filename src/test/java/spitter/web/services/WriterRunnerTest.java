package spitter.web.services;
import static org.mockito.Mockito.*;
import org.junit.Test;

/**
 * Created by lnthao on 5/4/2017.
 */

public class WriterRunnerTest {
    @Test
    public void run_Writer_WriteWasCalled(){
        IWriter mockWriter = mock(Writer.class);
        WriterRunner myDI = new WriterRunner(mockWriter);
        myDI.run();
        verify(mockWriter, times(1)).write("This is my test");
    }

    @Test
    public void run_NiceWriter_WriteWasCalled(){
        IWriter mockNiceWriter = mock(NiceWriter.class);
        WriterRunner myDI = new WriterRunner(mockNiceWriter);
        myDI.run();
        verify(mockNiceWriter, times(1)).write("This is my test");
    }
}
