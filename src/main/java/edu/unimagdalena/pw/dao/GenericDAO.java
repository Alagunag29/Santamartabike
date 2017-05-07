package edu.unimagdalena.pw.dao;

import java.io.Serializable;
import java.util.List;

import edu.unimagdalena.pw.exceptions.InstanceNotFoundException;

public interface GenericDAO <E, PK extends Serializable>{

	void save(E entity);

	E find(PK id) throws InstanceNotFoundException;

	boolean exists(PK id);

	void remove(PK id) throws InstanceNotFoundException;
	
	List<E> findAll() throws InstanceNotFoundException;

}
