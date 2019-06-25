<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Register User</h1>  
       <form:form method= "post" action="registerUser">    
           
          Email Id :   
          <input type="text" name= "email"  />
         <br/>
           
          Name :   
          <input type="text" name ="name" /> <br/>
         
             
          Password:     
          <input type="password" name="password" />  <br/>
             
         <input type="submit" value="registerUser" /> <br/>
             
       </form:form>    