<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <c:if test="${sessionScope.user_id == null}">
            <a href="${pageContext.request.getContextPath()}/login"><input type="button" value="login"/></a>
        </c:if>
        <c:if test="${sessionScope.user_id == 0}">
            <a href="${pageContext.request.getContextPath()}/addBook"><input type="button" value="add book"/></a>
        </c:if>
        <c:if test="${sessionScope.user_id != null}">
            <a href="${pageContext.request.getContextPath()}/logout"><input type="button" value="logout"/></a>
            <a href="${pageContext.request.getContextPath()}/getHiredBooks"><input type="button" value="get hired books"/></a>
            </c:if>
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
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td><a href="${pageContext.request.getContextPath()}/getBook?id=${book.id}">${book.id}</a></td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.summary}</td>
                        <td>${book.ownerid}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
