package spitter.web.services;

import org.springframework.stereotype.Component;
import spitter.web.services.Interfaces.IWriter;

/**
 * Created by nttao on 5/9/2017.
 */
@Component
public class NiceWriter implements IWriter {
    @Override
    public void Write() {
        System.out.print("this is NiceWriter Object!");
    }
}
