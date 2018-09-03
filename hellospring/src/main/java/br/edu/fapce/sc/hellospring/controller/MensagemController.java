package br.edu.fapce.sc.hellospring.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fapce.sc.hellospring.modelo.Mensagem;
import br.edu.fapce.sc.hellospring.repository.MensagemRepository;

@RestController
public class MensagemController {
	private List<Mensagem> mensagens;
	
	@Autowired
	private MensagemRepository mensagemRepository;

	@RequestMapping(value = "/hello")
	public String helloWorld() {
		return "Hello REST world ;)";
	}

	@RequestMapping(value = "/mensagem", method = GET)
	public List<Mensagem> getMensagem() {
		return mensagemRepository.findAll();
	}

	@RequestMapping(value = "/mensagem", method = POST)
	public Mensagem criar(@RequestBody Mensagem mensagem) {
		return mensagemRepository.save(mensagem);
	}

}
