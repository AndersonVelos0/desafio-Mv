package br.com.Mv.projetoAnderson.desafioMv.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Colaborador implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nome;
	@Column
	private String cpf;
	
	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.REMOVE)
    @Column(insertable = false, updatable = false)
	private List<Alimento> alimentos;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Alimento> getAlimentos() {
		return alimentos;
	}
	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}
	public Colaborador(int id, String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	public Colaborador() {
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
		Colaborador other = (Colaborador) obj;
		return id == other.id;
	}
	
}
