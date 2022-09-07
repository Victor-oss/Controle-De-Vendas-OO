package modelo;

/**
 *	Classe Console_Video_Game que representa um video-game e herda da classe abstrata produto
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

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
