<%--
  Created by IntelliJ IDEA.
  User: xczappa
  Date: 11.10.18
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car View One</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>
<jsp:include page="/WEB-INF/fragments/menu.jsp"/>


<table class="table table-striped table-bordered table-hover" id="carsviewone">
    <thead>
    <tr>
        <th>Dane</th>
        <th>Samochód nr ${carone.id}</th>
    </tr>
    </thead>

    <tbody>
    <tr><td>Id:<td>${carone.id}</td></tr>
    <tr><td>Model:<td>${carone.model}</td></tr>
    <tr><td>Marka:<td>${carone.brand}</td></tr>
    <tr><td>Rok produkcji:<td>${carone.year}</td></tr>
    <tr><td>Nr rej.:<td>${carone.plate}</td></tr>
    <tr><td>Nast. przegląd:<td>${carone.next_check}</td></tr>
    <tr><td>Nr klienta:<td>${carone.customer_id}</td></tr>
    </tbody>
</table> <br><br>
<a href="/taskbycar?car_id=${carone.id}">ZLECENIA dla tego samochodu</a><br>
<a href="/caredit?car_id=${carone.id}">EDYTUJ dane tego samochodu</a><br>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>

</body>
</html>
