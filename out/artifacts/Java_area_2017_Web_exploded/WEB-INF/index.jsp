<%--
  Created by IntelliJ IDEA.
  User: veyssi_b
  Date: 25/10/17
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="eu.epitech.area.Coyote" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>
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
</html>--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="525303514988-jv1jcq53c6avli5jeg8ig7katqug3u0d.apps.googleusercontent.com">

    <title>Servlet OAuth example</title>
</head>
<body>
<h2>Servlet OAuth example</h2>
<br>
<div class="g-signin2" data-onsuccess="onSignIn"></div>

<script>
    //google callback. This function will redirect to our login servlet
    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        console.log('ID: ' + profile.getId());
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail());
        console.log('id_token: ' + googleUser.getAuthResponse().id_token);

        //do not post all above info to the server because that is not secure.
        //just send the id_token

        var redirectUrl = 'login';

        //using jquery to post data dynamically
        var form = $('<form action="' + redirectUrl + '" method="post">' +
            '<input type="text" name="id_token" value="' +
            googleUser.getAuthResponse().id_token + '" />' +
            '</form>');
        $('body').append(form);
        form.submit();
    }

</script>
</body>
</html>
