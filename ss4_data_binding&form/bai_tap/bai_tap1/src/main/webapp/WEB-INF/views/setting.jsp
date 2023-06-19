<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/19/2023
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h2>Settings</h2>
<form:form method="post" action="/update" modelAttribute="mail">
    <table>
        <tr>
            <td>Languages</td>
            <td><form:select path="languages" items="${languages}"/></td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td> show <form:select path="pageSize" items="${pageSize}"/> email per page</td>
        </tr>
        <tr>
            <td>Spam filter</td>
            <td><form:checkbox path="spamsFilter"/>Enable spams filter</td>
        </tr>

        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"/></td>
        </tr><tr>
        <td></td>
        <td><button type="submit">Update</button>
            <a href=""><button>Cancel</button></a>
        </td>
    </tr>
    </table>
</form:form>
</body>
</html>
