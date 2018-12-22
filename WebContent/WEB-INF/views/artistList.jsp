<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<body>

	Kaikki artistit:
	<ul>
	
		<c:forEach items="${ artists }" var="artists">
			<li><c:out value="${ artist.getName() }" /></li>
		</c:forEach>
	</ul>
</body>
</html>