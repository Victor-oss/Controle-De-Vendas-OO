package controle;

import modelo.*;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *	Classe ControleDados que conecta a view a camada model      
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

public class ControleDados {
	/**
	 *	Atributo da classe Dados que fornece um banco de dados para a aplicação
	 */
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
	
	public Cliente[] getClientes() {
		return this.d.getClientes();
	}
	
	public int getClientesSize() {
		return this.d.getClientesSize();
	}	
		
	/**
	 *	Adiciona um cliente ao vetor de clientes na classe Dados usando um metodo da classe Dados
	 *	@see Dados
	 *	@param nome_novo Nome do novo cliente
	 *	@param ende_novo Endereco do novo cliente
	 *	@param tel_novo Telefone do novo cliente
	 */
	public void adicionarClientes(String nome_novo, String ende_novo, String tel_novo) {
		this.d.adicionarClientes(new Cliente(nome_novo, ende_novo, tel_novo)); 
	}
	
	/**
	 *	Edita as informações de um cliente no vetor de clientes possuindo a posicao do cliente no vetor
	 *	e usando um método da classe Dados
	 *	@see Dados
	 *	@param indice Indice do cliente que se deseja editar no vetor de clientes 
	 *	@param nome_edit Nome editado do cliente tendo a posicao desse cliente no vetor
	 * 	@param ende_edit Endereco editado do cliente tendo a posicao desse cliente no vetor
	 *  @param tel_edit Telefone editado do cliente tendo a posicao desse cliente no vetor 	
	 */
	public void editarCliente(int indice, String nome_edit, String ende_edit, String tel_edit) {
		this.d.editarCliente(indice, nome_edit, ende_edit, tel_edit);
	}
	
	/**
	 *	Exclui um cliente possuindo a posicao do cliente no vetor e usando um metodo da classe Dados
	 *	@see Dados
	 *	@param indice_excluido Indice do cliente que se deseja excluir
	 */
	public void excluirCliente(int indice_excluido) {
		this.d.excluirCliente(indice_excluido);		
	}
	
	public Fone[] getFones(){
		return this.d.getFones();
	}
	
	public int getFonesSize(){
		return this.d.getFonesSize();
	}
	
