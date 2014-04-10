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
    
      #mycustomerform label.error { // gør errorcode teksten rød mm.
        color: red; width:auto; font-size: small;
        float : right; display: block;
      }
      #mycustomerform input.error { // gør textfielden rød kant
        border:1px solid red;
      }

</style>
<script src="js/jquery.min.js"></script> <!-- HUSK AT LÆGGE JQUERY OG VALIDATION LOKALT PGA HTTPS FORBINDELSEN -->
<script src="js/jquery.validate.js"></script>
<script src="js/CustomerValidation.js">
 
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customeredit</title>
    </head>
    <body>
        <img src="photos/mrj.jpg"/><br><h1><b><font size="10" color="orange">The MRJ Bank</font></b></h1>

        <h1><b><font size="6" color="black">- Create or edit customer</font></b></h1><br>
        <hr/>

        <form id="mycustomerform" action="Controller" method="post">

            <table border='1'> 

                <tr><td><b>CPR:</b></td><td><input id="cpr" type="text" name="cpr" value="${showCustomer.cpr}"></td></tr>
                <tr><td><b>Title:</b></td><td>
                        <select name="title" value="${showCustomer.title}">
                            <option value="MR">Mr.</option>
                            <option value="MRS">Mrs.</option>
                            <option value="Ms">Ms.</option>
                        </select></td></tr>
                <tr><td><b>Firstname:</b></td><td><input id="firstname" type="text" name="firstName" value="${showCustomer.firstName}"></td></tr>
                <tr><td><b>Lastname:</b></td><td><input id="lastname" type="text" name="lastName" value="${showCustomer.lastName}"></td></tr>
                <tr><td><b>Street:</b></td><td><input id="street" type="text" name="street" value="${showCustomer.street}"></td></tr>
                <tr><td><b>Postalcode:</b></td><td><input id="postalcode" type="text" name="postalCode" value="${showCustomer.postalCode}"></td></tr>
                <tr><td><b>Postaldistrict:</b></td><td><input id="postaldistrict" type="text" name="postalDistrict" value="${showCustomer.postalDistrict}"></td></tr>
                <tr><td><b>Phone:</b></td><td><input id="phone" type="text" name="phone" value="${showCustomer.phone}"></td></tr>
                <tr><td><b>Email:</b></td><td><input id="email" type="email" name="email" value="${showCustomer.email}"></td></tr>
                <tr><td><b>Password:</b></td><td><input id="password" type="password" name="password" value="${showCustomer.password}"></td></tr>
                <tr><td><b>Password repeat:</b></td><td><input id="passwordrep" type="password" name="passwordrep" value="${showCustomer.password}"></td></tr>


                <td><button id="submit" type ="submit" name="command" value="save-customer">Save customer</button></td>
                <td><button id="getaddress">Get address from phone number</button></td>



        </form>

    </table>
    <br>
    <hr/>
    <a href="Controller?command=back">Back to main page</a>
</body>
</html>
