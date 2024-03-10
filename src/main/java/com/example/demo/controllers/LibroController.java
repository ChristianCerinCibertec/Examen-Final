package com.example.demo.controllers;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Genero;
import com.example.demo.model.Libro;
import com.example.demo.service.GeneroService;
import com.example.demo.service.LibroService;

@Controller
@RequestMapping("/libro")
public class LibroController {
	@Autowired
	private LibroService libroService;
    
	@Autowired
	private GeneroService generoService;
	
	@GetMapping("/libros")
	public String getAllLibro(Model model) {
		
		List<Libro> lisLibros = libroService.getAllLibros();		
		model.addAttribute("libro",lisLibros);
		return "libroList";
		
	}
	
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("generos",generoService.getAllGeneros());
		return "libroRegister";
		
	}
	
	@PostMapping("/register")
	public String createLibro(@RequestParam("NombredeLibro") String NombredeLibro, @RequestParam("NombredeAutor") String NombredeAutor, @RequestParam("FechaPublicacion") String FechaPublicacion, @RequestParam("FechaRegistro") String FechaRegistro,  @RequestParam("idGenero") Genero genero, Model model) {
		
		Libro libro = new Libro();
		libro.NombredeLibro = NombredeLibro;
		libro.NombredeAutor = NombredeAutor;
		libro.FechaPublicacion = java.sql.Date.valueOf(LocalDate.parse(FechaPublicacion));
		libro.FechaRegistro = java.sql.Date.valueOf(LocalDate.parse(FechaRegistro));
		libro.genero = genero;
		
		libroService.createLibro(libro);
		List<Libro> lisLibros = libroService.getAllLibros();
		model.addAttribute("libro",lisLibros);
		
		return "libroList";
	}
	
}
