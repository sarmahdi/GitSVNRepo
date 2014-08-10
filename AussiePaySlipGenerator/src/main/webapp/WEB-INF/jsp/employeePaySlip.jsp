<%-- 
    Document   : employeePaySlip
    Created on : Aug 7, 2014, 1:10:56 PM
    Author     : sarm
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Pay Slip</title>
    </head>  
    <body>
        <div align="center">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Employee Pay Slip</h2></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <h3>Here's the review of ${employee.firstName} ${employee.lastName}'s pay slip</h3>
                    </td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td>${employee.firstName}</td>
                </tr>
                <tr>
                    <td>last Name:</td>
                    <td>${employee.lastName}</td>
                </tr>

                <tr>
                    <td>Super Rate</td>
                    <td><spring:eval expression="employee.superRate" /></td>
                </tr>

                <%--  
    <tr>
                    <td>Start Date</td>
                    <td><spring:eval expression="employee.startDate" /></td>
                </tr>
                
                <tr>
                    <td>End of Month Date</td>
                    <td><spring:eval expression="employee.endOfMonth" /></td>
                </tr>
                --%> 
                <tr>
                    <td>Period</td>
                    <td>${employee.startingPeriod}  -  ${employee.endingPeriod} </td>
                </tr>

                 <tr>
                    <td>Gross Income</td>
                    <td>${employeePaySlip.grossIncome}</td>
                </tr>        
                <tr>
                    <td>Income Tax</td>
                    <td>${employeePaySlip.incomeTax}</td>
                </tr>

                <tr>
                    <td>Net income</td>
                    <td>${employeePaySlip.netIncome}</td>
                </tr>
                <tr>
                    <td>Monthly Super </td>
                    <td>${employeePaySlip.monthlySuper}</td>
                </tr>

            </table>

            <a href="loademployeeform.html">Start Again</a>

        </div>
    </body>
</html>