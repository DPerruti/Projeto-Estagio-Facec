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

import com.facec.model.Cliente;
import com.facec.repository.ClienteRepository;
import com.facec.repository.MovimentoRepository;


@Controller
@RequestMapping("cliente")
public class ClienteController {
	
	List<Cliente> clientes = new ArrayList<>();

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	MovimentoRepository mRepository;

	@RequestMapping("formulario")
	public String abrirFormulario(Cliente cliente, Model model) {
		return "cliente/formulario";
	}

	@GetMapping("editar")
	public String editarFormulario(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("cliente", clienteRepository.getById(id));

		return "cliente/formulario";
	}
	
	@RequestMapping("lista")
	public String abrirLista(Model model) {
		model.addAttribute("clientes", clienteRepository.findAll());

		return "cliente/lista";
	}

	@GetMapping("relatorio")
	public String abrirRelatorio(Model model) {
		
		model.addAttribute("cliente", clienteRepository.findAll());

		return "cliente/relatorio";
	}
	
	@PostMapping("consultar")
	public String consultar(String consultar, Model model) {
		clientes =  clienteRepository.findByNomeContaining(consultar);
		model.addAttribute("clientes", clientes);
		
		return "cliente/lista";
	}
	@PostMapping("salvar")
	public String salvar(@Valid Cliente cliente, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(cliente, model);
		}
		
		clienteRepository.save(cliente);

		return "redirect:/cliente/lista";
	}

	@PostMapping("editar/salvar")
	public String atualizar(@Valid Cliente cliente, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(cliente, model);
		}

		clienteRepository.save(cliente);

		return "redirect:/cliente/lista";
	}

	@RequestMapping("movimentos")
	public String abrirListaMovimentos(@PathParam(value = "id") Long id, Model model) {
		return "redirect:/movimento/lista?id=" + id;
	}
}
