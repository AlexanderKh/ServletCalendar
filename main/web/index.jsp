<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Locale" %>
<%@ page import="alex.calendar.MonthCalendar" %>
<%@ page import="alex.calendar.DayOfWeek" %>
<%@ page import="alex.calendar.Week" %>
<%@ page import="alex.calendar.Day" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Month Calendar</title>
</head>
<body>
<% String year = request.getParameter("year");
  String month = request.getParameter("month");
  Calendar calendar = Calendar.getInstance();
  if (year != null && month != null){
    calendar.set(Integer.valueOf(year), Integer.valueOf(month), 1);
  }
  calendar.add(Calendar.MONTH, -1);
%>
<a href="/?year=<%=calendar.get(Calendar.YEAR)%>&month=<%=calendar.get(Calendar.MONTH)%>">
  <%=calendar.get(Calendar.YEAR)%>
  <%=calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())%>
</a>
<%calendar.add(Calendar.MONTH, 2);%>
<br>
<a href="/?year=<%=calendar.get(Calendar.YEAR)%>&month=<%=calendar.get(Calendar.MONTH)%>">
    <%=calendar.get(Calendar.YEAR)%>
    <%=calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())%>
</a>
<br>
<%calendar.add(Calendar.MONTH, -1);
  MonthCalendar monthCalendar = new MonthCalendar(calendar);
%>
<table border=1>
    <tr>
        <%for (DayOfWeek dayOfWeek : DayOfWeek.values()){
            %><th>
        <%=dayOfWeek.title()%>
    </th>
    <%}%>
    </tr>
    <%
        for (Week week : monthCalendar.getWeeks()){
            %>
            <tr>
            <%
                for (Day day : week.getDays()){
                    %>
                <td>
                    <%=day.getDayInMonth()%>
                </td>
                <%
                }
            %>
            </tr>
        <%
        }
    %>
    %>
</table>
</body>
</html>