<%-- 
    Document   : hiredBooks
    Created on : Nov 9, 2017, 8:10:17 PM
    Author     : yoruk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                <c:forEach var="book" items="${hiredBookList}">
                    <tr>
                        <td><a href="${pageContext.request.getContextPath()}/getBook?id=${book.id}">${book.id}</a></td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.summary}</td>
                        <td>${book.ownerid}</td>
                    </tr>
                    <a href="${pageContext.request.getContextPath()}/takeBackBook?bookId=${book.id}"><input type="button" value="Take Back"/></a>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
