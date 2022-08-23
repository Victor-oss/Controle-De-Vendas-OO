package controle;
import javax.swing.DefaultListModel;

import modelo.*;


public class ControleClientes {
	private Cliente[] c;
	private int qtd_clientes;
	
	public ControleClientes(ControleDados d) {
		this.c = d.getClientes();
		this.qtd_clientes = d.getClientesSize();
	}
	
	public DefaultListModel<String> getTodosClientesNomes() {
		DefaultListModel<String> nomes_clientes = new DefaultListModel<String>();
		for(int i = 0; i < qtd_clientes; i++) {
			nomes_clientes.addElement(getClientesNomes(i));
		}		
		return nomes_clientes;
	}
	
	public String getClientesNomes(int indice) {
		return this.c[indice].getNome();
	}
	
	public String getClientesEnderecos(int indice) {
		return this.c[indice].getEndereco();
	}
	
	public String getClientesTelefones(int indice) {
		return this.c[indice].getTelefone();
	}	
	
}
