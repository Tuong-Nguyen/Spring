package spitter.web.services.writer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by nkim on 5/9/2017.
 */

public class NiceWriter implements IWriter {
    @Override
    public void writer(String s) {
        System.out.println("The string is " + s);
    }
}
