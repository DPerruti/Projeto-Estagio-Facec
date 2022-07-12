package com.facec.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.facec.dto.RenovacaoDto;
import com.facec.model.Renovacao;
import com.facec.repository.CnhRepository;
import com.facec.repository.DetranRepository;
import com.facec.repository.FuncionarioRepository;
import com.facec.repository.RenovacaoRepository;

@Controller
@RequestMapping("renovacao")
public class RenovacaoController {
	
	@Autowired
	FuncionarioRepository funRepository;
	
	@Autowired
	CnhRepository cnhRepository;
	
	@Autowired
	DetranRepository detranRepository;

	@Autowired
	RenovacaoRepository renRepository;
	

	@RequestMapping("formulario")
	public String abrirFormulario(Renovacao renovacao, Model model) {
		model.addAttribute("funcionarios", funRepository.findAll());
		model.addAttribute("cnhs", cnhRepository.findAll());
		model.addAttribute("detrans", detranRepository.findAll());
		

		return "renovacao/formulario";
	}
	

	@RequestMapping("lista")
	public String abrirLista(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("renovacao", renRepository.findAll());

		return "renovacao/lista";
	}
	
	@GetMapping("editar")
	public String editarFormulario(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("renovacao", renRepository.getById(id));
		model.addAttribute("funcionarios", funRepository.findAll());
		model.addAttribute("cnhs", cnhRepository.findAll());
		model.addAttribute("detrans", detranRepository.findAll());
		return "renovacao/formulario";
	}
	
	@GetMapping("relatorio")
	public String abrirRelatorio(Model model) {
		
		model.addAttribute("renovacao", renRepository.findAll());

		return "renovacao/relatorio";
	}
	
	
	@PostMapping("editar/salvar")
	public String atualizar(@Valid RenovacaoDto dto, Long id, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(dto.getEntity(), model);
		}

		renRepository.save(dto.getEntity());
		return "renovacao/lista?id=" + dto.getEntity().getCnh().getId();
	}
	
	@PostMapping("salvar")
	public String salvar(@Valid RenovacaoDto dto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(dto.getEntity(), model);
		}

		renRepository.save(dto.getEntity());

		return "redirect:lista?id=" + dto.getEntity().getCnh().getId();
	}
}