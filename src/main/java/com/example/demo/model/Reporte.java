package com.example.demo.model;

public class Reporte {

	public Long id;
	public String NombredeLibro;
	public String NombredeAutor;
	public String FechaPublicacion;
	public String FechaRegistro;
	public String genero;
	
	
	public Reporte(Long id, String NombredeLibro, String NombredeAutor, String FechaPublicacion, String FechaRegistro, String genero) {
		super();
		this.id = id;
		this.NombredeLibro = NombredeLibro;
		this.NombredeAutor = NombredeAutor;
		this.FechaPublicacion = FechaPublicacion;
		this.FechaRegistro = FechaRegistro;
		this.genero = genero;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombredeLibro() {
		return NombredeLibro;
	}


	public void setNombredeLibro(String nombredeLibro) {
		NombredeLibro = nombredeLibro;
	}


	public String getNombredeAutor() {
		return NombredeAutor;
	}


	public void setNombredeAutor(String nombredeAutor) {
		NombredeAutor = nombredeAutor;
	}


	public String getFechaPublicacion() {
		return FechaPublicacion;
	}


	public void setFechaPublicacion(String fechaPublicacion) {
		FechaPublicacion = fechaPublicacion;
	}


	public String getFechaRegistro() {
		return FechaRegistro;
	}


	public void setFechaRegistro(String fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
}
