package controle;
import modelo.*;

import javax.swing.DefaultListModel;

public class ControleVendas {
	private Venda[] v;
	private Cliente[] c;
	private Notebook[] n;
	private Fone[] f;
	private Console_Video_Game[] g;
	private Impressora[] imp;
	private int qtd_vendas;
	private ControleDados dados; 
	
	public ControleVendas(ControleDados d) {
		dados = d;
		this.v = d.getVendas();
		this.qtd_vendas = d.getVendasSize();
		this.c = d.getClientes();
		this.n = d.getNotebooks();
		this.f = d.getFones();
		this.g = d.getConsoles();
		this.imp = d.getImps();
	}
	
	public DefaultListModel<String> getTodasVendasNomes() {
		DefaultListModel<String> nomes_vendas = new DefaultListModel<String>();
		qtd_vendas++;
		String nome_venda;
		for(int i = 0; i < qtd_vendas; i++) {
			nome_venda = getClienteVendaNome(i) + " - " + getValorTotal(i) + " - " + this.v[i].getStatus();
			nomes_vendas.addElement(nome_venda);
		}		
		return nomes_vendas;
	}
	
	public int getVendasSize() {
		this.qtd_vendas = dados.getVendasSize(); 
		return this.qtd_vendas;
	}
	
	public String getClienteVendaNome(int indice) {
		this.v = dados.getVendas();
		return this.v[indice].getClienteVenda().getNome();
	}
	
	public double getValorTotal(int indice) {
		return this.v[indice].getPagamento().getValorTot();
	}
	
	public String getStatus(int indice) {
		return this.v[indice].getStatus();
	}	
	
	public Cliente procuraCliente(String nome_digitado) {
		Cliente cliente_procurado = new Cliente();
		for(int i = 0; i<c.length; i++) {
			if(nome_digitado.equals(c[i].getNome())) {
				cliente_procurado = c[i];
				return cliente_procurado;
			}
		}		
		return cliente_procurado;
	}
	
	public Notebook procuraNotebook(String not_digitado) {
		Notebook not_procurado = new Notebook();
		for(int i = 0; i<n.length; i++) {
			if(not_digitado.equals(n[i].getNome())) {
				not_procurado = n[i];
				return not_procurado;
			}
		}		
		return not_procurado;
	}
	
	public Console_Video_Game procuraConsole(String con_digitado) {
		Console_Video_Game con_procurado = new Console_Video_Game();
		for(int i = 0; i<g.length; i++) {
			if(con_digitado.equals(g[i].getNome())) {
				con_procurado = g[i];
				return con_procurado;
			}
		}		
		return con_procurado;
	}
	
	public Impressora procuraImpressora(String imp_digitada) {
		Impressora imp_procurada = new Impressora();
		for(int i = 0; i<imp.length; i++) {
			if(imp_digitada.equals(imp[i].getNome())) {
				imp_procurada = imp[i];
				return imp_procurada;
			}
		}		
		return imp_procurada;
	}
	
	public Fone procuraFone(String fone_digitado) {
		Fone fone_procurado = new Fone();
		for(int i = 0; i<f.length; i++) {
			if(fone_digitado.equals(f[i].getNome())) {
				fone_procurado = f[i];
				return fone_procurado;
			}
		}		
		return fone_procurado;
	}
}
