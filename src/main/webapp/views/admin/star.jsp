<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>movies stars</title>
    <%--<link rel="stylesheet" href="/bootstrap/css/bootstrap-theme.css">--%>
    <%--<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">--%>
</head>
<body>

    <div class="container">

        <div class="panel">
            <form:form action="/star?${_csrf.parameterName}=${_csrf.token}"
                       method="post" enctype="multipart/form-data">
                <div style="display: flex; justify-content: space-around ">

                    <div class="form-group">
                        <input name="name" type="text" class="form-control"
                                  placeholder="star name"/>
                        ${starNameException}
                    </div>
                    <div class="form-group">
                        <input name="about" type="text" class="form-control"
                                     placeholder="about"/>
                        ${starAboutException}
                    </div>
                    <div class="form-group">
                        <input type="file" name="image" class="btn btn-default btn-file">
                    </div>

                    <div class="form-group">
                        <button class="btn btn-default">save star</button>
                    </div>
                </div>
            </form:form>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>star name</th>
                <th>about star</th>
                <th>pic</th>
                <th>movies</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="star" items="${stars}">
                <tr>
                    <td>
                            ${star.name}
                    </td>
                    <td>
                            ${star.about}
                    </td>
                    <td>
                        <img src="${star.pathImage}" alt="" width="200px">
                    </td>
                    <td>

                    </td>
                    <td>
                        <a href="/updateStar/${star.id}">update</a>
                    </td>
                    <td>
                        <a href="/deleteStar/${star.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </div>
</body>
</html>