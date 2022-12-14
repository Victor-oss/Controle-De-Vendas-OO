package controle;

import javax.swing.DefaultListModel;

import modelo.*;

/**
 *	Classe ControleConsoles que faz os gets de um console no package view       
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

public class ControleConsoles {
	private Console_Video_Game[] c;
	private int qtd_consoles;	
	
	public ControleConsoles(ControleDados d) {
		c = d.getConsoles();
		qtd_consoles = d.getConsolesSize();		
	}
	
	public DefaultListModel<String> getTodosConsolesNomes(){
		DefaultListModel<String> nomes_produtos = new DefaultListModel<String>();
		for(int i = 0; i < qtd_consoles; i++) {
			nomes_produtos.addElement(getConsolesNomes(i));
		}
		return nomes_produtos;
	}
	
	public String getConsolesNomes(int indice) {
		return c[indice].getNome();
	}
	
	public String getConsolesFabricantes(int indice) {
		return c[indice].getFabricante();
	}
	
	public String getConsolesValCust(int indice) {
		return String.valueOf(c[indice].getValorCusto());
	}	
	
	public String getConsolesValVend(int indice) {
		return String.valueOf(c[indice].getValorVenda());
	}
	
	public String getConsolesQtdCont(int indice) {
		return String.valueOf(c[indice].getQtdControle());		
	}
	
	public String getConsolesQtdJogos(int indice) {
		return String.valueOf(c[indice].getQtdJogos());		
	}
}
