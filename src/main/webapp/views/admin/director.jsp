<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%--<title>Directors</title>--%>

<%--</head>--%>
<%--<body>--%>
<table class="table table-hover">

    <thead>
    <form:form action="/director?${_csrf.parameterName}=${_csrf.token}"
               method="post" enctype="multipart/form-data">
    <tr>
        <div class="form-group"><td>
            <input class="btn btn-default" type="file" name="image"></td></div>
       <div class="form-group">
           <td><input class="form-control" placeholder="name" type="text" name="name">${directorNameException}</td>

       </div>
        <div class="form-group">
            <td><input class="form-control" placeholder="about" type="text" name="about">${directorAboutException}</td>

        </div>

        <div> <td><button class="btn btn-default">save director</button></td></div>

    </tr>
    </form:form>
    </thead>
    <tbody>

    <c:forEach var="director" items="${directors}">

        <tr>
            <td><img src="${director.pathImage}" alt="${director.pathImage}" width="200px"></td>
            <td>${director.name}</td>
                <td>${director.about}</td>

            <td><a href="/deleteDirector/${director.id}/">delete</a></td>
            <td><a href="/updateDirector/${director.id}">update</a></td>

        </tr>

    </c:forEach>

    </tbody>

</table>

<%--</body>--%>
<%--</html>--%>