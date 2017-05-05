package spitter.web.services;

import org.springframework.stereotype.Component;

/**
 * Created by lnthao on 5/4/2017.
 */
@Component
public class Writer implements IWriter {
    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
