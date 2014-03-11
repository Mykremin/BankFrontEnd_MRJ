<%-- 
    Document   : transferedit
    Created on : 01-03-2014, 17:09:51
    Author     : Mykremin
Funktionaliteten for at overfører mellem de forskellige kontoer er ikke færdig!!!
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <title>Transfer</title>
    </head>
    <body>
        <img src="photos/mrj.jpg"/><br><h1><b><font size="10" color="orange">The MRJ Bank</font></b></h1>

        <h1><b><font size="6" color="black">- Transfer from account <u>${account.number}</u></font></b></h1><br>
        <p>customer: ${customer.cpr}</p>
        <hr/>

        <form action="Controller" method="post">
            
            <table border='1'> 

                <tr>
                    <td><b>Amount to transfer:</b></td>
                    <td><input type="text" name="amount"></td>
                    <td><b>Transfer to accountnumber:</b></td>
                    <td><input type="text" name="target"></td>
                  
                    
                    <input type="hidden" name="source" value="${account.number}"><br>
                      
                       
                    <td><button type ="submit" name="command" value="save-transfer">Transfer amount</button></td>
                    <td><button type ="submit" name="command" value="list-customer-accounts">Cancel transfer</button></button></td>

                </tr>
            </table>

            <br>
            <hr/>
            <a href="Controller?command=back">Back to main page</a>


        </form>       
    </body>
</html>
