package modelo;

/**
 *	Classe Fone que representa um fone de ouvido e herda da classe abstrata produto
 *	@author Victório Lázaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

public class Fone extends Produto{
	private String tipo_fone;
	private String tec_conexao;
	
	public Fone() {
		super();
	}
	
	public Fone(String n, String f, double vc, double vv, String tf, String tc) {
		this.nome = n;
		this.fabricante = f;
		this.valor_custo = vc;
		this.valor_venda = vv;
		tipo_fone = tf;
		tec_conexao = tc;
	}
	
	public String getTipoFone() {
		return this.tipo_fone;
	}
	
	public void setTipoFone(String tipo_fone) {
		this.tipo_fone = tipo_fone;
	}
	
	public String getTecConexao() {
		return this.tec_conexao;
	}
	
	public void setTecConexao(String tec_conexao) {
		this.tec_conexao = tec_conexao;
	}
	
}
