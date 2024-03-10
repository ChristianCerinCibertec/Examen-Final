package com.example.demo.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Libro;
import com.example.demo.model.Report;
import com.example.demo.model.Report2;
import com.example.demo.model.Report3;
import com.example.demo.model.Reporte;
import com.example.demo.service.LibroService;
//import com.example.demo.service.UserService;

//import com.example.demo.model.Report;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/reporte")
public class ReportController {
	@Autowired                       ///
	private LibroService libroService;
	@GetMapping("/reporte")
	public void report(HttpServletResponse response, Model model) throws JRException, IOException {
		//1. accede al reporte
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/reporte1.jasper");
		//condic
				List<Libro> listLibros = libroService.getAllLibros();
				model.addAttribute("libro", listLibros);
		
		//2. Preparadar los datos
				Map<String, Object> params = new HashMap<>();
		
				List<Report2> listLibrosReportados = new ArrayList<>();
				for(Libro libro:listLibros) {
					
					//LocalDate fecha_actual = LocalDate.now();
					//Date date = java.sql.Date.valueOf(fecha_actual);
					LocalDateTime fecha_actual_dias = LocalDate.now().atStartOfDay();
					LocalDateTime fecha_registro = libro.FechaRegistro.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atStartOfDay();
					
					Duration dd =  Duration.between(fecha_registro,fecha_actual_dias);
					System.out.println("");
					System.out.println(dd.toDays());
					System.out.println("");
					
					if(dd.toDays()>180) {
					listLibrosReportados.add(new Report2(libro.id,libro.NombredeAutor,libro.NombredeLibro,libro.FechaPublicacion.toString(),libro.FechaRegistro.toString(),libro.genero.nombre));
				
					}
				}
				 
			    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listLibrosReportados);				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
			  	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
				
		//3. Configuracion
				
				response.setContentType("application/x-pdf");
				response.setHeader("Content-disposition", "filename=reporte_ejemplo2.pdf");
		//4. Exportar reporte		
				final  OutputStream outputStream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint,outputStream);		
	}

}
