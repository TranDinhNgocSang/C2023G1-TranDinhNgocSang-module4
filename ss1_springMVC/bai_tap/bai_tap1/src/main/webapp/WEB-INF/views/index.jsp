<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>bai-tap1</title>
</head>
<body>
<h1>Ứng dụng chuyển đổi tiền tệ
</h1>
<br/>
    <form action="/changeMoney" method="post">
    <input type="number" name="USD" placeholder="USD" min="0">
    <button type="submit">doi</button>
</form>
<p>${kq}</p>
</body>
</html>