<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%--<title>Insert title here</title>--%>
<%--</head>--%>
<%--<body>--%>

    <form:form action="/logout" method="post">
        <button>log out</button>
    </form:form>

<table class="table table-hover">

    <thead style="text-align: center">

    <tr>
        <th style="text-align: center">movie pic</th>
        <th style="text-align: center">title</th>
        <th style="text-align: center">year</th>
        <th style="text-align: center">imdb</th>
        <th style="text-align: center">genre</th>
        <th style="text-align: center">stars</th>
        <th style="text-align: center">director</th>
        <th style="text-align: center">description</th>

    </tr>

    </thead>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>

                <img src="${movie.pathImage}" alt="${movie.pathImage}" width="200">

            </td>
            <td style="text-align: center">
                    ${movie.title}
            </td>

            <td style="text-align: center">
                    ${movie.year}
            </td>
            <td style="text-align: center">
                    ${movie.imdbRating}
            </td>
            <td style="text-align: center">
                <c:forEach var="genre" items="${movie.genres}">
                    ${genre.name}</br>
                </c:forEach>
            </td>
            <td style="text-align: center">

                <c:forEach var="star" items="${movie.stars}">
                    ${star.name}</br>
                </c:forEach>

            </td>
            <td>
                <c:forEach var="director" items="${movie.directors}">
                    ${director.name}
                </c:forEach>
            </td>

            <td>
                    ${movie.description}
            </td>

           <sec:authorize access="hasRole('ROLE_USER')">
               <td><a href="/addToCart/${movie.id}">add to cart</a></td>
               <td><a href="/buy/${movie.id}">buy</a></td>
           </sec:authorize>


        </tr>

    </c:forEach>

</table>
    <input type="hidden" name="csrf_name"
           value="${_csrf.parameterName}"/>
    <input type="hidden" name="csrf_value"
           value="${_csrf.token}"/>
<%--</body>--%>
<%--</html>--%>