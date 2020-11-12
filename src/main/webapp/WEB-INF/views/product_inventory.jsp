<%@ include file="common/header.jspf" %>

    <title>Product Inventory</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
    
    <h1>Product Inventory</h1>
     <c:if test="${!empty listProducts}">
        <table class="tg">
        <tr>
            <th width="80">Product ID</th>
            <th width="80">Product Image</th>
            <th width="80">Product Name</th>
            <th width="80">Category</th>
            <th width="80">Condition</th>
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
    

</div>
<!-- /container -->

<%@ include file="common/footer.jspf" %>