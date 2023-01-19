package business;

import java.time.LocalDate;
import java.util.*;

public class User {

    private String nome;
    private String email;
    private String password; 
    private int id;
    private ArrayList<HashMap<Integer, Leilao>> meusLeiloes = new ArrayList<HashMap<Integer,Leilao>>();
    private CatalogUser catalogUser;
    private CatalogLeilao catalogLeilao;
    private float reputacao = 5;
    private int numeroMeusLeiloes = 0;
    private ArrayList<Artigo> artigosCriados = new ArrayList<Artigo>();   /////////////
    private ArrayList<User> userPossivelAvaliar = new ArrayList<User>();
    
    public String feedBack_ultimaInteracao = null;
    
    public User(String nome, String email, String password) {
        this.nome=nome;
        this.email=email;
        this.password=password;
    }
    
    /** define o id do user
	 * @param id - id do user
	*/
    public void setID(int id) {
    	this.id = id;
    }
    
    /** obtém o nome do user
     * @return nome do user
	*/
    public String getNome() {
        return this.nome;
    }
    
    /** obtém o email do user
     * @return email do user
	*/
    public String getEmail() {
        return this.email;
    }
    
    /** obtém o id do user
     * @return id do user
	*/
    public int getID() {
    	return this.id;
    }
    
    /** cria um artigo
	 * @param categoria - Categoria do artigo
	 * @param condicao - Condição do artigo
	 * @param descricao - Descrição do artigo
	*/
    public void criaArtigo(String categoria, String condicao, String descricao) {//////////
    	Artigo artigo = new Artigo(categoria, condicao, descricao);
    	this.artigosCriados.add(artigo);
    }
    
    /** obtém a lista dos artigos criados
     * @return lista de artigos cridos pelo do user
	*/
    public ArrayList<Artigo> getArtigosCriados(){        ///////////////
    	return this.artigosCriados;
    }
    
    /** obtém o artigo com o id
	 * @param id - id do artigo
	 * @return artigo com o id
	*/
    public Artigo getArtigo(int id){          ///////////77
    	return this.artigosCriados.get(id);
    }
    
    /** adiciona detalhes ao artigo
	 * @param idArtigo - id do artigo
	 * @param nome - nome do detalhe
	 * @param valor - valor do detalhe
	*/
    public void adicionaDetalhes(int idArtigo, String nome, String valor) { ////////////
    	this.getArtigo(idArtigo).addDetalhes(nome, valor);
    }
    
    
	/** adiciona catalogo Leilao ao user
	 * @param catalogLeilao - Catalogo de Leiloes
	*/
    public void addCatalogLeilao(CatalogLeilao catalogLeilao) {
    	this.catalogLeilao = catalogLeilao;
    }
    
	/** adiciona catalogo User ao user
	 * @param catalogLeilao - Catalogo de Leiloes
	*/
    public void addCatalogUser(CatalogUser catalogUser) {
    	this.catalogUser = catalogUser;
    }
    
	/** cria leilao
	 * @param titulo - titulo do leilao
	 * @param artigo - artigo que se quer leiloar
	 * @require catalogoLeilao deve estar atribuido.
	 * @require catalogoUser deve estar atribuido.
	*/
    public void criaLeilao(String titulo, int idArtigo) {
    	
    	Leilao L = new Leilao(this.id, titulo, this.getArtigo(idArtigo),this.catalogUser);
    	
    	HashMap<Integer, Leilao> newMeuLeilao = new HashMap<Integer,Leilao>();
    	
    	newMeuLeilao.put(this.numeroMeusLeiloes, L);
    	
    	this.meusLeiloes.add(newMeuLeilao);
    	
    	this.numeroMeusLeiloes++;
    	
    	catalogLeilao.addLeilao(newMeuLeilao, L);
    }
    
    
	/** obtem leiloes possiveis de licitar
	 * @return leiloes possiveis a licitar
	*/
    public ArrayList<HashMap<Integer,Leilao>> getOutrosLeiloes() {
    	
    	return this.catalogLeilao.getLeiloesToLicitar(this.meusLeiloes);
    }
    
    /** obtem os meus leiloes
	 * @return meus leiloes
	*/
    public ArrayList<HashMap<Integer,Leilao>> getMeusLeiloes() {
    	return this.meusLeiloes;
	}
    
    /** obtem o meu leilao com o id
     * @param idLeilao - id do meu leilao
	 * @return meu leilao com o id
	*/
    public Leilao getMeuLeilao(int idLeilao) {
    	return this.getMeusLeiloes().get(idLeilao).get(idLeilao);
    }
    
    
    /** configura o leilao
	 * @param L - leilao que se quer configurar
	 * @param base - montante inicial do leilao
	 * @param dataFinal - data final do leilao
	*/
    public void configLeilao(Leilao L, float base, LocalDate dataFinal) {
    	L.configLeilao(base, dataFinal);
    } 
    
    /** publica leilao */
    public void publicita(Leilao L) {
    	L.publicita();
    }
    
    
    /** licita num leilao
	 * @param L - leilao que se quer licitar
	 * @param montante - montante da licita��o
	*/
    public String licitar(Leilao L, float montante) {     /////////////77
    	Licitacao licitacao = new Licitacao(this.id,montante);
    	return L.recebeLicitacao(licitacao);
    	
    }
    
    /** adiciona user possivel de avaliar
	 * @param user - user v�lido
	*/
    public void userPossivelAvaliar(User user) {
    	this.userPossivelAvaliar.add(user);
    }
    
    /** obtem todos os users possiveis de avaliar
     * @return todos os users possiveis de avaliar
	*/
    public ArrayList<User> getUsersPossivelAvaliar() {
    	return this.userPossivelAvaliar;
    }
    
    /** adiciona reputacao ao user
	 * @param user - user v�lido
	 * @param avalicao - avalicao a dar ao user
	*/
    public void formularioReputacao(User user, float avaliacao) {
    	if (this.userPossivelAvaliar.contains(user)) {
        	user.alteraReputacao(avaliacao);
        	this.userPossivelAvaliar.remove(user);
    	}
    }
    
    /** altera reputacao
	 * @param reputacaoNova - nova reputacao
	*/
    public void alteraReputacao(float reputacaoNova) {
    	this.reputacao=(this.reputacao + reputacaoNova)/2;
    } 
    
    public void terminaLeilao(Leilao leialo,LocalDate date) {
    	
    	leialo.terminaLeilao(date);
    }
    
    
    public String toString() {
    	
    	return "ID:" + this.id + "; Nome:" + this.nome + "; Email:" + this.email;
    }
}