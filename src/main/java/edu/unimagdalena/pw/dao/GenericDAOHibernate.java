package edu.unimagdalena.pw.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import edu.unimagdalena.pw.exceptions.InstanceNotFoundException;

public class GenericDAOHibernate<E, PK extends Serializable> implements GenericDAO<E, PK> {
	@Autowired
	private SessionFactory sessionFactory;

	private Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public GenericDAOHibernate() {
		this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	@Override
	public void save(E entity) {
		getSession().saveOrUpdate(entity);
		
	}
	@Override
	public E find(PK id) throws InstanceNotFoundException {
		 E entity = (E) getSession().get(entityClass, id);

         if (entity == null) {
             throw new InstanceNotFoundException(id, entityClass.getName());
         }

         return entity;
	}
	@Override
	public boolean exists(PK id) {
		return getSession().createCriteria(entityClass).add(
                Restrictions.idEq(id)).setProjection(Projections.id())
                .uniqueResult() != null;
	}
	@Override
	public void remove(PK id) throws InstanceNotFoundException {
		getSession().delete(find(id));
		
	}
	@Override
	public List<E> findAll() throws InstanceNotFoundException {
		return getSession().createCriteria(this.entityClass).list();
	}


}
