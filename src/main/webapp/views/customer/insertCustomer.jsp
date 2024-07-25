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
    <title>Insert Customer!</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>INSERT CUSTOMER!</h1>
        <h3 class="text-danger">${error}</h3>

        <form action="/customer" method="post">
            <table class="table table-bordered">
                <tr>
                    <td>Full name: </td>
                    <td><input type="text" name="fullName"/> </td>
                </tr>
                <tr>
                    <td>Gender: </td>
                    <td><input type="radio" name="gender" value="true"/>Male
                        <input type="radio" name="gender" value="false"/>Female</td>
                </tr>
                <tr>
                    <td>Birthday: </td>
                    <td><input type="date" name="birthday"/> </td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><textarea name="address"></textarea> </td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="email" name="email"/> </td>
                </tr>
                <tr>
                    <td>Phone: </td>
                    <td><input type="text" name="phone"/> </td>
                </tr>
                <tr>
                    <td>Status: </td>
                    <td><input type="radio" name="status" value="true"/>active
                        <input type="radio" name="status" value="false"/>nonactive</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="action" value="add"/>
                        <input type="reset" value="clear"/></td>
                </tr>
            </table>
        </form>
        <a href="/">Back</a>
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