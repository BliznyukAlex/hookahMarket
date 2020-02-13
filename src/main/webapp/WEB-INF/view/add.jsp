<%@include file="includes/header.jsp"%>
<form method="post">

    <div class="form-group">
        <label for="productId">Product ID</label>
        <input name="productId" type="text" class="form-control" id="productId" placeholder="Enter Product ID">
    </div>
    <div class="form-group">
        <label for="productName">Product Name</label>
        <input name="productName" type="text" class="form-control" id="productName" placeholder="Enter Product Name">
    </div>
    <div class="form-group">
        <label for="productPrice">Product price</label>
        <input name="productPrice" type="text" class="form-control" id="productPrice" placeholder="Enter Product Price">
    </div>

    <button type="submit" class="btn btn-primary">Add product</button>
</form>