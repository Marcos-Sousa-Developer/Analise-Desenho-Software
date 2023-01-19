package business;

import java.util.*;

public class CatalogUser {
	
	//lista de users
	private ArrayList<HashMap<Integer, String>> listUsers = new ArrayList<HashMap<Integer,String>>();
	
	//Todos os users mapeados
	private HashMap<Integer, User> mapUsers = new HashMap<Integer,User>();
	
	
	/** obtem todos os users criados 
	 * @return todos os users criados.
	*/
	public ArrayList<HashMap<Integer, String>> getUsers() {
		
		return listUsers;
	}
	
	/** obtem user com o id
	 * @param int id - id do user
	 * @return user com respetivo id.
	*/
	public User getUser(int id) { 
		
		return mapUsers.get(id);	
	} 
	
	/**adiciona novo user ao catalog user
    * @param CriarUser userCriado - Nome do user criado.
    * @requires o user deve ser criado pela classe CriarUser
    */
	public void addUser(CriarUser userCriado) {
		
		int ultimoID = listUsers.size()-1;
		
		User user = new User(userCriado.nome,userCriado.email, userCriado.password);
		
		HashMap<Integer, String> newUser = new HashMap<Integer,String>();
		
		newUser.put(ultimoID+1, user.toString());
		
		listUsers.add(newUser);
		
		mapUsers.put(ultimoID+1, user);
		
		user.setID(ultimoID+1);
	}
}
