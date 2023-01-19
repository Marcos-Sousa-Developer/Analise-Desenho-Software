package business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class CatalogLeilaoTest {
	
	private CatalogLeilao catalogLeilao;
	
	private ArrayList<HashMap<Integer, Leilao>> meusLeiloes;
	
	private CatalogUser catalogUser;
	
	@Before
	public void setup() {
		
		catalogLeilao = new CatalogLeilao();
		catalogUser= new CatalogUser();
		
		meusLeiloes = new ArrayList<HashMap<Integer, Leilao>>();
		
		Leilao meuleilao0 = new Leilao(1,"NOVA CONSOLA", new Artigo("Consola","Usado","Consola usada mas em bom estado"), catalogUser);
		Leilao meuleilao1 = new Leilao(1,"NOVA JOGO", new Artigo("JOGO","Usado","em bom estado"), catalogUser); 
		Leilao meuleilao2 = new Leilao(1,"BOLA", new Artigo("DESPORTO","Usado","em bom estado"), catalogUser); 
		Leilao meuleilao3 = new Leilao(1,"TENIS", new Artigo("DESPORTO","Usado","usada mas em bom estado"), catalogUser);  
			
		//Adicionar leiloes ao catalog leiloes
		HashMap<Integer, Leilao> mapLeilao0 = new HashMap<Integer, Leilao>();
		mapLeilao0.put(0, meuleilao0);
		catalogLeilao.addLeilao(mapLeilao0, meuleilao0);
		
		HashMap<Integer, Leilao> mapLeilao1 = new HashMap<Integer, Leilao>();
		mapLeilao1.put(1, meuleilao1);
		catalogLeilao.addLeilao(mapLeilao1, meuleilao1);
		
		HashMap<Integer, Leilao> mapLeilao2 = new HashMap<Integer, Leilao>();
		mapLeilao2.put(2, meuleilao2);
		catalogLeilao.addLeilao(mapLeilao2, meuleilao2);
		
		HashMap<Integer, Leilao> mapLeilao3 = new HashMap<Integer, Leilao>();
		mapLeilao3.put(3, meuleilao3);
		catalogLeilao.addLeilao(mapLeilao3, meuleilao3);
		
		//adicionar leiloes ao meus leiloes
		meusLeiloes.add(mapLeilao0);
		meusLeiloes.add(mapLeilao1);
		meusLeiloes.add(mapLeilao2);
		meusLeiloes.add(mapLeilao3);
		
		
		
			
		}
	
	@Test
	//Testas os leiloes possiveis a licitar
	
	public void testgetLeiloesToLicitar() {
		
		//ver leiloes possiveis de licitar
		catalogLeilao.getLeiloesToLicitar(meusLeiloes);
		assertEquals(catalogLeilao.getLeiloesToLicitar(meusLeiloes).size(),0); 
		
		// adicionar um novo leilao e ver leiloes possiveis de licitar
		Leilao newleilao0 = new Leilao(0,"BRINQUEDO", new Artigo("BRINQUEDO","NOVO","NOVO"), catalogUser);
		HashMap<Integer, Leilao> mapnewLeilao0 = new HashMap<Integer, Leilao>();
		mapnewLeilao0.put(4, newleilao0);
		
		catalogLeilao.addLeilao(mapnewLeilao0, newleilao0);
		
		assertEquals(catalogLeilao.getLeiloesToLicitar(meusLeiloes).size(),1);
		

	}

}


