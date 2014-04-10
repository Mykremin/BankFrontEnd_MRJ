<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>The MRJ Bank</title>
     <style>
            
            h1 {text-align: center;}
            
            img {float: left}
          
        </style>
  </head>
  <body>
    <img src="photos/mrj.jpg"/><br><h1><b><font size="10" color="orange">The MRJ Bank</font></b></h1>
        
        <h1><b><font size="6" color="black">- Main page</font></b></h1><br>

        <hr/>
        <ul>
            
            <li> <a href ="Controller?command=list-customers">List customers</a></li>
            <li> <a href ="Controller?command=customer-edit">Create customer</a></li>
            <li> <a href ="Controller?command=wannabeKrak-requests">WannabeKrak requests(count)</a></li>
            <li> <a href ="Controller?command=logout">Log out</a></li>
            <li> <a href ="Controller?command=hello">Test backend</a></li>
            
        </ul>
  </body>
</html>
