package br.edu.fapce.sc.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fapce.sc.hellospring.modelo.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long>{

}
