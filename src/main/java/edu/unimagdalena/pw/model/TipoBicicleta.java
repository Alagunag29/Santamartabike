package edu.unimagdalena.pw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_bicicleta")
public class TipoBicicleta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idtipo_bicicleta;
	@Column
	private String tipo_bicicleta;
	@Column(length = 255)
	private String descripcion;
	
	
	public Long getIdtipo_bicicleta() {
		return idtipo_bicicleta;
	}
	public void setIdtipo_bicicleta(Long idtipo_bicicleta) {
		this.idtipo_bicicleta = idtipo_bicicleta;
	}
	public String getTipo_bicicleta() {
		return tipo_bicicleta;
	}
	public void setTipo_bicicleta(String tipo_bicicleta) {
		this.tipo_bicicleta = tipo_bicicleta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
