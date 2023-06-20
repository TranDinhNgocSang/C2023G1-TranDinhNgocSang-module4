<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments
</h1>
<form action="/save" method="get">
  <input type="checkbox" name="condiment" value="Lettuce" id="Lettuce"><label for="Lettuce">Lettuce</label><br>
  <input type="checkbox" name="condiment" value="Tomato" id="Tomato"><label for="Tomato">Tomato</label><br>
  <input type="checkbox" name="condiment" value="Mustard" id="Mustard"><label for="Mustard">Lettuce</label><br>
  <input type="checkbox" name="condiment" value="Prouts" id="Prouts"><label for="Lettuce">Prouts</label><br>
    <hr>
    <button type="submit">save</button>
</form>
<c:if test="${condiment != null}">
  <p>Condiments:</p>
  <p>${condiment}</p>
</c:if>
</body>
</html>