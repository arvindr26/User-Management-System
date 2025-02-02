<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.UserBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .profile-container {
            width: 100%;
            max-width: 500px;
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
        String fName = (String) request.getAttribute("fname");
        UserBean ub = (UserBean) application.getAttribute("ubean");
    %>

    <div class="profile-container">
        <h3 class="text-center">Update Profile</h3>
        <p class="text-center text-success">Page belongs to <strong><%= fName %></strong></p>

        <form action="update" method="post">
            <div class="mb-3">
                <label class="form-label">Address</label>
                <input type="text" name="addr" class="form-control" value="<%= ub.getAddr() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="mid" class="form-control" value="<%= ub.getMid() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Phone Number</label>
                <input type="text" name="phno" class="form-control" value="<%= ub.getPhno() %>" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Update Profile</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
