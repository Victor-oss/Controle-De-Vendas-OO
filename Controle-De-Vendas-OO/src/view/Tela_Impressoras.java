package view;
import javax.swing.*;
import java.awt.*;
import controle.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tela_Impressoras implements ListSelectionListener, ActionListener {
	
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
	private JTextField tec_impressao;
	private JTextField tam_folha;
	private ControleImpressoras contImp; 
		
	public void mostrarTela(ControleDados d) {
		dados = d;
		contImp = new ControleImpressoras(dados);
		nomes_produtos = contImp.getTodosImpsNomes();				
		jlst = new JList<String>(nomes_produtos);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlst.addListSelectionListener(this);		
		indice = 0; 
		jf = new JFrame("Impressoras");
		jf.setSize(380, 700);
		jf.setLayout(new FlowLayout());
		jp = new JPanel();
		JPanel botoes_CRUD = new JPanel();
		JPanel titulo_secao = new JPanel(); 
		JPanel linha_nome = new JPanel();
		JPanel linha_fab = new JPanel();
		JPanel linha_vlcusto = new JPanel();
		JPanel linha_vlvenda = new JPanel();
		
		JPanel linha_tec_imp = new JPanel();
		JPanel linha_tam_folha = new JPanel();
		
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
		
		linha_tec_imp.setLayout(new BoxLayout(linha_tec_imp, BoxLayout.X_AXIS));
		linha_tec_imp.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_tam_folha.setLayout(new BoxLayout(linha_tam_folha, BoxLayout.X_AXIS));
		linha_tam_folha.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		jscp = new JScrollPane(jlst);
		jscp.setPreferredSize(new Dimension(360,300));
		titulo  = new JLabel("Cadastrar Produto");
		JLabel nome_lab  = new JLabel("Nome: ");
		JLabel fab_lab  = new JLabel("Fabricante: ");	
		JLabel vlcusto_lab  = new JLabel("Valor Custo: ");
		JLabel vlvend_lab  = new JLabel("Valor Venda: ");	
		
		JLabel tec_imp_lab  = new JLabel("Tecnologia de Impressão: ");
		JLabel tam_fol_lab  = new JLabel("Tamanho da Folha: ");
		
		nome_prod= new JTextField(15);
		fab_prod = new JTextField(15);
		vlcusto_prod = new JTextField(5);
		vlvend_prod = new JTextField(5);
		
		tec_impressao = new JTextField(5);
		tam_folha = new JTextField(5);
		
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
		
		tec_impressao.setEnabled(false);
		tam_folha.setEnabled(false);
		
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
		
		linha_tec_imp.add(tec_imp_lab);
		linha_tec_imp.add(tec_impressao);
		linha_tam_folha.add(tam_fol_lab);
		linha_tam_folha.add(tam_folha);
		
		jp.add(botoes_CRUD);
		jp.add(titulo_secao);
		jp.add(linha_nome);
		jp.add(linha_fab);
		jp.add(linha_vlcusto);
		jp.add(linha_vlvenda);	
		
		jp.add(linha_tec_imp);
		jp.add(linha_tam_folha);
		
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
		nome_prod.setText(contImp.getImpsNomes(indice));
		fab_prod.setText(contImp.getImpsFabricantes(indice));
		vlcusto_prod.setText(contImp.getImpsValCust(indice));
		vlvend_prod.setText(contImp.getImpsValVend(indice));
		tec_impressao.setText(contImp.getImpsTec(indice));
		tam_folha.setText(contImp.getImpsTam(indice));
		titulo.setText("Editar/Deletar Impressoras");//AQUI
		btn_salvar.setEnabled(false);
		btn_cancelar.setEnabled(false);
		btn_editar.setEnabled(true);
		btn_excluir.setEnabled(true);
		nome_prod.setEnabled(true);
		fab_prod.setEnabled(true);
		vlcusto_prod.setEnabled(true);
		vlvend_prod.setEnabled(true);
		tec_impressao.setEnabled(true);
		tam_folha.setEnabled(true);//AQUI
	}	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Novo")) {
			titulo.setText("Cadastrar Impressora");
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			tec_impressao.setText("");
			tam_folha.setText("");
			
			nome_prod.setEnabled(true);
			fab_prod.setEnabled(true);
			vlcusto_prod.setEnabled(true);
			vlvend_prod.setEnabled(true);
			
			tec_impressao.setEnabled(true);
			tam_folha.setEnabled(true);
			
			btn_salvar.setEnabled(true);
			btn_cancelar.setEnabled(true);		
			btn_excluir.setEnabled(false);
			btn_editar.setEnabled(false);
		} else if(ae.getActionCommand().equals("Salvar")) {
			String nome_novo = nome_prod.getText(); 
			String fab_novo = fab_prod.getText();
			double vlvend_novo = Double.parseDouble(vlvend_prod.getText());
			double vlcust_novo = Double.parseDouble(vlcusto_prod.getText());
			
			String tec_imp_nova = tec_impressao.getText();
			String tamfol_nova = tam_folha.getText();
			dados.adicionarImp(nome_novo, fab_novo, vlvend_novo, vlcust_novo, tec_imp_nova, tamfol_nova);
			nomes_produtos.addElement(nome_novo);
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			tec_impressao.setText("");
			tam_folha.setText("");
			
		} else if(ae.getActionCommand().equals("Cancelar")) {
			nome_prod.setText("");
			fab_prod.setText("");
			vlcusto_prod.setText("");
			vlvend_prod.setText("");
			
			tec_impressao.setText("");
			tam_folha.setText("");
			
			nome_prod.setEnabled(false);
			fab_prod.setEnabled(false);
			vlcusto_prod.setEnabled(false);
			vlvend_prod.setEnabled(false);
			
			tec_impressao.setEnabled(false);
			tam_folha.setEnabled(false);
			
			btn_salvar.setEnabled(false);
			btn_cancelar.setEnabled(false);
		} else if(ae.getActionCommand().equals("Editar")) {
			btn_salvar.setEnabled(false);
			btn_cancelar.setEnabled(false);
			nome_prod.setEnabled(false);
			fab_prod.setEnabled(false);
			vlcusto_prod.setEnabled(false);
			vlvend_prod.setEnabled(false);
			
			tec_impressao.setEnabled(false);
			tam_folha.setEnabled(false);
			
			btn_editar.setEnabled(false);
			btn_excluir.setEnabled(false);
			dados.editarImpressora(indice, nome_prod.getText(), fab_prod.getText(), Double.parseDouble(vlcusto_prod.getText()), Double.parseDouble(vlvend_prod.getText()), tec_impressao.getText(), tam_folha.getText());
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
		} else {
			btn_salvar.setEnabled(false);
			btn_cancelar.setEnabled(false);
			nome_prod.setEnabled(false);
			fab_prod.setEnabled(false);
			vlcusto_prod.setEnabled(false);
			vlvend_prod.setEnabled(false);
			
			tec_impressao.setEnabled(false);
			tam_folha.setEnabled(false);				
						
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
			
			tec_impressao.setText("");
			tam_folha.setText("");
		}
	}
}