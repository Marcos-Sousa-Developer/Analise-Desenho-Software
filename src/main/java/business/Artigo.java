package business;

import java.util.*;

public class Artigo {

    private String categoria;

    private String condicao;

    private HashMap<String,String> detalhes = new HashMap<String,String>();
    
    private String descricao;
    
    public Artigo(String categoria, String condicao, String descricao) {
        this.categoria=categoria;
        this.condicao=condicao;
        this.descricao=descricao;
    }
    
    /** obtem a categoria de um artigo 
	 * @return categoria de um artigo 
	*/
    public String getCategoria() {
        return this.categoria;
    }
    
    /** obtem a condicao de um artigo 
	 * @return condicao de um artigo 
	*/
    public  String getCondicao() {
        return this.condicao;
    }
    
    /** obtem a descricao do artigo 
	 * @return descricao de um artigo 
	*/
    public String getDescricao() {
        return this.descricao;
    }
    
    /** adiciona detalhes a um artigo
     * String nome - Tipo
     * String valor - Atributo 
	 * @return condicao de um artigo 
	*/
    public void addDetalhes(String tipo, String valor) {
    	detalhes.put(tipo, valor);
    }
    
    /** obtem os detalhes de um artigo 
	 * @return mapameanto detalhes de um artigo 
	*/
    public HashMap<String,String> getDetalhes() {
    	
    	return detalhes;
    }
    
}