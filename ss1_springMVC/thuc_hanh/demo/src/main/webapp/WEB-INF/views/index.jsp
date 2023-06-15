<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<h1>Hello: ${name}</h1>
<form action="/greeting" method="post">
    <input name="name" type="text">
    <button type="submit">submit</button>
</form>
</body>
</html>