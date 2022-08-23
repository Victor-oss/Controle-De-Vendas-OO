package modelo;

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
