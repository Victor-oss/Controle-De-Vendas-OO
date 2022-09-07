package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import controle.*;

/**
 *	Classe TelaDetalheVenda que permite que o usuario crie, pague parcelas ou exclua uma venda dependendo da acao realizada na 
 * 	tela com o menu de vendas      
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 * 	@see Tela_Vendas 
 */

public class TelaDetalheVenda implements ActionListener, ItemListener, ListSelectionListener{
	private JList<String> jlst;
	private JList<String> jlst2;	
	private JFrame jf;
	private JPanel jp;
	private JScrollPane jscp;
	private JScrollPane jscp2;
	private int indice_parcela;
	private DefaultListModel<String> nomes_produtos = new DefaultListModel<String>();
	private DefaultListModel<String> parcelas = new DefaultListModel<String>();
	private JButton btn_procurarCli;
	private JButton btn_adicionarProd;
	private JButton btn_salvar;
	private JButton btn_cancelar;
	private JButton btn_pagar_parc;
	private JButton btn_excluir;
	private JTextField nome_cliente;
	private JTextField nome_prod;
	private JTextField qtd_prod;
	private JTextField n_parc;
	private JTextField dt_vend;
	private JTextField dt_venc;
	private JTextField valor_tot;
	private JTextField valor_pendente;
	private ControleDados dados;
	private ControleVendas contVendas;
	
	private String nome_cliente_proc;
	private String end_cliente_proc;
	private String tel_cliente_proc;
	
	private JCheckBox checkNot = new JCheckBox("Notebook");
	private JCheckBox checkImp = new JCheckBox("Impressora");
	private JCheckBox checkFone = new JCheckBox("Fone");
	private JCheckBox checkGame = new JCheckBox("Console Video-Game");
	private int tipo;
	private int indice_sel;
	private double valor_venda = 0;
	
