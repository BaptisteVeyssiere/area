<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h2>Modules disponibles :</h2>
<c:forEach items="${applicationScope.core.getModules()}" var="module" >
    <c:set value="false" var="exist" />
    <c:forEach items="${sessionScope.client.getModules()}" var="cmodule" >
        <c:if test="${module.getName().equals(cmodule.getName())}">
            <c:set value="true" var="exist" />
        </c:if>
    </c:forEach>
    <c:if test="${exist.equals(\"false\")}">
        <c:out value="<h2>${module.getName()}</h2>" escapeXml="False" />
        <c:out value="<a title=\"Se connecter\" href=\"${module.getLink()}\">Se connecter</a>" escapeXml="False" />
    </c:if>
</c:forEach>
<h2>Modules connectés :</h2>
<c:forEach items="${sessionScope.client.getModules()}" var="module" >
    <c:out value="<h2>${module.getName()}</h2>" escapeXml="False" />
</c:forEach>
</html>
