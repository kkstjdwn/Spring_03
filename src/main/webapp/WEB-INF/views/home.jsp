<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<c:import url="layout/nav.jsp"/>
<c:import url="layout/bootStrap.jsp"/>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:import url="layout/bootStrap.jsp"/>
<c:import url="layout/nav.jsp"/>
<div class="container">
	<a href="notice/noticeList">Go List</a>
</div>

</body>
</html>
