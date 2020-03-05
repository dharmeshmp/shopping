<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.4.1/css/bootstrap.min.css"/>
</head>
<body>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <a class="my-0 navbar-brand col-sm-3 col-md-2 mr-md-auto" href="/">Shopping</a>
    <a class="btn btn-primary mr-2" href="admin">Admin</a>
    <a href="cart" class="btn btn-primary">
        Cart <span class="badge badge-light">${cartItems}</span>
    </a>
</div>

<div class="container">
    <div class="row mb-3 text-center">

        <c:forEach items="${products}" var="product">

            <div class="col-3">
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">${product.name}</h4>
                    </div>
                    <div class="card-body">
                        <h1 class="card-title pricing-card-title">$${product.price}</h1>
                        <p>${product.description}</p>
                        <a href="cart/add/${product.id}" class="btn btn-primary">Add to cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
