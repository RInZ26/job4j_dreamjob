<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Upload</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<form action="<%=request.getContextPath()%>/uploadPhoto?candidateId=<%=request.getParameter("candidateId")%>"
      method="post" enctype="multipart/form-data">
    <div class="checkbox">
        <input type="file" name="file">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
<h2>Upload image</h2>

</body>
</html>