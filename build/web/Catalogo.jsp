
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="edu.ulima.bean.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <title> Catalogo </title>

</head>


<%          

  List<Libro> catalogo=(List)request.getAttribute("catalogo");
  request.getSession().setAttribute("catalogo", catalogo);

%> 

<body >

<div class="container" >

    <div align="center" >   

    <h1>Bienvenido  ${sessionScope.nombre}</h1>

    <h2 > Catalogo de Libros </h2>

        <table  border="4" class="table table-hover" >

            <tr>
            <td> ID </td>
            <td> Nombre </td>  
            <td> Autor </td>
            <td> Editorial </td>
            <td> Año </td>
            <td> Estado </td>

            </tr>


            <c:forEach var="i" items="${catalogo}">

              <c:if test="${TipoUsuario == 'Operario' || i.estado == 'Disponible'}">

                <tr>
                <td> ${i.idLibro} </td>
                <td> ${i.nombre} </td>
                <td> ${i.autor} </td>
                <td> ${i.editorial}</td>
                <td> ${i.año} </td>
                
                 <c:if test="${TipoUsuario == 'Operario'}">
                     
                     
                <td> <c:if test="${i.estado == 'Disponible'}">
                <form action="CambiarEstado" method="GET">
                <input type='hidden' name='idLibro' value = '${i.idLibro}'/>
                <select name='estado' class="form-control" onchange="this.form.submit()" >
                <option selected value='Disponible'>Disponible</option>
                <option value ='Prestado' >Prestado</option>
                </select>  
                </form>
                 </c:if>

                <c:if test="${i.estado == 'Prestado'}">

                <form action="CambiarEstado" method="GET">
                <input type='hidden' name='idLibro' value = '${i.idLibro}'/>
                  <select name='estado' class="form-control" onchange="this.form.submit()">

                  <option  value='Disponible' >Disponible</option>
                  <option selected value ='Prestado' >Prestado</option>

                  </select>       
                </form>
                </c:if> </td>
                  </c:if>
                  <c:if test="${TipoUsuario == 'Cliente'}">
                  <td> ${i.estado} </td>
                  </c:if>
                  <c:if test="${TipoUsuario == 'Operario'}">
                  
                    <td> 

                      <form action='MostrarLibro' method='GET'> 
                      
                      <input type='hidden' name='idLibro' value = '${i.idLibro}'/> 
                      <input type='submit' value = 'Modificar' class="btn btn-link" />

                      </form> 

                    </td>
                  
                  </c:if>

                  <c:if test="${TipoUsuario == 'Cliente'}">

                    <td> 

                    <form action='MostrarLibro' method='GET'> 
                    
                    <input type='hidden' name='idLibro' value = '${i.idLibro}'/> 
                    <input type='submit' value = 'Visualizar' class="btn btn-link"/>

                    </form> 

                    </td>
                  
                  </c:if>

                </tr>

              </c:if>

            </c:forEach>

           
        </table>       

      

    <form action="IngresarLibros.jsp" method="GET">


  </div>    



  <div align="right" style="margin-bottom:1cm;">

      <c:if test="${TipoUsuario == 'Operario'}">
      
        <input type='submit' value='Ingresar Libro' class="btn btn-default" > 
      
      </c:if>

      <a class="btn btn-default" href="CerrarSesion" role="button">Cerrar Sesion</a>

  </div>





  </div>    


    </form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>


    
</html>
