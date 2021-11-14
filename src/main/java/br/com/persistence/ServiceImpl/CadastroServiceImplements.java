package br.com.persistence.ServiceImpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.persistence.Converter.DozerConverter;
import br.com.persistence.Converter.Custom.CadastroConverter;
import br.com.persistence.Repository.CadastroRepository;
import br.com.persistence.Service.CadastroService;
import br.com.persistence.data.Model.Cadastro;
import br.com.persistence.data.VO.CadastroVO;
import br.com.persistence.data.VO.CadastroVO2;

@Service
public class CadastroServiceImplements implements CadastroService {

	@Autowired
	private CadastroRepository rp;
	
	@Autowired
	CadastroConverter converter;
	
	// Metodo listar todos os cadastros
	@Override
	public List<CadastroVO> listAll() {
		return DozerConverter.parseListObject(rp.findAll(), CadastroVO.class);
	}
	
	// Metodo listar todos os cadastros v2
	@Override
	public List<CadastroVO2> listAllv2() {
		// TODO Auto-generated method stub
		return DozerConverter.parseListObject(rp.findAll(), CadastroVO2.class);
	}

	// Metodo para Salvar Cadastro
	@Override
	public CadastroVO salve(CadastroVO c) {
		var entity = DozerConverter.parseObject(c, Cadastro.class);
		var vo = DozerConverter.parseObject(rp.save(entity), CadastroVO.class);
		return vo;
	}	
	
	// Metodo para Salvar Cadastro v2
	@Override
	public CadastroVO2 salveVO2(CadastroVO2 c) {
		var entity = converter.convertVOToEntity(c);
		var v2 = converter.convertEntityToVO(rp.save(entity));
		return v2;
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
	
	//Metodo para buscar por Id V2
	@Override
	public CadastroVO2 buscaPorIdVO2(Long id) {
		var entity = rp.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found " + id));
		return DozerConverter.parseObject(entity, CadastroVO2.class);
	}
	
	// Metodo para excluir por Id
	@Override
	public void delete(Long id) {
		rp.deleteById(id);
	}

	

	

	

	

	

}
