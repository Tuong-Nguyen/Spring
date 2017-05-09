package spitter.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import spitter.web.models.Interfaces.IWriter;

/**
 * Created by nttao on 5/9/2017.
 */
public class WriterRunner {
    @Autowired
    private IWriter iWriter;

    public void write(){
        iWriter.Write();
    }
}