	/**
	 * Metodo que mostra uma tela para cadastrar uma venda ou uma para pagar parcelas ou excluir uma venda dependendo
	 * da operacao realizada na tela anterior. 
	 * @param cv Atributo que permite fazer os gets no banco de dados das informacoes das vendas cadastradas
	 * @param d Atributo que permite fazer a CRUD de produtos no banco de dados usando essa tela como interface
	 * @param operacao Se operacao e 1, o cliente vai para a tela de cadastro. Se for 2, ele vai para
	 * a tela com as informacoes uma venda ja cadastrada  
	 * @param indice_sel Esse indice e necessario apenas quando se deseja visualizar as informacoes de uma venda cadastrada e
	 * possamos fazer as requisicoes no banco de dados usando o indice da venda escolhida
	 * @see ControleDados
	 * @see ControleVendas 
	 */
	public void mostrarTela(ControleDados d, ControleVendas cv, int operacao, int indice_sel){		
		dados = d;
		contVendas = cv;
		this.indice_sel = indice_sel;
		if(indice_sel != -1) {
			nomes_produtos = contVendas.getVendaCarrinho(indice_sel);		
			parcelas = contVendas.getParcelasString(indice_sel);
		}
		
		jlst = new JList<String>(nomes_produtos);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlst2 = new JList<String>(parcelas);
		jlst2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlst2.addListSelectionListener(this);
		//jlst.addListSelectionListener(this);
		indice_parcela = 0; 
		jf = new JFrame("Cadastrar Venda");
		jp = new JPanel();
		JPanel linha_cliente = new JPanel();
		JPanel linha_tipo = new JPanel();
		JPanel linha_produto = new JPanel(); 
		JPanel linha_qtd = new JPanel();
		JPanel linha_n_parc = new JPanel();
		JPanel linha_dt_vend = new JPanel();
		JPanel linha_dt_venc = new JPanel();
		JPanel linha_valor_tot = new JPanel();
		JPanel botoes_operacoes = new JPanel();
		JPanel linha_tit_prod = new JPanel();
		JPanel linha_tit_parc = new JPanel();
		JPanel linha_btn_pagar = new JPanel();
		JPanel linha_valor_pendente = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		linha_cliente.setLayout(new BoxLayout(linha_cliente, BoxLayout.X_AXIS));
		linha_cliente.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_produto.setLayout(new BoxLayout(linha_produto, BoxLayout.X_AXIS));
		linha_produto.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_qtd.setLayout(new BoxLayout(linha_qtd, BoxLayout.X_AXIS));
		linha_qtd.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_tipo.setLayout(new BoxLayout(linha_tipo, BoxLayout.X_AXIS));
		linha_tipo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		botoes_operacoes.setLayout(new BoxLayout(botoes_operacoes, BoxLayout.X_AXIS));
		botoes_operacoes.setLayout(new BoxLayout(botoes_operacoes, BoxLayout.X_AXIS));
		linha_n_parc.setLayout(new BoxLayout(linha_n_parc, BoxLayout.X_AXIS));
		linha_n_parc.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_dt_vend.setLayout(new BoxLayout(linha_dt_vend, BoxLayout.X_AXIS));
		linha_dt_vend.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_dt_venc.setLayout(new BoxLayout(linha_dt_venc, BoxLayout.X_AXIS));
		linha_dt_venc.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));	
		linha_valor_tot.setLayout(new BoxLayout(linha_valor_tot, BoxLayout.X_AXIS));
		linha_valor_tot.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_tit_prod.setLayout(new BoxLayout(linha_tit_prod, BoxLayout.X_AXIS));
		linha_tit_prod.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));	
		linha_tit_parc.setLayout(new BoxLayout(linha_tit_parc, BoxLayout.X_AXIS));
		linha_tit_parc.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_btn_pagar.setLayout(new BoxLayout(linha_btn_pagar, BoxLayout.X_AXIS));
		linha_btn_pagar.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_valor_pendente.setLayout(new BoxLayout(linha_valor_pendente, BoxLayout.X_AXIS));
		linha_valor_pendente.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		jlst.setPreferredSize(new Dimension(390,200));
		jscp = new JScrollPane(jlst, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jscp.setPreferredSize(new Dimension(390,150));
		jlst2.setPreferredSize(new Dimension(390,200));
		jscp2 = new JScrollPane(jlst2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jscp2.setPreferredSize(new Dimension(390,150));
		JLabel lab_cliente  = new JLabel("Cliente: ");
		JLabel lab_produto  = new JLabel("Produto: ");
		JLabel lab_qtd  = new JLabel("Quantidade: ");
		JLabel lab_nparc  = new JLabel("Número de Parcelas: ");
		JLabel lab_dt_vend  = new JLabel("Data Venda: ");
		JLabel lab_dt_venc  = new JLabel("Data Vencimento: ");
		JLabel lab_valor_tot  = new JLabel("Valor Venda: ");
		JLabel lab_carrinho  = new JLabel("Produtos: ");
		JLabel lab_parcelas  = new JLabel("Parcelas: ");
		JLabel lab_valor_pend  = new JLabel("Valor Pendente: ");
		nome_cliente= new JTextField(15);
		nome_prod = new JTextField(15);
		qtd_prod = new JTextField(15);
		n_parc= new JTextField(15);
		dt_vend = new JTextField(15);
		dt_venc = new JTextField(15);
		valor_tot = new JTextField(15);
		valor_pendente = new JTextField(15);
		valor_pendente.setEnabled(false);
		btn_procurarCli = new JButton("Procurar");
		btn_procurarCli.setBackground(Color.green);
		btn_procurarCli.setForeground(Color.WHITE);
		btn_adicionarProd = new JButton("Adicionar");
		btn_adicionarProd.setBackground(Color.green);
		btn_adicionarProd.setForeground(Color.WHITE);
		btn_salvar = new JButton("Salvar");
		btn_salvar.setBackground(Color.green);
		btn_salvar.setForeground(Color.WHITE);
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBackground(Color.green);
		btn_cancelar.setForeground(Color.WHITE);
		btn_pagar_parc = new JButton("Pagar");
		btn_pagar_parc.setBackground(Color.green);
		btn_pagar_parc.setForeground(Color.WHITE);
		btn_excluir = new JButton("Excluir");
		btn_excluir.setBackground(Color.green);
		btn_excluir.setForeground(Color.WHITE);
		checkFone.addItemListener(this);
		checkNot.addItemListener(this);
		checkGame.addItemListener(this);
		checkImp.addItemListener(this);
		limparTd();	
		btn_procurarCli.addActionListener(this);
		btn_adicionarProd.addActionListener(this);
		btn_salvar.addActionListener(this);
		btn_cancelar.addActionListener(this);
		btn_pagar_parc.addActionListener(this);
		btn_excluir.addActionListener(this);
		linha_cliente.add(lab_cliente);
		linha_cliente.add(nome_cliente);
		linha_produto.add(lab_produto);
		linha_produto.add(nome_prod);
		linha_qtd.add(lab_qtd);
		linha_qtd.add(qtd_prod);
		linha_qtd.add(btn_adicionarProd);
		linha_tipo.add(checkNot);
		linha_tipo.add(checkFone);
		linha_tipo.add(checkImp);
		linha_tipo.add(checkGame);
		linha_n_parc.add(lab_nparc);
		linha_n_parc.add(n_parc);
		linha_dt_vend.add(lab_dt_vend);
		linha_dt_vend.add(dt_vend);
		linha_dt_venc.add(lab_dt_venc);
		linha_dt_venc.add(dt_venc);
		linha_valor_tot.add(lab_valor_tot);
		linha_valor_tot.add(valor_tot);
		linha_tit_prod.add(lab_carrinho);
		linha_tit_parc.add(lab_parcelas);
		linha_btn_pagar.add(btn_pagar_parc);
		if(operacao == 1) {
			jf.setSize(410, 570);
			jf.setLayout(new FlowLayout());
			botoes_operacoes.add(btn_salvar);
			botoes_operacoes.add(btn_cancelar);
			linha_cliente.add(btn_procurarCli);
			jp.add(linha_cliente);
			jp.add(linha_tipo);
			jp.add(linha_produto);
			jp.add(linha_qtd);
			jp.add(jscp);
			jp.add(linha_n_parc);
		} else {
			jf.setSize(410, 700);
			jf.setLayout(new FlowLayout());
			linha_valor_pendente.add(lab_valor_pend);
			linha_valor_pendente.add(valor_pendente);
			botoes_operacoes.add(btn_excluir);			
			jp.add(linha_cliente);
			jp.add(linha_tit_prod);
			jp.add(jscp);
			jp.add(linha_tit_parc);
			jp.add(jscp2);
			jp.add(linha_btn_pagar);
			jp.add(linha_valor_pendente);
			nome_cliente.setText(contVendas.getClienteVendaNome(indice_sel));
			dt_vend.setText(contVendas.getDataVenda(indice_sel));
			dt_venc.setText(contVendas.getDataVencimento(indice_sel));
			valor_tot.setText(String.format("%.2f", contVendas.getValorTotal(indice_sel)));
			valor_pendente.setText(String.format("%.2f", contVendas.getValorPend(indice_sel)));
		}
		jp.add(linha_dt_vend);
		jp.add(linha_dt_venc);
		jp.add(linha_valor_tot);
		jp.add(botoes_operacoes);		
		jf.add(jp);
		jf.setVisible(true);
	}
	
	/**
	 * Metodo para deixar a tela com as informacoes de um jeito que e exigido muitas vezes nessa classe, logo foi feito um metodo
	 * para evitar linhas repetidas   
	 */
	public void limparTd() {
		nome_cliente.setText("");
		nome_prod.setText("");		
		qtd_prod.setText("");	
		n_parc.setText("");	
		dt_vend.setText("");	
		dt_venc.setText("");	
		valor_tot.setText("");			
		checkFone.setEnabled(false);
		checkNot.setEnabled(false);
		checkGame.setEnabled(false);
		checkImp.setEnabled(false);
		checkFone.setEnabled(false);
		checkNot.setEnabled(false);
		checkGame.setEnabled(false);
		checkImp.setEnabled(false);
		btn_salvar.setEnabled(false);
		btn_adicionarProd.setEnabled(false);
		nome_prod.setEnabled(false);		
		qtd_prod.setEnabled(false);
		n_parc.setEnabled(false);
		dt_vend.setEnabled(false);
		dt_venc.setEnabled(false);
		valor_tot.setEnabled(false);
		btn_pagar_parc.setEnabled(false);
		if(indice_sel == -1) {
			nomes_produtos.clear();
		}
	}
	
	/**
	 * Metodo responsavel por realizar uma acao dependendo do botao clicado
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Procurar")) {
			try {
				String nome_digitado = nome_cliente.getText();
				nome_cliente_proc = contVendas.procuraNomeCliente(nome_digitado);
				end_cliente_proc = contVendas.procuraEndCliente(nome_digitado);
				tel_cliente_proc = contVendas.procuraTelCliente(nome_digitado);
				checkFone.setEnabled(true);
				checkNot.setEnabled(true);
				checkGame.setEnabled(true);
				checkImp.setEnabled(true);				
			} catch(NullPointerException e) {
				nome_cliente.setText("");
				mensagemErroCliente();
			}					
								
		} else if (ae.getActionCommand().equals("Adicionar")) {
			String prod_procurado;
			try {
				String produto_digitado = nome_prod.getText();
				int n_produtos = Integer.parseInt(qtd_prod.getText());
				double valor_unitario = 0; 
				if(tipo == 1 && !qtd_prod.getText().isEmpty()) {
					try {
						prod_procurado = contVendas.procuraNomeNotebook(produto_digitado);
						valor_unitario = contVendas.procuraPrecoNotebook(produto_digitado); 
						valor_venda += valor_unitario*n_produtos;
						adicionarProdutoNaLista(produto_digitado, valor_unitario, n_produtos);
					} catch(NullPointerException e) {
						mensagemErroProduto();
					}															
				} else if (tipo == 2 && !qtd_prod.getText().isEmpty()) {
					try {
						prod_procurado = contVendas.procuraNomeFone(produto_digitado);
						valor_unitario = contVendas.procuraPrecoFone(produto_digitado); 
						valor_venda += valor_unitario*n_produtos;
						adicionarProdutoNaLista(produto_digitado, valor_unitario, n_produtos);
					} catch(NullPointerException e) {
						mensagemErroProduto();
					}		
				} else if (tipo == 3 && !qtd_prod.getText().isEmpty()) {
					try {
						prod_procurado = contVendas.procuraNomeImpressora(produto_digitado);
						valor_unitario = contVendas.procuraPrecoImpressora(produto_digitado); 
						valor_venda += valor_unitario*n_produtos;
						adicionarProdutoNaLista(produto_digitado, valor_unitario, n_produtos);
					} catch(NullPointerException e) {
						mensagemErroProduto();
					}
				} else if (tipo == 4 && !qtd_prod.getText().isEmpty()) {
					try {
						prod_procurado = contVendas.procuraNomeConsole(produto_digitado);
						valor_unitario = contVendas.procuraPrecoConsole(produto_digitado); 
						valor_venda += valor_unitario*n_produtos;
						adicionarProdutoNaLista(produto_digitado, valor_unitario, n_produtos);
					} catch(NullPointerException e) {
						mensagemErroProduto();
					}
				} else {
					mensagemErroQtdProdutos();
				}					
			} catch(NumberFormatException e) {
				mensagemErroQtdProdutos();
			}				
		} else if (ae.getActionCommand().equals("Salvar")) {
			String data_venda = dt_vend.getText();
			String data_venci = dt_venc.getText();
			String qtd_meses_parcelados = n_parc.getText();
			if(dados.adicionarVenda(nome_cliente_proc, end_cliente_proc, tel_cliente_proc, data_venda, data_venci, valor_venda,
				qtd_meses_parcelados, contVendas.converteEmArray(nomes_produtos))) {
				limparTd();
			} else {
				mensagemErroDados();
			}			
		} else if (ae.getActionCommand().equals("Cancelar")) {
			limparTd();
		} else if (ae.getActionCommand().equals("Pagar")) {
			if(dados.getStatusParcela(indice_sel, indice_parcela).equals("Não paga")) {
				dados.pagarParcela(indice_sel, indice_parcela);
				String data_parcela = dados.getParcelaData(indice_sel, indice_parcela);
				String valor_parcela = String.format("%.2f",  dados.getParcelaValor(indice_sel, indice_parcela));
				parcelas.set(indice_parcela, valor_parcela + " - "+ data_parcela +" - Paga");				
			}
			if(dados.verificaVendaPaga(indice_sel) == true) {
				dados.pagaVenda(indice_sel);
			}
			btn_pagar_parc.setEnabled(false);
			valor_pendente.setText(String.format("%.2f", contVendas.getValorPend(indice_sel)));
		} else {
			jlst.removeListSelectionListener(this);
			jlst2.removeListSelectionListener(this);
			nomes_produtos.clear();
			parcelas.clear();
			nome_cliente.setText("");
			dt_vend.setText("");
			dt_venc.setText("");
			valor_tot.setText("");
			valor_pendente.setText("");
			dados.excluirVenda(indice_sel);
		}
	}
	
	/**
	 * Método utilizado na tela de cadastro de venda para adicionar as informações de um produto comprado na forma
	 * correta
	 */
	public void adicionarProdutoNaLista(String produto_digitado, double valor_unitario, int n_produtos) {
		valor_tot.setText(String.format("%.2f", valor_venda));
		nomes_produtos.addElement(produto_digitado+" "+"R$"+valor_unitario+" x"+n_produtos);
		nome_prod.setText("");
		qtd_prod.setText("");
		n_parc.setEnabled(true);
		dt_vend.setEnabled(true);
		dt_venc.setEnabled(true);			
		btn_salvar.setEnabled(true);
	}
	
	/**
	 * Metodo que detecta acoes no checkbox
	 */
	public void itemStateChanged(ItemEvent evento) {
		nome_prod.setEnabled(true);
		qtd_prod.setEnabled(true);
		btn_adicionarProd.setEnabled(true);	
		if(checkNot.isSelected()) {   
		   tipo = 1;	
		   checkNot.setEnabled(false);
		   if(!checkFone.isEnabled()) {
			   checkFone.setEnabled(true);
			   checkFone.doClick();
		   } else if (!checkGame.isEnabled()) {
			   checkGame.setEnabled(true);
			   checkGame.doClick();
		   } else if (!checkImp.isEnabled()) {
			   checkImp.setEnabled(true);
			   checkImp.doClick();
		   } 
	   }
	   
	   if(checkFone.isSelected()) {   
		   tipo = 2;
		   checkFone.setEnabled(false);
		   if(!checkNot.isEnabled()) {
			   checkNot.setEnabled(true);
			   checkNot.doClick();
		   } else if (!checkGame.isEnabled()) {
			   checkGame.setEnabled(true);
			   checkGame.doClick();
		   } else if (!checkImp.isEnabled()) {
			   checkImp.setEnabled(true);
			   checkImp.doClick();
		   }
	   }
	   
	   if(checkImp.isSelected()) {   
		   tipo = 3;
		   checkImp.setEnabled(false);
		   if(!checkNot.isEnabled()) {
			   checkNot.setEnabled(true);
			   checkNot.doClick();
		   } else if (!checkGame.isEnabled()) {
			   checkGame.setEnabled(true);
			   checkGame.doClick();
		   } else if (!checkFone.isEnabled()) {
			   checkFone.setEnabled(true);
			   checkFone.doClick();
		   }
	   }
	   
	   if(checkGame.isSelected()) {   
		   tipo = 4;
		   checkGame.setEnabled(false);
		   if(!checkNot.isEnabled()) {
			   checkNot.setEnabled(true);
			   checkNot.doClick();
		   } else if (!checkImp.isEnabled()) {
			   checkImp.setEnabled(true);
			   checkImp.doClick();
		   } else if (!checkFone.isEnabled()) {
			   checkFone.setEnabled(true);
			   checkFone.doClick();
		   }
	   }  			  
	}
	
	/**
	 * Metodo para detectar acoes na lista de parcelas na tela de visualizacao de uma venda previamente cadastrada
	 */
	public void valueChanged(ListSelectionEvent le) {
		indice_parcela = jlst2.getSelectedIndex();
		btn_pagar_parc.setEnabled(true);		
	}
	
	/**
	 * Metodo que exibe uma mensagem de erro caso ocorra algum problema na hora de buscar um cliente existente 
	 */
	public void mensagemErroCliente() {
		JOptionPane.showMessageDialog(null,"ERRO AO PROCURAR CLIENTE!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nome do cliente não foi digitado corretamente, digite o nome completo\n"
				+ "2. Cliente não existe", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Metodo que exibe uma mensagem de erro caso o usuario nao adicione um numero inteiro na JTextField
	 * para definir a quantidade de produtos que ele deseja comprar 
	 */
	public void mensagemErroQtdProdutos() {
		JOptionPane.showMessageDialog(null,"ERRO AO ADICIONAR PRODUTO!\n "
				+ "Digite um número inteiro no campo de quantidade", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Metodo que exibe uma mensagem de erro caso ocorra um problema na hora de buscar um produto para adicionar ao carrinho
	 */
	public void mensagemErroProduto() {
		JOptionPane.showMessageDialog(null,"ERRO AO PROCURAR PRODUTO!\n "
				+ "Pode ter ocorrido um dos três erros a seguir:  \n"
				+ "1. Nome do produto não foi digitado corretamente, digite o nome completo\n"
				+ "2. Produto não existe\n"
				+ "3. Checkbox errado selecionado", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Método que exibe uma mensagem de erro caso ocorra um problema na hora de cadastrar a venda
	 */	
	public void mensagemErroDados() {
		JOptionPane.showMessageDialog(null,"ERRO AO CADASTRAR VENDA!\n "
				+ "Pode ter ocorrido um dos cinco erros a seguir:  \n"
				+ "1. Data não colocada no formato XX/XX/XXXX, onde X corresponde a um dígito numérico\n"
				+ "2. Data de vencimento é anterior a data de venda\n"
				+ "3. Data de venda anterior ao dia atual\n"
				+ "4. Data inexistente\n"
				+ "5. Nem todos os campos foram preenchidos", null, 
				JOptionPane.ERROR_MESSAGE);
	}
}

