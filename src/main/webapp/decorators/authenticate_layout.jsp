<%--
  Created by IntelliJ IDEA.
  User: kitaro
  Date: 12/4/2021
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="session" />
<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title><dec:title></dec:title></title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${root}/assets/css/bootstrap.min.css" />

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="${root}/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="${root}/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="${root}/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="${root}/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="${root}/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
    <link rel="icon" href="${root}/assets/img/favicons/favicon.ico">
    <meta name="theme-color" content="#7952b3">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

    <link rel="stylesheet" type="text/css" href="${root}/assets/css/auth.css" />
    <dec:getProperty property="page.local_styles"></dec:getProperty>
</head>
<body class="text-center">
    <main class="main-auth">
        <dec:body></dec:body>
    </main>

    <dec:getProperty property="page.local_scripts"></dec:getProperty>
</body>
</html>
