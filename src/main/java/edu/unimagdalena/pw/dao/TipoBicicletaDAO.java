package edu.unimagdalena.pw.dao;

import edu.unimagdalena.pw.model.TipoBicicleta;
import java.util.List;
import edu.unimagdalena.pw.exceptions.InstanceNotFoundException;


public interface TipoBicicletaDAO extends GenericDAO<TipoBicicleta, Long> {
	TipoBicicleta buscarPorNombre(String nom) throws InstanceNotFoundException;

}
