
<!DOCTYPE html>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="movie_crud.Movie"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>  body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"], textarea, select, input[type="number"], input[type="file"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        textarea {
            resize: vertical;
        }

        .checkbox-group {
            margin-bottom: 12px;
        }

        .checkbox-group label {
            display: inline-block;
            margin-right: 10px;
        }

        button {
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;</style>
</head>
<body>
<%Movie movie=(Movie)request.getAttribute("movie"); %>
<form action="update-movie" method="post" enctype="multipart/form-data">
         <input type="hidden" name="id" value="<%=movie.getId() %>">
        <label for="name">Movie Name:</label>
        <input type="text" id="name" name="name" value="<%=movie.getMovieName()%>">

        <label for="description">Movie Description:</label>
        <textarea id="description" name="description" rows="3"><%=movie.getDescription() %></textarea>

        <label for="language">Movie Language:</label>
        <select id="language" name="language" required>
            <option value="">Select a language</option>
            <option value="TELUGU">TELUGU</option>
            <option value="KANNADA">KANNADA</option>
            <option value="ENGLISH">ENGLISH</option>
        </select>

        <label for="poster">Movie Poster:</label>
        <input type="file" id="poster" name="poster">
        <img height="100px" width="100px" alt="<%=movie.getMovieName() %>" src="data:image/png;base64,<%=Base64.encodeBase64String(movie.getPoster()) %>">


        <div class="checkbox-group">
            <label>Movie Genres:</label>
            <label><input type="checkbox" name="gener" value="Action"> Action</label>
            <label><input type="checkbox" name="gener" value="Comedy"> Comedy</label>
            <label><input type="checkbox" name="gener" value="Romance"> Romance</label>
            <label><input type="checkbox" name="gener" value="Horror"> Horror</label>
            <label><input type="checkbox" name="gener" value="Scientific"> Scientific</label>
        </div>

        <label for="rating">Movie Rating:</label>
        <input type="number" id="rating" name="rating" value="<%=movie.getRating()%>">

        <button type="submit">DONE</button>
    </form>
</body>
</html>