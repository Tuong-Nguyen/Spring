package spitter;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nkim on 5/8/2017.
 */
public class ListUnitTest {
    @Test
    public void list_RemoveAnObject(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(1));
        list.add(new Integer(1));

        list.remove(new Integer(2));
        Assert.assertEquals(3, list.size());
    }
}