	/**
	 *	Adiciona um fone ao vetor de fones na classe Dados usando um metodo da classe Dados
	 *	@see Dados
	 * 	@throws NumberFormatException Essa excecao e chamada quando os valores de venda nao tiverem sido digitados nos formatos
	 * 	especificados
	 * 	@return boolean
	 * 	@param nome_novo Nome do novo fone
	 * 	@param fab_novo Fabricante do novo fone
	 * 	@param vlvend_novo Valor de venda do novo fone
	 * 	@param vlcust_novo Valor de custo do novo fone
	 * 	@param tpfone_novo Tipo do novo fone
	 * 	@param teccon_novo Tecnologia de conexao do novo fone
	 */
	public boolean adicionarFone(String nome_novo, String fab_novo, String vlvend_novo, String vlcust_novo, String tpfone_novo, 
			String teccon_novo) {
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
	
	/**
	 *	Edita as informacoes de um fone no vetor de fones possuindo a posicao do fone no vetor
	 *	e usando um metodo da classe Dados
	 *	@see Dados
	 *	@throws NumberFormatException Essa excecao e chamada quando os valores de venda nao tiverem sido digitados nos formatos
	 * 	especificados
	 *	@return boolean
	 *	@param indice Indice do fone que se deseja editar no vetor de fones
	 *	@param nome_edit Nome editado do fone tendo a posicao desse fone no vetor
	 *	@param fab_edit Fabricante editado do novo fone
	 * 	@param valvend_edit Valor de venda editado do novo fone
	 * 	@param valcust_edit Valor de custo editado do novo fone
	 * 	@param tp_fone_edit Tipo editado do novo fone
	 * 	@param tec_con_edit Tecnologia de conexao editada do novo fone
	 */
	public boolean editarFone(int indice, String nome_edit, String fab_edit, String valcust_edit, String valvend_edit, 
			String tp_fone_edit, String tec_con_edit) {
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
	
	/**
	 *	Exclui um fone possuindo a posicao do fone no vetor e usando um metodo da classe Dados
	 *	@see Dados
	 *	@param indice_excluido Indice do fone que se deseja excluir
	 */
	public void excluirFone(int indice_excluido) {
		this.d.excluirFone(indice_excluido);	
	}
	
	public Notebook[] getNotebooks() {
		return this.d.getNotebooks();
	}
	
	public int getNotebooksSize() {
		return this.d.getNotebooksSize();
	}
	
	/**
	 *	Adiciona um notebook ao vetor de notebooks na classe Dados usando um metodo da classe Dados
	 *	@see Dados
	 * 	@throws NumberFormatException Essa excecao e chamada quando os valores de venda nao tiverem sido digitados nos formatos
	 * 	especificados
	 * 	@return boolean
	 * 	@param nome_novo Nome do novo notebook
	 * 	@param fab_novo Fabricante do novo notebook
	 * 	@param vlvend_novo Valor de venda do novo notebook
	 * 	@param vlcust_novo Valor de custo do novo notebook
	 * 	@param arm_novo Armazenamento do novo notebook em GB
	 * 	@param so_novo Sistema operacional do novo notebook
	 */
	public boolean adicionarNotebook(String nome_novo, String fab_novo, String vlvend_novo, String vlcust_novo, String arm_novo, 
			String so_novo) {
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
	
	/**
	 *	Edita as informacoes de um notebook no vetor de notebooks possuindo a posicao do notebook no vetor
	 *	e usando um metodo da classe Dados
	 *	@see Dados
	 *	@throws NumberFormatException Essa excecao e chamada quando os valores de venda nao tiverem sido digitados nos formatos
	 * 	especificados
	 *	@return boolean
	 *	@param indice Indice do notebook que se deseja editar
	 *	@param nome_edit Nome editado do notebook
	 *	@param fab_edit Fabricante editado do notebook
	 * 	@param valvend_edit Valor de venda editado do notebook
	 * 	@param valcust_edit Valor de custo editado do notebook
	 * 	@param arm_edit Armazenamento em GB editado do notebook
	 * 	@param so_edit Sistema operacional editado do notebook
	 *	
	 */	
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
	
	/**
	 *	Exclui um notebook possuindo a posicao do notebook no vetor e usando um metodo da classe Dados
	 *	@see Dados
	 *	@param indice_excluido Indice do notebook que se deseja excluir
	 */
	public void excluirNotebook(int indice_excluido) {
		this.d.excluirNotebook(indice_excluido);		
	}
		
	public Impressora[] getImps() {
		return this.d.getImps();
	}
	
	public int getImpsSize() {
		return this.d.getImpsSize();
	}	
		
	/**
	 *	Adiciona uma impressora ao vetor de impressoras na classe Dados usando um metodo da classe Dados
	 *	@see Dados
	 * 	@throws NumberFormatException Essa excecao e chamada quando os valores de venda nao tiverem sido digitados nos formatos
	 * 	especificados
 	 *  @return boolean 	
 	 *  @param nome_novo Nome da nova impressora
	 * 	@param fab_novo Fabricante da nova impressora
	 * 	@param vlvend_novo Valor de venda da nova impressora
	 * 	@param vlcust_novo Valor de custo da nova impressora
	 * 	@param tec_imp_nova Tecnologia de impressao da nova impressora
	 * 	@param tamfol_nova Tamanho da folha que a nova impressora imprime
	 */
	public boolean adicionarImp(String nome_novo, String fab_novo, String vlvend_novo, String vlcust_novo, String tec_imp_nova, 
			String tamfol_nova) {
		if(!nome_novo.isEmpty() && !fab_novo.isEmpty() && !vlvend_novo.isEmpty() &&
				!vlcust_novo.isEmpty() && !tec_imp_nova.isEmpty() && !tamfol_nova.isEmpty()){
				try {
					double vlvenda_ver = Double.parseDouble(vlvend_novo);
					double vlcust_ver = Double.parseDouble(vlcust_novo);
					this.d.adicionarImp(new Impressora(nome_novo, fab_novo, vlcust_ver, vlvenda_ver, tamfol_nova, tec_imp_nova));
					return true;
				} catch (NumberFormatException e) {
					return false;
				}				 
				
		} else {
			return false;
		}		 
	}
	
	/**
	 *	Edita as informacoes de uma impressora no vetor de impressoras possuindo a posicao da impressora no vetor
	 *	e usando um metodo da classe Dados
	 *	@see Dados
	 *	@throws NumberFormatException Essa excecao e chamada quando os valores de venda nao tiverem sido digitados nos formatos
	 * 	especificados
	 *	@return boolean
	 *	@param indice Indice da impressora que se deseja editar
	 *	@param nome_edit Nome editado da impressora
	 *	@param fab_edit Fabricante editado da impressora
	 * 	@param valvend_edit Valor de venda editado da impressora
	 * 	@param valcust_edit Valor de custo editado da impressora
	 * 	@param tec_imp_edit Tecnologia de impressao editada da impressora
	 * 	@param tam_fol_edit Tamanho da folha editado que a impressora imprime	
	 */
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
	
	/**
	 *	Exclui uma impressora possuindo a posicao da impressora no vetor e usando um metodo da classe Dados
	 *	@see Dados
	 *	@param indice_excluido Indice da impressora que se deseja excluir
	 */
	public void excluirImpressora(int indice_excluido) {
		this.d.excluirImpressora(indice_excluido);		
	}
	
	public Console_Video_Game[] getConsoles() {
		return d.getConsoles();
	}
	
	public int getConsolesSize() {
		return d.getConsolesSize();
	}
	
	/**
	 *	Adiciona um console ao vetor de consoles na classe Dados usando um metodo da classe Dados
	 *	@see Dados
	 * 	@throws NumberFormatException Essa excecao e chamada quando os valores de venda nao tiverem sido digitados nos formatos
	 * 	especificados
 	 *  @return boolean 	
 	 *  @param nome_novo Nome do novo console
	 * 	@param fab_novo Fabricante do novo console
	 * 	@param vlvend_novo Valor de venda do novo console
	 * 	@param vlcust_novo Valor de custo do novo console
	 * 	@param qtdcont_novo Quantidade de controles do novo console
	 * 	@param qtdjogo_novo Quantidade jogos instalados previamente do novo console
	 */
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
	
	/**
	 *	Edita as informacoes de um console no vetor de consoles possuindo a posiçao do console no vetor
	 *	e usando um metodo da classe Dados
	 *	@see Dados
	 *	@throws NumberFormatException Essa excecao e chamada quando os valores de venda nao tiverem sido digitados nos formatos
	 * 	especificados
	 *	@return boolean	
	 *	@param indice Indice do console que se deseja editar
	 *	@param nome_edit Nome editado do console
	 *	@param fab_edit Fabricante editado do console
	 * 	@param valvend_edit Valor de venda editado do console
	 * 	@param valcust_edit Valor de custo editado do console
	 * 	@param qtd_cont_edit Quantidade de controles editada do console
	 * 	@param qtd_jogo_edit Quantidade de jogos instalados previamente editada do console
	 */
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
	
	/**
	 *	Exclui um console possuindo a posiçao do console no vetor e usando um metodo da classe Dados
	 *	@see Dados
	 *	@param indice_excluido Indice do console que se deseja excluir
	 */
	public void excluirConsole(int indice_excluido) {
		this.d.excluirConsole(indice_excluido);		
	}
		
	public int getVendasSize() {
		return d.getVendasSize();
	}
	
	/**
	 *	Esse metodo estatico verifica a veracidade das datas de venda e de vencimento de uma venda
	 *	@throws NullPointerException Essa excecao e chamada quando algum valor e nulo
	 *	@return boolean	
	 *	@param dataVenda Data de venda que se deseja verificar
	 * 	@param dataVencimento Data de vencimento que se deseja verificar
	 */
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
	
	/**
	 *	Adiciona uma venda ao vetor de vendas na classe Dados usando um metodo da classe Dados
	 *	@see Dados
	 * 	@throws NullPointerException Essa excecao e chamada quando algum valor e nulo 
 	 *  @return boolean 	
 	 *  @param nome_cliente Nome do cliente da nova venda
	 * 	@param end_cliente Endereco do cliente da nova venda
	 * 	@param tel_cliente Telefone do cliente da nova venda
	 * 	@param data_venda Data de venda da nova venda
	 * 	@param data_vencimento Data de vencimento do prazo para comecar a pagar a nova venda
	 * 	@param valor_total Valor total da nova venda
 	 * 	@param qtd_meses Quantidade de meses em que o cliente quer parcelar a venda
 	 * 	@param produtos Vetor de Strings onde cada String contem o nome, quantidade e preco unitario de cada produto comprado   
	 */
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
	
	/**
	 *	Paga uma venda dado o indice da venda no vetor
	 *	@param indice_venda Indice da venda que se deseja pagar
	 */	
	public void pagaVenda(int indice_venda) {
		this.d.getVendas()[indice_venda].pagarVenda();
	}
	
	public String getDataVenda(int indice_venda) {
		return this.d.getVendas()[indice_venda].getPagamento().getDataVend();
	}
	
	public String getDataVencimento(int indice_venda) {
		return this.d.getVendas()[indice_venda].getPagamento().getDataVenci();
	}	
		
	public String[] getVendaCarrinho(int indice_venda_escolhida) {
		return this.d.getCarrinho(indice_venda_escolhida);
	}
			
	public String getClienteVendaNome(int indice) {
		return this.d.getVendas()[indice].getClienteVenda().getNome();
	}
	
	public double getValorTotal(int indice) {
		return this.d.getVendas()[indice].getPagamento().getValorTot();
	}
	
	public double getValorPend(int indice) {
		return this.d.getVendas()[indice].getPagamento().getValorPend();
	}
	
	public String getStatus(int indice) {
		return this.d.getVendas()[indice].getStatus();
	}
	
	public String getStatusParcela(int indice_venda, int indice_parcela) {
		return this.d.getVendas()[indice_venda].getPagamento().getStatusParcela(indice_parcela);
	}
	
	/**
	 *	Verifica se todas as parcelas de uma venda foram pagas e, se sim, paga a venda
 	 *  @return boolean 	
 	 *  @param indice_venda Indice da venda que se deseja verificar se todas as vendas foram pagas
	 */
	public boolean verificaVendaPaga(int indice_venda) {
		return this.d.getVendas()[indice_venda].getPagamento().verificaTdsParcelasPagas();
	}
	
	public String[] getParcelasString(int indice_selecionado) {
		return this.d.getParcelasString(indice_selecionado);
	}
	
	/**
	 *	Verifica se o nome digitado pelo usuario corresponde a um usuario existente no banco de dados e retorna o cliente
	 *	caso ele exista 
 	 *  @throws NullPointerException Essa excecao e chamada quando alguma posicao do vetor de clientes e chamada e ela e nula 
 	 *  @return String 	
 	 *  @param nome_digitado Nome do cliente procurado 
	 */
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
	
	/**
	 *	Retorna o endereço do cliente procurado
 	 *  @return String 	
 	 *  @param nome_digitado Nome do cliente que se deseja procurar o endereco
	 */
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
	
	/**
	 *	Retorna o telefone do cliente procurado
 	 *  @return String 
 	 *  @param nome_digitado Nome do cliente que se deseja procurar o telefone  	
	 */
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
	
	/**
	 *	Retorna o nome do notebook procurado
 	 *  @return String 
 	 *  @param not_digitado Nome do notebook procurado	
	 */
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
	
	/**
	 *	Retorna o preço do notebook procurado dado o nome do notebook
 	 *  @return double 	
 	 *  @param not_digitado Nome do notebook que se deseja procurar o preco
	 */
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
	
	/**
	 *	Retorna o nome do console procurado
 	 *  @return String 	
 	 *  @param con_digitado Nome do console procurado
	 */
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
	
	/**
	 *	Retorna o preço do console procurado dado o nome do console
 	 *  @return double 	
 	 *  @param con_digitado Nome do console que se deseja procurar o preco
	 */
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
	
	/**
	 *	Retorna o nome da impressora procurada
 	 *  @return String 	
 	 *  @param imp_digitada Nome da impressora procurada	
	 */
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
	
	/**
	 *	Retorna o preço da impressora procurada dado o nome da impressora
 	 *  @return double 	
 	 *  @param imp_digitada Nome da impressora que se deseja procurar o preco
	 */
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
	
	/**
	 *	Retorna o nome do fone procurado
 	 *  @return String 	
 	 *  @param fone_digitado Nome do fone procurado	
	 */
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
	
	/**
	 *	Retorna o preço do fone procurado dado o nome do fone
 	 *  @return double 	
 	 *  @param fone_digitado Nome do fone que se deseja procurar o preco
	 */
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
	
		
	/**
	 * Utilizado para pagar uma parcela caso o usuário decida declarar essa parcela dado o índice da parcela e o índice da venda
	 * @param indice_venda Indice da venda no vetor de vendas
	 * @param indice_parcela Indice da parcela que se deseja pagar no vetor de parcelas da venda escolhida
	 */
	public void pagarParcela(int indice_venda, int indice_parcela) {
		Venda[] vendas = this.d.getVendas();
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
		return this.d.getVendas()[indice_venda].getPagamento().getParcelas()[indice_parcela].getValor();
	}
	
	public String getParcelaData(int indice_venda, int indice_parcela) {
		return this.d.getVendas()[indice_venda].getPagamento().getParcelas()[indice_parcela].getDataPag();
	}
	
	/**
	 *  Metodo responsavel pela exclusao de uma venda do banco de dados dado o indice da venda e utilizando um metodo da classe
	 *  Dados
	 *  @see Dados
	 *  @param indice_sel Indice da venda que seja excluir 
	 */
	public void excluirVenda(int indice_sel) {
		this.d.excluirVenda(indice_sel);
	}
}      

