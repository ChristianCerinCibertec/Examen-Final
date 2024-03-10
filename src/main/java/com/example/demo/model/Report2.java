package com.example.demo.model;

public class Report2 {

	
	public Long id;
	public String nombreautor;
	public String nombrelibro;
	public String fechapublicacion;
	public String fecharegistro ;
	public String genero;
 

public Report2(Long id,String nombreautor,String nombrelibro,String fechapublicacion,String fecharegistro,String genero) {
	super();
	
	this.id=id;
	this.nombreautor=nombreautor;
	this.nombrelibro=nombrelibro;
	this.fechapublicacion=fechapublicacion;
	this.fecharegistro=fecharegistro;
	this.genero=genero;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getNombreautor() {
	return nombreautor;
}


public void setNombreautor(String nombreautor) {
	this.nombreautor = nombreautor;
}


public String getNombrelibro() {
	return nombrelibro;
}


public void setNombrelibro(String nombrelibro) {
	this.nombrelibro = nombrelibro;
}


public String getFechapublicacion() {
	return fechapublicacion;
}


public void setFechapublicacion(String fechapublicacion) {
	this.fechapublicacion = fechapublicacion;
}


public String getFecharegistro() {
	return fecharegistro;
}


public void setFecharegistro(String fecharegistro) {
	this.fecharegistro = fecharegistro;
}


public String getGenero() {
	return genero;
}


public void setGenero(String genero) {
	this.genero = genero;
}

    
}