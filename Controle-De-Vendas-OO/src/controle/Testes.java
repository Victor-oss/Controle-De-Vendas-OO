package controle;

import static org.junit.jupiter.api.Assertions.*;
import modelo.*;

import org.junit.jupiter.api.Test;

class Testes {

	@Test
	void verificaDatasTeste () throws Exception {
		String vend1 = "29/08/2022";
		String venc1 = "29/09/2022";
		assertTrue(ControleDados.verificaDatas(vend1, venc1));
		String vend2 = "29/08/2022";
		String venc2 = "29/08/2022";
		assertTrue(ControleDados.verificaDatas(vend2, venc2));
		String vend3 = "29/08/2022";
		String venc3 = "29/07/2022";
		assertFalse(ControleDados.verificaDatas(vend3, venc3));
		String vend4 = "31/08/2022";
		String venc4 = "31/09/2022";
		assertFalse(ControleDados.verificaDatas(vend4, venc4));
		String vend5 = "29/08/2022";
		String venc5 = "29/02/2023";
		assertFalse(ControleDados.verificaDatas(vend5, venc5));
		String vend6 = "29/08//2022";
		String venc6 = "28/02/2023";
		assertFalse(ControleDados.verificaDatas(vend6, venc6));
		String vend7 = "28/08/2022";
		String venc7 = "29/08/2023";
		assertFalse(ControleDados.verificaDatas(vend7, venc7));
	}
	
	@Test
	void verificaNomeCliente() throws Exception {
		ControleDados d = new ControleDados();
		String cliente1 = "Geuza Souza";
		assertEquals(cliente1, d.procuraNomeCliente(cliente1));
		String cliente2 = "Roberto Soares";
		assertEquals(cliente2, d.procuraNomeCliente(cliente2));
		String cliente3 = "Geuza Soza";
		assertNull(d.procuraNomeCliente(cliente3));
		String cliente4 = "Maria da Silva";
		assertNull(d.procuraNomeCliente(cliente4));
	}

	@Test
	void inserirEditarConsole() throws Exception {
		ControleDados d = new ControleDados();
		assertTrue(d.adicionarConsole("PlayStation 4", "Sony", "3000", "2000", "2", "2"));
		assertTrue(d.editarConsole(2, "PlayStation 3", "Sony", "2304.12", "3012", "2", "2"));
		assertFalse(d.adicionarConsole("PlayStation 2", "Sony", "A", "2000", "2", "Q"));
		assertFalse(d.editarConsole(2, "PlayStation 3", "Sony", "aBC", "17A", "2B", "G"));
	}

}
