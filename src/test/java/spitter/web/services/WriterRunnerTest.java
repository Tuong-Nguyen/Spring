package spitter.web.services;
import static org.mockito.Mockito.*;
import org.junit.Test;

/**
 * Created by lnthao on 5/4/2017.
 */

public class WriterRunnerTest {
    @Test
    public void run_IWriter_WriteWasCalled(){
        IWriter mockWriter = mock(IWriter.class);
        WriterRunner myDI = new WriterRunner(mockWriter);
        myDI.run();
        verify(mockWriter, times(1)).write("This is my test");
    }
}
