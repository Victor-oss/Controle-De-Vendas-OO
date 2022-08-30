package view;
import javax.swing.*;
import java.awt.*;
import controle.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tela_Consoles implements ListSelectionListener, ActionListener {
	
	private JList<String> jlst;	
	private JFrame jf;
	private JPanel jp;
	private JScrollPane jscp;
	private JLabel titulo;
	private int indice;
	private DefaultListModel<String> nomes_produtos = new DefaultListModel<String>();
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
	private JTextField qtd_controle;	
	private JTextField qtd_jogo;
	private ControleConsoles contConsoles;
		
	public void mostrarTela(ControleDados d) {
		dados = d;
		contConsoles = new ControleConsoles(dados);
		nomes_produtos = contConsoles.getTodosConsolesNomes();		
		jlst = new JList<String>(nomes_produtos);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlst.addListSelectionListener(this);		
		indice = 0; 
		jf = new JFrame("Notebooks");//AQUI
		jf.setSize(380, 700);
		jf.setLayout(new FlowLayout());
		jp = new JPanel();
		JPanel botoes_CRUD = new JPanel();
		JPanel titulo_secao = new JPanel(); 
		JPanel linha_nome = new JPanel();
		JPanel linha_fab = new JPanel();
		JPanel linha_vlcusto = new JPanel();
		JPanel linha_vlvenda = new JPanel();
		
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
		
		JLabel qtd_cont_lab  = new JLabel("Número de Controles: ");
		JLabel qtd_jogo_lab  = new JLabel("Número de Jogos: ");
		
		nome_prod= new JTextField(15);
		fab_prod = new JTextField(15);
		vlcusto_prod = new JTextField(5);
		vlvend_prod = new JTextField(5);
		
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
		
		jp.add(linha_qtd_cont);//AQUI
		jp.add(linha_qtd_jogo);//AQUI
		
		JPanel botoes_nova = new JPanel();
		botoes_nova.setLayout(new BoxLayout(botoes_nova, BoxLayout.X_AXIS));
		botoes_nova.add(btn_salvar);
		botoes_nova.add(btn_cancelar);
		jp.add(botoes_nova);	
		jf.add(jp);
		jf.setVisible(true);
		
	}
	
	public void valueChanged(ListSelectionEvent le) {
		indice = jlst.getSelectedIndex();
		if(indice < 0 || indice >= nomes_produtos.getSize()) {
			indice = 0;
		}
		nome_prod.setText(contConsoles.getConsolesNomes(indice));
		fab_prod.setText(contConsoles.getConsolesFabricantes(indice));
		vlcusto_prod.setText(contConsoles.getConsolesValCust(indice));
		vlvend_prod.setText(contConsoles.getConsolesValVend(indice));
		qtd_controle.setText(contConsoles.getConsolesQtdCont(indice));
		qtd_jogo.setText(contConsoles.getConsolesQtdJogos(indice));
		titulo.setText("Editar/Deletar Console");
		btn_salvar.setEnabled(false);
		btn_cancelar.setEnabled(false);
		btn_editar.setEnabled(true);
		btn_excluir.setEnabled(true);
		nome_prod.setEnabled(true);
		fab_prod.setEnabled(true);
		vlcusto_prod.setEnabled(true);
		vlvend_prod.setEnabled(true);
		qtd_controle.setEnabled(true);
		qtd_jogo.setEnabled(true);
	}	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Novo")) {
			titulo.setText("Cadastrar Console");
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			qtd_controle.setText("");
			qtd_jogo.setText("");
			
			nome_prod.setEnabled(true);
			fab_prod.setEnabled(true);
			vlcusto_prod.setEnabled(true);
			vlvend_prod.setEnabled(true);
			
			qtd_controle.setEnabled(true);
			qtd_jogo.setEnabled(true);
			
			btn_salvar.setEnabled(true);
			btn_cancelar.setEnabled(true);		
			btn_excluir.setEnabled(false);
			btn_editar.setEnabled(false);
		} else if(ae.getActionCommand().equals("Salvar")) {
			String nome_novo = nome_prod.getText(); 
			String fab_novo = fab_prod.getText();
			String vlvend_novo = vlvend_prod.getText();
			String vlcust_novo = vlcusto_prod.getText();
			String qtdcont_novo = qtd_controle.getText();
			String qtdjogo_novo = qtd_jogo.getText();
			if(!dados.adicionarConsole(nome_novo, fab_novo, vlvend_novo, vlcust_novo, qtdcont_novo, qtdjogo_novo)) {
				mensagemErroCadastro();
			} else {
				nomes_produtos.addElement(nome_novo);
			}			
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			qtd_controle.setText("");
			qtd_jogo.setText("");
			
		} else if(ae.getActionCommand().equals("Cancelar")) {
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			qtd_controle.setText("");
			qtd_jogo.setText("");
			
			nome_prod.setEnabled(false);
			fab_prod.setEnabled(false);
			vlcusto_prod.setEnabled(false);
			vlvend_prod.setEnabled(false);
			
			qtd_controle.setEnabled(false);
			qtd_jogo.setEnabled(false);
			
			btn_salvar.setEnabled(false);
			btn_cancelar.setEnabled(false);
		} else if(ae.getActionCommand().equals("Editar")) {
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
			if (!dados.editarConsole(indice, nome_prod.getText(), fab_prod.getText(), vlcusto_prod.getText(), vlvend_prod.getText(),
				qtd_controle.getText(), qtd_jogo.getText())){
				mensagemErroCadastro(); 
			} else {
				nomes_produtos.set(indice, nome_prod.getText());
			}			 
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			qtd_controle.setText("");
			qtd_jogo.setText("");
			
			btn_editar.setEnabled(false);
			btn_excluir.setEnabled(false);
			btn_salvar.setEnabled(true);
			btn_cancelar.setEnabled(true);
		} else {
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
			btn_salvar.setEnabled(true);
			btn_cancelar.setEnabled(true);
			
			dados.excluirConsole(indice);
			nomes_produtos.remove(indice);
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			qtd_controle.setText("");
			qtd_jogo.setText("");
		}
	}
	
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos três erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Valores de custo e venda não contem apenas números ou ponto\n"
				+ "3. Número de controles ou de jogos pré-instalados não são inteiros", null, 
				JOptionPane.ERROR_MESSAGE);
	}
}

