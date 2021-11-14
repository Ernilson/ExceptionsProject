package br.com.persistence.Converter.Custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.persistence.data.Model.Cadastro;
import br.com.persistence.data.VO.CadastroVO2;



@Service
public class CadastroConverter {
	
	public CadastroVO2 convertEntityToVO(Cadastro cad) {
		
		CadastroVO2 vo = new CadastroVO2();
		vo.setId(cad.getId());
		vo.setNome(cad.getNome());
		vo.setEndereco(cad.getEndereco());
		vo.setTelefone(cad.getTelefone());
		vo.setZap(cad.getZap());
		return vo;
	}
	
	public Cadastro convertVOToEntity(CadastroVO2 c) {
		
		Cadastro entity = new Cadastro();
		entity.setId(c.getId());
		entity.setNome(c.getNome());
		entity.setEndereco(c.getEndereco());
		entity.setTelefone(c.getTelefone());
		entity.setZap(c.getZap());
		return entity;
	}

}
