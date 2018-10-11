<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xczappa
  Date: 10.10.18
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View All Cars</title>
</head>
<body>

<jsp:include page="/WEB-INF/fragments/header.jsp"/>
<jsp:include page="/WEB-INF/fragments/menu.jsp"/>

<br>
<a href="caraddnew">Wprowadz dane nowego samochodu</a>

<br><br>

<table class="table table-striped table-bordered table-hover" id="carsviewall">
    <thead>
    <tr>
        <th>id</th>
        <th>Model</th>
        <th>Marka</th>
        <th>Rok produkcji</th>
        <th>Nr rejestracyjny</th>
        <th>Nastepny przeglad</th>
        <th>Kod wlasciciela</th>
        <%--<th>USUŃ</th>--%>
        <%--<th>MODYFIKUJ</th>--%>
        <th>Więcej...</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.id}</td>
            <td>${car.model}</td>
            <td>${car.brand}</td>
            <td>${car.year}</td>
            <td>${car.plate}</td>
            <td>${car.next_check}</td>
            <td>${car.customer_id}</td>
            <%--<td><a href="/cardelete?id=${car.id}">usuń</a></td>--%>
            <%--<td><a href="http://wp.pl">link testowy</a></td>--%>
            <td><a href="/carviewone?id=${car.id}">Szczegóły</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<jsp:include page="/WEB-INF/fragments/footer.jsp"/>




</body>
</html>
