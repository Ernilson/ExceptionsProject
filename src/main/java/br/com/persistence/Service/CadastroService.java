package br.com.persistence.Service;

import java.util.List;

import br.com.persistence.Model.Cadastro;

public interface CadastroService {
	
	//Metodo para Salvar ou Alterar
	Cadastro salveOrUpdate(Cadastro c);

	//Metodo para Deletar pelo Id
	void delete(Long id);

	//Metodo para Listar todos os cadastros
	List<Cadastro> listAll();
	
	//Metodo para buscar por Id
	Cadastro buscaPorId(Long id);
}