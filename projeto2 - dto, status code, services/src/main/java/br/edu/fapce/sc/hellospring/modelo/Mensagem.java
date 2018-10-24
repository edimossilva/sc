package br.edu.fapce.sc.hellospring.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mensagem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long numero;
	private String texto;

}
