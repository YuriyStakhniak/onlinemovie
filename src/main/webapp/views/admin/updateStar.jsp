<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update star</title>
	<title>Title</title>
	<link rel="stylesheet" href="/bootstrap/css/bootstrap-theme.css">
	<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
</head>
<body>
<table class="table table-hover">

	<thead>

	<form:form action="/updateStar/${currentStar.id}?${_csrf.parameterName}=${_csrf.token}"
			   method="post" enctype="multipart/form-data">
		<div class="form-group"><th><input class="form-control" type="file" name="image"></th></div>
		<div class="form-group"><th><input class="form-control" type="text" name="name" value="${currentStar.name}"></th>
		${starNameException}
		</div>
		<div class="form-group"><th><input class="form-control" type="text" name="about" value="${currentStar.about}"></th>
		${starAboutException}
		</div>
		<div class="form-group"><th><button class="btn btn-default">update star</button></th></div>

	</form:form>

	</thead>

</table>
</body>
</html>