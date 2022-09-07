package view;

import javax.swing.*;
import java.awt.*;
import controle.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *	Classe Tela_Detalhe_Produto que permite que o usuario cadastre/insira/leia/exclua um notebook, console, fone-de-ouvido ou
 *	impressora dependendo do botao escolhido na tela de produtos	     
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 * 	@see Tela_Produtos 
 */

public class Tela_Detalhe_Produtos implements ListSelectionListener, ActionListener {
	
	private JList<String> jlst;	
	private JFrame jf;
	private JPanel jp;
	private JScrollPane jscp;
	private JLabel titulo;
	private int indice;
	private DefaultListModel<String> nomes_produtos = new DefaultListModel<String>();;
	private int tipo_produto;
	private JButton btn_novo;
	private JButton btn_editar;
	private JButton btn_excluir;
	private JButton btn_salvar;
	private JButton btn_cancelar;
	private JTextField nome_prod;
	private JTextField fab_prod;
	private JTextField vlcusto_prod;
	private JTextField vlvend_prod;
	private ControleDados dados;
	private JTextField armazenamento;
	private JTextField so;
	private JTextField tec_impressao;
	private JTextField tam_folha;
	private JTextField tipo_fone;
	private JTextField tec_conexao;
	private JTextField qtd_controle;	
	private JTextField qtd_jogo;
	private ControleNotebooks contNot;
	private ControleImpressoras contImp; 
	private ControleFones contFones;
	private ControleConsoles contConsoles;		
		
