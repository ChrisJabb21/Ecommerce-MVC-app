<%@ include file="common/header.jspf" %>

<title>Products</title>
</head>
<body>

    <!--Display all products for sale availiable from database-->
	<div class="container">
		<h2>All Products</h2>
		<br>
		<p>Checkout all the awesome products available now!</p>
		<br><br>		
		<table class="table">
			<thead>
				<tr>
					<td scope="col">Photo</td>
					<td scope="col">Product Name</td>
					<td scope="col">Category</td>
					<td scope="col">Condition</td>
					<td scope="col">Price</td>
					<td scope="col">Info</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listEndpointHere}" var="listEndpointHere">
					<tr>
						<td>${endPointHere.photo}</td>
						<td>${endPointHere.name}</td>
						<td>${endPointHere.category}</td>
						<td>${endPointHere.condition}</td>
						<td>${endPointHere.price}</td>
						<td>${endPointHere.info}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> <!-- End of container -->

<%@ include file="common/footer.jspf" %>
