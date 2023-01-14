package com.clases.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.clases.dao.impl.AfiliadoDAOImpl;
import com.clases.modelo.Afiliado;

@Controller
public class AfiliadoController {
	@Autowired
	private AfiliadoDAOImpl afiliadoDAOImpl;
	
	@RequestMapping(value="/")
	public String buscar(Model model,@Param("numeroDocumento")String numeroDocumento,@RequestParam Map<String, Object>params) {
		int page=params.get("page")!=null?(Integer.valueOf(params.get("page").toString())-1):0;
		PageRequest pageRequest=PageRequest.of(page, 5);
		Page<Afiliado> pageAfiliados = afiliadoDAOImpl.buscarNumeroDni(numeroDocumento, pageRequest);
		int totalPage=pageAfiliados.getTotalPages();
		if (totalPage>0) {
			List<Integer>pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		model.addAttribute("afiliados", pageAfiliados.getContent());
		model.addAttribute("current", page+1);
		model.addAttribute("next", page+2);
		model.addAttribute("prev", page);
		model.addAttribute("last",totalPage);
		return "listar";
	}
	/*@RequestMapping(value="/")
	public String buscar(Model model,@Param("numeroDocumento")String numeroDocumento,@RequestParam Map<String, Object>params) {
		int page=params.get("page")!=null?(Integer.valueOf(params.get("page").toString())-1):0;
		PageRequest pageRequest=PageRequest.of(page, 5);
		Page<Afiliado>pagePersona=afiliadoDAO.obtenerTodos(pageRequest);
		int totalPage=pagePersona.getTotalPages();
		if (totalPage>0) {
			List<Integer>pages=IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		//List<Afiliado> listaAfiliado = afiliadoDAOImpl.findAll(numeroDocumento);
		//model.addAttribute("afiliados",listaAfiliado);
		model.addAttribute("numeroDocumento",numeroDocumento);
		
		model.addAttribute("afiliados", pagePersona.getContent());
		model.addAttribute("current", page+1);
		model.addAttribute("next", page+2);
		model.addAttribute("prev", page);
		model.addAttribute("last",totalPage);
		return "listar";
	}*/
	@RequestMapping(value="/form")
	public String form(Model model) {
		Afiliado afiliado = new Afiliado();
		model.addAttribute("afiliado",afiliado);
		return "form";
	}
	
	@PostMapping(value="/")
	public String guardar(@ModelAttribute("estudiante") Afiliado afiliado) {
		if(afiliado.getNombresCompletos().trim().isEmpty()||afiliado.getApellidoPaterno().trim().isEmpty()
				||afiliado.getApellidoMaterno().trim().isEmpty()||afiliado.getTipoDocumento().trim().isEmpty()
				||afiliado.getNumeroDocumento().trim().isEmpty()||afiliado.getDireccion().trim().isEmpty()
				||afiliado.getEmail().trim().isEmpty()||afiliado.getTelefono1().trim().isEmpty()
				||afiliado.getTelefono2().trim().isEmpty()) {
			return "redirect:/form";
		}else {
			afiliadoDAOImpl.add(afiliado);
			return "redirect:/";
		}
	}
	/*@GetMapping("/form/{id}")
	public String editar(@PathVariable(value="id")Long id, Map<String, Object>model) {
		Afiliado afiliado=null;
		if(id>0) {
			afiliado=afiliadoDAOImpl.findOne(id);
		}else {
			return "redirect:/";
		}
		model.put("cliente", afiliado);
		return "form";
	}*/
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable(value="id")Long id) {
		ModelAndView modelo = new ModelAndView("form_editar");
		
		Afiliado afiliado = afiliadoDAOImpl.findOne(id);
		modelo.addObject("afiliado",afiliado);
		return modelo;
	}
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id>0) {
			afiliadoDAOImpl.delete(id);
		}
		return "redirect:/";
	}
	
}
