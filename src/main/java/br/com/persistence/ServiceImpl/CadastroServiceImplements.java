package br.com.persistence.ServiceImpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.persistence.Model.Cadastro;
import br.com.persistence.Repository.CadastroRepository;
import br.com.persistence.Service.CadastroService;

@Service
public class CadastroServiceImplements implements CadastroService{

	@Autowired
	private CadastroRepository rp;
	
	//Metodo para Salvar ou Alterar Cadastro
	@Override
	public Cadastro salveOrUpdate(Cadastro c) {		
		return rp.save(c);
	}

	//Metodo para excluir por Id
	@Override
	public void delete(Long id) {
		rp.deleteById(id);		
	}

	//Metodo listar todos os cadastros
	@Override
	public List<Cadastro> listAll() {		
		return rp.findAll();
	}

	//Metodo para buscar por Id
	@Override
	public Cadastro buscaPorId(Long id) {
		return rp.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Id not found " + id));
	}	
		
}
