package spitter.web.services;

import spitter.web.services.Interfaces.IWriter;

/**
 * Created by nttao on 5/9/2017.
 */
public class Writer implements IWriter {
    @Override
    public void Write() {
        System.out.print("this is Writer Object!");
    }
}
