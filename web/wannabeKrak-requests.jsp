<%-- 
    Document   : krak-requests
    Created on : 10-04-2014, 14:27:10
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
<script src="js/jquery.min.js"></script> <!-- HUSK AT LÆGGE JQUERY OG VALIDATION LOKALT PGA HTTPS FORBINDELSEN -->
<script src="js/WannabeKrakRequests.js">
 
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WannabeKrak-requests</title>
    </head>
    <body>
        <img src="photos/mrj.jpg"/><br><h1><b><font size="10" color="orange">The MRJ Bank</font></b></h1>

        <h1><b><font size="6" color="black">- WannabeKrak requests</font></b></h1><br>
        <hr/>

        <table border='1'> 

            <tr><td><b>Requests made(count):</b></td><td><input id="countrequest" type="text" name="countrequest"><button id="btnupdate">Update count</button></td></tr>

        </table>
        <br>
        <hr/>
        <a href="Controller?command=back">Back to main page</a>
    </body>
</html>
