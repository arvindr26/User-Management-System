<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .dashboard-container {
            width: 100%;
            max-width: 500px;
            margin: auto;
            padding: 20px;
            margin-top: 50px;
            background: white;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            text-align: center;
        }
    </style>
</head>
<body>

    <%
        String fName = (String) request.getAttribute("fname");
        String msg = (String) request.getAttribute("msg");
    %>

    <div class="dashboard-container">
        <h3 class="text-center">Welcome, <%= fName %>! 🎉</h3>

        <% if (msg != null) { %>
            <div class="alert alert-info" role="alert">
                <%= msg %>
            </div>
        <% } %>

        <div class="d-grid gap-2">
            <a href="view" class="btn btn-primary">View Profile</a>
            <a href="edit" class="btn btn-warning">Edit Profile</a>
            <a href="logout" class="btn btn-danger">Logout</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
