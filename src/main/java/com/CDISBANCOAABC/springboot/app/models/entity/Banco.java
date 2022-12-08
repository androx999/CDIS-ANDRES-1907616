package com.CDISBANCOAABC.springboot.app.models.entity;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "banco")
public class Banco implements Serializable{
	
	private static final long serialVersionUID = 4896617350957550531L;

	@Column
	@NotEmpty
	private String nombre;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ubi", nullable = false, length = 30)
	@NotEmpty
	private String ubi;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUbi() {
		return ubi;
	}

	public void setUbi(String ubi) {
		this.ubi = ubi;
	}
	
	

}
