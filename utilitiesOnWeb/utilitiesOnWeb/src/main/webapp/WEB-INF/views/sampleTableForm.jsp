<%-- 
    Document   : sampleTableForm
    Created on : Jun 19, 2014, 4:46:52 PM
    Author     : sarm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample table form with data and upload fields/title>
    </head>
    <body>
        <form:form modelAttribute="employeeData" enctype="multipart/form-data" method="post" action="myconrtollernamerequestMappingvalue" >
            <fieldset
                <legend>Employee Data </legend>
                <p>
                    <form:label for="aNamefd" path="aNamewe"  >Name</form:label>
                    <form:input path="aNamere"/>
                </p>

                <p>
                    <form:label path="someanotherField"  >Another Field</form:label>
                    <form:input path="anotherField"/>
                </p>
                <p>
                    <form:label for="fileData" path="fileData">Upload File</form:label><br/>
                    <form:input path="fileData" type="file"/>
                </p>

                <p>	
                    <input name="SomethingOtherSubmit" type="submit"/>
                </p>
            </fieldset>


        </form:form>
    </body>
</html>
