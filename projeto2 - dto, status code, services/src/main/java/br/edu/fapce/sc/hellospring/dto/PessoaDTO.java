package br.edu.fapce.sc.hellospring.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
	@NotNull(message = "A pessoa precisa ter o campo {nome}")
	private String nome;
	@NotNull(message = "A pessoa precisa ter o campo {idade}")
	private Long idade;
}
