<%--
  Created by IntelliJ IDEA.
  User: veyssi_b
  Date: 25/10/17
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="525303514988-jv1jcq53c6avli5jeg8ig7katqug3u0d.apps.googleusercontent.com">
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/homepage.css"/>" />

    <title>Area</title>
</head>
<body>
<c:import url="header.jsp" />
<br>
<h3>Veuillez vous connecter avec votre compte Google pour acceder à nos service :</h3>
<div class="g-signin2" data-onsuccess="onSignIn"></div>

<script>
    //google callback. This function will redirect to our login servlet
    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        /*console.log('ID: ' + profile.getId());
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail());*/
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
