<%-- 
    Document   : main
    Created on : Jun 10, 2014, 2:06:25 PM
    Author     : sarm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
    </head>
    <body>
        <h1> So another Hello World!</h1>
        
        <textarea name="fileUpload" rows="4" cols="20">
        </textarea>
        <form action="">
            <input type="file" name="fileUpload" value="" />
            <input type="submit" value="Upload" />
            
            <f:view>
                <h:form>
                   
                </h:form>
            </f:view>

        </form>
         </body>
</html>
