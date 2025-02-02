<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.UserBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .profile-container {
            width: 100%;
            max-width: 600px;
            margin: auto;
            padding: 20px;
            margin-top: 50px;
            background: white;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
    </style>
</head>
<body>

    <%
        String fN = (String) request.getAttribute("fName");
        UserBean ub = (UserBean) application.getAttribute("ubean");
    %>

    <div class="profile-container">
        <h3 class="text-center">User Profile</h3>
        <p class="text-center text-success">Page of User: <strong><%= fN %></strong></p>

        <table class="table table-bordered">
            <tr>
                <th>First Name</th>
                <td><%= ub.getfName() %></td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td><%= ub.getlName() %></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><%= ub.getAddr() %></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><%= ub.getMid() %></td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td><%= ub.getPhno() %></td>
            </tr>
        </table>

        <div class="d-grid gap-2">
            <a href="edit" class="btn btn-warning">Edit Profile</a>
            <a href="logout" class="btn btn-danger">Logout</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
