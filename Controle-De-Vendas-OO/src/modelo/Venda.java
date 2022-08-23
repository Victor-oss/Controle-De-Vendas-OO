package modelo;

public class Venda {
	private String status;
	private Pagamento pagamento;
	private Cliente cliente;
	
	//gets e sets
	public Venda(Cliente cliente, String data_venda, String data_vencimento, double valor_total, int qtd_meses) {
		this.status = "Não paga";
		this.pagamento = new Pagamento(data_venda, data_vencimento, valor_total, qtd_meses);
		this.cliente = cliente;		
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
	
	//Pagar venda
	public void pagarVenda() {
		setStatus("Paga");
	}
}
