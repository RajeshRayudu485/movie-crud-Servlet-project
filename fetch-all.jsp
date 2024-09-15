<!DOCTYPE html>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.Arrays"%>
<%@page import="movie_crud.Movie"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% List<Movie> movies =(List<Movie>)request.getAttribute("movies");%>
    <div align="center">
	<table border="1">
		<tr>
		<th>Id</th>>
		<th>Movie Name</th>
		<th>Movie Desciprition</th>
		<th>Movie Language</th>
		<th>Movie Rating</th>
		<th>Movie Geners</th>
		<th>Movie Poster</th>
		<th>Edit</th>
		<th>Delete</th>
		</tr>
		
		<% for(Movie movie:movies) {%>
		<tr>
		<th><%=movie.getId() %></th>
		<th><%=movie.getMovieName() %></th>
		<th><%=movie.getDescription() %></th>
		<th><%=movie.getLanguage() %></th>
		<th><%=movie.getRating() %></th>
		<th><%=Arrays.toString(movie.getGener()) %></th>
		<th><img height="100px" width="100px" alt="<%=movie.getMovieName() %>" src="data:image/png;base64,<%=Base64.encodeBase64String(movie.getPoster()) %>"></th>
		<th><a href="edit?id=<%= movie.getId()%>"><button>Edit</button></a></th>
		<th><a href="delete?id=<%=movie.getId()%>"><button>Delete</button></a></th>
		</tr>
		<%} %>
	</table>
	</div>
</body>
</html>