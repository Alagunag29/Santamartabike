$(function(){
	agregarTipoBicicleta();
	editarUsuario();
	guardarEdicionUsuario();
});

function agregarTipoBicicleta() {
	$('#enviar').on('click', function(e){
		e.preventDefault();
		var Dtipo 		   = $('#tipoBicicleta');
		var Ddescripcion   = $('#descripcion');
		var tipoBicicleta  = {
			tipo_bicicleta		 : Dtipo.val(),
			descripcion : Ddescripcion.val()
		};
		
		var request = $.ajax({
			type		:  'POST',
			contentType :  'application/json',
			url			:  'tipoBicicleta',
			data		:  JSON.stringify(tipoBicicleta),
			dataType	:  'json'
		});
		
		request.done(function(data){
			$('#cuerpoTabla').append(
					"<tr> data-id=' " + data.id + "'>"+ 
						"<td>" + data.idtipo_bicicleta + "</td>" +
						"<td>" + data.tipo_bicicleta + "</td>" +
						"<td>" + data.descripcion + "</td>" +
						"<td>  <a href='#' class='editar button'>EDITAR</a>" +
						"<td>  <a href='#' class='editar button'>ELIMINAR</a>" +
					"</tr>"
			);
		});
		
		request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
		});
		Dtipo.val('');
		Ddescripcion.val('');
		
	});	
}

function editarUsuario(){
	$('#cuerpoTabla').on('click','.editar',function(e){
			e.preventDefault();
			console.log("aca");
			var tr = $(this).closest('tr');
			var tdTipoBicicleta = tr.children("td:nth-child(2)");
			var tdDescripcion = tr.children("td:nth-child(3)");
			var tdGuardar = tr.children("td:nth-child(4)");
			var tdCancelar = tr.children("td:nth-child(5)");

			tdTipoBicicleta.html("<input type='text' id='txtNombre' value='"+tdTipoBicicleta.html()+"'/>");
			tdDescripcion.html("<input type='text' id='txtNombre' value='"+tdDescripcion.html()+"'/>");
			tdGuardar.html("<a href='#' class='guardar button'>Guardar</a>");
			tdCancelar.html("<a href='#' class='cancelar button'>Cancelar</a>");

			
		});
}

function guardarEdicionUsuario(){
	$('#cuerpoTabla').on('click','.guardar',function(e){
			e.preventDefault();
			var tr = $(this).closest('tr');
			var ID = tr.data('id');
			var tdTipoBicicleta = tr.children("td:nth-child(2)");
			var tdDescripcion = tr.children("td:nth-child(3)");
			var tdGuardar = tr.children("td:nth-child(4)");
			var tdCancelar = tr.children("td:nth-child(5)");

			tdTipoBicicleta = tdNombre.children("input[type=text]").val();
			tdDescripcion = tdApellidos.children("input[type=text]").val();
		
			var tipoBicicletaEditar  = {
					tipo_bicicleta	: tdTipoBicicleta.val(),
					descripcion 	: tdDescripcion.val()
			};
			var request = $.ajax({
				type : "PUT",
				contentType : "application/json",
				url : "tipoBicicleta/"+ID,
				data : JSON.stringify(usuarioEditado),
				dataType : 'json'	
				
			});
			request.done(function(data){
				tdTipoBicicleta.html(data.tipo_bicicleta);				
				tdDescripcion.html(data.descripcion);
			});
			
			tdGuardar.html("<a href='#' class='editar button'>Editar</a>");
			tdCancelar.html("<a href='#' class='eliminar button'>Eliminar</a>");
		});
}

