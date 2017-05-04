package spitter.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lnthao on 5/4/2017.
 */
@Service
public class MySpringBeanWithDependency {
    private IWriter writer;

    @Autowired
    public MySpringBeanWithDependency(IWriter writer) {
        this.writer = writer;
    }

    public void run(){
        String s = "This is my test";
        this.writer.write(s);
    }
}
