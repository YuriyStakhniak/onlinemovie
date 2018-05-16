<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>

<div class="table-responsive">
    <table class="table table-hover">
        <thead>
        <tr>
            <form:form action="/movie?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">

                <th style="width: 210px"><div class="form-group"><input name="image" type="file" class="form-control btn btn-default"></div></th>

                <th style="width: 200px"><div class="form-group" >
                    <input name="title" type="text" class="form-control"
                           placeholder="movie title" value="${movie.title}">${movieTitleException}</div></th>

                <th>
                    <div class="form-group">
                    <select name="directorsId" class="form-control">
                    <option value="-100" selected="selected">director</option>
                    <c:forEach items="${directors}" var="director">

                        <option value="${director.id}">${director.name}</option>

                    </c:forEach>
                    </select>

                </div>
                </th>
                <th style="width: 100px">
                    <div class="form-group">

                        <select name="yearMovie" class="dropdown form-control">
                            <option value="-100" selected="selected">year</option>
                            <option value="1900">1900</option>
                            <option value="1901">1901</option>
                            <option value="1902">1902</option>
                            <option value="1903">1903</option>
                            <option value="1904">1904</option>
                            <option value="1905">1905</option>
                            <option value="1906">1906</option>
                            <option value="1907">1907</option>
                            <option value="1908">1908</option>
                            <option value="1909">1909</option>
                            <option value="1910">1910</option>
                            <option value="1911">1911</option>
                            <option value="1912">1912</option>
                            <option value="1913">1913</option>
                            <option value="1914">1914</option>
                            <option value="1915">1915</option>
                            <option value="1916">1916</option>
                            <option value="1917">1917</option>
                            <option value="1918">1918</option>
                            <option value="1919">1919</option>
                            <option value="1920">1920</option>
                            <option value="1921">1921</option>
                            <option value="1922">1922</option>
                            <option value="1923">1923</option>
                            <option value="1924">1924</option>
                            <option value="1925">1925</option>
                            <option value="1926">1926</option>
                            <option value="1927">1927</option>
                            <option value="1928">1928</option>
                            <option value="1929">1929</option>
                            <option value="1930">1930</option>
                            <option value="1931">1931</option>
                            <option value="1932">1932</option>
                            <option value="1933">1933</option>
                            <option value="1934">1934</option>
                            <option value="1935">1935</option>
                            <option value="1936">1936</option>
                            <option value="1937">1937</option>
                            <option value="1938">1938</option>
                            <option value="1939">1939</option>
                            <option value="1940">1940</option>
                            <option value="1941">1941</option>
                            <option value="1942">1942</option>
                            <option value="1943">1943</option>
                            <option value="1944">1944</option>
                            <option value="1945">1945</option>
                            <option value="1946">1946</option>
                            <option value="1947">1947</option>
                            <option value="1948">1948</option>
                            <option value="1949">1949</option>
                            <option value="1950">1950</option>
                            <option value="1951">1951</option>
                            <option value="1952">1952</option>
                            <option value="1953">1953</option>
                            <option value="1954">1954</option>
                            <option value="1955">1955</option>
                            <option value="1956">1956</option>
                            <option value="1957">1957</option>
                            <option value="1958">1958</option>
                            <option value="1959">1959</option>
                            <option value="1960">1960</option>
                            <option value="1961">1961</option>
                            <option value="1962">1962</option>
                            <option value="1963">1963</option>
                            <option value="1964">1964</option>
                            <option value="1965">1965</option>
                            <option value="1966">1966</option>
                            <option value="1967">1967</option>
                            <option value="1968">1968</option>
                            <option value="1969">1969</option>
                            <option value="1970">1970</option>
                            <option value="1971">1971</option>
                            <option value="1972">1972</option>
                            <option value="1973">1973</option>
                            <option value="1974">1974</option>
                            <option value="1975">1975</option>
                            <option value="1976">1976</option>
                            <option value="1977">1977</option>
                            <option value="1978">1978</option>
                            <option value="1979">1979</option>
                            <option value="1980">1980</option>
                            <option value="1981">1981</option>
                            <option value="1982">1982</option>
                            <option value="1983">1983</option>
                            <option value="1984">1984</option>
                            <option value="1985">1985</option>
                            <option value="1986">1986</option>
                            <option value="1987">1987</option>
                            <option value="1988">1988</option>
                            <option value="1989">1989</option>
                            <option value="1990">1990</option>
                            <option value="1991">1991</option>
                            <option value="1992">1992</option>
                            <option value="1993">1993</option>
                            <option value="1994">1994</option>
                            <option value="1995">1995</option>
                            <option value="1996">1996</option>
                            <option value="1997">1997</option>
                            <option value="1998">1998</option>
                            <option value="1999">1999</option>
                            <option value="2001">2001</option>
                            <option value="2002">2002</option>
                            <option value="2003">2003</option>
                            <option value="2004">2004</option>
                            <option value="2005">2005</option>
                            <option value="2006">2006</option>
                            <option value="2007">2007</option>
                            <option value="2008">2008</option>
                            <option value="2009">2009</option>
                            <option value="2010">2010</option>
                            <option value="2011">2011</option>
                            <option value="2000">2012</option>
                            <option value="2000">2013</option>
                            <option value="2000">2014</option>
                            <option value="2000">2015</option>
                            <option value="2000">2016</option>
                            <option value="2000">2017</option>

                        </select>
                            ${yearException}
                    </div>
                </th>

                <th style="width: 100px">

                    <div class="form-group">
                        <select name="imdbRatingMovie" class="dropdown form-control">

                            <option value="-100" selected="selected">IMDB</option>
                            <option value="1.0">1.0</option>
                            <option value="1.1">1.1</option>
                            <option value="1.2">1.2</option>
                            <option value="1.3">1.3</option>
                            <option value="1.4">1.4</option>
                            <option value="1.5">1.5</option>
                            <option value="1.6">1.6</option>
                            <option value="1.7">1.7</option>
                            <option value="1.8">1.8</option>
                            <option value="1.9">1.9</option>
                            <option value="2.0">2.0</option>
                            <option value="2.1">2.1</option>
                            <option value="2.2">2.2</option>
                            <option value="2.3">2.3</option>
                            <option value="2.4">2.4</option>
                            <option value="2.5">2.5</option>
                            <option value="2.6">2.6</option>
                            <option value="2.7">2.7</option>
                            <option value="2.8">2.8</option>
                            <option value="2.9">2.9</option>
                            <option value="3.0">3.0</option>
                            <option value="3.1">3.1</option>
                            <option value="3.2">3.2</option>
                            <option value="3.3">3.3</option>
                            <option value="3.4">3.4</option>
                            <option value="3.5">3.5</option>
                            <option value="3.6">3.6</option>
                            <option value="3.7">3.7</option>
                            <option value="3.8">3.8</option>
                            <option value="3.9">3.9</option>
                            <option value="4.0">4.0</option>
                            <option value="4.1">4.1</option>
                            <option value="4.2">4.2</option>
                            <option value="4.3">4.3</option>
                            <option value="4.4">4.4</option>
                            <option value="4.5">4.5</option>
                            <option value="4.6">4.6</option>
                            <option value="4.7">4.7</option>
                            <option value="4.8">4.8</option>
                            <option value="4.9">4.9</option>
                            <option value="5.0">5.0</option>
                            <option value="5.1">5.1</option>
                            <option value="5.2">5.2</option>
                            <option value="5.3">5.3</option>
                            <option value="5.4">5.4</option>
                            <option value="5.5">5.5</option>
                            <option value="5.6">5.6</option>
                            <option value="5.7">5.7</option>
                            <option value="5.8">5.8</option>
                            <option value="5.9">5.9</option>
                            <option value="6.0">6.0</option>
                            <option value="6.1">6.1</option>
                            <option value="6.2">6.2</option>
                            <option value="6.3">6.3</option>
                            <option value="6.4">6.4</option>
                            <option value="6.5">6.5</option>
                            <option value="6.6">6.6</option>
                            <option value="6.7">6.7</option>
                            <option value="6.8">6.8</option>
                            <option value="6.9">6.9</option>
                            <option value="7.0">7.0</option>
                            <option value="7.1">7.1</option>
                            <option value="7.2">7.2</option>
                            <option value="7.3">7.3</option>
                            <option value="7.4">7.4</option>
                            <option value="7.5">7.5</option>
                            <option value="7.6">7.6</option>
                            <option value="7.7">7.7</option>
                            <option value="7.8">7.8</option>
                            <option value="7.9">7.9</option>
                            <option value="8.0">8.0</option>
                            <option value="8.1">8.1</option>
                            <option value="8.2">8.2</option>
                            <option value="8.3">8.3</option>
                            <option value="8.4">8.4</option>
                            <option value="8.5">8.5</option>
                            <option value="8.6">8.6</option>
                            <option value="8.7">8.7</option>
                            <option value="8.8">8.8</option>
                            <option value="8.9">8.9</option>
                            <option value="9.0">9.0</option>
                            <option value="9.1">9.1</option>
                            <option value="9.2">9.2</option>
                            <option value="9.3">9.3</option>
                            <option value="9.4">9.4</option>
                            <option value="9.5">9.5</option>
                            <option value="9.6">9.6</option>
                            <option value="9.7">9.7</option>
                            <option value="9.8">9.8</option>
                            <option value="9.9">9.9</option>
                            <option value="10.0">10.0</option>

                        </select>
                            ${imdbRaitingException}
                    </div>

                </th>

                <th style="width: 160px">

                    <div class="form-group">

                        <select class="form-control" multiple="multiple" name="genresId" required arial-required="true">
                            <option value="" selected="">choose genres</option>
                            <c:forEach var="genre" items="${genres}">
                                <option value="${genre.id}">${genre.name}</option>
                            </c:forEach>

                        </select>
                            ${genreException}
                    </div>

                </th>
                <th style="width: 200px">

                    <div class="form-group">

                        <select class="form-control" multiple name="starsId">
                        <option value="-100" selected="selected">choose stars</option>
                        <c:forEach var="star" items="${stars}">
                            <option value="${star.id}">${star.name}</option>
                        </c:forEach>
                        </select>
                            ${starException}
                    </div>

                </th>


                <th>

                    <div class="form-group">
                        <input class="form-control"
                               placeholder="description" name="descriptionMovie"
                               type="text" value="${movie.description}">${descriptionException}
                    </div>

                </th>
                <th></th>
                <th style="width: 50px">

                    <div class="form-group"><button class="btn btn-default">save</button></div>

                </th>

            </form:form>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="movie" items="${movies}">
            <tr>
                <td>

                    <img src="${movie.pathImage}" alt="${movie.pathImage}" width="200">

                </td>

                <td>
                        ${movie.title}
                </td>

                <td>
                    <c:forEach var="director" items="${movie.directors}">
                        ${director.name}</br>
                    </c:forEach>
                </td>

                <td>
                        ${movie.year}
                </td>
                <td>
                        ${movie.imdbRating}
                </td>
                <td>
                    <c:forEach var="genre" items="${movie.genres}">
                        ${genre.name}</br>
                    </c:forEach>
                </td>
                <td>

                    <c:forEach var="star" items="${movie.stars}">
                        ${star.name}</br>
                    </c:forEach>
                ${starException}
                </td>

                <td>
                        ${movie.description}
                </td>
                <td><a href="/deleteMovie/${movie.id}">delete</a></td>
                <td><a href="/updateMovie/${movie.id}">update</a></td>
            </tr>

        </c:forEach>

        </tbody>

    </table>

</div>

</body>
</html>