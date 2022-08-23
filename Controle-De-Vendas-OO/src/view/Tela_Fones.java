package view;
import javax.swing.*;
import java.awt.*;
import controle.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tela_Fones implements ListSelectionListener, ActionListener {
	
	private JList<String> jlst;	
	private JFrame jf;
	private JPanel jp;
	private JScrollPane jscp;
	private JLabel titulo;
	private int indice;
	private DefaultListModel<String> nomes_produtos = new DefaultListModel<String>();;
	private JButton btn_novo;
	private JButton btn_editar;
	private JButton btn_excluir;
	private JButton btn_salvar;
	private JButton btn_cancelar;
	private JTextField nome_prod;
	private JTextField fab_prod;
	private JTextField vlcusto_prod;
	private JTextField vlvend_prod;
	private JTextField tipo_fone;
	private JTextField tec_conexao;
	private ControleDados dados;
	private ControleFones contFones;
		
	public void mostrarTela(ControleDados d) {
		dados = d;
		contFones = new ControleFones(dados);
		nomes_produtos = contFones.getTodosFonesNomes();		
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
		
		JPanel linha_tipo_fone = new JPanel();
		JPanel linha_tec_con = new JPanel();
		
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
		
		linha_tipo_fone.setLayout(new BoxLayout(linha_tipo_fone, BoxLayout.X_AXIS));
		linha_tipo_fone.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_tec_con.setLayout(new BoxLayout(linha_tec_con, BoxLayout.X_AXIS));
		linha_tec_con.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		jscp = new JScrollPane(jlst);
		jscp.setPreferredSize(new Dimension(360,300));
		titulo  = new JLabel("Cadastrar Produto");
		JLabel nome_lab  = new JLabel("Nome: ");
		JLabel fab_lab  = new JLabel("Fabricante: ");	
		JLabel vlcusto_lab  = new JLabel("Valor Custo: ");
		JLabel vlvend_lab  = new JLabel("Valor Venda: ");	
		
		JLabel tipo_fon_lab  = new JLabel("Tipo de Fone: ");
		JLabel tec_con_lab  = new JLabel("Tecnologia de Conexão: ");
		
		nome_prod= new JTextField(15);
		fab_prod = new JTextField(15);
		vlcusto_prod = new JTextField(5);
		vlvend_prod = new JTextField(5);
		
		tipo_fone = new JTextField(5);
		tec_conexao = new JTextField(5);
		
		btn_novo = new JButton("Novo");
		btn_editar = new JButton("Editar");
		btn_excluir = new JButton("Excluir"); 
		btn_salvar = new JButton("Salvar");
		btn_cancelar = new JButton("Cancelar");
		btn_salvar.setEnabled(false);
		btn_cancelar.setEnabled(false);
		btn_editar.setEnabled(false);
		btn_excluir.setEnabled(false);
		nome_prod.setEnabled(false);
		fab_prod.setEnabled(false);
		vlcusto_prod.setEnabled(false);
		vlvend_prod.setEnabled(false);
		
		tipo_fone.setEnabled(false);
		tec_conexao.setEnabled(false);
		
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
		
		linha_tipo_fone.add(tipo_fon_lab);
		linha_tipo_fone.add(tipo_fone);
		linha_tec_con.add(tec_con_lab);
		linha_tec_con.add(tec_conexao);
		
		jp.add(botoes_CRUD);
		jp.add(titulo_secao);
		jp.add(linha_nome);
		jp.add(linha_fab);
		jp.add(linha_vlcusto);
		jp.add(linha_vlvenda);	
		
		jp.add(linha_tipo_fone);//AQUI
		jp.add(linha_tec_con);//AQUI
		
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
		nome_prod.setText(contFones.getFonesNomes(indice));
		fab_prod.setText(contFones.getFonesFabricantes(indice));
		vlcusto_prod.setText(contFones.getFonesValCust(indice));
		vlvend_prod.setText(contFones.getFonesValVend(indice));
		tipo_fone.setText(contFones.getTipoFone(indice));
		tec_conexao.setText(contFones.getTecCon(indice));
		titulo.setText("Editar/Deletar Fone");
		btn_salvar.setEnabled(false);
		btn_cancelar.setEnabled(false);
		btn_editar.setEnabled(true);
		btn_excluir.setEnabled(true);
		nome_prod.setEnabled(true);
		fab_prod.setEnabled(true);
		vlcusto_prod.setEnabled(true);
		vlvend_prod.setEnabled(true);
		
		tipo_fone.setEnabled(true);
		tec_conexao.setEnabled(true);
	}	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Novo")) {
			titulo.setText("Cadastrar Fone");
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			tipo_fone.setText("");
			tec_conexao.setText("");
			
			nome_prod.setEnabled(true);
			fab_prod.setEnabled(true);
			vlcusto_prod.setEnabled(true);
			vlvend_prod.setEnabled(true);
			
			tipo_fone.setEnabled(true);
			tec_conexao.setEnabled(true);
			
			btn_salvar.setEnabled(true);
			btn_cancelar.setEnabled(true);		
			btn_excluir.setEnabled(false);
			btn_editar.setEnabled(false);
		} else if(ae.getActionCommand().equals("Salvar")) {
			String nome_novo = nome_prod.getText(); 
			String fab_novo = fab_prod.getText();
			double vlvend_novo = Double.parseDouble(vlvend_prod.getText());
			double vlcust_novo = Double.parseDouble(vlcusto_prod.getText());
			
			String tpfone_novo = tipo_fone.getText();
			String teccon_novo = tec_conexao.getText();
			dados.adicionarFone(nome_novo, fab_novo, vlvend_novo, vlcust_novo, tpfone_novo, teccon_novo);
			nomes_produtos.addElement(nome_novo);
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			tipo_fone.setText("");
			tec_conexao.setText("");
			
		} else if(ae.getActionCommand().equals("Cancelar")) {
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			tipo_fone.setText("");
			tec_conexao.setText("");
			
			nome_prod.setEnabled(false);
			fab_prod.setEnabled(false);
			vlcusto_prod.setEnabled(false);
			vlvend_prod.setEnabled(false);
			
			tipo_fone.setEnabled(false);
			tec_conexao.setEnabled(false);
			
			btn_salvar.setEnabled(false);
			btn_cancelar.setEnabled(false);
		} else if(ae.getActionCommand().equals("Editar")) {
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
			dados.editarFone(indice, nome_prod.getText(), fab_prod.getText(), Double.parseDouble(vlcusto_prod.getText()), Double.parseDouble(vlvend_prod.getText()), tipo_fone.getText(), tec_conexao.getText());
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
		} else {
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
			btn_salvar.setEnabled(true);
			btn_cancelar.setEnabled(true);
			
			dados.excluirNotebook(indice);
			nomes_produtos.remove(indice);
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			tipo_fone.setText("");
			tec_conexao.setText("");
		}
	}
}