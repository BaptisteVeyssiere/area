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
<c:forEach items="${applicationScope.core.getModules()}" var="module" >
    <c:out value="<h2>Module ${module.getName()} :</h2>" escapeXml="False" />
    <c:if test="${module.getTriggers().size() > 0}">
        <c:out value="<h4>Actions :</h4><ul>" escapeXml="False" />
    </c:if>
    <c:forEach items="${module.getTriggers()}" var="trigger" >
        <c:out value="<li>${trigger.getName()}</li>" escapeXml="False" />
    </c:forEach>
    <c:if test="${module.getReactions().size() > 0}">
        <c:out value="</ul><h4>Reactions :</h4><ul>" escapeXml="False" />
    </c:if>
    <c:forEach items="${module.getReactions()}" var="reaction" >
        <c:out value="<li>${reaction.getName()}</li>" escapeXml="False" />
    </c:forEach>
    <c:out value="</ul>" escapeXml="False" />
</c:forEach>
</html>
