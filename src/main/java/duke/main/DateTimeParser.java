package duke.main;

//import com.joestelmach.natty.DateGroup;
//import com.joestelmach.natty.DateGroup;
import duke.error.IncorrectDateTimeError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.util.List;
//import com.joestelmach.natty.Parser;

public class DateTimeParser {
    public DateTimeParser() {
    }

    public static Date parse(String s) throws IncorrectDateTimeError {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
//        try {
//            Date date = formatter.parse(s);
//            return date;
//        } catch (ParseException e) {
//            throw new IncorrectDateTimeError();
//        }
        com.joestelmach.natty.Parser parser = new com.joestelmach.natty.Parser();
        List<com.joestelmach.natty.DateGroup> groups = parser.parse("the day before next thursday");
        return groups.get(0).getDates().get(0);
    }



    public static String format(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
        return formatter.format(d);
    }
}
