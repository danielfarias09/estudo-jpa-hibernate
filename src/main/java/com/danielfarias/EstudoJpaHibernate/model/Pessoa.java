package com.danielfarias.EstudoJpaHibernate.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	//* Cascade: Quando salvar ou remover a pessoa, também salva ou remove endereço em cascata.
	//* orphanRemoval=true é mais agressivo. Por exemplo: se eu fizer pessoa.setEndereco(null) e o endereço não estiver mais,
	//relacionado à pessoa, o endereço também será removido, pois nao estará mais atribuído a ninguém. 
	//Ou seja, o endereço só pode existir se estiver relacionado a uma pessoa.
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval=true) 
	@JoinColumn(name = "endereco_id") //Nome da chave estrangeira dentro da tabela pessoa
	private Endereco endereco;
	
	@ElementCollection //* Permite mapear para uma lista de Strings ou Enums sem precisar criar uma nova entidade
	@CollectionTable(name = "pessoa_tem_emails") //* Mapeia para esta tabela
	private Set<String> emails;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "pessoa")//* O mappedBy diz que a entidade pet é a dona do relacionamento, e a tabela pet quem
	//terá a chave estrangeira.
	//* Se deixar apenas @OneToMany sem o mappedBy, a Jpa procurará por uma tabela
	//adicional chamada pessoa_pet para relacionar o id da pessoa com o do pet. 
	//@JoinColumn(name="pessoa_id")//* Usando @JoinColumn a Jpa procurará pela chave estrangeira pessoa_id na tabela pet
	//E não precisará de uma tabela extra. Nesse caso, o relacionamento será bidirecional. 
	private List<Pet> pets;

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}
