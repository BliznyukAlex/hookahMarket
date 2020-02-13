
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
    <tr>
<%--        <th scope="row">1</th>--%>
        <td>${productId}</td>
        <td>${productName}</td>
        <td>${productPrice}</td>
    </tr>

    </tbody>
</table>


