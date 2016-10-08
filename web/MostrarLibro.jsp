

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
        
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="java.util.*"%>
<%@ page import="edu.ulima.bean.Libro"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/MostrarLibro.css">        
<title>${libro.nombre}</title>

</head>

<body>

<div class="container" > 
<form action='ActualizarLibros' method="GET" >

<%
    
  HttpSession sesion=request.getSession();
  Libro libro=(Libro)request.getAttribute("libro");
  sesion.setAttribute("idLibro",  libro.getIdLibro());

%>


 <div align = "center">

  <h1> ${libro.nombre}</h1>
   
 </div>

    
<c:if test="${TipoUsuario == 'Operario'}">
    
    <div class="form-group">
    
      <label > Nombre </label>  
      <input type= 'text' name='nombre' value='${libro.nombre}'  required  class="form-control">

    </div>
    
    <div class="form-group">

      <label > Autor </label>      
      <input type= 'text' name='autor' value='${libro.autor}' required class="form-control">

    </div>

    <div class="form-group">

      <label > Editorial </label>  
      <input type= 'text' name='editorial' value='${libro.editorial}'  required class="form-control">

    </div>

    <div class="form-group">

      <label > Año </label>  
      <input type= 'number' name='anho' value='${libro.año}'  required min="1500" max="2016" class="form-control" >

    </div>
    

  <c:if test="${libro.estado == 'Disponible'}">

    <label > Estado </label> 
    <select name='estado' class="form-control" >

    <option selected value='Disponible'>Disponible</option>
    <option value ='Prestado' >Prestado</option>

    </select>    


  </c:if>

   <c:if test="${libro.estado == 'Prestado'}">

      <label > Estado </label>  
      <select name='estado' class="form-control">

      <option  value='Disponible' >Disponible</option>
      <option selected value ='Prestado' >Prestado</option>

      </select>       

   </c:if>



     <div class="form-group">

      <label > Descripcion  </label>  
      <!--<input type= 'text' name='descripcion' value='${libro.descripcion}' class="form-control" >-->
      <textarea class="form-control" rows="2" name='descripcion' >${libro.descripcion}</textarea>

    </div>
 
   <div align="right">

   <input  type='submit' value='Actualizar' class="btn btn-success" align ="center" >
   <a class="btn btn-default" href="MostrarLibros" role="button">Regresar</a>
     
   </div>
   


  </c:if>

 <c:if test="${TipoUsuario == 'Cliente'}">
  
    <div class="form-group">
    
      <label > Nombre </label>  
      <input disabled type= 'text' name='nombre' value='${libro.nombre}'  required  class="form-control">

    </div>
    
    <div class="form-group">

      <label > Autor </label>      
      <input disabled type= 'text' name='autor' value='${libro.autor}' required class="form-control">

    </div>

    <div class="form-group">

      <label > Editorial </label>  
      <input disabled type= 'text' name='editorial' value='${libro.editorial}'  required class="form-control">

    </div>

    <div class="form-group">

      <label > Año </label>  
      <input disabled type= 'number' name='anho' value='${libro.año}'  required min="1500" max="2016" class="form-control" >

    </div>
    

     <div class="form-group">

      <label > Descripcion  </label>  
      <!--<input type= 'text' name='descripcion' value='${libro.descripcion}' class="form-control" >-->
      <textarea disabled class="form-control" rows="3" name='descripcion' > ${libro.descripcion} </textarea>

    </div>
 
   <div align="right">

   <a class="btn btn-default" href="MostrarLibros" role="button">Regresar</a>
     
   </div>
  
  </c:if>


</form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

                    
</body>
</html>
