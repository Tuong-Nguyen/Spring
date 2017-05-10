package spitter.web.services.writer;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by nkim on 5/9/2017.
 */

public class WriterRunnerWithMock {
    private IWriter writer;

    public WriterRunnerWithMock(IWriter writer){
        this.writer = writer;
    }
    public void setWriter(IWriter writer){
        this.writer = writer;
    }

    public IWriter getWriter() {
        return this.writer;
    }

    public void run(){
        String s = "This is my test";
        writer.writer(s);
    }

}
