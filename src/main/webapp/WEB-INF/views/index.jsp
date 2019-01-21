<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
  <head>
     <title>Spring MVC Form Handling</title>
  </head>

  <body>
     <h2>User Information</h2>
         <form action="userinfo">
         Username: <input type="text" name="user"><br>
         Password: <input type="password" name="password">
         <input type="submit" name="submit">

         </form>
  </body>

</html>