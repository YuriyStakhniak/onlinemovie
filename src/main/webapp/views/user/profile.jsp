<%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 23.07.2017
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<br/>
<br/>
<br/>
<br/>
<br/>

<table class="table table-hover">

    <thead>
    <tr></tr>
    </thead>

    <tbody>


        <c:forEach var="movie" items="${userCart.movies}" >
        <tr>

            <td>
                ${movie.title}
            </td>
            <td>
                ${userCart.id}
                ${userCart.name}
            </td>
            <td>
                <img src="${movie.pathImage}" alt="${movie.title}" width="100px">
            </td>

            <td><a href="/deleteFromCart/${userCart.id}/${movie.id}">delete</a> </td>

        </tr>

        </c:forEach>


    </tbody>

    <form:form action="/buy" method="post">
        <button class="btn btn-default">buy</button>
    </form:form>

</table>
<table class="table table-hover">
    <thead>
     <c:forEach items="${userOrders.orders}" var="orders">

          <tr>

              <th>

                  ${orders.id}

              </th>
              <th>
                  ${orders.date}
              </th>
              <th>
                 <%--<c:forEach var="movie" items=" ${orders.movies}">--%>
                      <%--${movie.title}--%>
                  <%--</c:forEach>--%>

                         ${orders.movies}

              </th>
          </tr>

      </c:forEach>


    </thead>
</table>