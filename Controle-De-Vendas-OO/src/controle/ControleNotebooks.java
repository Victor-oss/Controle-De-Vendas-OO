package controle;
/**
 *	Classe ControleNotebooks que é responsável pelos gets de um notebook no package view        
 *	@author Victório Lázaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */
import javax.swing.DefaultListModel;

import modelo.*;

public class ControleNotebooks {
	private Notebook[] n;
	private int qtd_notebooks;
	
	public ControleNotebooks(ControleDados d){
		n = d.getNotebooks();
		qtd_notebooks = d.getNotebooksSize();
	}
	
	public DefaultListModel<String> getTodosNotebooksNomes() {
		DefaultListModel<String> nomes_produtos = new DefaultListModel<String>(); 
		for(int i = 0; i < qtd_notebooks; i++) {
			nomes_produtos.addElement(getNotebooksNomes(i));
		}
		return nomes_produtos;
	}
	
	public String getNotebooksNomes(int indice) {
		return this.n[indice].getNome();
	}
	
	public String getNotebooksFabricantes(int indice) {
		return this.n[indice].getFabricante();
	}
	
	public String getNotebooksValCust(int indice) {
		return String.valueOf(this.n[indice].getValorCusto());
	}	
	
	public String getNotebooksValVend(int indice) {
		return String.valueOf(this.n[indice].getValorVenda());
	}
	
	public String getNotebooksArm(int indice) {
		return String.valueOf(this.n[indice].getArmazenamento());
	}
	
	public String getNotebooksSO(int indice) {
		return this.n[indice].getSistemaOp();
	}
}
