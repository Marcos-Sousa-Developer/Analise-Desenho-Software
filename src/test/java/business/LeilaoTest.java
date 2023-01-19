
package business;

import static org.junit.Assert.*;

import java.time.LocalDate;

// cf. API em http://junit.org/junit4/javadoc/latest/
// comentar os imports desnecessarios
import org.junit.Before; 
import org.junit.Test;


public class LeilaoTest {
	
	private Leilao leilao;
	
	@Before   // run before each test
	public void setup() {
		
		CriarUser newuser0 = new CriarUser("Marcos","0@gmail.com","cr7goat");
		CriarUser newuser1 = new CriarUser("Gabriel","1@gmail.com","cr8goat");
		CriarUser newuser2 = new CriarUser("Rafael", "2@sapo.pt", "cr9goat");
		CriarUser newuser3 = new CriarUser("Miguel", "3@sapo.pt", "cr10goat");
		
		CatalogUser catalogUser = new CatalogUser();
		
		catalogUser.addUser(newuser0); 
		catalogUser.addUser(newuser1);
		catalogUser.addUser(newuser2);
		catalogUser.addUser(newuser3);
		
		leilao = new Leilao(1,"NOVA CONSOLA", new Artigo("Consola","Usado","Consola usada mas em bom estado"), catalogUser);
		
	}
	
	@Test
	//test obter vendedor
	public void testgetVendedor() {
		assertEquals(leilao.getVendedor(),1);
	}
	
	@Test
	//test obter titulo
	public void testgetTitulo() {
		assertEquals(leilao.getTitulo(),"NOVA CONSOLA");
	}
	
	@Test
	//test obter Data Fim e Montante Inicial
	public void testgetDataFim_testMontanteInicial() {
		
		leilao.configLeilao(1000, LocalDate.now());
		
		assertEquals(leilao.getMontanteInicial(),1000,1);
	}
	
	@Test
	//test estado leilao
	public void testEstado() {
		
		leilao.configLeilao(1000, LocalDate.now());
		
		leilao.publicita();
		assertEquals(leilao.getEstado(),"ATIVO");
		
		leilao.arquivaLeilao();
		assertEquals(leilao.getEstado(),"ARQUIVADO");
		
		leilao.terminaLeilao(LocalDate.now());
		// A DATA AINDA NÃO PASSOU
		assertEquals(leilao.getEstado(),"ARQUIVADO");
		
	}
	
	@Test
	//test obter artigo
	
	public void testgetArtigo() {
		
		assertEquals(leilao.getArtigo().getCategoria(),"Consola");
		
	}
	
	@Test
	//test obter valorAtual
	
	public void testgetValorAtual() {
		
		leilao.configLeilao(1000, LocalDate.now());
		
		assertEquals(leilao.getValorAtual(), 1000, 1);
		
	}
	
	@Test
	//test fazer licitacao
	public void testrecebeLicitacao() { 
		
		Licitacao licitacao = new Licitacao(1,10);  
		leilao.configLeilao(1000, LocalDate.now());
		
		assertEquals(leilao.recebeLicitacao(licitacao),"Licitação negada - Deve de aumentar o valor da licitação");
		
		
		
		
	}
	


}
