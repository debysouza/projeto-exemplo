package br.com.api.projex.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aluno") //alu_cd_id
	private Integer id;
	
	@NotNull
	@Size(max=60)
	@Column(name="nome_aluno") //alu_tx_nome
	private String nome;
	
	@Column(name="ativo") //alu_bl_ativo
	private Boolean ativo;
	
	@ManyToMany
	@JoinTable(
			name="aluno_disciplina",
			joinColumns=@JoinColumn(name="aluno_id"),
			inverseJoinColumns=@JoinColumn(name="disciplina_id")
			)
	private List<Disciplina> disciplinas;

	public Aluno() {
		super();
	}

	public Aluno(Integer id, @NotNull @Size(max = 60) String nome, Boolean ativo, List<Disciplina> disciplinas) {
		super();
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
		this.disciplinas = disciplinas;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", ativo=" + ativo + ", disciplinas=" + disciplinas + "]";
	}
	
}
