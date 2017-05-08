package edu.unimagdalena.pw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
}
