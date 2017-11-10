<%-- 
    Document   : login
    Created on : Nov 9, 2017, 1:53:43 PM
    Author     : yoruk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${requestScope.name}
        ${sessionScope.ses}
        <form:form method="POST" action="loginIsValid">
            <table> 
                <tr>
                    <td><form:label path="id">User Id</form:label></td>
                    <td><form:input path="id" /></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:input path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
