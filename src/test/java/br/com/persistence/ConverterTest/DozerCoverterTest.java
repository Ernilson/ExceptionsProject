package br.com.persistence.ConverterTest;

import java.util.List;

//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.persistence.Converter.Mocks.MockCadastro;
import br.com.persistence.data.Model.Cadastro;
import br.com.persistence.data.VO.CadastroVO;

import br.com.persistence.Converter.DozerConverter;

public class DozerCoverterTest {
	
	 MockCadastro inputObject;

	    @Before
	    public void setUp() {
	        inputObject = new MockCadastro();
	    }

	    @Test
	    public void parseEntityToVOTest() {
	    	CadastroVO output = DozerConverter.parseObject(inputObject.mockEntity(), CadastroVO.class);	    	
	        Assert.assertEquals(Long.valueOf(0L), output.getId());
	        Assert.assertEquals("Nome Test0", output.getNome());
	        Assert.assertEquals("Endereço Test0", output.getEndereco());
	        Assert.assertEquals("Telefone 1230", output.getTelefone());	        
	    }

	    @Test
	    public void parseEntityListToVOListTest() {
	        List<CadastroVO> outputList = DozerConverter.parseListObject(inputObject.mockEntityList(), CadastroVO.class);
	        CadastroVO outputZero = outputList.get(0);
	        
	        Assert.assertEquals(Long.valueOf(0L),outputZero.getId());
	        Assert.assertEquals("Nome Test0",outputZero.getNome());
	        Assert.assertEquals("Endereço Test0",outputZero.getEndereco());
	        Assert.assertEquals("Telefone 1230", outputZero.getTelefone());
	        
	        CadastroVO outputSeven = outputList.get(7);
	        
	        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
	        Assert.assertEquals("Nome Test7", outputSeven.getNome());
	        Assert.assertEquals("Endereço Test7", outputSeven.getEndereco());
	        Assert.assertEquals("Telefone 1237", outputSeven.getTelefone());
	        	        
	        CadastroVO outputTwelve = outputList.get(12);
	        
	        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
	        Assert.assertEquals("Nome Test12", outputTwelve.getNome());;
	        Assert.assertEquals("Endereço Test12", outputTwelve.getEndereco());
	        Assert.assertEquals("Telefone 12312", outputTwelve.getTelefone());
	        }

	    @Test
	    public void parseVOToEntityTest() {
	       Cadastro output = DozerConverter.parseObject(inputObject.mockVO(), Cadastro.class);
	       Assert.assertEquals(Long.valueOf(0L), output.getId());
	        Assert.assertEquals("Nome Test0", output.getNome());
	        Assert.assertEquals("Endereço Test0", output.getEndereco());
	        Assert.assertEquals("Telefone 1230", output.getTelefone());
	    }

	    @Test
	    public void parserVOListToEntityListTest() {
	        List<Cadastro> outputList = DozerConverter.parseListObject(inputObject.mockVOList(), Cadastro.class);
	        Cadastro outputZero = outputList.get(0);
	        
	        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
	        Assert.assertEquals("Nome Test0", outputZero.getNome());
	        Assert.assertEquals("Endereço Test0", outputZero.getEndereco());
	        Assert.assertEquals("Telefone 1230", outputZero.getTelefone());
	        
	        
	        Cadastro outputSeven = outputList.get(7);
	        
	        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
	        Assert.assertEquals("Nome Test7", outputSeven.getNome());
	        Assert.assertEquals("Endereço Test7", outputSeven.getEndereco());
	        Assert.assertEquals("Telefone 1237", outputSeven.getTelefone());
	       	        
	        Cadastro outputTwelve = outputList.get(12);
	        
	        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
	        Assert.assertEquals("Nome Test12", outputTwelve.getNome());
	        Assert.assertEquals("Endereço Test12", outputTwelve.getEndereco());
	        Assert.assertEquals("Telefone 12312", outputTwelve.getTelefone());
	     
	    }

}
