package modelo;

/**
 *	Classe Notebook que representa um notebook e herda da classe abstrata produto
 *	@author Victório Lázaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

public class Notebook extends Produto{
	private int armazenamento;
	private String sistema_op;
	
	public Notebook() {
		super();
	}
	
	public Notebook(String n, String f, double vc, double vv, int a, String so) {
		this.nome = n;
		this.fabricante = f;
		this.valor_custo = vc;
		this.valor_venda = vv;
		armazenamento = a;
		sistema_op = so;
	}
	
	public int getArmazenamento() {
		return this.armazenamento;
	}
	
	public void setArmazenamento(int armazenamento) {
		this.armazenamento = armazenamento;
	}
	
	public String getSistemaOp() {
		return this.sistema_op;
	}
	
	public void setSistemaOp(String sistema_op) {
		this.sistema_op = sistema_op;
	}
}
