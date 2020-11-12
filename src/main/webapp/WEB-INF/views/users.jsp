<%@ include file="common/header.jspf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Page</title>
</head>
<body>
 <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
                <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
        
            </c:if> 
        
     <c:if test="${!empty listUsers}">
        <table class="tg">
        <tr>
            <th width="80">Username</th> 
            <th width="80">Full Name</th>           
            <th width="80">Email Address</th>
            <th width="80">Enabled</th>
            <th width="80">Contact Number</th>
            <th width="80">Shipping Address</th>
            <th width="80">Billing Address</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.fullname}</td>
                <td>${user.email}</td>
                <td>${user.enabled}</td>
                <td>${user.phone_number}</td>
                <td>${user.shipping_address}</td>
                <td>${user.billing_address}</td>
            </tr>
        </c:forEach>
        </table>
    </c:if> 
    <!--Display all Users from database-->
    <!-- add Create, Update and Delete user functionality -->



</body>
</html>