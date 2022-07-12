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

import com.facec.model.Detran;
import com.facec.repository.DetranRepository;


@Controller
@RequestMapping("detran")
public class DetranController {
	List<Detran> detrans= new ArrayList<>();

	@Autowired
	DetranRepository dRepo;

	

	@RequestMapping("formulario")
	public String abrirFormulario(Detran detran, Model model) {
		return "detran/formulario";
	}

	@GetMapping("editar")
	public String editarFormulario(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("detran", dRepo.getById(id));

		return "detran/formulario";
	}
	@GetMapping("deletar")
	public String deletar(@PathParam(value="id")Long id, Model model){
				
		
		dRepo.deleteById(id);
		
		return "redirect:/detran/lista";
	}

	@RequestMapping("lista")
	public String abrirLista(Model model) {
		detrans = dRepo.findAll();
		model.addAttribute("detran", detrans);

		return "detran/lista";
	}
	
	@GetMapping("relatorio")
	public String abrirRelatorio(Model model) {
		
		model.addAttribute("detran", detrans);

		return "detran/relatorio";
	}
	
	@PostMapping("consultar")
	public String consultar(String consultar, Model model) {
		detrans = dRepo.findByNomeContaining(consultar);
		model.addAttribute("detran", detrans);
		
		return "detran/lista";
	}

	@PostMapping("salvar")
	public String salvar(@Valid Detran detran, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(detran, model);
		}

		dRepo.save(detran);

		return "redirect:/detran/lista";
	}

	@PostMapping("editar/salvar")
	public String atualizar(@Valid Detran detran, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(detran, model);
		}

		dRepo.save(detran);

		return "redirect:/detran/lista";
	}
}
