<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Month Calendar</title>
</head>
<body>
<center>
    <h1>Month Calendar</h1>
    <hr>
    <table border = 1>
        <tr>
            <jstl:forEach var="dayOfWeek" items="${dayOfWeekList}">
                <th>
                    ${dayOfWeek.title()}
                </th>
            </jstl:forEach>
        </tr>
        <jstl:forEach var="week" items="${monthCalendar.getWeeks()}">
            <tr>
                <jstl:forEach var="day" items="${week.getDays()}">
                    <td>
                        ${day.getDayInMonth()}
                    </td>
                </jstl:forEach>
            </tr>
        </jstl:forEach>
    </table>
</center>
</body>
</html>
