<%-- 
    Document   : addEmployeeform
    Created on : Jul 3, 2014, 4:11:51 PM
    This form uses Spring core tags for a form and to uplopad a file
    Author     : sarm
--%>

<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Upload Form</title>
    </head>
    <body>
        <form:form modelAttribute="employeeData" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>Upload Fields</legend>
 
                <p>
                    <form:label for="name" path="name">Name</form:label><br/>
                    <form:input path="name"/>
                </p>
                
                  <p>
                    <form:label for="lastname" path="lastname">Name</form:label><br/>
                    <form:input path="lastname"/>
                </p>
                  <p>
                    <form:label for="contactNnumber" path="contactNumber">Name</form:label><br/>
                    <form:input path="ContactNumber"/>
                </p>
                  <p>
                    <form:label for="email" path="email">Name</form:label><br/>
                    <form:input path="name"/>
                </p>
 
                <p>
                    <form:label for="employeePhoto" path="employeePhoto">File</form:label><br/>
                    <form:input path="employeePhoto" type="file"/>
                </p>
 
                <p>
                    <input type="submit" />
                </p>
 
            </fieldset>
        </form:form>
    </body>
</html>