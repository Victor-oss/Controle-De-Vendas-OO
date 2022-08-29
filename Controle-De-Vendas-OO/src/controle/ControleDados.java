package controle;
import modelo.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.DefaultListModel;

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.fillWithSomeData();
	}
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}
	
	//Clientes	
	public Cliente[] getClientes() {
		return this.d.getClientes();
	}
	
	public int getClientesSize() {
		return this.d.getClientesSize();
	}	
		
	public void adicionarClientes(String nome_novo, String ende_novo, String tel_novo) {
		this.d.adicionarClientes(new Cliente(nome_novo, ende_novo, tel_novo)); 
	}
	
	public void editarCliente(int indice, String nome_edit, String ende_edit, String tel_edit) {
		this.d.editarCliente(indice, nome_edit, ende_edit, tel_edit);
	}
	
	public void excluirCliente(int indice_excluido) {
		this.d.excluirCliente(indice_excluido);		
	}
	
	//Fones
	public Fone[] getFones(){
		return this.d.getFones();
	}
	
	public int getFonesSize(){
		return this.d.getFonesSize();
	}
	
	public boolean adicionarFone(String nome_novo, String fab_novo, String vlvend_novo, String vlcust_novo, String tpfone_novo, String teccon_novo) {
		if(!nome_novo.isEmpty() && !fab_novo.isEmpty() && !vlvend_novo.isEmpty() &&
				!vlcust_novo.isEmpty() && !tpfone_novo.isEmpty() && !teccon_novo.isEmpty()){
				try {
					double vlvenda_ver = Double.parseDouble(vlvend_novo);
					double vlcust_ver = Double.parseDouble(vlcust_novo);
					this.d.adicionarFone(new Fone(nome_novo, fab_novo, vlcust_ver,  vlvenda_ver, tpfone_novo, teccon_novo)); 
					return true;
				} catch (NumberFormatException e) {
					return false;
				}				 
				
		} else {
			return false;
		}
	}
	
	public boolean editarFone(int indice, String nome_edit, String fab_edit, String valcust_edit, String valvend_edit, String tp_fone_edit, String tec_con_edit) {
		if(!nome_edit.isEmpty() && !fab_edit.isEmpty() && !valvend_edit.isEmpty() &&
				!valcust_edit.isEmpty() && !tp_fone_edit.isEmpty() && !tec_con_edit.isEmpty()){
				try {
					double vlvenda_ver = Double.parseDouble(valvend_edit);
					double vlcust_ver = Double.parseDouble(valcust_edit);
					this.d.editarFone(indice, nome_edit, fab_edit, vlcust_ver, vlvenda_ver, tp_fone_edit, tec_con_edit);
					return true;
				} catch (NumberFormatException e) {
					return false;
				}				 
				
		} else {
			return false;
		}		
	}
	
	public void excluirFone(int indice_excluido) {
		this.d.excluirFone(indice_excluido);	
	}
	
	//Notebooks
	public Notebook[] getNotebooks() {
		return this.d.getNotebooks();
	}
	
	public int getNotebooksSize() {
		return this.d.getNotebooksSize();
	}
	
	public boolean adicionarNotebook(String nome_novo, String fab_novo, String vlvend_novo, String vlcust_novo, String arm_novo, String so_novo) {
		if(!nome_novo.isEmpty() && !fab_novo.isEmpty() && !vlvend_novo.isEmpty() &&
				!vlcust_novo.isEmpty() && !arm_novo.isEmpty() && !so_novo.isEmpty()){
				try {
					double vlvenda_ver = Double.parseDouble(vlvend_novo);
					double vlcust_ver = Double.parseDouble(vlcust_novo);
					int arm_ver = Integer.valueOf(arm_novo);
					this.d.adicionarNotebook(new Notebook(nome_novo, fab_novo, vlcust_ver, vlvenda_ver, arm_ver, so_novo));
					return true;
				} catch (NumberFormatException e) {
					return false;
				}				 
				
		} else {
			return false;
		}
		
		
	}
	
	public boolean editarNotebook(int indice, String nome_edit, String fab_edit, String valcust_edit, String valvend_edit, 
			String arm_edit, String so_edit) {
		if(!nome_edit.isEmpty() && !fab_edit.isEmpty() && !valvend_edit.isEmpty() &&
				!valcust_edit.isEmpty() && !arm_edit.isEmpty() && !so_edit.isEmpty()){
				try {
					double vlvenda_ver = Double.parseDouble(valvend_edit);
					double vlcust_ver = Double.parseDouble(valcust_edit);
					int arm_ver = Integer.valueOf(arm_edit);
					this.d.editarNotebook(indice, nome_edit, fab_edit, vlcust_ver, vlvenda_ver, arm_ver, so_edit);
					return true;
				} catch (NumberFormatException e) {
					return false;
				}				 
				
		} else {
			return false;
		}
		
	}
	
	public void excluirNotebook(int indice_excluido) {
		this.d.excluirNotebook(indice_excluido);		
	}
	
	//Impressoras
	public Impressora[] getImps() {
		return this.d.getImps();
	}
	
	public int getImpsSize() {
		return this.d.getImpsSize();
	}	
		
	public boolean adicionarImp(String nome_novo, String fab_novo, String vlvend_novo, String vlcust_novo, String tec_imp_nova, 
			String tamfol_nova) {
		if(!nome_novo.isEmpty() && !fab_novo.isEmpty() && !vlvend_novo.isEmpty() &&
				!vlcust_novo.isEmpty() && !tec_imp_nova.isEmpty() && !tamfol_nova.isEmpty()){
				try {
					double vlvenda_ver = Double.parseDouble(vlvend_novo);
					double vlcust_ver = Double.parseDouble(vlcust_novo);
					this.d.adicionarImp(new Impressora(nome_novo, fab_novo, vlcust_ver, vlvenda_ver, tec_imp_nova, tamfol_nova));
					return true;
				} catch (NumberFormatException e) {
					return false;
				}				 
				
		} else {
			return false;
		}		 
	}
	
	public boolean editarImpressora(int indice, String nome_edit, String fab_edit, String valcust_edit, String valvend_edit, 
			String tec_imp_edit, String tam_fol_edit) {
		if(!nome_edit.isEmpty() && !fab_edit.isEmpty() && !valvend_edit.isEmpty() &&
				!valcust_edit.isEmpty() && !tec_imp_edit.isEmpty() && !tam_fol_edit.isEmpty()){
				try {
					double vlvenda_ver = Double.parseDouble(valvend_edit);
					double vlcust_ver = Double.parseDouble(valcust_edit);
					this.d.editarImpressora(indice, nome_edit, fab_edit, vlcust_ver, vlvenda_ver, tec_imp_edit, tam_fol_edit);
					return true;
				} catch (NumberFormatException e) {
					return false;
				}				 
				
		} else {
			return false;
		}	
		
	}
	
	public void excluirImpressora(int indice_excluido) {
		this.d.excluirImpressora(indice_excluido);		
	}
	
	//Consoles Video Game
	public Console_Video_Game[] getConsoles() {
		return d.getConsoles();
	}
	
	public int getConsolesSize() {
		return d.getConsolesSize();
	}
		
	public boolean adicionarConsole(String nome_novo, String fab_novo, String vlvend_novo, String vlcust_novo, String qtdcont_novo,
			String qtdjogo_novo) {
		if(!nome_novo.isEmpty() && !fab_novo.isEmpty() && !vlvend_novo.isEmpty() &&
				!vlcust_novo.isEmpty() && !qtdcont_novo.isEmpty() && !qtdjogo_novo.isEmpty()){
				try {
					double vlvenda_ver = Double.parseDouble(vlvend_novo);
					double vlcust_ver = Double.parseDouble(vlcust_novo);
					int qtdcont_ver = Integer.valueOf(qtdcont_novo);
					int qtdjogo_ver = Integer.valueOf(qtdjogo_novo);
					this.d.adicionarConsole(new Console_Video_Game(nome_novo, fab_novo, vlcust_ver, vlvenda_ver, qtdcont_ver, qtdjogo_ver));
					return true;
				} catch (NumberFormatException e) {
					return false;
				}				 
				
		} else {
			return false;
		}		 
	}	
	
	public boolean editarConsole(int indice, String nome_edit, String fab_edit, String valcust_edit, String valvend_edit,
			String qtd_cont_edit, String qtd_jogo_edit) {
		if(!nome_edit.isEmpty() && !fab_edit.isEmpty() && !valcust_edit.isEmpty() &&
				!valvend_edit.isEmpty() && !qtd_cont_edit.isEmpty() && !qtd_jogo_edit.isEmpty()){
				try {
					double vlvenda_ver = Double.parseDouble(valvend_edit);
					double vlcust_ver = Double.parseDouble(valcust_edit);
					int qtdcont_ver = Integer.valueOf(qtd_cont_edit);
					int qtdjogo_ver = Integer.valueOf(qtd_jogo_edit);
					this.d.editarConsole(indice, nome_edit, fab_edit, vlcust_ver, vlvenda_ver, qtdcont_ver, qtdjogo_ver);
					return true;
				} catch (NumberFormatException e) {
					return false;
				}				 
				
		} else {
			return false;
		}		
	}
	
	public void excluirConsole(int indice_excluido) {
		this.d.excluirConsole(indice_excluido);		
	}
	
	//Vendas
	public Venda[] getVendas() {
		return d.getVendas();
	}
	
	public int getVendasSize() {
		return d.getVendasSize();
	}
	
	public static boolean verificaDatas(String dataVenda, String dataVencimento) {
		if(dataVenda.length() == 10 && dataVencimento.length() == 10 && !dataVenda.isEmpty() && !dataVencimento.isEmpty()) {
			try {
				int dia_vend = Integer.parseInt(dataVenda.substring(0, 2));
				int mes_vend = Integer.parseInt(dataVenda.substring(3, 5));
				int ano_vend = Integer.parseInt(dataVenda.substring(6));
				int dia_venc = Integer.parseInt(dataVencimento.substring(0, 2));
				int mes_venc = Integer.parseInt(dataVencimento.substring(3, 5));
				int ano_venc = Integer.parseInt(dataVencimento.substring(6));
				Calendar c_vend = Calendar.getInstance();
				c_vend.set(ano_vend, mes_vend, dia_vend);
				Calendar c_venc = Calendar.getInstance();
				c_venc.set(ano_venc, mes_venc, dia_venc);
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        df.setLenient(false);
		        df.parse(dataVenda);
		        df.parse(dataVencimento);
		        String dataAtual = dtf.format(LocalDateTime.now());
		        int dia_atual = Integer.parseInt(dataAtual.substring(0, 2));
				int mes_atual = Integer.parseInt(dataAtual.substring(3, 5));
				int ano_atual = Integer.parseInt(dataAtual.substring(6));
				Calendar c_atual = Calendar.getInstance();
				c_atual.set(ano_atual, mes_atual, dia_atual);
				if(c_vend.compareTo(c_atual) > 0 || (dia_vend == dia_atual && mes_vend == mes_atual 
		        		&& ano_vend == ano_atual)) {					
					if(c_venc.compareTo(c_vend) > 0 || (dia_vend == dia_venc && mes_vend == mes_venc && ano_vend == ano_venc)) {
						return true;
					} else {
						return false;
					}					
				} else {
					return false;
				}
									
			} catch (NullPointerException e) {
				return false;
			} catch (ParseException e) {
				return false;
			}
			
		} else {
			return false;
		}		
	}
	
	public boolean adicionarVenda(String nome_cliente, String end_cliente, String tel_cliente, String data_venda, 
			String data_vencimento, double valor_total, String qtd_meses, String[] produtos) {
			if(data_venda.length() == 10 && data_vencimento.length() == 10 && !data_venda.isEmpty() && !data_vencimento.isEmpty() &&
					!qtd_meses.isEmpty()) {
				try {
					int qtd_meses_ver =  Integer.valueOf(qtd_meses);
					if(verificaDatas(data_venda, data_vencimento)){
						this.d.adicionarVenda(new Venda(new Cliente(nome_cliente, end_cliente, tel_cliente), data_venda, 
							data_vencimento, valor_total, qtd_meses_ver, produtos));
						return true;
					} else {
						return false;
					}										
				} catch (NullPointerException e) {
					return false;
				}
			} else {
				return false;
			}
		
	}	
	
	public void pagaVenda(int indice_venda) {
		this.getVendas()[indice_venda].pagarVenda();
	}
	
	public String getDataVenda(int indice_venda) {
		return this.getVendas()[indice_venda].getPagamento().getDataVend();
	}
	
	public String getDataVencimento(int indice_venda) {
		return this.getVendas()[indice_venda].getPagamento().getDataVenci();
	}	
		
	public String[] getVendaCarrinho(int indice_venda_escolhida) {
		return this.d.getCarrinho(indice_venda_escolhida);
	}
			
	public String getClienteVendaNome(int indice) {
		return this.getVendas()[indice].getClienteVenda().getNome();
	}
	
	public double getValorTotal(int indice) {
		return this.getVendas()[indice].getPagamento().getValorTot();
	}
	
	public double getValorPend(int indice) {
		return this.getVendas()[indice].getPagamento().getValorPend();
	}
	
	public String getStatus(int indice) {
		return this.getVendas()[indice].getStatus();
	}
	
	public String getStatusParcela(int indice_venda, int indice_parcela) {
		return this.getVendas()[indice_venda].getPagamento().getStatusParcela(indice_parcela);
	}
	
	public boolean verificaVendaPaga(int indice_venda) {
		return this.getVendas()[indice_venda].getPagamento().verificaTdsParcelasPagas();
	}
	
	public String[] getParcelasString(int indice_selecionado) {
		return this.d.getParcelasString(indice_selecionado);
	}
	
	public String procuraNomeCliente(String nome_digitado) {
		try {
			Cliente[] c = this.d.getClientes();
			Cliente cliente_procurado = new Cliente();
			for(int i = 0; i<c.length; i++) {
					if(nome_digitado.equals(c[i].getNome())) {
						cliente_procurado = c[i];
						return cliente_procurado.getNome(); 
					}
			}
			return cliente_procurado.getNome();
		} catch(NullPointerException e) {
			return null;
		}		
	}
	
	public String procuraEndCliente(String nome_digitado) {
		Cliente[] c = this.d.getClientes();
		Cliente cliente_procurado = new Cliente();
		for(int i = 0; i<c.length; i++) {
				if(nome_digitado.equals(c[i].getNome())) {
					cliente_procurado = c[i];
					return cliente_procurado.getEndereco();
				}
		}
		return cliente_procurado.getEndereco();
	}
	
	public String procuraTelCliente(String nome_digitado) {
		Cliente[] c = this.d.getClientes();
		Cliente cliente_procurado = new Cliente();
		for(int i = 0; i<c.length; i++) {
				if(nome_digitado.equals(c[i].getNome())) {
					cliente_procurado = c[i];
					return cliente_procurado.getTelefone();
				}
		}
		return cliente_procurado.getTelefone();
	}
	
	public String procuraNomeNotebook(String not_digitado) {
		Notebook[] n = this.d.getNotebooks();
		Notebook not_procurado = new Notebook();
		for(int i = 0; i<n.length; i++) {
			if(not_digitado.equals(n[i].getNome())) {
				not_procurado = n[i];
				return not_procurado.getNome();
			}
		}		
		return not_procurado.getNome();
	}
	
	public double procuraPrecoNotebook(String not_digitado) {
		Notebook[] n = this.d.getNotebooks();
		Notebook not_procurado = new Notebook();
		for(int i = 0; i<n.length; i++) {
			if(not_digitado.equals(n[i].getNome())) {
				not_procurado = n[i];
				return not_procurado.getValorVenda();
			}
		}		
		return not_procurado.getValorVenda();
	}
	
	public String procuraNomeConsole(String con_digitado) {
		Console_Video_Game[] g = this.d.getConsoles();  
		Console_Video_Game con_procurado = new Console_Video_Game();
		for(int i = 0; i<g.length; i++) {
			if(con_digitado.equals(g[i].getNome())) {
				con_procurado = g[i];
				return con_procurado.getNome();
			}
		}		
		return con_procurado.getNome();
	}
	
	public double procuraPrecoConsole(String con_digitado) {
		Console_Video_Game[] g = this.d.getConsoles();  
		Console_Video_Game con_procurado = new Console_Video_Game();
		for(int i = 0; i<g.length; i++) {
			if(con_digitado.equals(g[i].getNome())) {
				con_procurado = g[i];
				return con_procurado.getValorVenda();
			}
		}		
		return con_procurado.getValorVenda();
	}
	
	public String procuraNomeImpressora(String imp_digitada) {
		Impressora imp_procurada = new Impressora();
		Impressora[] imp = this.d.getImps();
		for(int i = 0; i<imp.length; i++) {
			if(imp_digitada.equals(imp[i].getNome())) {
				imp_procurada = imp[i];
				return imp_procurada.getNome();
			}
		}		
		return imp_procurada.getNome();
	}
	
	public double procuraPrecoImpressora(String imp_digitada) {
		Impressora imp_procurada = new Impressora();
		Impressora[] imp = this.d.getImps();
		for(int i = 0; i<imp.length; i++) {
			if(imp_digitada.equals(imp[i].getNome())) {
				imp_procurada = imp[i];
				return imp_procurada.getValorVenda();
			}
		}		
		return imp_procurada.getValorVenda();
	}
	
	public String procuraNomeFone(String fone_digitado) {
		Fone[] f = this.d.getFones(); 
		Fone fone_procurado = new Fone();
		for(int i = 0; i<f.length; i++) {
			if(fone_digitado.equals(f[i].getNome())) {
				fone_procurado = f[i];
				return fone_procurado.getNome();
			}
		}		
		return fone_procurado.getNome();
	}
	
	public double procuraPrecoFone(String fone_digitado) {
		Fone[] f = this.d.getFones(); 
		Fone fone_procurado = new Fone();
		for(int i = 0; i<f.length; i++) {
			if(fone_digitado.equals(f[i].getNome())) {
				fone_procurado = f[i];
				return fone_procurado.getValorVenda();
			}
		}		
		return fone_procurado.getValorVenda();
	}
	
	public String[] converteEmArray(DefaultListModel<String> produtos_carrinho) {
		String[] carrinho_array = new String[10]; 
		for(int i = 0; i<produtos_carrinho.getSize(); i++) {
			carrinho_array[i] = produtos_carrinho.elementAt(i); 
		}
		return carrinho_array;
	}
	
	public void pagarParcela(int indice_venda, int indice_parcela) {
		Venda[] vendas = this.getVendas();
		Venda vendaSelecionada = vendas[indice_venda];
		Pagamento pagamento = vendaSelecionada.getPagamento();
		Parcela[] parcelas = pagamento.getParcelas();
		parcelas[indice_parcela].pagarParcela();
		double valortotinicial = getValorTotal(indice_venda);
		double valorpendinicial = getValorPend(indice_venda);
		double valor_parcela = parcelas[indice_parcela].getValor();
		double novovalorpend = valorpendinicial - valor_parcela;
		pagamento.setValorPend(novovalorpend);
		pagamento.setValorPago(valortotinicial - novovalorpend); 
	}
	
	public double getParcelaValor(int indice_venda, int indice_parcela) {
		return this.getVendas()[indice_venda].getPagamento().getParcelas()[indice_parcela].getValor();
	}
	
	public String getParcelaData(int indice_venda, int indice_parcela) {
		return this.getVendas()[indice_venda].getPagamento().getParcelas()[indice_parcela].getDataPag();
	}
	
	public void excluirVenda(int indice_sel) {
		this.d.excluirVenda(indice_sel);
	}
}      

