<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
<!-- Make it a Bootstrap grid view-->
    <c:if test="${!empty listProducts}">
        <table class="tg">
        <tr>
            <th width="120">Product ID</th>
            <th width="80">Product Image</th>
            <th width="120">Product Name</th>
            <th width="120">Category</th>
            <th width="120">Condition</th>
            <th width="60">Price</th>
        </tr>
        <c:forEach items="${listProducts}" var="product">
            <tr>
                <td>${product.productId}</td>
                <td>${product.product_image}</td>
                <td>${product.name}</td>
                <td>${product.category}</td>
                <td>${product.condition}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
        </table>
    </c:if>
    <!--Display all products for sale availiable from database-->



</body>
</html>
