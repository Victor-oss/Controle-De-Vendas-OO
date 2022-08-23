package modelo;

public class Console_Video_Game extends Produto{
	private int qtd_controle;
	private int qtd_jogos;
	
	public Console_Video_Game() {
		super();
	}
	
	public Console_Video_Game(String n, String f, double vc, double vv, int qc, int qj) {
		this.nome = n;
		this.fabricante = f;
		this.valor_custo = vc;
		this.valor_venda = vv;
		qtd_controle = qc;
		qtd_jogos = qj;
	}
	
	public int getQtdControle() {
		return this.qtd_controle;
	}
	
	public void setQtdControle(int qtd_controle) {
		this.qtd_controle = qtd_controle;
	}
	
	public int getQtdJogos() {
		return this.qtd_jogos;
	}
	
	public void setQtdJogos(int qtd_jogos) {
		this.qtd_jogos = qtd_jogos;
	}
}
