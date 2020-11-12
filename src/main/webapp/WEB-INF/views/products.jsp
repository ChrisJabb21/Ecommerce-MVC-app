<%@ include file="common/header.jspf" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<title>Products</title>
<p>Checkout all the awesome products available now!</p>
<h2>All Products</h2>
</head>
<body>
<!-- Make it a Bootstrap grid view-->
    <c:if test="${!empty listProducts}">
        <table class="tg">
        <tr>
<!--             <th width="80">Product ID</th>-->
            <th width="80">Product Image</th>
            <th width="80">Product Name</th>
            <th width="80">Category</th>
            <th width="80">Condition</th>
            <th width="60">Price</th>
        </tr>
        <c:forEach items="${listProducts}" var="product">
            <tr>
                <!-- <td>${product.productId}</td> -->
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
	<div class="container">
		<br><br>		
		<table class="table">
			<thead>
				<tr>
					<td scope="col">Photo</td>
					<td scope="col">Product Name</td>
					<td scope="col">Category</td>
					<td scope="col">Condition</td>
					<td scope="col">Price</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listEndpointHere}" var="listEndpointHere">
					<tr>
						<!-- Consider making entire field clickable -->
						<td>${endPointHere.photo}</td>
						<td>${endPointHere.name}</td>
						<td>${endPointHere.category}</td>
						<td>${endPointHere.condition}</td>
						<td>${endPointHere.price}</td>
						<td><button class="addCart" type="button">Add to Cart</button></td>
						<!-- <td>${endPointHere.info}</td> -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> <!-- End of container -->

<%@ include file="common/footer.jspf" %>
