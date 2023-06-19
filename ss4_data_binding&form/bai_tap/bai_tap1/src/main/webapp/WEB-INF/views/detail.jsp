<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/19/2023
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>email</title>
</head>
<body>
<h2>Mail</h2>
<table>
    <tr>
        <th>
            Languages
        </th>
        <td>
            ${mail.languages}
        </td>
    </tr>
    <tr>
        <th>
            Page Size
        </th>
        <td>
            ${mail.pageSize}
        </td>
    </tr>
    <tr>
        <th>
            Spam filte
        </th>
        <c:if test="${mail.spamsFilter == true}">
            <td>Enable</td>
        </c:if>
        <c:if test="${mail.spamsFilter == false}">
            <td>Disable</td>
        </c:if>
    </tr>
    <tr>
        <th>
            Signature
        </th>
        <td>
            ${mail.signature}
        </td>
    </tr>
</table>
<a href="/update-form">
    <button>Setting</button>
</a>
</body>
</html>
