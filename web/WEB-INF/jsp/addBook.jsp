<%-- 
    Document   : addBook
    Created on : Nov 8, 2017, 11:53:13 AM
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
        <form:form method="POST" action="addBookToDatabase">
            <table> 
                <tr>
                    <td><form:label path="id">Book ISBN</form:label></td>
                    <td><form:input path="id" /></td>
                </tr>
                <tr>
                    <td><form:label path="title">Book Name</form:label></td>
                    <td><form:input path="title" /></td>
                </tr>
                <tr>
                    <td><form:label path="author">Author</form:label></td>
                    <td><form:input path="author" /></td>
                </tr>
                <tr>
                    <td><form:label path="summary">Summary</form:label></td>
                    <td><form:input path="summary" /></td>
                </tr>
                <tr>
                    <td><form:label path="ownerid">Owner Id</form:label></td>
                    <td><form:input path="ownerid" /></td>
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
