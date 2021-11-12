package br.com.persistence.Service;

import java.util.List;

import br.com.persistence.data.VO.CadastroVO;

public interface CadastroService {
	
	//Metodo para Salvar ou Alterar
	CadastroVO salve(CadastroVO c);
	
	CadastroVO Update(CadastroVO c);

	//Metodo para Deletar pelo Id
	void delete(Long id);

	//Metodo para Listar todos os cadastros
	List<CadastroVO> listAll();
	
	//Metodo para buscar por Id
	CadastroVO buscaPorId(Long id);
}