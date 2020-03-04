<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@include file="includes/header.jsp" %>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Product Id</th>
        <th scope="col">Product Name</th>
        <th scope="col">Product Price</th>
        <th scope="col">Image</th>
        <th scope="col">Update</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tempProducts" items="${products}">
        <c:url var="updateLink" value="/updateProduct">
            <c:param name="productId" value="${tempProducts.productId}"/>
        </c:url>
        <tr>
            <td> ${tempProducts.productId}</td>
            <td> ${tempProducts.productName}</td>
            <td> ${tempProducts.productPrice}</td>
            <td><img src="${pageContext.request.contextPath}${initParam.imagesPath}products/1.jpg"/></td>
            <td>
                <!-- display the update link -->
                <a href="${updateLink}">Update</a>
            </td>
            <td>
                <s:url var="deleteLink" value="/products">
                    <s:param name="productId" value="${tempProducts.productId}"/>
                </s:url>
                <sf:form action="${deleteLink}" method="delete">
                    <div class="pull-right">
<%--                        <button type="submit" class="btn btn-xs btn-default">Delete</button>--%>
                        <input class="btn-link" type="submit" value="Delete">
                    </div>
                </sf:form>
            </td>
        </tr>

    </c:forEach>
    </tbody>

</table>

<br>

<div>
    <a href="<c:url value="add"/>">
        <button type="submit" class="btn btn-primary">
            Create product
        </button>
    </a>
</div>
