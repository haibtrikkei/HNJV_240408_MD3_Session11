<%--
  Created by IntelliJ IDEA.
  User: bthai
  Date: 7/25/2024
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>List Customer!</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>LIST CUSTOMERS!</h1>
        <form action="/customer" method="get">
            <b>Customer name: </b>
            <input type="text" name="fullName"/>
            <input type="submit" name="action" value="search"/>
        </form>
        <h3 class="text-success">${success}</h3>
        <h3 class="text-danger">${error}</h3>

        <table class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>Full name</th>
                <th>Gender</th>
                <th>Birthday</th>
                <th>Address</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${list}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.fullName}</td>
                    <td>${c.gender?"male":"female"}</td>
                    <td>${c.birthday}</td>
                    <td>${c.address}</td>
                    <td>${c.email}</td>
                    <td>${c.phone}</td>
                    <td>${c.status?"active":"nonactive"}</td>
                    <td>
                        <a href="/customer?action=edit&cusId=${c.id}">update</a>
                        <a href="/customer?action=delete&cusId=${c.id}" onclick="return confirm('Bạn có chắc chắn nuốn xóa?')">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="views/customer/insertCustomer.jsp">Add New Customer</a>
    </div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>