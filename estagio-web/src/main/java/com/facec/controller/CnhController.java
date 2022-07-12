package com.facec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facec.model.Cnh;
import com.facec.repository.CnhRepository;


@Controller
@RequestMapping("cnh")
public class CnhController {
	List<Cnh> cnhs= new ArrayList<>();

	@Autowired
	CnhRepository cnhRepo;

	

	@RequestMapping("formulario")
	public String abrirFormulario(Cnh cnh, Model model) {
		return "cnh/formulario";
	}

	@GetMapping("editar")
	public String editarFormulario(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("cnh", cnhRepo.getById(id));

		return "cnh/formulario";
	}
	@GetMapping("deletar")
	public String deletar(@PathParam(value="id")Long id, Model model){
				
		
		cnhRepo.deleteById(id);
		
		return "redirect:/cnh/lista";
	}

	@RequestMapping("lista")
	public String abrirLista(Model model) {
		model.addAttribute("cnh", cnhRepo.findAll());

		return "cnh/lista";
	}
	
	@GetMapping("relatorio")
	public String abrirRelatorio(Model model) {
		
		model.addAttribute("cnh", cnhRepo.findAll());

		return "cnh/relatorio";
	}
	
	@PostMapping("consultar")
	public String consultar(String consultar, Model model) {
		cnhs = cnhRepo.findByNome(consultar);
		model.addAttribute("cnh", cnhs);
		
		return "cnh/lista";
	}

	@PostMapping("salvar")
	public String salvar(@Valid Cnh cnh, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(cnh, model);
		}

		cnhRepo.save(cnh);

		return "redirect:/cnh/lista";
	}

	@PostMapping("editar/salvar")
	public String atualizar(@Valid Cnh cnh, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(cnh, model);
		}

		cnhRepo.save(cnh);

		return "redirect:/cnh/lista";
	}
}
