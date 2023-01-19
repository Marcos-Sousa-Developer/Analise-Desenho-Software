package business;

import static org.junit.Assert.*;

// cf. API em http://junit.org/junit4/javadoc/latest/
// comentar os imports desnecessarios
import org.junit.Before; 
import org.junit.Test;

public class CatalogUserTest {
	
	private CriarUser newuser0;
	private CriarUser newuser1;
	private CriarUser newuser2;
	private CriarUser newuser3;
	
	private CatalogUser catalogUser = new CatalogUser(); 
	
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
		
	}
	
	@Test
	//Testa obter todos os users
	public void testgetUsers() {
		assertEquals(this.catalogUser.getUsers().size(),4);
	}

	@Test
	//Testa obter um user
	public void testgetUser() { 
		assertEquals(catalogUser.getUser(0).getID(), 0);
		assertEquals(catalogUser.getUser(1).getID(), 1);
		assertEquals(catalogUser.getUser(2).getID(), 2);
		assertEquals(catalogUser.getUser(3).getID(), 3);
	}
}
