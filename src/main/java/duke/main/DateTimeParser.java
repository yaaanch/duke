package duke.main;

import duke.error.IncorrectDateTimeError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeParser {
    public DateTimeParser() {
    }
    public static Date parse(String s) throws IncorrectDateTimeError {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
        try {
            Date date = formatter.parse(s);
            return date;
        } catch (ParseException e) {
            throw new IncorrectDateTimeError();
        }
    }
    public static String format(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
        return formatter.format(d);
    }
}
