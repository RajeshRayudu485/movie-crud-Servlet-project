<!DOCTYPE html>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.Arrays"%>
<%@page import="movie_crud.Movie"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Movie movie=(Movie)request.getAttribute("moviename"); %>
	<div align="center">
	
		<table border="1">
			<tr>
				<th>Movie Name</th>
				<th>Movie Description</th>
				<th>Movie Language</th>
				<th>Movie Rating</th>
				<th>Movie Gener</th>
				<th>Movie Poster</th>
			</tr>
			
			<tr>
				<th><%=movie.getMovieName() %></th>
				<th><%=movie.getDescription() %></th>
				<th><%=movie.getLanguage() %></th>
				<th><%=movie.getRating() %></th>
				<th><%=Arrays.toString(movie.getGener())%></th>
				<th><img  height="100px" width="100px"   alt="<%=movie.getMovieName()%>" src="data:image/png;base64,<%=Base64.encodeBase64String(movie.getPoster()) %>">
			</tr>
		</table>
	</div>
</body>
</html>