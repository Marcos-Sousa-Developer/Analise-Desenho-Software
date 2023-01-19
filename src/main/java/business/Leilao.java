
 package business;

import java.time.LocalDate;

import java.util.*;

public class Leilao {

	private int IDvendedor;
	private String titulo;
	private Artigo artigo;
	private LocalDate dataFim;
	private float montanteInicial; 
	private LocalDate dataUltimaLicitacao;
	private CatalogUser users;
	private float valorAtual; 
	private int IDComprador;
	private String estado = "INATIVO"; 
	
    
    public Leilao(int IDvendedor, String titulo, Artigo artigo, CatalogUser users) {
    	
        this.IDvendedor= IDvendedor;
        this.titulo=titulo;
        this.artigo=artigo;
        this.users = users;
    }
    
    /** obtém o id do vendedor
	 * @param id - id do vendedor
	 * @return id do vendedor
	*/
    public int getVendedor() {
        return this.IDvendedor;
    }
    
    /** obtém o titulo do leilão
     * @return titulo do leilão
	*/
    public String getTitulo() {
        return this.titulo;
    }
    
    /** obtém a data final do leilão
     * @return data final do leilão
	*/
    public LocalDate getDataFim() {
        return this.dataFim;
    }
    
    /** obtém o montante inicial do leilão
     * @return montande inicial do leilão
	*/
    public float getMontanteInicial() {
        return this.montanteInicial;
    }
    
    /** obtém o estado do leilão
     * @return estado do leilão
	*/
    public String getEstado() {
        return this.estado;
    }
    
    /** obtém o artigo do leilão
     * @return artigo do leilão
	*/
    public Artigo getArtigo() {
        return this.artigo;
    }
    
    /** obtém o valor atual do leilão
     * @return valor atual do leilão
	*/
    public float getValorAtual() {
    	return this.valorAtual;
    }
    /** configura o leilao
	 * @param base - montante inicial do leilao
	 * @param dataFinal - data final do leilao
	*/
    public void configLeilao(float base, LocalDate dataFinal) {
    	this.montanteInicial=base;
    	this.valorAtual=base;
    	this.dataFim=dataFinal;
    }
    
    /** publicita o leilão
	*/
    public void publicita() {
    	this.estado = "ATIVO";
    }
    
    /** arquiva o leilão
	*/
    public void arquivaLeilao() { 
    	this.estado="ARQUIVADO";
    }
    
    /** termina o Leilao
	 * @param data - data atual
	*/
    public void terminaLeilao(LocalDate data) { 
    	
    	if (data.isAfter(this.dataFim)) {
    		this.estado="ENCERRADO";
    		
    	}
    }
    
    /** recebe uma Licitacao
	 * @param licitacao - licitacao do user
	 * @return status da licitação
	*/
    public String recebeLicitacao(Licitacao licitacao) {  //////////////7
    	
    	if (licitacao.getMontante() > this.valorAtual) {
    		
    		this.valorAtual = licitacao.getMontante();
    		
    		this.dataUltimaLicitacao = licitacao.getData();
    		
    		this.IDComprador = licitacao.getComprador();
    		
    		return "Licitação aprovada";
    	}
    	return "Licitação negada - Deve de aumentar o valor da licitação";
    }
      
}