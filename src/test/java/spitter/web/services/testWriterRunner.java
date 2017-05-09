package spitter.web.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spitter.web.services.Interfaces.IWriter;

/**
 * Created by nttao on 5/9/2017.
 */
public class testWriterRunner {
    @Test
    public void wirte(){
        IWriter iWriter = new Writer();
        WriterRunner wr = new WriterRunner(iWriter);
        wr.write();
    }
    @Test
    public void niceWirte(){
        IWriter iWriter = new NiceWriter();
        WriterRunner wr = new WriterRunner(iWriter);
        wr.write();
    }
}
