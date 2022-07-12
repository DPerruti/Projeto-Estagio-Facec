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

import com.facec.model.Funcionario;
import com.facec.repository.FuncionarioRepository;


@Controller
@RequestMapping("funcionario")
public class FuncionarioController {
	List<Funcionario> funci= new ArrayList<>();

	@Autowired
	FuncionarioRepository funRepository;

	

	@RequestMapping("formulario")
	public String abrirFormulario(Funcionario funcionario, Model model) {
		return "funcionario/formulario";
	}

	@GetMapping("editar")
	public String editarFormulario(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("funcionario", funRepository.getById(id));

		return "funcionario/formulario";
	}
	@GetMapping("deletar")
	public String deletar(@PathParam(value="id")Long id, Model model){
				
		
		funRepository.deleteById(id);
		
		return "funcionario/lista";
	}

	@RequestMapping("lista")
	public String abrirLista(Model model) {
		funci = funRepository.findAll();
		model.addAttribute("funcionarios", funci);

		return "funcionario/lista";
	}
	
	@GetMapping("relatorio")
	public String abrirRelatorio(Model model) {
		
		model.addAttribute("funcionario", funci);

		return "funcionario/relatorio";
	}
	
	@PostMapping("consultar")
	public String consultar(String consultar, Model model) {
		funci = funRepository.findByNomeContaining(consultar);
		model.addAttribute("funcionarios", funci);
		
		return "funcionario/lista";
	}

	@PostMapping("salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(funcionario, model);
		}

		funRepository.save(funcionario);

		return "redirect:/funcionario/lista";
	}

	@PostMapping("editar/salvar")
	public String atualizar(@Valid Funcionario funcionario, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(funcionario, model);
		}

		funRepository.save(funcionario);

		return "redirect:/funcionario/lista";
	}
}
