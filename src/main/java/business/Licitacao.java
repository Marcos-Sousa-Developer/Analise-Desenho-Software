package business;

import java.time.LocalDate;


public class Licitacao {

    private int IDcomprador;

    private float montante;
    
    private LocalDate data;
    
    /** obtém o id do User que fez a licitação
	 * @return id do User que fez a licitação
	*/
    public Licitacao(int IDcomprador, float montante) {
        this.IDcomprador= IDcomprador;
        this.montante=montante;
        this.data=LocalDate.now();
    }
    
    /** obtém o id do User que fez a licitação
	 * @return id do User que fez a licitação
	*/
    public int getComprador() {
        return this.IDcomprador;
    }
    
    /** obtém o montante da licitação
	 * @return montante da licitação
	*/
    public float getMontante() {
        return this.montante;
    }
    
    /** obtém o data da licitação
	 * @return data da licitação
	*/
    public LocalDate getData() {
    	
        return this.data;
    }
    
}
