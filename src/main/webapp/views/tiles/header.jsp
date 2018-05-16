<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 24.06.2017
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%--<script src="/js/jquery-3.2.1.min.js"></script>--%>
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          <%--integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"--%>
            <%--integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"--%>
            <%--crossorigin="anonymous"></script>--%>

    <meta charset="UTF-8">
</head>
<body>
<nav class="nav navbar-nav">
<div class="container-fluid">
<header class="header" role="banner">
<nav>
<ul class="nav navbar-nav">
    <li class="active">
        <sec:authentication property="name"/>
    </li>
    <li class="active"><a href="/">home</a> </li>
   <sec:authorize access="hasRole('ROLE_ADMIN')">
       <li class="active"><a href="/movie">movies</a></li>
       <li class="active"><a href="/star">stars</a></li>
       <li class="active"><a href="/director">directors</a></li>
       <li class="active"><a href="/genre">genres</a></li>

   </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <li class="active"><a href="/register">register</a></li>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">

        <li class="active"><a href="/profile">profile</a></li>


        <li>
            <form:form action="/logout" method="post">
                <button>log out</button>
            </form:form>
        </li>
    </sec:authorize>


</ul>
</nav>
</header>
</div>
</nav>

</br>
</br>
</br>


</body>
</html>
