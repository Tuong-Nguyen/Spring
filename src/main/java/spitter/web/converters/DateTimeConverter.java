package spitter.web.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nttao on 5/26/2017.
 */
public class DateTimeConverter implements Converter<String, Date> {
    @Override
    public Date convert(String strDate) {
        Date date = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ModelAndView view = new ModelAndView();
        try {
            date = (Date) df.parse(strDate);
        }catch (Exception ex){
            throw new RuntimeException();
        }
        return date;
    }
}
