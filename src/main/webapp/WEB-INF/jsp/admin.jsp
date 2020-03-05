<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.4.1/css/bootstrap.min.css"/>
</head>
<body>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="/">Shopping</a>
</div>

<div class="container">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
        <h1 class="h2">Products</h1>
        <a href="admin/create" class="btn btn-primary mb-2 mb-md-0">Add product</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Code</th>
            <th scope="col">Price</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${products}" var="product">
            <tr>
                <th scope="row">${product.id}</th>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.code}</td>
                <td>$${product.price}</td>
                <td>
                    <a href="admin/delete/${product.id}" class="btn btn-danger btn-sm mb-2 mb-md-0">Delete</a>
                    <a href="admin/edit/${product.id}" class="btn btn-primary btn-sm mb-2 mb-md-0">Edit</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>
</body>
</html>
