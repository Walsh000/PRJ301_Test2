<%-- 
    Document   : InsertDepartment
    Created on : Jun 12, 2022, 7:03:04 PM
    Author     : fpt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/InsertDepartment.js" type="text/javascript"></script>
        <link href="css/style1.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="dept/insertStd" method="post">
            <div id="mainform">
                <!-- Display box to enter department's information -->
                Department Id: <input id="deptId" type="number" name="deptId">${requestScope.deptId}</input><br>
                Department name: <input type="text" name="deptName">${requestScope.deptName}</input>

                <!-- Display add button -->
                <input class="button" type="button" name="Add" value="Add student" onclick="addStudent()"/>
            </div>

            <div>
                <table id="container">
                </table>
                <!-- Display save button -->
                <input class="button" type="submit" value="Submit" name = "Submit"/>
            </div>
        </form>
    </body>
</html>
