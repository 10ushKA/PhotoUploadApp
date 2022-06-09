<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.05.2022
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style><%@include file="/WEB-INF/css/custom_buttons.css"%></style>
    <title>Download From DB</title>
    <style>
        tr,td,th{
            padding: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<%--<form method="get" class="form-group" id="myForm" action="download?command=download_photo" enctype="multipart/form-data" >--%>
<form method="get" class="form-group" id="myForm" action="downloadServlet" enctype="multipart/form-data" >
<%--<from method = "post" action = "post">--%>
<%--<from method = "" action="download?command=to_download">--%>
    <table border = "2">
<%--        <thead>--%>
<%--        <tr>First Name</tr>--%>
<%--        <tr>Last Name</tr>--%>
<%--        <tr>Photo Name</tr>--%>
<%--        <tr>Added Date</tr>--%>
<%--        <tr>Download</tr>--%>
<%--        </thead>--%>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Photo Name</th>
        <th>Added Date</th>
        <th>Download</th>
    </tr>
        <tbody>
        <c:forEach var = "user" items="${users}">
            <tr>
                <td>
                    <c:out value="${user.id}" />
                </td>
                <td>
                    <c:out value="${user.firstName}" />
                </td>
                <td>
                    <c:out value="${user.lastName}" />

                </td>
                <td>
                    <c:out value="${user.photoName}" />
                </td >

                <td>
                    <c:out value="${user.addedDate}" />
                </td>

                <td>
<%--                    <c:when test="${user.photoName}">--%>

                        <a href="downloadServlet?id=${user.id}"  class="previous round">&#8595;</a>
<%--                    </c:when>--%>

<%--                  <a href="download?command=download_photo" class="previous round" download="" target="_blank">&#8595;</a>--%>
<%--                <td><a href="DownloadServlet?fileName=<%=rs.getString(4)%>">Download</a></td>--%>
                </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<a href = "home?command=to_home">Home</a>
<%--</from>--%>
</body>
</html>
