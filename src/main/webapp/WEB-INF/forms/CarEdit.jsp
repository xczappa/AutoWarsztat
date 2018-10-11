<%--
  Created by IntelliJ IDEA.
  User: xczappa
  Date: 11.10.18
  Time: 08:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Edit FORM</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>

<form action="caredit" method="post">
    <label>
        id: <input name="id" value="${carone.id}" readonly /><br>
    </label>
    <label>
        Model: <input type="text" name="model" value="${carone.model}" /><br>
    </label>
    <label>
        Marka: <input type="text" name="brand" value="${carone.brand}" /><br>
    </label>
    <label>
        Rocznik: <input type="number" name="year" value="${carone.year}"/><br>
    </label>
    <label>
        Nr rej.: <input type="text" name="plate" value="${carone.plate}"/><br>
    </label>
    <label>
        Nast. przeglad: <input type="date" name="next_check" value="${carone.next_check}"/><br>
    </label>
    <label>
        ID klienta: <input type="number" name="customer_id" value="${carone.customer_id}"/><br>
    </label>
    <input type="submit" value="Wyślij" /><br>

</form>


<jsp:include page="/WEB-INF/fragments/footer.jsp"/>

</body>
</html>
