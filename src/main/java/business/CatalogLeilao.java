
package business;

import java.util.ArrayList;
import java.util.HashMap;

public class CatalogLeilao {
	
	private ArrayList<HashMap<Integer, Leilao>> listLeiloes = new ArrayList<HashMap<Integer,Leilao>>();
	
	private HashMap<Integer, Leilao> mapLeiloes = new HashMap<Integer,Leilao>();
	
	/** obtem todos os leiloes possiveis de licitar 
	 * @param meusLeiloes - leiloes de um resptivo user
	 * @return todos os leiloes possiveis de licitar .
	*/
	public ArrayList<HashMap<Integer, Leilao>> getLeiloesToLicitar(ArrayList<HashMap<Integer, Leilao>> meusLeiloes) { 
		
		ArrayList<HashMap<Integer, Leilao>> leiloesPossiveis = new ArrayList<HashMap<Integer, Leilao>>();
		
		for(HashMap<Integer, Leilao> par: listLeiloes) {
				if( !meusLeiloes.contains(par)) {
					leiloesPossiveis.add(par);
				}
				
			}
		
		return leiloesPossiveis;
	}
	
	/** obtem todos os leiloes
	 * @return obtem todos os leiloes.
	*/
	public ArrayList<HashMap<Integer, Leilao>> getLeiloes() {
		
		return listLeiloes;
	}
	
	/**adiciona novo leilao ao catalog leilao
	 * @param novoLeilao - com id e valor (novo leilao)
	 * @param Leilao - novo leilao
	 */
	public void addLeilao(HashMap<Integer, Leilao> novoLeilao, Leilao leilao) {
		
		this.listLeiloes.add(novoLeilao);
		
		int ultimoID = this.listLeiloes.size()-1;
		
		this.mapLeiloes.put(ultimoID+1, leilao);
		
	}

}
