package com.example.demo.model;

public class Report3 {
	public Long id;
	public String nombre_libro;

	
	public Report3(Long id,String nombre_libro) {
		
		this.id=id;
		this.nombre_libro=nombre_libro;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre_libro() {
		return nombre_libro;
	}


	public void setNombre_libro(String nombre_libro) {
		this.nombre_libro = nombre_libro;
	}
	
	
	
}
