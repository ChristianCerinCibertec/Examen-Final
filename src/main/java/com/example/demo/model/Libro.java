package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idlibro", nullable = false)
	public Long id;
	
	@Column(name = "NombredeLibro", nullable = false)
	public String NombredeLibro;
	
	@Column(name = "NombredeAutor", nullable = false)
	public String NombredeAutor;
	
	@Column(name = "FechaPublicacion", nullable = false)
	public Date FechaPublicacion;
	
	@Column(name = "FechaRegistro", nullable = false)
	public Date FechaRegistro;
	
	@ManyToOne
	@JoinColumn(name = "idgenero", nullable = false)
	public Genero genero;
}
