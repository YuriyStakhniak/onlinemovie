<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Director update</title>
</head>
<body>

<table class="table table-hover">

    <thead>
    <tr>
    <form:form action="/updateDirector/${currentDirector.id}?${_csrf.parameterName}=${_csrf.token}"
               method="post" enctype="multipart/form-data">



            <div><td><input type="file" name="image" class="btn btn-default"></td></div>
            <div class="form-group">
                <td>
                <input class="form-control" name="name" type="text" value="${currentDirector.name}">
            </td>
                ${directorNameException}
            </div>
            <div class="form-group">
                <td>
                <input class="form-control" name="about" type="text" size="120" value="${currentDirector.about}">
            </td>
                ${directorAboutException}
            </div>
            <div class="form-group"><td><button class="btn btn-default">update</button></td>
            </div>



    </tr>
    </form:form>
    </thead>

</table>


</body>
</html>
