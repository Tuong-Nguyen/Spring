package spitter.web.models;

import spitter.web.models.Interfaces.IWriter;

/**
 * Created by nttao on 5/9/2017.
 */
public class Writer implements IWriter {
    @Override
    public void Write() {
        System.out.print("this is Writer Object!");
    }
}
