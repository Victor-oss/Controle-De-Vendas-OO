package controle;


import javax.swing.DefaultListModel;

public class ControleVendas {
	private ControleDados dados;
	
	public ControleVendas(ControleDados d) {
		dados = d;
	}
	
	public DefaultListModel<String> getTodasVendasNomes() {
		DefaultListModel<String> nomes_vendas = new DefaultListModel<String>();
		int qtd_vendas = dados.getVendasSize();
		String nome_venda;
		for(int i = 0; i < qtd_vendas; i++) {
			nome_venda = getClienteVendaNome(i) + " - R$" + getValorTotal(i) + " - " + getStatus(i);
			nomes_vendas.addElement(nome_venda);
		}		
		System.out.println(nomes_vendas);
		return nomes_vendas;
	}
	
	public DefaultListModel<String> getVendaCarrinho(int indice_venda_escolhida) {
		DefaultListModel<String> nomes_carrinho = new DefaultListModel<String>();
		String[] lista_carrinho = this.dados.getVendaCarrinho(indice_venda_escolhida);
		for(int i = 0; i < lista_carrinho.length; i++) {
			if(lista_carrinho[i] != null) {
				nomes_carrinho.addElement(lista_carrinho[i]);
			}
		}		
		return nomes_carrinho;
	}
	
	public int getVendasSize() {
		return this.dados.getVendasSize();
	}
	
	public String getClienteVendaNome(int indice) {
		return this.dados.getClienteVendaNome(indice);
	}
	
	public double getValorTotal(int indice) {
		return this.dados.getValorTotal(indice);
	}
	
	public String getStatus(int indice) {
		return this.dados.getStatus(indice);
	}	
	
	public String procuraNomeCliente(String nome_digitado) {
		return this.dados.procuraNomeCliente(nome_digitado);
	}
	
	public String procuraEndCliente(String nome_digitado) {
		return this.dados.procuraEndCliente(nome_digitado);
	}
	
	public String procuraTelCliente(String nome_digitado) {
		return this.dados.procuraTelCliente(nome_digitado);
	}
	
	
	public String procuraNomeNotebook(String not_digitado) {
		return this.dados.procuraNomeNotebook(not_digitado);
	}
	
	public double procuraPrecoNotebook(String not_digitado) {
		return this.dados.procuraPrecoNotebook(not_digitado);
	}
	
	public String procuraNomeConsole(String con_digitado) {
		return this.dados.procuraNomeConsole(con_digitado); 
	}
	
	public double procuraPrecoConsole(String con_digitado) {
		return this.dados.procuraPrecoConsole(con_digitado); 
	}
	
	public String procuraNomeImpressora(String imp_digitada) {
		return this.dados.procuraNomeImpressora(imp_digitada);
	}
	
	public double procuraPrecoImpressora(String imp_digitada) {
		return this.dados.procuraPrecoImpressora(imp_digitada);
	}
	
	public String procuraNomeFone(String fone_digitado) {
		return this.dados.procuraNomeFone(fone_digitado);
	}
	
	public double procuraPrecoFone(String fone_digitado) {
		return this.dados.procuraPrecoFone(fone_digitado);
	}
	
	public String[] converteEmArray(DefaultListModel<String> produtos_carrinho) {
		String[] carrinho_array = new String[10]; 
		for(int i = 0; i<produtos_carrinho.getSize(); i++) {
			carrinho_array[i] = produtos_carrinho.elementAt(i); 
		}
		return carrinho_array;
	}
	
	public DefaultListModel<String> getParcelasString(int indice_selecionado){
		DefaultListModel<String> parcelas = new DefaultListModel<String>();
		String[] lista_parcelas = this.dados.getParcelasString(indice_selecionado);
		for(int i = 0; i < lista_parcelas.length; i++) {
			if(lista_parcelas[i] != null) {
				parcelas.addElement(lista_parcelas[i]);
			}
		}		
		return parcelas;
	}	
	
	public String getDataVenda(int indice_venda) {
		return this.dados.getDataVenda(indice_venda);
	}
	
	public String getDataVencimento(int indice_venda) {
		return this.dados.getDataVencimento(indice_venda);
	}
	
	public double getValorPend(int indice_venda) {
		return this.dados.getValorPend(indice_venda);
	}
	
	
}
