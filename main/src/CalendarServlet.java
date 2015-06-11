import alex.calendar.DayOfWeek;
import alex.calendar.MonthCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

public class CalendarServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Calendar.jsp");
        String year = request.getParameter("year");
        String month = request.getParameter("month");

        Calendar currentMonth = Calendar.getInstance();
        try {
            int yearNo = Integer.valueOf(year);
            int monthNo = Integer.valueOf(month);
            currentMonth.set(yearNo, monthNo, 1);
        }catch (Exception e){
            currentMonth.set(Calendar.DAY_OF_MONTH, 1);
        }

        Calendar nextMonth = getNextMonth(currentMonth);
        Calendar prevMonth = getPreviousMonth(currentMonth);

        request.setAttribute("nextMonthYear", nextMonth.get(Calendar.YEAR));
        request.setAttribute("nextMonthNum", nextMonth.get(Calendar.MONTH));
        request.setAttribute("nextMonthTitle", nextMonth.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));

        request.setAttribute("prevMonthYear", prevMonth.get(Calendar.YEAR));
        request.setAttribute("prevMonthNum", prevMonth.get(Calendar.MONTH));
        request.setAttribute("prevMonthTitle", prevMonth.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));

        MonthCalendar monthCalendar = new MonthCalendar(currentMonth);
        request.setAttribute("monthCalendar", monthCalendar);

        DayOfWeek[] dayOfWeekList = DayOfWeek.values();
        request.setAttribute("dayOfWeekList", dayOfWeekList);

        dispatcher.forward(request, response);
    }

    private Calendar getPreviousMonth(Calendar calendar){
        Calendar result = (Calendar) calendar.clone();
        result.roll(Calendar.MONTH, false);
        return result;
    }

    private Calendar getNextMonth(Calendar calendar){
        Calendar result = (Calendar) calendar.clone();
        result.roll(Calendar.MONTH, true);
        return result;
    }
}
