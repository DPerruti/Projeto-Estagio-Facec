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

import com.facec.model.Veiculo;
import com.facec.repository.VeiculoRepository;
import com.facec.repository.MovimentoRepository;


@Controller
@RequestMapping("veiculo")
public class VeiculoController {
	List<Veiculo> veiculos = new ArrayList<>();

	@Autowired
	VeiculoRepository vRepository;
	
	@Autowired
	MovimentoRepository mRepository;

	

	@RequestMapping("formulario")
	public String abrirFormulario(Veiculo veiculo, Model model) {
		return "veiculo/formulario";
	}

	@GetMapping("editar")
	public String editarFormulario(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("veiculo", vRepository.getById(id));

		return "veiculo/formulario";
	}
	@GetMapping("deletar")
	public String deletar(@PathParam(value="id")Long id, Model model){
				
		
		vRepository.deleteById(id);
		
		return "redirect:/veiculo/lista";
	}

	@RequestMapping("lista")
	public String abrirLista(Model model) {
		veiculos = vRepository.findAll();
		model.addAttribute("veiculos",veiculos);
		//model.addAttribute("veiculos", vRepository.findAll());

		return "veiculo/lista";
	}
	
	@GetMapping("relatorio")
	public String abrirRelatorio(Model model) {
		
		model.addAttribute("veiculos", veiculos);

		return "veiculo/relatorio";
	}
	
	@PostMapping("consultar")
	public String consultar(String consultar, Model model) {
		veiculos = vRepository.findByChassiContaining(consultar);
		model.addAttribute("veiculos", veiculos);
		
		return "veiculo/lista";
	}
	@PostMapping("consultarModelo")
	public String consultarModelo(String consultarModelo, Model model) {
		veiculos = vRepository.findByModeloContaining(consultarModelo);
		model.addAttribute("veiculos", veiculos);
		
		return "veiculo/lista";
	}

	@PostMapping("salvar")
	public String salvar(@Valid Veiculo veiculo, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(veiculo, model);
		}

		vRepository.save(veiculo);

		return "redirect:/veiculo/lista";
	}

	@PostMapping("editar/salvar")
	public String atualizar(@Valid Veiculo veiculo, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(veiculo, model);
		}

		vRepository.save(veiculo);

		return "redirect:/veiculo/lista";
	}
}
