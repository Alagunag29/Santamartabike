package edu.unimagdalena.pw.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unimagdalena.pw.dao.TipoBicicletaDAO;
import edu.unimagdalena.pw.model.TipoBicicleta;

@Service("tipoBicicletaService")
@Transactional
public class TipoBicicletaService implements ITipoBicicletaService{
	@Autowired
	private TipoBicicletaDAO tipoBicicletaDao;
	
	@Override
	public void crearTipoBicicleta(TipoBicicleta tipoBicicleta){
		tipoBicicletaDao.save(tipoBicicleta);
	}
	
	@Override
	public List<TipoBicicleta> consultarTiposBicicletas(){
		List<TipoBicicleta> tipoBicicleta = null;
		try {
			tipoBicicleta = tipoBicicletaDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tipoBicicleta;
	}
	
	@Override
	public void eliminarTipoBicicleta(Long id){
		try{
			tipoBicicletaDao.remove(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public TipoBicicleta buscarTipoBicicleta(Long id){
		TipoBicicleta tipoBicicleta = null;
		try {
			tipoBicicleta = tipoBicicletaDao.find(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tipoBicicleta;
	}
	
	@Override
	public boolean existeTipoBicicleta(TipoBicicleta tipoBicicleta){
		Long id = new Long(tipoBicicleta.getIdtipo_bicicleta());
		return tipoBicicletaDao.exists(id);
	}
	
	@Override
	public TipoBicicleta buscarTipoBicicletaNombre(String nombre){
		TipoBicicleta tipoBicicleta = null;
		try {
			tipoBicicleta =  tipoBicicletaDao.buscarPorNombre(nombre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tipoBicicleta;
	}
	
}
