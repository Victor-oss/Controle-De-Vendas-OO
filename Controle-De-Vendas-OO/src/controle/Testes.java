package controle;

import static org.junit.jupiter.api.Assertions.*;
import modelo.*;

import org.junit.jupiter.api.Test;

class Testes {

	@Test
	void procuraCliente(String nome_digitado, ControleDados d) throws Exception {
		Cliente[] dadosClientes = d.getClientes();
		for(int i = 0; i<d.getClientesSize(); i++) {
			assertEquals(nome_digitado, dadosClientes[i].getNome());						
		}
	}

}
