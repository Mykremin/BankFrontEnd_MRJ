<%-- 
    Document   : customer-edit
    Created on : 09-03-2014, 20:47:32
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
        <title>Customeredit</title>
    </head>
    <body>
        <img src="photos/mrj.jpg"/><br><h1><b><font size="10" color="orange">The MRJ Bank</font></b></h1>

        <h1><b><font size="6" color="black">- Create or edit customer</font></b></h1><br>
        <hr/>

        <form action="Controller" method="post">

            <table border='1'> 

                <tr><td><b>CPR:</b></td><td><input type="text" name="cpr" value="${showCustomer.cpr}" required></td></tr>
                <tr><td><b>Title:</b></td><td>
                        <select name="title" value="${showCustomer.title}">
                            <option value="MR">Mr.</option>
                            <option value="MRS">Mrs.</option>
                            <option value="Ms">Ms.</option>
                        </select></td></tr>
                <tr><td><b>Firstname:</b></td><td><input type="text" name="firstName" value="${showCustomer.firstName}" required></td></tr>
                <tr><td><b>Lastname:</b></td><td><input type="text" name="lastName" value="${showCustomer.lastName}" required></td></tr>
                <tr><td><b>Street:</b></td><td><input type="text" name="street" value="${showCustomer.street}" required></td></tr>
                <tr><td><b>Postalcode:</b></td><td><input type="text" name="postalCode" value="${showCustomer.postalCode}" required></td></tr>
                <tr><td><b>Postaldistrict:</b></td><td><input type="text" name="postalDistrict" value="${showCustomer.postalDistrict}" required></td></tr>
                <tr><td><b>Phone:</b></td><td><input type="text" name="phone" value="${showCustomer.phone}" required></td></tr>
                <tr><td><b>Email:</b></td><td><input type="email" name="email" value="${showCustomer.email}" required></td></tr>

                
                <td><button type ="submit" name="command" value="save-customer">Save customer</button></td>
                
                

        </form>

    </table>
    <br>
    <hr/>
    <a href="Controller?command=back">Back to main page</a>
</body>
</html>
