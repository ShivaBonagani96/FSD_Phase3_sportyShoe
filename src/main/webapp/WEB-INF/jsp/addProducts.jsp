<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>


<form action="saveproducts" method="post">
 
   <label for="product">Products:</label><br>
   <input type="text" id="product" name="product"><br>
   <label for="price">Price:</label><br>
   <input type="text" id="price" name="price" ><br>
  <label for="quantity">Quantity:</label><br>
  <input type="text" id="quantity" name="quantity" ><br>
  
  <br>
  <input type="submit" value="Submit">
</form> 

</body>
</html>