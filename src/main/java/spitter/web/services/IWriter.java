package spitter.web.services;

import org.springframework.stereotype.Service;

/**
 * Created by lnthao on 5/4/2017.
 */
@Service
public interface IWriter {
    public void write(String s);
}
