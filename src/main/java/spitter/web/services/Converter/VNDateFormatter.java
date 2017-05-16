package spitter.web.services.Converter;

import org.springframework.format.Formatter;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by nkim on 5/16/2017.
 */
public class VNDateFormatter implements Formatter<Date> {

    private String pattern;

    public VNDateFormatter(String pattern){
        this.pattern = pattern;
    }
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        String date = "";
        if (s.length() == 0){
            return null;
        }
        int dayIndex = s.indexOf("ngay");
        int monthIndex = s.indexOf("thang");
        int yearIndex  = s.indexOf("nam");

        if (s.startsWith("ngay")){
            String day = s.substring(dayIndex + 4, monthIndex).trim();
            String month = s.substring(monthIndex + 5, yearIndex).trim();
            String year = s.substring(yearIndex + 3).trim();
            date = day + "/" + month + "/" + year;
        }

        return getDateFormat(locale).parse(date);
    }

    @Override
    public String print(Date date, Locale locale) {
        if (date == null) {
            return "";
        }
        String[] dateArray = getDateFormat(locale).format(date).split("/");
        String printDate = "ngay " + dateArray[0] + " thang " + dateArray[1] + " nam " + dateArray[2];
        return printDate;
    }

    protected DateFormat getDateFormat(Locale locale) {
        DateFormat dateFormat = new SimpleDateFormat(this.pattern, locale);
        dateFormat.setLenient(false);
        return dateFormat;
    }
}
