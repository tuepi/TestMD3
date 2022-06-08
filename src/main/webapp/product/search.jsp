<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 08/06/2022
  Time: 10:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Product List to look for</h2>
<c:forEach items="${products}" var="product">
    <h3>${product.id}, ${product.name} </h3>
</c:forEach>
</body>
</html>
