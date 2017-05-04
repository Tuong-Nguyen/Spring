package spitter.web.services;

/**
 * Created by lnthao on 5/4/2017.
 */
public class Writer implements IWriter {
    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
