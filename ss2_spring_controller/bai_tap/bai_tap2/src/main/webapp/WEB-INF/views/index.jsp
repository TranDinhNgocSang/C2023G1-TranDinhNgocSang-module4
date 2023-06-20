<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
    <input type="number" name="firtsNum" value="${firtsNum}">
    <input type="number" name="secondNum" value="${secondNum}">
    <br>
    <button type="submit" name="calculator" value="summation">+</button>
    <button type="submit" name="calculator" value="Subtraction">-</button>
    <button type="submit" name="calculator" value="multiplication">x</button>
    <button type="submit" name="calculator" value="division">/</button>
</form>
<c:if test="${result != null}">
    <p>result = ${result}</p>
</c:if>
</body>
</html>