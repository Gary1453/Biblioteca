<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>

<head>
   <c:if test="${mensaje!=null}">
        <script type="text/javascript">
            alert("${mensaje}");
        </script>
        <c:remove var="mensaje" scope="session"/>
    </c:if>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/IngresarLibro.css"> 
    <title>Registro de Libros</title>

</head>


<body>

    <div class="container">

     <h1 align="center" >Ingresar Libros</h1>


        <form action="IngresarLIbros" method="GET">

            <div class="form-group">

                <label > IdLibro </label>  
                <input type="number" name="idLibro" required class="form-control">

            </div>
            
            <div class="form-group">
            
                  <label > Nombre </label>  
                  <input type= 'text' name='nombre' required  class="form-control">

            </div>
            
            <div class="form-group">

                  <label > Autor </label>      
                  <input type= 'text' name='autor' required class="form-control">

            </div>

            <div class="form-group">

                  <label > Editorial </label>  
                  <input type= 'text' name='editorial' required class="form-control">

            </div>

            <div class="form-group">

                  <label > Año </label>  
                  <input type= 'number' name='anho' required min="1500" max="2016" class="form-control" >

            </div>
           
            <label> Estado </label>
            <select name="estado" class="form-control">

                    <option value="Disponible" >Disponible</option>
                    <option value ="Prestado" >Prestado</option>

            </select>

            <div class="form-group">

                <label > Descripcion  </label>                  
                <textarea class="form-control" rows="2" name='descripcion' ></textarea>

            </div> 

            <div align="right">

                <input  type='submit' value='Ingresar' class="btn btn-success" align ="center" >
                <a class="btn btn-default" href="MostrarLibros" role="button">Regresar</a>

            </div>


        </form>



    </div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</body>

</html>
