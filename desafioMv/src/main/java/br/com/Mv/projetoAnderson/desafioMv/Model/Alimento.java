package br.com.Mv.projetoAnderson.desafioMv.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Alimento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nome;
	
	@JoinColumn(name="id_colaborador", insertable = false, updatable = false)
	@ManyToOne(optional=false)
	@JsonIgnore
	private Colaborador colaborador;
	
	@Column(name = "id_colaborador")
	private int idColaborador;
	
	@Column
	private int codigoIndentificador;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	public int getIdColaborador() {
		return idColaborador;
	}
	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}
	
	public int getCodigoIndentificador() {
		return codigoIndentificador;
	}
	public void setCodigoIndentificador(int codigoIndentificador) {
		this.codigoIndentificador = codigoIndentificador;
	}
	
	public Alimento(String nome, Colaborador colaborador, int idColaborador, int codigoIndentificador) {
		super();
		this.nome = nome;
		this.colaborador = colaborador;
		this.idColaborador = idColaborador;
		this.codigoIndentificador = codigoIndentificador;
	}
	public Alimento() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		return id == other.id;
	}
	
}
