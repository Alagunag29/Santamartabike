package edu.unimagdalena.pw.dao;

import java.io.Serializable;
import java.util.List;

import edu.unimagdalena.pw.exceptions.InstanceNotFoundException;

public interface GenericDAO <E, PK extends Serializable>{

	void save(E entity);

	List<E> findAll() throws InstanceNotFoundException;
	
	void remove(PK id) throws InstanceNotFoundException;
	
	E find(PK id) throws InstanceNotFoundException;

	boolean exists(PK id);

	
	
	

}
