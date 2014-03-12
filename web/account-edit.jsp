<%-- 
    Document   : account-edit
    Created on : 10-03-2014, 19:27:23
    Author     : Mykremin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Accountedit</title>
    </head>
    <body>
        <img src="photos/mrj.jpg"/><br><h1><b><font size="10" color="orange">The MRJ Bank</font></b></h1>

        <h1><b><font size="6" color="black">- Create new account for customer with <u>${customer.cpr}</u></font></b></h1><br>

        <hr/>

        <form action="Controller" method="post">
            <input type="hidden" name="cpr" value="${customer.cpr}">
            <table border='1'> 

                <tr>
                    <td><b>Accountnumber:</b></td>
                    <td><input type="text" value="Automatically generated"></td>
                <tr><td><b>Interest:</b></td>
                    <td><input type="text" name="interest"></td></tr>

                <td><button type ="submit" name="command" value="save-account">Create account</button></td>
                <td><button type ="submit" name="command" value="list-customer-accounts">Cancel create account</button></td>

                </tr>
            </table>
            <br>
            <hr/> 

            <a href="Controller?command=back">Back to main page</a>
    </body>
</html>
