package com.danielfarias.EstudoJpaHibernate.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)//Declara que o enum será salvo no banco de acordo como uma String de acordo com o que foi definido.
	private TipoDePet tipoDePet;
	
	@ManyToOne//Torna o relacionamento bidirecional. Agora o pet sabe quem é a pessoa responsável por ele.
	@JoinColumn(name="pessoa_id")//Cria a chave estrangeira pessoa_id na tabela pet.
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoDePet getTipoDePet() {
		return tipoDePet;
	}

	public void setTipoDePet(TipoDePet tipoDePet) {
		this.tipoDePet = tipoDePet;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
