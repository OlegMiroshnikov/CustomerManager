<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Customers Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Customer List</h1>

<c:if test="${!empty listCustomers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Reg.Nr</th>
            <th width="360">Name</th>
            <th width="360">EMail</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCustomers}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td><a href="/customerdata/${customer.id}" target="_blank">${customer.regNr}</a></td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td><a href="<c:url value='/edit/${customer.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${customer.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Customer</h1>

<c:url var="addAction" value="/customer/add"/>

<form:form action="${addAction}" commandName="customer">
    <table>
        <c:if test="${!empty customer.regNr}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="regNr">
                    <spring:message text="Reg Nr."/>
                </form:label>
            </td>
            <td>
                <form:input path="regNr"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="Address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="EMail"/>
                </form:label>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>
        <tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty customer.regNr}">
                    <input type="submit"
                           value="<spring:message text="Edit Customer"/>"/>
                </c:if>
                <c:if test="${empty customer.regNr}">
                    <input type="submit"
                           value="<spring:message text="Add Customer"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
