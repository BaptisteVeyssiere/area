<%--
  Created by IntelliJ IDEA.
  User: veyssi_b
  Date: 25/10/17
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="eu.epitech.area.Coyote" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Servlet</title>
    <meta charset="utf-8" />
</head>
<body>
    <p>Ceci est une page générée depuis une JSP.</p>
    <p>
        ${ requestScope.test }
        ${ param.auteur }
        <c:out value="test" />
    </p>
    <p>
        Récupération du bean :
        ${ requestScope.coyote.prenom }
        ${ requestScope.coyote.nom }
    </p>
</body>
</html>
