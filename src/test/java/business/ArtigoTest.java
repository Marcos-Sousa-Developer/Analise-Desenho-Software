package business;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

public class ArtigoTest {
	
	private String categoria;
	private String condicao;
	private String descricao;
	
	private Artigo artigo;
	
	
    @Before   // run before each test
    public void setup() { 
    	
    	categoria = "Consola"; 
    	
    	condicao = "Usado"; 
    	
    	descricao = "Consola usada mas em bom estado";
    	
    	this.artigo = new Artigo(categoria,condicao,descricao);
    	
    }
	
	@Test
	//Teste para verificar a categoria de um artigo 
    public void testgetCategoria() {
		
		assertEquals(this.artigo.getCategoria(),this.categoria);
    }
	
	@Test
	//Teste para verificar a condição de um artigo 
	public void testgetCondicao() {
		
		assertEquals(this.artigo.getCondicao(), this.condicao);
	}
	
	@Test 
	//Teste para adicionar e verificar detalhes 
	public void testadicionar_verficaDetalhes() {
		
		HashMap<String,String> detalhes = new HashMap<String,String>(); 
		
		detalhes.put("Marca", "Sony");
		
		detalhes.put("Cor", "Branco");
		
		this.artigo.addDetalhes("Marca", detalhes.get("Marca"));
		this.artigo.addDetalhes("Cor", detalhes.get("Cor"));   
		
		assertEquals(this.artigo.getDetalhes(),detalhes);
		
	}
	
	@Test
	// Teste para verificar a descrição do artigo
	public void testgetDescricao() {
		
		assertEquals(this.artigo.getDescricao(),this.descricao);
		
	}
}
