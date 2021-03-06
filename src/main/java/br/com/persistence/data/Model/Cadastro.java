package br.com.persistence.data.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cadastro")
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String Endereco;	
	private String Telefone;
	private String zap;	
	
	public Cadastro() {
		
	}

	public Cadastro(Long id, String nome, String endereco, String telefone, String zap) {
		super();
		this.id = id;
		this.nome = nome;
		Endereco = endereco;
		Telefone = telefone;
		this.zap = zap;
	}

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

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getZap() {
		return zap;
	}

	public void setZap(String zap) {
		this.zap = zap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Endereco, Telefone, id, nome, zap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return Objects.equals(Endereco, other.Endereco) && Objects.equals(Telefone, other.Telefone)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(zap, other.zap);
	}

	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", nome=" + nome + ", Endereco=" + Endereco + ", Telefone=" + Telefone + ", zap="
				+ zap + "]";
	}
	
	
		
}
