
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	 <spring:url value="/resources/css/estilos.css" var="coreCss" />
	 
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <title>Tipos Bicicletas</title>
	 <link rel="stylesheet" href="${coreCss}">
	  
	 
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container-info">
		<div>
			<a href="" class="botton">Agregar Un Nuevo Tipo</a>
		</div> 
		<div class="contenido-tipo-bici">
 		<table>
 			<thead> 
 				<tr> 
 					<th>Id</th>
 					<th>Tipo Bicicleta</th>
 					<th>Descripción</th>
 					<th>Acción</th> 
 					<th>Acción</th>
 				</tr> 
 			</thead>
 			<tbody> 
 				
 			</tbody>
 		</table>
 	</div>
 	</div> 
 	
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</body>
</html>
