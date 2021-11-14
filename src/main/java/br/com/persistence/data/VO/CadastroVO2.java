package br.com.persistence.data.VO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CadastroVO2 implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private String Endereco;
	
	private String Telefone;
	
	private String zap;
	
	public CadastroVO2() {
		
	}

	public CadastroVO2(Long id, String nome, String endereco, String telefone, String zap) {
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
		CadastroVO2 other = (CadastroVO2) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CadastroVO2 [id=" + id + ", nome=" + nome + ", Endereco=" + Endereco + ", Telefone=" + Telefone
				+ ", zap=" + zap + "]";
	}
	
}
