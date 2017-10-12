<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Find Bank  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form:form method="POST" action="/lab09/lista">
            <input type="submit" value="Ver lista"/>
</form:form>
</body>
</html>
