<%-- 
    Document   : Insert
    Created on : Jun 15, 2022, 8:04:07 AM
    Author     : fpt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .form{
                background-image: linear-gradient(rgba(140, 150, 255, 0.8), rgba(200, 210, 255, 0.5));
                padding: 20px 10%;
                position: relative;
                top: 25%;
                margin: auto;
                margin-top:0;
                width: 60%;
                box-shadow: 3px 3px 3px 3px rgba(150, 150, 150, 0.8);
                border-radius: 7px;
            }

            input {
                border-radius: 5px;
                border:0;
                height: 30px;
                width: 50%;
                margin: auto;
            }

            #sendButton {
                margin: auto;
                display: block;
                background-color: #fff;
                cursor: pointer;
                margin-top: 10px;
                width: 80px
                    /*background-image: radial-gradient(rgba(140, 150, 255, 0.8), rgba(200, 210, 255, 0.5));*/
            }

            table {
                margin: auto;
                margin-top: 20px;
                border: 1px solid darkblue;
                /*border-radius: 13px;*/
                background: darkblue;
                width: 80%;
            }

            th {
                background: #ffcc99;
                padding: 3px 0px;
            }

            td {
                background-color: #ffff88;
                padding: 5px 5px;
            }

        </style>
    </head>
    <body>
        <form class = 'form' action="/insert" method="POST">
            <table>
                <tr>
                    <th>Reason</th>
                    <td>
                        <input type="text" name="reason"></input>
                    </td>
                </tr>

                <tr>
                    <th>From</th>
                    <td>
                        <input type="date" name="from"></input>
                    </td>
                </tr>

                <tr>
                    <th>To</th>
                    <td>
                        <input type="date" name="to"></input>
                    </td>
                </tr>

                <tr>
                    <th>Created by</th>
                    <td>
                        <select name="create" style="border-radius: 5px; border:0px; height: 30px;
                                width: 50%; text-align: center">
                            <c:forEach items="${requestScope.empList}" var="emp">
                                <option value="${emp.id}">
                                    ${emp.name} 
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <th>Reviewed by</th>
                    <td>
                        <select name="review" style="border-radius: 5px; border:0px; height: 30px;
                                width: 50%; text-align: center">
                            <c:forEach items="${requestScope.empList}" var="emp">
                                <option value="${emp.id}">
                                    ${emp.name} 
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>

            <!--</div>-->
            <input id='sendButton' type="submit" value="Send"/>
        </form>
    </body>
</html>
