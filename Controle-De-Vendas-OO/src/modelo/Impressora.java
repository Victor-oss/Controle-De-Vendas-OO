package modelo;

/**
 *	Classe Impressora que representa uma impressora e herda da classe abstrata produto
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

public class Impressora extends Produto{
	private String tamanho_folha;
	private String tec_impressao;

	public Impressora() {
		super();
	}
	
	public Impressora(String n, String f, double vc, double vv, String tam, String tec) {
		this.nome = n;
		this.fabricante = f;
		this.valor_custo = vc;
		this.valor_venda = vv;
		tamanho_folha = tam;
		tec_impressao = tec;
	}
	
	public String getTamanhoFolha() {
		return this.tamanho_folha;
	}
	
	public void setTamanhoFolha(String tamanho_folha) {
		this.tamanho_folha = tamanho_folha;
	}
	
	public String getTecImpressao() {
		return this.tec_impressao;
	}
	
	public void setTecImpressao(String tec_impressao) {
		this.tec_impressao = tec_impressao;
	}
}
