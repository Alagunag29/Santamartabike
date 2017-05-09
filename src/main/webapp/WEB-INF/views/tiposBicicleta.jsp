
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	 <spring:url value="/resources/css/estilos.css" var="coreCss" />
	 <spring:url value="/resources/js/app.js" var="coreJs" />
	 
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <title>Tipos Bicicletas</title>
	 <link rel="stylesheet" href="${coreCss}">
	
	 
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container-info">
		<div>
			<div class="formulario">
						<div class="contedor-titulo">
							<h3 class="titulo-form">Registrar información</h3>
						</div>
						<form action="#">
							<div class="contenedor-campos">
								<div class="campos">
									<div class="contenedor-label">
										<label class="label-formulario">
											Tipo Bicicleta:
										</label>
									</div>
									<div class="contenedor-input">
										<input type="text" placeholder="Tipo de bicicleta" class="input-formulario" id="tipoBicicleta">
									</div>
								</div>
								<div class="campos">
									<div class="contenedor-label">
										<label class="label-formulario">
											Descripción:
										</label>
									</div>
									<div class="contenedor-input">
										<input type="text" placeholder="Descripción" class="input-formulario" id="descripcion">
									</div>
								</div>
								<div class="submit-contenedor">
									<input type="submit" value="Guardar" class="submit-formulario" id="enviar">
								</div>
							</div>
						</form>
					</div>
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
 				<tbody id="cuerpoTabla"> 
 				<c:forEach var="tiposBicicleta" items="${TiposBicicletas}">
					<tr data-id="${usuario.id}">
			      		<td>${tiposBicicleta.idtipo_bicicleta}</td>
						<td>${tiposBicicleta.tipo_bicicleta}</td>
						<td>${tiposBicicleta.descripcion}</td>
						<td><a href='' class='editar button' id="editar">EDITAR</a></td>
						<td><a href='' class='eliminar button'>ELIMINAR</a></td>					
				</tr>
			</c:forEach>
 				</tbody>
 			</table>
 		</div>
 	</div> 
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="${coreJs}"></script>

</body>
</html>