	/**
	 * Metodo que mostra a tela do tipo de produto desejado com base na opção escolhida pelo cliente
	 * @param d Atributo que permite fazer a CRUD de um dos produtos disponiveis 
	 * @param tipo Se tipo igual a 1 a tela sera de notebooks, se for 2 a tela sera de impressoras, se for 3 a tela sera de fones e 
	 * se for 4 a tela sera de consoles
	 */
	public void mostrarTela(ControleDados d, int tipo) {
		tipo_produto = tipo;
		dados = d;
		if (tipo_produto == 1) {
			contNot = new ControleNotebooks(dados);
			nomes_produtos = contNot.getTodosNotebooksNomes();
		}  else if (tipo_produto == 2) {
			contImp = new ControleImpressoras(dados);
			nomes_produtos = contImp.getTodosImpsNomes();
		}  else if (tipo_produto == 3) {
			contFones = new ControleFones(dados);
			nomes_produtos = contFones.getTodosFonesNomes();	
		}  else {
			contConsoles = new ControleConsoles(dados);
			nomes_produtos = contConsoles.getTodosConsolesNomes();	
		}						
		jlst = new JList<String>(nomes_produtos);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlst.addListSelectionListener(this);		
		indice = 0; 
		jf = new JFrame("Produtos");
		jf.setSize(380, 700);
		jf.setLayout(new FlowLayout());
		jp = new JPanel();
		JPanel botoes_CRUD = new JPanel();
		JPanel titulo_secao = new JPanel(); 
		JPanel linha_nome = new JPanel();
		JPanel linha_fab = new JPanel();
		JPanel linha_vlcusto = new JPanel();
		JPanel linha_vlvenda = new JPanel();
		JPanel linha_arm = new JPanel();
		JPanel linha_so = new JPanel();
		JPanel linha_tec_imp = new JPanel();
		JPanel linha_tam_folha = new JPanel();
		JPanel linha_tipo_fone = new JPanel();
		JPanel linha_tec_con = new JPanel();
		JPanel linha_qtd_cont = new JPanel();
		JPanel linha_qtd_jogo = new JPanel();		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		botoes_CRUD.setLayout(new BoxLayout(botoes_CRUD, BoxLayout.X_AXIS));
		botoes_CRUD.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		titulo_secao.setLayout(new BoxLayout(titulo_secao, BoxLayout.X_AXIS));
		linha_nome.setLayout(new BoxLayout(linha_nome, BoxLayout.X_AXIS));
		linha_nome.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_fab.setLayout(new BoxLayout(linha_fab, BoxLayout.X_AXIS));
		linha_fab.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_vlcusto.setLayout(new BoxLayout(linha_vlcusto, BoxLayout.X_AXIS));
		linha_vlcusto.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_vlvenda.setLayout(new BoxLayout(linha_vlvenda, BoxLayout.X_AXIS));
		linha_vlvenda.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_arm.setLayout(new BoxLayout(linha_arm, BoxLayout.X_AXIS));
		linha_arm.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_so.setLayout(new BoxLayout(linha_so, BoxLayout.X_AXIS));
		linha_so.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_tec_imp.setLayout(new BoxLayout(linha_tec_imp, BoxLayout.X_AXIS));
		linha_tec_imp.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_tam_folha.setLayout(new BoxLayout(linha_tam_folha, BoxLayout.X_AXIS));
		linha_tam_folha.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_tipo_fone.setLayout(new BoxLayout(linha_tipo_fone, BoxLayout.X_AXIS));
		linha_tipo_fone.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_tec_con.setLayout(new BoxLayout(linha_tec_con, BoxLayout.X_AXIS));
		linha_tec_con.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_qtd_cont.setLayout(new BoxLayout(linha_qtd_cont, BoxLayout.X_AXIS));
		linha_qtd_cont.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_qtd_jogo.setLayout(new BoxLayout(linha_qtd_jogo, BoxLayout.X_AXIS));
		linha_qtd_jogo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		jlst.setPreferredSize(new Dimension(360,400));
		jscp = new JScrollPane(jlst, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jscp.setPreferredSize(new Dimension(360,300));
		titulo  = new JLabel("Cadastrar Produto");
		JLabel nome_lab  = new JLabel("Nome: ");
		JLabel fab_lab  = new JLabel("Fabricante: ");	
		JLabel vlcusto_lab  = new JLabel("Valor Custo: ");
		JLabel vlvend_lab  = new JLabel("Valor Venda: ");			
		JLabel arm_lab = new JLabel("Armazenamento: ");
		JLabel so_lab = new JLabel("Sistema Operacional: ");
		JLabel tec_imp_lab  = new JLabel("Tecnologia de Impressão: ");
		JLabel tam_fol_lab  = new JLabel("Tamanho da Folha: ");
		JLabel tipo_fon_lab  = new JLabel("Tipo de Fone: ");
		JLabel tec_con_lab  = new JLabel("Tecnologia de Conexão: ");
		JLabel qtd_cont_lab  = new JLabel("Número de Controles: ");
		JLabel qtd_jogo_lab  = new JLabel("Número de Jogos: ");
		nome_prod= new JTextField(15);
		fab_prod = new JTextField(15);
		vlcusto_prod = new JTextField(5);
		vlvend_prod = new JTextField(5);
		armazenamento = new JTextField(5);
		so = new JTextField(5);
		tec_impressao = new JTextField(5);
		tam_folha = new JTextField(5);
		tipo_fone = new JTextField(5);
		tec_conexao = new JTextField(5);
		qtd_controle = new JTextField(5);
		qtd_jogo = new JTextField(5);		
		btn_novo = new JButton("Novo");
		btn_novo.setBackground(Color.green);
		btn_novo.setForeground(Color.WHITE);
		btn_editar = new JButton("Editar");
		btn_editar.setBackground(Color.green);
		btn_editar.setForeground(Color.WHITE);
		btn_excluir = new JButton("Excluir"); 
		btn_excluir.setBackground(Color.green);
		btn_excluir.setForeground(Color.WHITE);
		btn_salvar = new JButton("Salvar");
		btn_salvar.setBackground(Color.green);
		btn_salvar.setForeground(Color.WHITE);
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBackground(Color.green);
		btn_cancelar.setForeground(Color.WHITE);
		btn_salvar.setEnabled(false);
		btn_cancelar.setEnabled(false);
		btn_editar.setEnabled(false);
		btn_excluir.setEnabled(false);
		nome_prod.setEnabled(false);
		fab_prod.setEnabled(false);
		vlcusto_prod.setEnabled(false);
		vlvend_prod.setEnabled(false);
		armazenamento.setEnabled(false);
		so.setEnabled(false);
		tec_impressao.setEnabled(false);
		tam_folha.setEnabled(false);
		tipo_fone.setEnabled(false);
		tec_conexao.setEnabled(false);
		qtd_controle.setEnabled(false);
		qtd_jogo.setEnabled(false);
		btn_novo.addActionListener(this);
		btn_editar.addActionListener(this);
		btn_excluir.addActionListener(this);
		btn_salvar.addActionListener(this);
		btn_cancelar.addActionListener(this); 
		jp.add(jscp);
		botoes_CRUD.add(btn_novo);
		botoes_CRUD.add(btn_editar);
		botoes_CRUD.add(btn_excluir);
		titulo_secao.add(titulo);
		linha_nome.add(nome_lab);
		linha_nome.add(nome_prod);
		linha_fab.add(fab_lab);
		linha_fab.add(fab_prod);
		linha_vlcusto.add(vlcusto_lab);
		linha_vlcusto.add(vlcusto_prod);
		linha_vlvenda.add(vlvend_lab);
		linha_vlvenda.add(vlvend_prod);
		linha_arm.add(arm_lab);
		linha_arm.add(armazenamento);
		linha_so.add(so_lab);
		linha_so.add(so);
		linha_tec_imp.add(tec_imp_lab);
		linha_tec_imp.add(tec_impressao);
		linha_tam_folha.add(tam_fol_lab);
		linha_tam_folha.add(tam_folha);
		linha_tipo_fone.add(tipo_fon_lab);
		linha_tipo_fone.add(tipo_fone);
		linha_tec_con.add(tec_con_lab);
		linha_tec_con.add(tec_conexao);
		linha_qtd_cont.add(qtd_cont_lab);
		linha_qtd_cont.add(qtd_controle);
		linha_qtd_jogo.add(qtd_jogo_lab);
		linha_qtd_jogo.add(qtd_jogo);
		jp.add(botoes_CRUD);
		jp.add(titulo_secao);
		jp.add(linha_nome);
		jp.add(linha_fab);
		jp.add(linha_vlcusto);
		jp.add(linha_vlvenda);	
		if(tipo_produto == 1) {
			jp.add(linha_arm);
			jp.add(linha_so);
		} else if (tipo_produto == 2) {
			jp.add(linha_tec_imp);
			jp.add(linha_tam_folha);			
		} else if (tipo_produto == 3) {
			jp.add(linha_tipo_fone);
			jp.add(linha_tec_con);
		}  else {
			jp.add(linha_qtd_cont);
			jp.add(linha_qtd_jogo);
		}		
		JPanel botoes_nova = new JPanel();
		botoes_nova.setLayout(new BoxLayout(botoes_nova, BoxLayout.X_AXIS));
		botoes_nova.add(btn_salvar);
		botoes_nova.add(btn_cancelar);
		jp.add(botoes_nova);	
		jf.add(jp);
		jf.setVisible(true);
		
	}
	
	/**
	 * Metodo responsavel por detectar e responder ao clique do usuario em um componente de jlist
	 */
	public void valueChanged(ListSelectionEvent le) {
		indice = jlst.getSelectedIndex();
		if(indice < 0 || indice >= nomes_produtos.getSize()) {
			indice = 0;
		}
		if (tipo_produto == 1) {
			nome_prod.setText(contNot.getNotebooksNomes(indice));
			fab_prod.setText(contNot.getNotebooksFabricantes(indice));
			vlcusto_prod.setText(contNot.getNotebooksValCust(indice));
			vlvend_prod.setText(contNot.getNotebooksValVend(indice));
			armazenamento.setText(contNot.getNotebooksArm(indice));
			so.setText(contNot.getNotebooksSO(indice));
			titulo.setText("Editar/Deletar Notebook");
			armazenamento.setEnabled(true);
			so.setEnabled(true);
		}  else if (tipo_produto == 2) {
			nome_prod.setText(contImp.getImpsNomes(indice));
			fab_prod.setText(contImp.getImpsFabricantes(indice));
			vlcusto_prod.setText(contImp.getImpsValCust(indice));
			vlvend_prod.setText(contImp.getImpsValVend(indice));
			tec_impressao.setText(contImp.getImpsTec(indice));
			tam_folha.setText(contImp.getImpsTam(indice));
			titulo.setText("Editar/Deletar Impressoras");//AQUI
			tec_impressao.setEnabled(true);
			tam_folha.setEnabled(true);
		}  else if (tipo_produto == 3) {
			nome_prod.setText(contFones.getFonesNomes(indice));
			fab_prod.setText(contFones.getFonesFabricantes(indice));
			vlcusto_prod.setText(contFones.getFonesValCust(indice));
			vlvend_prod.setText(contFones.getFonesValVend(indice));
			tipo_fone.setText(contFones.getTipoFone(indice));
			tec_conexao.setText(contFones.getTecCon(indice));
			titulo.setText("Editar/Deletar Fone");
			tipo_fone.setEnabled(true);
			tec_conexao.setEnabled(true);
		}  else {
			nome_prod.setText(contConsoles.getConsolesNomes(indice));
			fab_prod.setText(contConsoles.getConsolesFabricantes(indice));
			vlcusto_prod.setText(contConsoles.getConsolesValCust(indice));
			vlvend_prod.setText(contConsoles.getConsolesValVend(indice));
			qtd_controle.setText(contConsoles.getConsolesQtdCont(indice));
			qtd_jogo.setText(contConsoles.getConsolesQtdJogos(indice));
			titulo.setText("Editar/Deletar Console");
			qtd_controle.setEnabled(true);
			qtd_jogo.setEnabled(true);
		}	
		
		btn_salvar.setEnabled(false);
		btn_cancelar.setEnabled(false);
		btn_editar.setEnabled(true);
		btn_excluir.setEnabled(true);
		nome_prod.setEnabled(true);
		fab_prod.setEnabled(true);
		vlcusto_prod.setEnabled(true);
		vlvend_prod.setEnabled(true);		
	}	
	
	/**
	 * Metodo responsavel para que uma acao de CRUD seja realizada dependendo do botao clicado e dependendo do tipo de produto  
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Novo")) {
			if (tipo_produto == 1) {
				armazenamento.setText("");
				so.setText("");
				armazenamento.setEnabled(true);
				so.setEnabled(true);
				titulo.setText("Cadastrar Notebook");
			}  else if (tipo_produto == 2) {
				tec_impressao.setText("");
				tam_folha.setText("");
				tec_impressao.setEnabled(true);
				tam_folha.setEnabled(true);
				titulo.setText("Cadastrar Impressora");
			}  else if (tipo_produto == 3) {
				tipo_fone.setText("");
				tec_conexao.setText("");
				tipo_fone.setEnabled(true);
				tec_conexao.setEnabled(true);
				titulo.setText("Cadastrar Fone");
			}  else {
				qtd_controle.setText("");
				qtd_jogo.setText("");
				qtd_controle.setEnabled(true);
				qtd_jogo.setEnabled(true);
				titulo.setText("Cadastrar Console");
			}				
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");						
			nome_prod.setEnabled(true);
			fab_prod.setEnabled(true);
			vlcusto_prod.setEnabled(true);
			vlvend_prod.setEnabled(true);	
			btn_salvar.setEnabled(true);
			btn_cancelar.setEnabled(true);		
			btn_excluir.setEnabled(false);
			btn_editar.setEnabled(false);
		} else if(ae.getActionCommand().equals("Salvar")) {
			String nome_novo = nome_prod.getText(); 
			String fab_novo = fab_prod.getText();
			String vlvend_novo = vlvend_prod.getText();
			String vlcust_novo = vlcusto_prod.getText();
			if (tipo_produto == 1) {
				String arm_novo = armazenamento.getText();
				String so_novo = so.getText();
				if(!dados.adicionarNotebook(nome_novo, fab_novo, vlvend_novo, vlcust_novo, arm_novo, so_novo)) {
					mensagemErroCadastro();
				} else {
					nomes_produtos.addElement(nome_novo);
					nome_prod.setText("");
					fab_prod.setText("");
					vlcusto_prod.setText("");
					vlvend_prod.setText("");
					armazenamento.setText("");
					so.setText("");
				}			
			}  else if (tipo_produto == 2) {
				String tec_imp_nova = tec_impressao.getText();
				String tamfol_nova = tam_folha.getText();
				if(!dados.adicionarImp(nome_novo, fab_novo, vlvend_novo, vlcust_novo, tec_imp_nova, tamfol_nova)) {
					mensagemErroCadastroImpressora();					
				} else {
					nomes_produtos.addElement(nome_novo);
					nome_prod.setText("");
					fab_prod.setText("");
					vlcusto_prod.setText("");
					vlvend_prod.setText("");
					tec_impressao.setText("");
					tam_folha.setText("");
				}			
			}  else if (tipo_produto == 3) {
				String tpfone_novo = tipo_fone.getText();
				String teccon_novo = tec_conexao.getText();
				if(!dados.adicionarFone(nome_novo, fab_novo, vlvend_novo, vlcust_novo, tpfone_novo, teccon_novo)) {
					mensagemErroCadastroFone();
				} else {
					nomes_produtos.addElement(nome_novo);
					nome_prod.setText("");
					fab_prod.setText("");
					vlcusto_prod.setText("");
					vlvend_prod.setText("");			
					tipo_fone.setText("");
					tec_conexao.setText("");
				}
			}  else {
				String qtdcont_novo = qtd_controle.getText();
				String qtdjogo_novo = qtd_jogo.getText();
				if(!dados.adicionarConsole(nome_novo, fab_novo, vlvend_novo, vlcust_novo, qtdcont_novo, qtdjogo_novo)) {
					mensagemErroCadastroConsole();
				} else {
					nomes_produtos.addElement(nome_novo);
					nome_prod.setText("");
					fab_prod.setText("");
					vlcusto_prod.setText("");
					vlvend_prod.setText("");
					qtd_controle.setText("");
					qtd_jogo.setText("");
				}			
			}		
		} else if(ae.getActionCommand().equals("Cancelar")) {
			if (tipo_produto == 1) {
				armazenamento.setText("");
				so.setText("");
				armazenamento.setEnabled(false);
				so.setEnabled(false);
			}  else if (tipo_produto == 2) {
				tec_impressao.setText("");
				tam_folha.setText("");
				tec_impressao.setEnabled(false);
				tam_folha.setEnabled(false);				
			}  else if (tipo_produto == 3) {
				tipo_fone.setText("");
				tec_conexao.setText("");
				tipo_fone.setEnabled(false);
				tec_conexao.setEnabled(false);
			}  else {
				qtd_controle.setText("");
				qtd_jogo.setText("");
				qtd_controle.setEnabled(false);
				qtd_jogo.setEnabled(false);
			}	
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");		
			nome_prod.setEnabled(false);
			fab_prod.setEnabled(false);
			vlcusto_prod.setEnabled(false);
			vlvend_prod.setEnabled(false);					
			btn_salvar.setEnabled(false);
			btn_cancelar.setEnabled(false);
		} else if(ae.getActionCommand().equals("Editar")) {
			if (tipo_produto == 1) {
				if (!dados.editarNotebook(indice, nome_prod.getText(), fab_prod.getText(), vlcusto_prod.getText(), 
						vlvend_prod.getText(), armazenamento.getText(), so.getText())) {
					mensagemErroCadastro();					
				} else {
					nomes_produtos.set(indice, nome_prod.getText());
					nome_prod.setText("");
					fab_prod.setText("");
					vlcusto_prod.setText("");
					vlvend_prod.setText("");
					armazenamento.setText("");
					so.setText("");
					btn_editar.setEnabled(false);
					btn_excluir.setEnabled(false);
					btn_salvar.setEnabled(true);
					btn_cancelar.setEnabled(true);
					armazenamento.setEnabled(false);
					so.setEnabled(false);
					btn_salvar.setEnabled(false);
					btn_cancelar.setEnabled(false);
					nome_prod.setEnabled(false);
					fab_prod.setEnabled(false);
					vlcusto_prod.setEnabled(false);
					vlvend_prod.setEnabled(false);						
					btn_editar.setEnabled(false);
					btn_excluir.setEnabled(false);
				}
				
			}  else if (tipo_produto == 2) {
				if(!dados.editarImpressora(indice, nome_prod.getText(), fab_prod.getText(), vlcusto_prod.getText(), 
						vlvend_prod.getText(), tec_impressao.getText(), tam_folha.getText())) {
					mensagemErroCadastroImpressora();
				} else {
					nomes_produtos.set(indice, nome_prod.getText()); 
					nome_prod.setText("");
					fab_prod.setText("");
					vlcusto_prod.setText("");
					vlvend_prod.setText("");					
					tec_impressao.setText("");
					tam_folha.setText("");
					btn_editar.setEnabled(false);
					btn_excluir.setEnabled(false);
					btn_salvar.setEnabled(true);
					btn_cancelar.setEnabled(true);
					tec_impressao.setEnabled(false);
					tam_folha.setEnabled(false);
					btn_salvar.setEnabled(false);
					btn_cancelar.setEnabled(false);
					nome_prod.setEnabled(false);
					fab_prod.setEnabled(false);
					vlcusto_prod.setEnabled(false);
					vlvend_prod.setEnabled(false);						
					btn_editar.setEnabled(false);
					btn_excluir.setEnabled(false);
				}			
			
			}  else if (tipo_produto == 3) {
				if(!dados.editarFone(indice, nome_prod.getText(), fab_prod.getText(), vlcusto_prod.getText(), vlvend_prod.getText(), 
						tipo_fone.getText(), tec_conexao.getText())) {
					mensagemErroCadastroFone();
				} else {
					nomes_produtos.set(indice, nome_prod.getText());
					nome_prod.setText("");
					fab_prod.setText("");
					vlcusto_prod.setText("");
					vlvend_prod.setText("");
					tipo_fone.setText("");
					tec_conexao.setText("");
					btn_editar.setEnabled(false);
					btn_excluir.setEnabled(false);
					btn_salvar.setEnabled(true);
					btn_cancelar.setEnabled(true);
					btn_salvar.setEnabled(false);
					btn_cancelar.setEnabled(false);
					nome_prod.setEnabled(false);
					fab_prod.setEnabled(false);
					vlcusto_prod.setEnabled(false);
					vlvend_prod.setEnabled(false);
					tipo_fone.setEnabled(false);
					tec_conexao.setEnabled(false);
					btn_editar.setEnabled(false);
					btn_excluir.setEnabled(false);
				}				
			}  else {
				if (!dados.editarConsole(indice, nome_prod.getText(), fab_prod.getText(), vlcusto_prod.getText(),
						vlvend_prod.getText(),
						qtd_controle.getText(), qtd_jogo.getText())){
						mensagemErroCadastroConsole(); 
					} else {
						nomes_produtos.set(indice, nome_prod.getText());
						nome_prod.setText("");
						fab_prod.setText("");
						vlcusto_prod.setText("");
						vlvend_prod.setText("");
			            qtd_controle.setText("");
						qtd_jogo.setText("");
						btn_salvar.setEnabled(false);
						btn_cancelar.setEnabled(false);
						nome_prod.setEnabled(false);
						fab_prod.setEnabled(false);
						vlcusto_prod.setEnabled(false);
						vlvend_prod.setEnabled(false);	
						qtd_controle.setEnabled(false);
						qtd_jogo.setEnabled(false);
						btn_editar.setEnabled(false);
						btn_excluir.setEnabled(false);
					}	 					
				
			}						
			
		} else {
			btn_salvar.setEnabled(false);
			btn_cancelar.setEnabled(false);
			nome_prod.setEnabled(false);
			fab_prod.setEnabled(false);
			vlcusto_prod.setEnabled(false);
			vlvend_prod.setEnabled(false);
			if (tipo_produto == 1) {
				dados.excluirNotebook(indice);				
			}  else if (tipo_produto == 2) {
				dados.excluirImpressora(indice);				
			}  else if (tipo_produto == 3) {
				dados.excluirFone(indice);				
			}  else {
				dados.excluirConsole(indice);				
			}		
			nomes_produtos.remove(indice);
			btn_editar.setEnabled(false);
			btn_excluir.setEnabled(false);
			btn_salvar.setEnabled(true);
			btn_cancelar.setEnabled(true);
			tec_impressao.setText("");
			tam_folha.setText("");
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");			
			armazenamento.setText("");
			so.setText("");
			tipo_fone.setText("");
			tec_conexao.setText("");
			qtd_controle.setText("");
			qtd_jogo.setText("");
		}
	}
	
	/**
	 * Metodo responsavel por exibir uma mensagem de erro caso alguma informacao na hora de criar ou editar um notebook
	 * esteja errada
	 */
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um três erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Valores de custo e venda não contem apenas números ou ponto\n"
				+ "3. Armazenamento não contem apenas números em GB", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Metodo responsavel por exibir uma mensagem de erro caso alguma informacao na hora de criar ou editar uma impressora
	 * esteja errada
	 */
	public void mensagemErroCadastroImpressora() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Valores de custo e venda não contem apenas números ou ponto", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Metodo responsavel por exibir uma mensagem de erro caso alguma informacao na hora de criar ou editar um fone
	 * esteja errada
	 */
	public void mensagemErroCadastroFone() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Valores de custo e venda não contem apenas números ou ponto", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Metodo responsavel por exibir uma mensagem de erro caso alguma informacao na hora de criar ou editar um console
	 * esteja errada
	 */
	public void mensagemErroCadastroConsole() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos três erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Valores de custo e venda não contem apenas números ou ponto\n"
				+ "3. Número de controles ou de jogos pré-instalados não são inteiros", null, 
				JOptionPane.ERROR_MESSAGE);
	}
}
