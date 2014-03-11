<%-- 
    Document   : show-account-detail
    Created on : 28-02-2014, 12:23:36
    Author     : RidvanGurel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<style>
    h1 {text-align: center;}

    img {float: left}

    table {
        background-color: #cccccc;
        border: 3px solid;
        border-color: #eeeeee #aaaaaa #aaaaaa #eeeeee;
    }

    th, td {
        padding: 0.8ex;    /* Det er afstanden mellem tekst og rækken*/
    } 
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account detail</title>
    </head>
    <body>
        <input type="hidden" name="cpr" value="${customer.cpr}">
        <img src="photos/mrj.jpg"/><br><h1><b><font size="10" color="orange">The MRJ Bank</font></b></h1>

        <h1><b><font size="6" color="black">- Account detail for account: ${account.number}</font></b></h1><br>

        <hr/>
        <ul>
            <li>customer: ${customer.cpr}</li>
            <li>Account number: ${account.number}</li>
            <li>Interest: <fmt:formatNumber value="${account.interest}" maxFractionDigits="3" minFractionDigits="3"/></li>
            <li>Type: ${account.type}</li>
        </ul>

        <table border='1'> 

            <tr>
                <th>Dato:</th>
                <th>Beløb:</th>
                <th>Konto:</th>

            </tr>

            <c:forEach var="transfer" items="${account.transfers}">
                <tr>
                    <td>${transfer.date}</td>
                    <td> ${transfer.amount}</td> 
                    <td>${transfer.accountNumber}</td>
                </tr>
            </c:forEach>
        </table>


     <br>
    <hr/>
    <a href="Controller?command=back">Back to main page</a>
</body>
</html>
