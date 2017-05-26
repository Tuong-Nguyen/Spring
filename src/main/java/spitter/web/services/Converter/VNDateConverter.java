package spitter.web.services.Converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nkim on 5/26/2017.
 */
public class VNDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String strDate) {
        Date tmpDate = null;
        try{
            System.out.println("Converting VNDate");
            tmpDate = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);

        } catch (ParseException e){
            e.printStackTrace();
        }
        return tmpDate;
    }
}
