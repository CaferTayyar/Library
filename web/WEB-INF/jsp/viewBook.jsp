<%-- 
    Document   : viewBook
    Created on : Nov 8, 2017, 8:12:43 PM
    Author     : yoruk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${pageContext.request.getContextPath()}
        <table border="1">
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>Book Name</th>
                    <th>Author</th>
                    <th>Summary</th>
                    <th>Owner Id</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.summary}</td>
                    <td>${book.ownerid}</td>
                </tr>
            </tbody>
        </table>
    <c:if test="${sessionScope.user_id != null}">
        <a href="${pageContext.request.getContextPath()}/hireBook?bookId=${book.id}"><input type="button" value="Hire"/></a>
    </c:if>
</body>
</html>
