<%-- 
    Document   : customer-list
    Created on : 26-02-2014, 10:45:13
    Author     : Mykremin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer list</title>
    </head>
    <body>
        
        <img src="photos/mrj.jpg"/><br><h1><b><font size="10" color="orange">The MRJ Bank</font></b></h1>

        <h1><b><font size="6" color="black">- Customer list</font></b></h1><br>

        <hr/>

        <table border='1'> 

            <tr>
                <td><b>CPR:</b></td><td><b>Navn:</b></td><td><b>Adresse:</b></td><td><b>Telefon:</b></td><td><b>Email:</b></td>

            </tr>

            <c:forEach var="customer" items="${customers}">
                <form action="Controller" method="post">

                    <input type ="hidden" name ="cpr" value ="${customer.cpr}">
                    <input type ="hidden" name ="name" value ="${customer.name}">
                    <input type ="hidden" name ="address" value ="${customer.address}">
                    <input type ="hidden" name ="phone" value ="${customer.phone}">
                    <input type ="hidden" name ="email" value ="${customer.email}">
                   
                    <tr>
                        <td>${customer.cpr}</td>
                        <td>${customer.name}</td>
                        <td>${customer.address}</td>
                        <td>${customer.phone}</td>
                        <td>${customer.email}</td> 
                        <td><button type ="submit" name="command" value="list-customer-accounts">Accounts</button></td>
                        <td><button type="submit" name="command" value="customer-update">Update</button></td>
                    </tr>

                </form>
            </c:forEach>
        </table>
        <br>
        <hr/>
        <a href="Controller?command=back">Back to main page</a>



    </body>
</html>
