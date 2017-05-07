package edu.unimagdalena.pw.services;

import java.util.List;

import edu.unimagdalena.pw.model.TipoBicicleta;

public interface ITipoBicicletaService {
	void crearTipoBicicleta(TipoBicicleta tipoBicicleta);
	List<TipoBicicleta> consultarTiposBicicletas();
	void eliminarTipoBicicleta(Long id);
	TipoBicicleta buscarTipoBicicleta(Long id);
	boolean existeTipoBicicleta(TipoBicicleta tipoBicicleta);
	TipoBicicleta buscarTipoBicicletaNombre(String nombre);
}
