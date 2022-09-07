package modelo;

public abstract class Produto {
	protected String nome;
	protected String fabricante;
	protected double valor_custo;
	protected double valor_venda;
		
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFabricante() {
		return this.fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public double getValorCusto() {
		return this.valor_custo;
	}
	
	public void setValorCusto(double valor_custo) {
		this.valor_custo = valor_custo;
	}
	
	public double getValorVenda() {
		return this.valor_venda;
	}
	
	public void setValorVenda(double valor_venda) {
		this.valor_venda = valor_venda;
	}	
}
