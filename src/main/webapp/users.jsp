<%--
  Created by IntelliJ IDEA.
  User: OSCAR
  Date: 29/05/2022
  Time: 4:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Lista clientes</h1>
<ul>
<c:forEach var="users" items="$(Users)">
    <li>$(Users.user_id) $(Users.user_name)</li>
</c:forEach>
</ul>
</body>
</html>
