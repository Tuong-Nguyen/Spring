package spitter.web.services.writer;

import org.springframework.stereotype.Component;

/**
 * Created by nkim on 5/9/2017.
 */

public class Writer implements IWriter {

    @Override
    public void writer(String s) {
        System.out.println(s);
    }
}
