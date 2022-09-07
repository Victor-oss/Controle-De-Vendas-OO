package modelo;

/**
 *	Classe Venda que representa uma venda de um produto
 *	@author Victório Lázaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

public class Venda {
	private String status;
	private Pagamento pagamento;
	private Cliente cliente;
	private String[] produtos;
	
	public Venda(Cliente cliente, String data_venda, String data_vencimento, double valor_total, int qtd_meses, String[] produtos) {
		this.status = "Não paga";
		this.pagamento = new Pagamento(data_venda, data_vencimento, valor_total, qtd_meses);
		this.cliente = cliente;
		this.produtos = produtos;
	}
	
	public Cliente getClienteVenda() {
		return this.cliente;
	}
			
	public String getStatus() {
		return this.status;
	}
	
	public Pagamento getPagamento() {
		return this.pagamento;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String[] getCarrinho() {
		return this.produtos;
	}
	
	/**
	 * Altera o status da venda para "Paga"
	 */	
	public void pagarVenda() {
		setStatus("Paga");
	}	
	
}
