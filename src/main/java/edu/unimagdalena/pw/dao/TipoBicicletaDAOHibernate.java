package edu.unimagdalena.pw.dao;

import java.util.List;

import edu.unimagdalena.pw.exceptions.InstanceNotFoundException;
import edu.unimagdalena.pw.model.TipoBicicleta;

public class TipoBicicletaDAOHibernate extends GenericDAOHibernate<TipoBicicleta, Long> implements TipoBicicletaDAO{

	public TipoBicicleta buscarPorNombre(String nombre) throws InstanceNotFoundException {
		TipoBicicleta tipoBicicleta = (TipoBicicleta)getSession().createQuery("SELECT u FROM TipoBicicleta u WHERE u.tipo_bicicleta = :name").setParameter("name", nombre);
		if (tipoBicicleta == null){
			throw new InstanceNotFoundException(nombre, TipoBicicleta.class.getName());
		}else {
			return tipoBicicleta;
		}																			
	}
}
