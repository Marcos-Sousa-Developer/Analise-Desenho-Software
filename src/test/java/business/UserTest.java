package business;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	
	private CriarUser newuser0;
	private CriarUser newuser1;
	private CriarUser newuser2;
	private CriarUser newuser3;
	
	private CatalogUser catalogUser = new CatalogUser(); 
	private CatalogLeilao catalogLeilao = new CatalogLeilao();
	
	@Before
	//Testa criar um user
	public void testcriaUser() {
		
		//Criar novos users
		newuser0 = new CriarUser("Marcos","0@gmail.com","cr7goat");
		newuser1 = new CriarUser("Gabriel","1@gmail.com","cr8goat");
		newuser2 = new CriarUser("Rafael", "2@sapo.pt", "cr9goat");
		newuser3 = new CriarUser("Miguel", "3@sapo.pt", "cr10goat"); 
		
		//Adicionar um novo user ao catolg de Users
		catalogUser.addUser(newuser0); 
		catalogUser.addUser(newuser1);
		catalogUser.addUser(newuser2);
		catalogUser.addUser(newuser3); 
		
		//adicionar catalogo user ao user
		catalogUser.getUser(0).addCatalogUser(catalogUser);
		
		//adicionar catalogo leilao ao user
		catalogUser.getUser(0).addCatalogLeilao(catalogLeilao);
		
		
	}
	
	@Test
	//Testa obter o nome do User
	public void testgetNome() {
		User user = catalogUser.getUser(0);
		assertEquals(user.getNome(), "Marcos");
	}
	
	@Test
	//Testa obter o email do User
	public void testgetEmail() {
		User user = catalogUser.getUser(0);
		assertEquals(user.getEmail(), "0@gmail.com");
	}
	
	@Test
	//Testa obter o email do User
	public void testgetID() {
		User user = catalogUser.getUser(1);
		assertEquals(user.getID(), 1);
	}
	
	@Test 
	//Testa criar um artigo, obter artigos criados, obter artigo criado e adicionar detalhes a um artigo
	 
	public void testArtigoUser() {
		
		User user = catalogUser.getUser(2); 
		
		String categoria = "Consola"; 
		String condicao = "Usado"; 
		String descricao = "Consola usada mas em bom estado";
		
		//criar artigo
		user.criaArtigo(categoria,condicao, descricao);
		
		//obter artigos criados
		assertEquals(user.getArtigosCriados().size(), 1); 
		
		//obter artigo
		assertEquals(user.getArtigo(0), user.getArtigosCriados().get(0)); 
		
		//adicionarDetalhes
		HashMap<String,String> detalhes = new HashMap<String,String>(); 
		
		detalhes.put("Marca", "Sony");
		
		user.adicionaDetalhes(0, "Marca", "Sony"); 
		
		assertEquals(user.getArtigo(0).getDetalhes(), detalhes);  		
	}
	
	@Test
	//test criar leilao
	//test gerirLeilao
	public void testaCasoCriar_GerirLeilao() {
		
		User user0 = catalogUser.getUser(0);
		
		user0.criaArtigo("Consola", "Usado", "Consola usada mas em bom estado");
		
		user0.criaLeilao("NOVA CONSOLA", 0); 
		
		
		//obter outros leiloes 
		assertEquals(user0.getOutrosLeiloes().size(),0);
		
		//obter meu leilao
		assertEquals(user0.getMeusLeiloes().size(),1);
		
		//configurar meu leilao
		user0.configLeilao(user0.getMeuLeilao(0), 1000, LocalDate.now());
		
		//publicta leilao
		user0.publicita(user0.getMeuLeilao(0));
		
		//novo leilao para ser licitado
		Leilao newleilao1 = new Leilao(1,"NOVA CONSOLA", new Artigo("Consola","Usado","Consola usada mas em bom estado"), catalogUser);
		HashMap<Integer, Leilao> mapnewLeilao1 = new HashMap<Integer, Leilao>();
		mapnewLeilao1.put(1, newleilao1);
		catalogLeilao.addLeilao(mapnewLeilao1, newleilao1); 
		
		//configurar leilao a licitar
		catalogUser.getUser(1).configLeilao(newleilao1, 1000, LocalDate.now()); 
		
		//licitar num leilao
		assertEquals(user0.licitar(newleilao1, 1050),"Licitação aprovada");
		
		//obter user vendedor
		catalogUser.getUser(1).terminaLeilao(newleilao1, LocalDate.parse("2023-06-21"));
		
		//adicionaUser possivel Avaliar
		user0.userPossivelAvaliar(catalogUser.getUser(1)); 
		
		//obter users possiveis de avaliar
		assertEquals(user0.getUsersPossivelAvaliar().size(),1);
		
		//prenncher formulario reputação 
		user0.formularioReputacao(catalogUser.getUser(1), 5); 
		
		
	}
}
