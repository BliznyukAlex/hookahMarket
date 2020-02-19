<%@include file="includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="product" type="java"--%>
<form:form method="post" modelAttribute="product">

    <div class="form-group">
        <label for="productId">Product ID</label>
        <form:input name="productId" type="text" class="form-control" id="productId" placeholder="Enter Product ID" path="productId"/>
    </div>
    <div class="form-group">
        <label for="productName">Product Name</label>
        <form:input name="productName" type="text" class="form-control" id="productName" placeholder="Enter Product Name" path="productName"/>
    </div>
    <div class="form-group">
        <label for="productPrice">Product price</label>
        <form:input name="productPrice" type="text" class="form-control" id="productPrice" placeholder="Enter Product Price" path="productPrice"/>
    </div>

    <button type="submit" class="btn btn-primary">Add product</button>

</form:form>