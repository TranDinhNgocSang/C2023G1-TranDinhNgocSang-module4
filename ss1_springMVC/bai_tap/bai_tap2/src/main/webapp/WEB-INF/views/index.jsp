<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Từ Điển Anh - Việt
</h1>
<form method="post" action="/search">
<input type="text" name="eng" placeholder="English" value="${eng}">
    <span>==></span>
    <input type="text" readonly value="${vn}">
    <button type="submit">dịch</button>
</form>
</body>
</html>