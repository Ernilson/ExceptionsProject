package br.com.persistence.data.VO;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


public class CadastroVO {
	private Long id;
	
	private String nome;
	
	private String Endereco;
	
	private String Telefone;
	
	 public CadastroVO() {
		// TODO Auto-generated constructor stub
	}

	public CadastroVO(Long id, String nome, String endereco, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		Endereco = endereco;
		Telefone = telefone;
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
		CadastroVO other = (CadastroVO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CadastroVO [id=" + id + ", nome=" + nome + ", Endereco=" + Endereco + ", Telefone=" + Telefone + "]";
	} 
	 
}
