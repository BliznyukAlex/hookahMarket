<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="includes/header.jsp" %>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Product Id</th>
        <th scope="col">Product Name</th>
        <th scope="col">Product Price</th>
        <th scope="col">Image</th>
        <th scope="col">Update</th>
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

        </tr>

    </c:forEach>
    </tbody>

</table>

<br>

<s:url var="newProduct" value="/add"></s:url>
<%--<a href="${newProduct}">Create product</a>--%>

<%--<sf:form id="productForm" class="form-horizontal"--%>
<%--         action="${newProduct}">--%>
<%--    <button type="submit" class="btn btn-primary">--%>
<%--        Create product--%>
<%--    </button>--%>
<%--</sf:form>--%>

<%--<sf:form id="productForm" class="form-horizontal"--%>
<%--         action="${add}">--%>

<%--    <div class="form-group">--%>
<%--        <div class="col-sm-offset-3 col-sm-8">--%>
<%--            <a href="<c:url value="products" />" class="btn">--%>
<%--                Back--%>
<%--            </a>--%>
<%--            <button type="submit" class="btn btn-primary">--%>
<%--                Create product--%>
<%--            </button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--&lt;%&ndash;</sf:form>&ndash;%&gt;--%>