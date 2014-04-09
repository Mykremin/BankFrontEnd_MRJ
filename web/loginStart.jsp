<%-- 
    Document   : login
    Created on : 10-03-2014, 21:53:07
    Author     : Mykremin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<style>
     h1 {text-align: center;}

    img {float: left}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The MRJ Bank</title>
    </head>
    <body>
         <img src="photos/mrj.jpg"/><br><h1><b><font size="10" color="orange">The MRJ Bank</font></b></h1>

        <h1><b><font size="6" color="black">- Main page</font></b></h1><br>

        <hr/>
        
        <ul>
      <c:if test="${pageContext.request.isUserInRole('Customer')==true}">
        <li><a href="Controller?command=main2">Customer main page</a></li>
      </c:if >

      <c:if test="${pageContext.request.isUserInRole('Employee')==true || 
                    pageContext.request.isUserInRole('SuperEmployee')==true}">
        <li><a href="Controller?command=main2">Employee Main page</a></li>
      </c:if>
        
      <c:if test="${pageContext.request.isUserInRole('SuperEmployee')==true}">
        <li><a href="Controller?command=customer-edit">Add Customer</a></li>
      </c:if>

      <c:choose >
        <c:when test="${pageContext.request.remoteUser== null}">
          <li><a href="Controller?command=showlogin">Login</a>
        </c:when>
        <c:otherwise>
          <li><a href="Controller?command=logout">Log out</a></li>
        </c:otherwise>
      </c:choose>
    </ul>
    </body>
</html>
