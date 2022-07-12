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

import com.facec.dto.MovimentoDto;
import com.facec.model.Movimento;
import com.facec.repository.ClienteRepository;
import com.facec.repository.FuncionarioRepository;
import com.facec.repository.MovimentoRepository;
import com.facec.repository.VeiculoRepository;

@Controller
@RequestMapping("movimento")
public class MovimentoController {
	
	List<Movimento> movimentos= new ArrayList<>();

	@Autowired
	ClienteRepository cRepository;
	
	@Autowired
	VeiculoRepository vRepository;
	
	@Autowired
	FuncionarioRepository funRepository;	

	@Autowired
	MovimentoRepository mRepository;
	

	@RequestMapping("formulario")
	public String abrirFormulario(Movimento movimento, Model model) {
		model.addAttribute("clientes", cRepository.findAll());
		model.addAttribute("veiculos", vRepository.findAll());
		model.addAttribute("funcionarios", funRepository.findAll());

		return "movimento/formulario";
	}
	

	@RequestMapping("lista")
	public String abrirLista(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("movimentos", mRepository.findByCliente(cRepository.getById(id)));

		return "movimento/lista";
	}
	
	@GetMapping("editar")
	public String editarFormulario(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("movimento", mRepository.getById(id));
		model.addAttribute("clientes", cRepository.getById(id));
		model.addAttribute("veiculos", vRepository.getById(id));
		model.addAttribute("funcionarios", funRepository.getById(id));
		return "movimento/formulario";
	}
	
	@GetMapping("relatorio")
	public String abrirRelatorio(Model model) {
		
		model.addAttribute("movimento", mRepository.findAll());

		return "movimento/relatorio";
	}
	
	@PostMapping("consultar")
	public String consultar(String consultar, Model model) {
		movimentos = mRepository.findByClienteContaining(consultar);
		model.addAttribute("consultar", movimentos);
		
		return "veiculo/lista";
	}
	
	
	@PostMapping("editar/salvar")
	public String atualizar(Movimento movimento, MovimentoDto dto, Long id, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(dto.getEntity(), model);
		}

		mRepository.save(dto.getEntity());
		return "lista?id=" + dto.getEntity().getCliente().getId();
	}
	
	@PostMapping("salvar")
	public String salvar(@Valid MovimentoDto dto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", bindingResult.getAllErrors());
			return abrirFormulario(dto.getEntity(), model);
		}

		mRepository.save(dto.getEntity());
		return "redirect:lista?id=" + dto.getEntity().getCliente().getId();
	}
}