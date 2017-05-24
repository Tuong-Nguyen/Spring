package spitter.web.models;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * Created by nkim on 5/23/2017.
 */

public class HitCounter {
    private int hits;

    public HitCounter(){
        System.out.println("Hit Counter Instantiated");
    }

    public int getHits(){
        return hits;
    }

    public void setHits(int hits){
        this.hits = hits;
    }
}
