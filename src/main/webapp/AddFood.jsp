<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form action="FoodServlet"method="post">
<input type="hidden" value="addFood"name="process" class="form-control">
<table class="table table-success">
<tr>
<th>Food Name:</th>
<td><input type="text"name="foodName" class="form-control"></td>
</tr>
<tr>
<th>Food Type:</th>
<td><input type="text"name="foodType"class="form-control"></td>
</tr>
<tr>
<th>Food Category:</th>
<td><input type="text"name="foodCategory"class="form-control"></td>
</tr>
<tr>
<th>Food Description:</th>
<td><input type="text"name="foodDesc"class="form-control"></td>
</tr>
<tr>
<th>Food Price:</th>
<td><input type="text"name="price"class="form-control"></td>
</tr>
<tr>
<th>Food Iamge:</th>
<td><input type="text"name="image"class="form-control"></td>
</tr>
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>