import alex.CalendarFormatter;
import alex.CalendarWriter;
import alex.calendar.Year;
import alex.formatter.HTMLFormatter;
import alex.reader.TodayReader;
import alex.writer.ConsoleWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class First extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {

            OutputStream out = resp.getOutputStream();
            CalendarFormatter formatter = new HTMLFormatter();
            List<Year> today = new TodayReader().getYears();
            CalendarWriter writer = new ConsoleWriter(out);
            writer.writeYears(today, formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
