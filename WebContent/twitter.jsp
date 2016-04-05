<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QuickBooks Bugs and Feature Tracker</title>
</head>
<body>
<h1>Twitter Related Information</h1>
<p> Found <%=request.getAttribute("count")%> </p>
<table>
  <tr>
  	<td>User Id</td>
  	<td>Name</td>
  	<td>Tweet (Bug or Feature)</td>
  	<td></td>
  </tr>	
  <c:forEach items="${tweetsList}" var="entry">
    <tr>
      <td><c:out value="${entry.key}" /></td>	
      <td><c:out value="${entry.value.name}" /></td>
      <td><c:out value="${entry.value.text}" /></td>
      <td>
          <form action="EventTracker" method="get">
                <input type="hidden" name="trackEntry" value="${entry.key}" />
                <input type="submit" value="Track">
          </form>
        </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>