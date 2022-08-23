package modelo;

public class Parcela {
	private String status;
	private String data_pagamento;
	private double valor_parcela;
	
	public Parcela(String status, String data_pagamento, double valor_parcela) {
		this.status = status;
		this.data_pagamento = data_pagamento;
		this.valor_parcela = valor_parcela;
	}
	
	public Parcela(String status, double valor_parcela) {
		this.status = status;
		this.valor_parcela = valor_parcela;
	}
	
	public String getStatus() {			
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDataPag() {
		return this.data_pagamento;
	}
	
	public void setDataPag(String data_pagamento) {
		this.data_pagamento = data_pagamento;
	}
	
	
	public double getValor() {
		return this.valor_parcela;
	}
	
	public void setValor(double valor_parcela) {
		this.valor_parcela = valor_parcela;
	}
	
	public void pagarParcela() {
		setStatus("Paga");
	}
}
