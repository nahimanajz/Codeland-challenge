<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Codeland Challenge</title>
      <link href="WEB-INFO/css/styles.css" rel="stylesheet">
      <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
      <style>
             <%@include file="/WEB-INF/css/styles.css"%>
      </style>
   </head>
   <body>
      <!-- TODO: WRITE FORM VALIDATE PASSWORD WITH JAVASCRIPT THEN SUBMIT INFO TO Backend -->
      <div class="container">
         <div class="title">
            <h2>Responsive Registration Form</h2>
         </div>
          <%
            Object error = request.getAttribute("error");
            Object checkError=  error !=null ?"Ooops"+error:" ";
          %>          
           <%=           checkError        %>
           
            <form  method="POST" action="Signup">
            <div class="grid">
               <div class="grid-col-2">
                  <span> <i aria-hidden="true" class="fa fa-user"></i> </span>
                  <input type="text" name="fname" required placeholder="First Name" class="md"/>
               </div>
               <div class="grid-col-2 ml">
                  <span> <i aria-hidden="true" class="fa fa-user"></i> </span>
                  <input type="text" name="lname" required placeholder="Last Name"  class="md"/>
               </div>
            </div>
            <div class="grid-col-2">
               <span><i class="fa fa-user"></i></span>
               <input type="text" placeholder="Username" name="username" />
            </div>
            <div class="grid-col-2">
               <span><i class="fa fa-user"></i></span>
               <input type="number" placeholder="age" name="age" required />
            </div>
            <div class="grid-col-2">
               <span><i aria-hidden="true" class="fa fa-mobile "></i></span>
               <input type="text" placeholder="phone Number" name="phoneNumber" />
            </div>
            <div class="grid-col-2">
               <span><i aria-hidden="true" class="fa fa-lock"></i></span>
               <input type="password"  id="usr_password" placeholder="password" name="user_password" />               

            </div>
                
            <div class="grid-col-2">
               <span><i aria-hidden="true" class="fa fa-lock"></i></span>
               <input type="password" name="retype_password" id="conf_password"
                  placeholder="Re-type Password" />
            </div>
            <div class="input-container mt">
               <input type="radio" name="gender" value="male" id="male" /> <label for="male">Male</label>
               <input type="radio" name="gender"  value="female" id="female" /> <label
                  for="female">Female</label>
            </div>
            <div class="input-container">
               <select  id="role" name="roles">
                  <option>Select User Role</option>
                  <option value="guest">Guest</option>
                  <option value="admin">Admin</option>
               </select>
            </div>
            <div class="checkboxes">
               <input type="checkbox" id="terms"><label for="terms">I agree with terms and conditions</label>   <br />  
               <input type="checkbox" id="newsletter"><label for="newsletter"> I want to receive newsletter </label>  
            </div>
            <div>
               <input class="btn" type="submit"  value="Register" />
            </div>
           
         </form
          
      </div>
       
   </body>
</html>
