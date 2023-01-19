package business;

public class CriarUser {
	
    final protected String nome;
    final protected String email;
    final protected String password; 
	
    public CriarUser(String nome, String email, String password) {
    	
        this.nome=nome;
        this.email=email;
        this.password=password;
       
    }
}
