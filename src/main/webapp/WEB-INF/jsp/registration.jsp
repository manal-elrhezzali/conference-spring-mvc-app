<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 4/24/22
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>Registration</h1>
    <form:form modelAttribute="registration">
        <table>
            <tr>
                <td>
                    Name:
                </td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                   <input type="submit" value="Add Registration">
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
