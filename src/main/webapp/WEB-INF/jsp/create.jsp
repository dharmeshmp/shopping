<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css"/>
</head>
<body>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="/">Shopping</a>
</div>

<div class="container">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
        <h1 class="h2">Create product</h1>
    </div>

    <div class="row">
        <div class="col-6">
            <%--@elvariable id="product" type="com.example.shopping.model.Product"--%>
            <form:form method="post" action="/admin/create" modelAttribute="product">

                <form:input type="hidden" path="id"/>

                <div class="form-group">
                    <form:label for="name" path="name">Name</form:label>
                    <form:input type="text" name="name" class="form-control" id="name" path="name"/>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <form:label for="code" path="code">Code</form:label>
                        <form:input type="text" name="code" class="form-control" id="code" path="code"/>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="price">Price</label>
                        <form:input type="number" name="price" class="form-control" id="price" path="price"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label for="description" path="description">Description</form:label>
                    <form:textarea type="text" name="description" class="form-control" id="description"
                                   placeholder="Description" path="description"/>
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
