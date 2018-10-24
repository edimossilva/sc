package br.edu.fapce.sc.hellospring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fapce.sc.hellospring.dto.PessoaDTO;
import br.edu.fapce.sc.hellospring.modelo.Mensagem;
import br.edu.fapce.sc.hellospring.repository.MensagemRepository;

@RequestMapping("/mensagem")
@RestController
public class MensagemController {
	@Autowired
	private MensagemRepository mensagemRepository;

	@GetMapping
	public List<Mensagem> listar() {
		return mensagemRepository.findAll();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity criar(@Valid @RequestBody PessoaDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			bindingResult.getAllErrors().forEach(e -> errors.add(e.getDefaultMessage()));
			ResponseEntity<List<String>> response = new ResponseEntity<List<String>>(errors, HttpStatus.BAD_REQUEST);
			return response;
		}

		Mensagem mensagem = Mensagem.builder().texto(dto.getNome()).numero(dto.getIdade()).build();
		mensagem = mensagemRepository.save(mensagem);
		ResponseEntity<Mensagem> response = new ResponseEntity<Mensagem>(mensagem, HttpStatus.CREATED);
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletar(@PathVariable("id") Long id) {
		mensagemRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
