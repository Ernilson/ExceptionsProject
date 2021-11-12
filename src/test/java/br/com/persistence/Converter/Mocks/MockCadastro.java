package br.com.persistence.Converter.Mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.persistence.data.Model.Cadastro;
import br.com.persistence.data.VO.CadastroVO;

public class MockCadastro {


    public Cadastro mockEntity() {
    	return mockEntity(0);
    }
    
    public CadastroVO mockVO() {
    	return mockVO(0);
    }
    
    public List<Cadastro> mockEntityList() {
        List<Cadastro> cad = new ArrayList<Cadastro>();
        for (int i = 0; i < 14; i++) {
            cad.add(mockEntity(i));
        }
        return cad;
    }

    public List<CadastroVO> mockVOList() {
        List<CadastroVO> cad = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
           cad.add(mockVO(i));
        }
        return cad;
    }
    
    private Cadastro mockEntity(Integer number) {
    	Cadastro cad = new Cadastro();
    	cad.setEndereco("quadra");
    	cad.setNome("teste");;
    	cad.setTelefone("1234567");
    	  return cad;
    }

    private CadastroVO mockVO(Integer number) {
    	CadastroVO cad = new CadastroVO();
    	cad.setEndereco("quadra");
    	cad.setNome("teste");;
    	cad.setTelefone("1234567");
    	return cad;
    }

}
