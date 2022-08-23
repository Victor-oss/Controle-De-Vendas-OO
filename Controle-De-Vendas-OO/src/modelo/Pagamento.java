package modelo;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Pagamento {
	private String data_venda;
	private String data_vencimento;
	private double valor_total;
	private double valor_pago;
	private double valor_pendente;	
	private int qtd_meses;
	private Parcela[] parcelas = new Parcela[20];	
	private Calendar c_Venc = Calendar.getInstance();
	
	
	public Pagamento(String data_venda, String data_vencimento, double valor_total, int qtd_meses){
		this.data_venda = data_venda;
		this.data_vencimento = data_vencimento;
		int dia_venc = Integer.parseInt(data_vencimento.substring(0, 2));
		int mes_venc = Integer.parseInt(data_vencimento.substring(3, 5));
		int ano_venc = Integer.parseInt(data_vencimento.substring(6));
		c_Venc.set(ano_venc, mes_venc, dia_venc);
		this.valor_total = valor_total;
		this.valor_pago = 0;
		this.valor_pendente = valor_total;
		this.qtd_meses = qtd_meses;
		gerarParcelas();
	}
	
	//gets e sets
	public String getDataVend() {
		return this.data_venda;
	}
	
	public void setDataVend(String data_venda) {
		this.data_venda = data_venda;
	}
	
	public String getDataVenci() {
		return this.data_vencimento;
	}
	
	public void setDataVenci(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}
	
	public double getValorTot() {
		return this.valor_total;
	}
	
	public void setValorTot(double valor_total) {
		this.valor_total = valor_total;
	}
	
	public double getValorPago() {
		return this.valor_pago;
	}
	
	public void setValorPago(double valor_pago) {
		this.valor_pago = valor_pago;
	}
	
	public double getValorPend() {
		return this.valor_pendente;
	}
	
	public void setValorPend(double valor_pendente) {
		this.valor_pendente = valor_pendente;
	}
	
	public int getQtdMeses() {
		return this.qtd_meses;
	}
	
	public void setQtdMeses(int qtd_meses) {
		this.qtd_meses = qtd_meses;
	}
	
	public void gerarParcelas() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		double valor_parcela = getValorTot()/getQtdMeses();
		for(int i = 0; i<getQtdMeses(); i++) {
			Date dia_parcela = c_Venc.getTime();
			Parcela parcela = new Parcela("Não paga", sdf.format(dia_parcela), valor_parcela);
			parcelas[i] = parcela;
			c_Venc.add(Calendar.MONTH, 1);			
		}
	}
	
	public void excluirParcela(Parcela parcela) {
		//TO DO
	}
	
	public void pagar() {
		setValorPend(0);	
		setValorPago(this.valor_total);		
	}	
}

