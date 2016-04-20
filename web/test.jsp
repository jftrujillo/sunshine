<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : test
    Created on : 19-abr-2016, 15:32:41
    Author     : jhon
resource name = java:app/post-gre-sql_remote_virtual_box_postgresPool
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <table border="1">
        <!-- column headers -->
        <tr>
            <c:forEach var="columnName" items="#{ususariosPresentacion.columNames()}">
            <th><c:out value="${columnName}"/></th>
        </c:forEach>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="#{sunshineView.nameUsers}">
        <tr>
            <c:forEach var="column" items="#{sunshineView.nameUsers}">
            <td><c:out value="${column}"/></td>
        </c:forEach>
        </tr>
    </c:forEach>
</table>
        
    </body>
</html>
