package com.bd.almacenEF.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bd.almacenEF.modelo.TblMedicot3;
import com.bd.almacenEF.servicio.IMedicoServicio;

@Controller
@RequestMapping("/Vistas")
public class MedicoController {
	
	@Autowired
	private IMedicoServicio imedicoservicio;
	
	@GetMapping ("ListadoMedicos")
	public String listarMedicos(Model modelo){
		//Recuperamos los datos de la BD
		List<TblMedicot3> listado=imedicoservicio.ListadoMedicos();
		//Enviamos hacia la vista
		modelo.addAttribute("listado",listado);
		//Retornamos
		return "/Vistas/ListadoMedicos";
	}
	//creamos el metodo para registrar
	@GetMapping ("/RegistrarMedico")
	public String RegistrarMedico(Model modelo) {
		//Realizamos la respectiva instancia
		TblMedicot3 tblmed=new TblMedicot3();
		//Enviamos hacia la vista
		modelo.addAttribute("regmedico",tblmed);
		//Retornamos al formulario
		return "/Vistas/FrmRegMedico";
	}
	//Realizamos el mapeo con postmapping
	@PostMapping ("/GuardarMedico")
	public String GuardarMedico(@ModelAttribute TblMedicot3 tblmed, Model modelo) {
		imedicoservicio.RegistrarMedico(tblmed);
		//Msj por consola
		System.out.println("dato registrado en la BD");
		//Retornamos el listado
		return "redirect:/Vistas/ListadoMedicos";
	}
	//Editar
	@GetMapping ("/editarmedico/{id}")
	public String Editar(@PathVariable("id") Integer idmedico, Model modelo) {

		TblMedicot3 clmedico=imedicoservicio.buscarporId(idmedico);
		modelo.addAttribute("regmedico", clmedico);
		return "/Vistas/FrmRegistrarMedico";
	}
	//Eliminar
	
	@GetMapping ("/eliminarmedico/{id}")
	public String eliminar(@PathVariable("id") Integer idmedico, Model modelo) {
		TblMedicot3 tblmed=new TblMedicot3();
		tblmed.setIdmedicot3(idmedico);
		//Aplicamos la inyeccion de dependencia
		imedicoservicio.EliminarMedico(tblmed);
		//Actualizamos el listado
		List<TblMedicot3> listado=imedicoservicio.ListadoMedicos();
		//Enviamos hacia la vista
		modelo.addAttribute("listado", listado);
		//Redireccionamos 
		return "redirect:/Vistas/ListadoMedicos";		
	}
}
