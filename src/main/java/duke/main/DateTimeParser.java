package duke.main;

import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.Parser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class DateTimeParser {
    public DateTimeParser() {
    }

    public static Date parse(String s) {
        Parser parser = new Parser();
        List<DateGroup> groups = parser.parse(s);
        return groups.get(0).getDates().get(0);
    }

    public static String format(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
        return formatter.format(d);
    }
}
