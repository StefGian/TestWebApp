<%-- 
    Document   : newstudent
    Created on : Jun 26, 2019, 11:58:06 AM
    Author     : George.Pasparakis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>
    <body>
        <h1><%= request.getAttribute("title")%></h1>
        <form method="POST" action="InsertStudent">
            Name: <input name="name" type="text" /><br />
            Surname: <input name="surname" type="text" /><br />
            Grade: <input name="grade" type="number" /><br />
            BirthDate: <input name="birthdate" type="date" /><br />
            <input type="Submit" name="new" value="New Student" /><br />
        </form>
    </body>
</html>
