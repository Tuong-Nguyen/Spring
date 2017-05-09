package spitter.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import spitter.web.services.Interfaces.IWriter;

/**
 * Created by nttao on 5/9/2017.
 */
public class WriterRunner {

    @Autowired
    private IWriter iWriter;

    public WriterRunner(IWriter iw){
        this.iWriter = iw;
    }
    public IWriter getiWriter() { return iWriter; }

    public void setiWriter(IWriter iWriter) { this.iWriter = iWriter; }

    public void write(){
        iWriter.Write();
    }
}
