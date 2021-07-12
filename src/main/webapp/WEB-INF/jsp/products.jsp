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
<h2>Products</h2>

<p><a href ="/">Logout</a><br><br>

<table style="float:left">



   <tr><th>ID</th><th>Product</th><th>Price</th><th>Quantity</th></tr>
   <c:forEach items="${products}" var="products" varStatus="count">
    <tr id="${count.index}">
        <td>${products.id}</td>
        <td>${products.product}</td>
        <td>${products.price}</td>
        <td>${products.quantity}</td>
    </tr>
  </c:forEach>
</table>
<br><br><br><br><br><br><br><br><br><br><br><br>
<a href="addproducts">Click Here To Add PRODUCT</a> 
<a href ="productdetailsedit">Edit Products</a>

</body>
</html>