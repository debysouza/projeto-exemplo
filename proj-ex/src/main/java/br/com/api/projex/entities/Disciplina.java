package br.com.api.projex.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_disciplina") //dis_cd_id
	private Integer id;
	
	@NotNull
	@Size(max=20)
	@Column(name="nome_disciplina") //dis_tx_nome
	private String nome;
	
	@NotNull
	@Size(max=60)
	@Column(name="nome_professor") //dis_tx_nome_prof
	private String professor;

	//opcional
//	@OneToMany(mappedBy="disciplina") //relação de um para muitos - mappedBy-> recebe o nome da tabela que contém o relacionamento, ou seja, o nome da tabela em questão (disciplina)
//	private List<Aluno> alunos; //listar os alunos de uma determinada disciplina
	
	public Disciplina() {
		super();
	}

	public Disciplina(Integer id, @NotNull @Size(max = 20) String nome, @NotNull @Size(max = 60) String professor) {
		super();
		this.id = id;
		this.nome = nome;
		this.professor = professor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", professor=" + professor + "]";
	}
	
}
