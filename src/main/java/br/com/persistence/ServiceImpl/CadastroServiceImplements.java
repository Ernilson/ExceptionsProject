package br.com.persistence.ServiceImpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.persistence.Converter.DozerConverter;
import br.com.persistence.Repository.CadastroRepository;
import br.com.persistence.Service.CadastroService;
import br.com.persistence.data.Model.Cadastro;
import br.com.persistence.data.VO.CadastroVO;

@Service
public class CadastroServiceImplements implements CadastroService {

	@Autowired
	private CadastroRepository rp;
	
	// Metodo listar todos os cadastros
	@Override
	public List<CadastroVO> listAll() {
		return DozerConverter.parseListObject(rp.findAll(), CadastroVO.class);
	}

	// Metodo para Salvar ou Alterar Cadastro
	@Override
	public CadastroVO salve(CadastroVO c) {
		var entity = DozerConverter.parseObject(c, Cadastro.class);
		var vo = DozerConverter.parseObject(rp.save(entity), CadastroVO.class);
		return vo;
	}	

	//Metodo para Alterar cadastro
	@Override
	public CadastroVO Update(CadastroVO c) {
		var c2 = rp.findById(c.getId()).orElseThrow(() -> new EntityNotFoundException("No records found for this ID"));
		
		c2.setNome(c.getNome());
		c2.setEndereco(c.getEndereco());
		c2.setTelefone(c.getTelefone());
		
		var vo = DozerConverter.parseObject(rp.save(c2), CadastroVO.class);
		return vo;
	}
	
	// Metodo para buscar por Id
	@Override
	public CadastroVO buscaPorId(Long id) {
		var entity = rp.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found " + id));
		return DozerConverter.parseObject(entity, CadastroVO.class);
	}
	
	// Metodo para excluir por Id
	@Override
	public void delete(Long id) {
		rp.deleteById(id);
	}

	

	

}
