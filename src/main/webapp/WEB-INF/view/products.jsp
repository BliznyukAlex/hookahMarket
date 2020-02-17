<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="includes/header.jsp"%>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Product Id</th>
        <th scope="col">Product Name</th>
        <th scope="col">Product Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tempProducts" items="${products}">
    <tr>
        <td> ${tempProducts.productId}</td>
        <td> ${tempProducts.productName}</td>
        <td> ${tempProducts.productPrice}</td>

    </tr>


    </c:forEach>
    </tbody>

</table>


