<%@ page import="alex.calendar.Day" %>
<%@ page import="alex.calendar.DayOfWeek" %>
<%@ page import="alex.calendar.MonthCalendar" %>
<%@ page import="alex.calendar.Week" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Month Calendar</title>
</head>
<body>
<center>
<h1>Month Calendar</h1><hr>
<%
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    Calendar calendar = Calendar.getInstance();
    if (year != null && month != null){
        calendar.set(Integer.valueOf(year), Integer.valueOf(month), 1);
    }else
        calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.MONTH, -1);
%>
<a href="/?year=<%=calendar.get(Calendar.YEAR)%>&month=<%=calendar.get(Calendar.MONTH)%>">
    <%=calendar.get(Calendar.YEAR)%>
    <%=calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())%>
</a>
<%
    calendar.add(Calendar.MONTH, 2);
%>
<br>
<a href="/?year=<%=calendar.get(Calendar.YEAR)%>&month=<%=calendar.get(Calendar.MONTH)%>">
    <%=calendar.get(Calendar.YEAR)%>
    <%=calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())%>
</a>
<br><hr>
<%
    calendar.add(Calendar.MONTH, -1);
    MonthCalendar monthCalendar = new MonthCalendar(calendar);
%>
<table border = 1>
    <tr>
        <%for (DayOfWeek dayOfWeek : DayOfWeek.values()){%>
            <th>
                <%=dayOfWeek.title()%>
            </th>
        <%}%>
    </tr>
    <%for (Week week : monthCalendar.getWeeks()){%>
        <tr>
            <%for (Day day : week.getDays()){%>
                <td>
                    <font  color=<%=day.getType().weekendDay() ? "'DarkRed'" : "'Black'"%>>
                        <%=day.getDayInMonth()%>
                    </font>
                </td>
            <%}%>
        </tr>
    <%}%>
</table>
</center>
</body>
</html>
