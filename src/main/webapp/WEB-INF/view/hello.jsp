<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
<div>
    <div>
        <h1>Spring Boot JSP Example</h1>
        <h2>This example shows how to work with JSP expression</h2>

        <h2>Current time is <%= LocalDateTime.now() %></h2>
    </div>
</div>
</body>
</html>