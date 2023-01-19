package client;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import business.*;

/**
 * Cliente simples
 *	
 * @author ...
 * @version ...
 * 
 */
public class SimpleClient {

	/**
	 * A simple interaction with the application services
	 * 
	 * @param args Command line parameters
	 */
	public static void main(String[] args) {
		
		//Caso simples de Criar e Gerir um leilão
		CriarUser newuser0;
		CriarUser newuser1;

		CatalogUser catalogUser = new CatalogUser(); 
		CatalogLeilao catalogLeilao = new CatalogLeilao();
		
		//Criar novos users
		newuser0 = new CriarUser("Marcos","0@gmail.com","cr7goat");
		newuser1 = new CriarUser("Gabriel","1@gmail.com","cr8goat");

		
		//Adicionar um novo user ao catolg de Users
		catalogUser.addUser(newuser0); 
		catalogUser.addUser(newuser1);

		
		//adicionar catalogo user ao user
		catalogUser.getUser(0).addCatalogUser(catalogUser);
		
		//adicionar catalogo leilao ao user
		catalogUser.getUser(0).addCatalogLeilao(catalogLeilao);
		
		User user0 = catalogUser.getUser(0);
		
		user0.criaArtigo("Consola", "Usado", "Consola usada mas em bom estado");
		
		user0.criaLeilao("NOVA CONSOLA", 0); 
		
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
