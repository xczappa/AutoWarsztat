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

<table class="table table-striped table-bordered table-hover" id="carsviewone">
    <thead>
    <tr>
        <th>id</th>
        <th>Model</th>
        <th>Marka</th>
        <th>Rok produkcji</th>
        <th>Nr rejestracyjny</th>
        <th>Nastepny przeglad</th>
        <th>Kod wlasciciela</th>
        <th>USUŃ</th>
        <th>MODYFIKUJ</th>
    </tr>
    </thead>
    <tbody>
    <%--<c:forEach var="car" items="${carone}">--%>
        <tr>
            <td>${carone.id}</td>
            <td>${carone.model}</td>
            <td>${carone.brand}</td>
            <td>${carone.year}</td>
            <td>${carone.plate}</td>
            <td>${carone.next_check}</td>
            <td>${carone.customer_id}</td>
            <td><a href="/cardelete?id=${carone.id}">usuń</a></td>
            <td><a href="http://wp.pl">link testowy</a></td>
        </tr>
    <%--</c:forEach>--%>
    </tbody>
</table>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>

</body>
</html>
