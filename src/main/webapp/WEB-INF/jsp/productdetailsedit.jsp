<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>Products Edit</h2>

<p>${message}</p>

<form action="productdetailsedit" method="post">
  <label for="id">Product Id:</label><br> <input type="text" id="id" name="id" value="${products.id}"><br>
   <label for="product">Products:</label><br> <input type="text" id="product" name="product" value="${products.product}"><br>
  <label for="price">Price:</label><br>  <input type="text" id="price" name="price" value="${products.price}"><br>
  <label for="quantity">Quantity:</label><br> <input type="text" id="quantity" name="quantity" value="${products.quantity}"><br>
  
  <br>
  <input type="submit" value="Submit">
</form> 

<br><br><br>
<a href ="products">Show Products</a>

</body>
</html>