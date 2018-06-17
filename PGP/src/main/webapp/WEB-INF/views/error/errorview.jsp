<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<body>
<h3>This is custom exception page</h3>
<p>Exception Type: <b>${exception['class'].simpleName}</b></p>
 <p>Exception Message: <b>${exception.message}</b></p>

</body>
</html>