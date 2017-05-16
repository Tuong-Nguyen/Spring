package spitter.web.services.Converter;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nkim on 5/16/2017.
 */
public class VNDateFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<VNDateFormat> {
    @Override
    public Set<Class<?>> getFieldTypes() {
        return new HashSet<>(Arrays.asList(Date.class));
    }

    @Override
    public Printer<?> getPrinter(VNDateFormat vnDateFormat, Class<?> aClass) {
        return getVNDateFormatter(vnDateFormat, aClass);
    }

    @Override
    public Parser<?> getParser(VNDateFormat vnDateFormat, Class<?> aClass) {
        return getVNDateFormatter(vnDateFormat, aClass);
    }

    private Formatter<Date> getVNDateFormatter(VNDateFormat annotation, Class<?> fieldType){
        VNDateFormatter vnDateFormatter = new VNDateFormatter(annotation.pattern());
        return vnDateFormatter;
    }

}
