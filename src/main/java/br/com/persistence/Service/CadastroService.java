package br.com.persistence.Service;

import java.util.List;

import br.com.persistence.data.VO.CadastroVO;
import br.com.persistence.data.VO.CadastroVO2;

public interface CadastroService {
	
	//Metodo para Salvar
	CadastroVO salve(CadastroVO c);
	
	//Metodo para Salvar
	CadastroVO2 salveVO2(CadastroVO2 c);
	
	//Metodo para Alterar
	CadastroVO Update(CadastroVO c);

	//Metodo para Deletar pelo Id
	void delete(Long id);

	//Metodo para Listar todos os cadastros
	List<CadastroVO> listAll();
	
	//Metodo para Listar todos os cadastros
	List<CadastroVO2> listAllv2();
	
	//Metodo para buscar por Id
	CadastroVO buscaPorId(Long id);
	
	//Metodo para buscar por Id v2
	CadastroVO2 buscaPorIdVO2(Long id);
}