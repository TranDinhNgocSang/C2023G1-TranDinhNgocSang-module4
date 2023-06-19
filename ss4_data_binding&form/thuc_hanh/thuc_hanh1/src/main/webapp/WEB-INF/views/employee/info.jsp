<%@ page import="org.springframework.web.bind.annotation.ModelAttribute" %>
<%@ page import="org.springframework.ui.ModelMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
<%--    <%--%>
<%--        ModelMap modelMap;--%>
<%--        String ten = modelMap.getAttribute("name");--%>
<%--    %>--%>
    <tr>
        <td>Name:</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>ID:</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>Contact Number:</td>
        <td>${contactNumber}</td>
    </tr>
</table>
</body>
</html>