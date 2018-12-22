<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<body>


<h1><c:out value="${ artist.getName() }"/></h1>

Kaikki albumit: 


<ul>
	
		<c:forEach items="${ albums }" var="album">
			<li><c:out value="${ albums.getTitle() }" /></li>
		</c:forEach>
	</ul>

		
</body>
</html>

