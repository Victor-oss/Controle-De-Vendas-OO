package modelo;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *	Classe Pagamento que representa um pagamento de uma venda e que e atributo da classe Venda
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */



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
	
	/**
	 *	Retorna o status de determinada parcela dado o indice da parcela
	 * 	@return String
	 * 	@param indice_parc Indice da parcela que se deseja editar
	 */
	public String getStatusParcela(int indice_parc) {
		return this.parcelas[indice_parc].getStatus();
	}
	
	/**
	 *	Verifica se todas as parcelas de um pagamento foram pagas
	 * 	@return boolean
	 */
	public boolean verificaTdsParcelasPagas() {
		boolean vendaPaga = true;
		for(int i = 0; i < this.parcelas.length; i++) {
			if(parcelas[i] != null) {
				if(parcelas[i].getStatus().equals("Não Paga")) {
					vendaPaga = false;
				}
			}
		}
		return vendaPaga;
	}
	
	/**
	 *	Cria as parcelas do pagamento
	 */	
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
	
	public Parcela[] getParcelas() {
		return this.parcelas;
	}
	
	/**
	 *	Paga a venda igualando o valor pendente a zero e o valor pago ao valor total  
	 */
	public void pagar() {
		setValorPend(0);	
		setValorPago(this.valor_total);		
	}	
}

