import alex.CalendarFormatter;
import alex.CalendarWriter;
import alex.calendar.Year;
import alex.formatter.HTMLFormatter;
import alex.reader.StringParamReader;
import alex.reader.TodayReader;
import alex.writer.ConsoleWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

public class First extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            ServletOutputStream out = resp.getOutputStream();
            CalendarFormatter formatter = new HTMLFormatter();
            List<Year> today = new StringParamReader(req.getParameter("year"), req.getParameter("month")).getYears();
            CalendarWriter writer = new ConsoleWriter(out);
            Calendar currentMonth = today.get(0).getFirstMonth();
            currentMonth.add(Calendar.MONTH, -1);
            out.println("<a href='/servlet?year=" + currentMonth.get(Calendar.YEAR) + "&month=" + currentMonth.get(Calendar.MONTH) + "'> prev month </a>");
            currentMonth.add(Calendar.MONTH, 2);
            out.println("<a href='/servlet?year=" + currentMonth.get(Calendar.YEAR) + "&month=" + currentMonth.get(Calendar.MONTH)  + "'> next month </a>");
            writer.writeYears(today, formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
