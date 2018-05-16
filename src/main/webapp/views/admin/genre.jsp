<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Genres</title>
</head>
<body>

<table class="table table-hover">

<thead>
<form:form>
<tr>

        <div class="form-group"><td><input class="form-control" name="name" type="text" placeholder="name"></td>
        ${genreNameExeption}
        </div>

        <div class="form-group"><td><button class="btn btn-default">save genre</button></td></div>
</tr>
 </form:form>
     </thead>


   <tbody>
   <c:forEach var="genre" items="${genres}">
   <tr>


           <td style="text-align: center">${genre.name}</td>
              <td style="text-align: right"> <a href="/deleteGenre/${genre.id}">delete</a></td>
               <td style="text-align: left"><a href="/updateGenre/${genre.id}">update</a></td>




   </tr>
   </c:forEach>
   </tbody>
</table>



</body>
</html>