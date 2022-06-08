<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 08/06/2022
  Time: 9:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Search product</h2>
<form action="/products">
    <input type="hidden" name="action" value="search">
    <input type="text" name="name" placeholder="search">
    <button>Search</button>
</form>

<h2>Search by price range</h2>
<form action="/products">
    <input type="hidden" name="action" value="search-by-price">
    <input type="number" name="begin" placeholder="begin price">
    <input type="number" name="end" placeholder="end price">
    <button>Search</button>
</form>
<h2>Product List</h2>
<c:forEach items="${products}" var="product">
    <h3>${product.id}, ${product.name} </h3>
    <c:if test="${product.price > 200}">Sale 10%</c:if>
    <c:if test="${product.price < 200}">Sale 20%</c:if>
</c:forEach>
</body>
</html>
