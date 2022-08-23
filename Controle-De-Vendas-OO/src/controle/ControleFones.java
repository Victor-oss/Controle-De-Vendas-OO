package controle;
import javax.swing.DefaultListModel;

import modelo.*;

public class ControleFones {
	private Fone [] f;
	private int qtd_fones;
	
	public ControleFones(ControleDados d) {
		f = d.getFones();
		qtd_fones = d.getFonesSize(); 
	}
	
	public DefaultListModel<String> getTodosFonesNomes() {
		DefaultListModel<String> nomes_produtos = new DefaultListModel<String>();
		for(int i = 0; i < qtd_fones; i++) {
			nomes_produtos.addElement(getFonesNomes(i));
		}		
		return nomes_produtos;
	}
	
	public String getFonesNomes(int indice) {
		return this.f[indice].getNome();
	}
	
	public String getFonesFabricantes(int indice) {
		return this.f[indice].getFabricante();
	}
	
	public String getFonesValCust(int indice) {
		return String.valueOf(this.f[indice].getValorCusto());
	}	
	
	public String getFonesValVend(int indice) {
		return String.valueOf(this.f[indice].getValorVenda());
	}
	
	public String getTipoFone(int indice) {
		return this.f[indice].getTipoFone();		
	}
	
	public String getTecCon(int indice) {
		return this.f[indice].getTecConexao();		
	}
}
