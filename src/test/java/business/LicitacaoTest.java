package business;

import java.time.LocalDate;
import static org.junit.Assert.*;

//cf. API em http://junit.org/junit4/javadoc/latest/
//comentar os imports desnecessarios

import org.junit.Test;

public class LicitacaoTest { 
	
	private Licitacao licitacao = new Licitacao(1,10);
	

	@Test 
	//Test obter um comprador
	public void testObterComprador() {
		
		assertEquals(licitacao.getComprador(),1);
	}
	
	@Test
	// test obter um montante
	public void testObterMontante() {
		assertEquals(licitacao.getMontante(),10,0.01);
	}
	
	@Test
	//Test obter uma data de licitacao
	public void testObterDataLicitacao() {
		
		LocalDate data = LocalDate.now();
		
		assertEquals(licitacao.getData(), data);
		
	}
	
	
}
