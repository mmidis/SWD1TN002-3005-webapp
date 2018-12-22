<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Testi</title>
<body>
	<c:if test="${ param.nimi.length() <= 0 } ">
	Hello <c:out value=" ${ param.nimi }" />
	</c:if>

	<c:if test="${ param.nimi.length() > 0 }">
Tervehdys <c:out value=" ${ param.nimi.toUpperCase() }" />
	</c:if>

</body>
</head>
</html>