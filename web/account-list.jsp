

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
        <title>Accountliste</title>
    </head>
    <body>
        <img src="photos/mrj.jpg"/><br><h1><b><font size="10" color="orange">The MRJ Bank</font></b></h1>

        <h1><b><font size="6" color="black">- Customer with <u>${customer.cpr}</u> accountlist</font></b></h1><br>

        <hr/>
        <form action ="Controller" method="post">
        
        <button type ="submit" name="command" value="account-edit">Create new account</button>

        <table border='1'> 

            <tr>
                <td><b>Kontonummer:</b></td><td><b>Type:</b></td><td><b>Saldo:</b></td>

            </tr>

            <c:forEach var="account" items="${accounts}">

                

                    <input type ="hidden" name ="number" value ="${account.number}">

                    <tr>
                        <td>${account.number}</td>
                        <td>${account.type}</td>
                        <td>${account.balance} kr.</td>
                        <td><button type ="submit" name="command" value="show-account-detail">Details</button></td>
                        <td><button type ="submit" name="command" value="prepare-transfer">Transfer</button></td>
                    </tr>
                </form>
            </c:forEach>
        </table>
        <br>
        <hr/> 

        <a href="Controller?command=back">Back to main page</a>
    </body>

</html>
