package edu.unimagdalena.pw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import edu.unimagdalena.pw.model.TipoBicicleta;
import edu.unimagdalena.pw.services.ITipoBicicletaService;

@Controller
public class TipoBicicletaController {
	@Autowired
	private ITipoBicicletaService tipoBicicletaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/index")
	public ModelAndView index(ModelAndView model){
		List<TipoBicicleta> tiposBicicletas= tipoBicicletaService.consultarTiposBicicletas();
		model.addObject("TiposBicicletas", tiposBicicletas);
		model.setViewName("tiposBicicleta");
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/tipoBicicleta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoBicicleta>> consultarTipoBicicleta(){
		List<TipoBicicleta> tiposBicicletas = tipoBicicletaService.consultarTiposBicicletas();
		if(tiposBicicletas.isEmpty()){
			return new ResponseEntity<List<TipoBicicleta>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TipoBicicleta>>(tiposBicicletas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tipoBicicleta", method = RequestMethod.POST)
	public ResponseEntity<TipoBicicleta> crearTipoBicicleta(@RequestBody TipoBicicleta tipoBicicleta, UriComponentsBuilder ucBuilder){
		if( tipoBicicleta.getIdtipo_bicicleta() != null && tipoBicicletaService.existeTipoBicicleta(tipoBicicleta) ){
			return new ResponseEntity<TipoBicicleta>(HttpStatus.CONFLICT);
		}
		tipoBicicletaService.crearTipoBicicleta(tipoBicicleta);
		return new ResponseEntity<TipoBicicleta>(tipoBicicleta, HttpStatus.CREATED);
	}
	

	
}
