package controle;

import javax.swing.DefaultListModel;

import modelo.*;		

/**
 *	Classe ControleImpressoras que faz os gets de uma impressora no package view         
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

public class ControleImpressoras {
	private Impressora[] i;
	private int qtd_impressoras;
	
	public ControleImpressoras(ControleDados d) {
		i = d.getImps();
		qtd_impressoras = d.getImpsSize();
	}
	
	public DefaultListModel<String> getTodosImpsNomes() {
		DefaultListModel<String> nomes_produtos = new DefaultListModel<String>();
		for(int i = 0; i < qtd_impressoras; i++) {
			nomes_produtos.addElement(getImpsNomes(i));
		}
		return nomes_produtos;
		
	}
	
	public String getImpsNomes(int indice) {
		return this.i[indice].getNome();
	}
	
	public String getImpsFabricantes(int indice) {
		return this.i[indice].getFabricante();
	}
	
	public String getImpsValCust(int indice) {
		return String.valueOf(this.i[indice].getValorCusto());
	}	
	
	public String getImpsValVend(int indice) {
		return String.valueOf(this.i[indice].getValorVenda());
	}
	
	public String getImpsTec(int indice) {
		return this.i[indice].getTecImpressao();		
	}
	
	public String getImpsTam(int indice) {
		return this.i[indice].getTamanhoFolha();		
	}	
	
}
