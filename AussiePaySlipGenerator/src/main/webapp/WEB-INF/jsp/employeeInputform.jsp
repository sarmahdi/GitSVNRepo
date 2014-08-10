<%-- 
    Document   : employeeInputform
    Created on : Aug 6, 2014, 1:00:56 PM
    Author     : sarm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html>
    <head>
        <title>Employee Input Form </title>
    </head>
    <body>

        <h2>Employee Information</h2>
        <form:form method="POST" action="generatePaySlip.html" commandName="employeeInfo">
            <table>
                <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td><form:input path="firstName" /></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name</form:label></td>
                    <td><form:input path="lastName" /></td>
                </tr>
                <tr>
                    <td><form:label path="annualSalary">Annual Salary</form:label></td>
                    <td><form:input path="annualSalary" /></td>
                </tr>
                <tr>
                    <td><form:label path="superRate">Super Rate</form:label></td>
                    <td><form:input path="superRate" /></td>
                </tr>

                <tr>
                    <td><form:label path="startDate">Start Date</form:label></td>
                    <td><form:input type="date" id="datepicker" path="startDate" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </table>  
        </form:form>
    </body>
</html>