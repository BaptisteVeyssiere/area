<%--
  Created by IntelliJ IDEA.
  User: veyssi_b
  Date: 27/10/17
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bienvenue sur Area</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/homepage.css"/>" />
</head>
<c:import url="header.jsp" />
<c:import url="menu.jsp" />
<form method="get" action="linkMaking" >
    <br>
    Action : <select name="action">
        <c:forEach items="${sessionScope.client.getModules()}" var="module" >
            <c:forEach items="${module.getTriggers()}" var="action" >
                <c:out value="<option value=\"${module.getName()}-${action.getName()}\">${module.getName()}-${action.getName()}</option>" escapeXml="False" />
            </c:forEach>
        </c:forEach>
    </select>
    <br>
    <br>
    Reaction : <select name="reaction">
        <c:forEach items="${sessionScope.client.getModules()}" var="module" >
            <c:forEach items="${module.getReactions()}" var="reaction" >
                <c:out value="<option value=\"${module.getName()}-${reaction.getName()}\">${module.getName()}-${reaction.getName()}</option>" escapeXml="False" />
            </c:forEach>
        </c:forEach>
    </select>
    <br>
    <br>
    <input type="submit">
</form>
</html>
