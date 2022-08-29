package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controle.*;


public class Tela_Clientes implements ActionListener, ListSelectionListener{
	private JList<String> jlst;	
	private JFrame jf;
	private JPanel jp;
	private JScrollPane jscp;
	private JLabel nome_lab;
	private JLabel ende_lab;
	private JLabel tel_lab;
	private JLabel titulo;
	private int indice;
	private DefaultListModel<String> nomes_clientes = new DefaultListModel<String>();
	private JButton btn_novo;
	private JButton btn_editar;
	private JButton btn_excluir;
	private JButton btn_salvar;
	private JButton btn_cancelar;
	private JTextField nome_cliente;
	private JTextField endereco_cliente;
	private JTextField telefone_cliente;
	private static ControleDados dados;
	private static ControleClientes contClientes;
	
	public void mostrarTela(ControleDados d){		
		dados = d;
		contClientes = new ControleClientes(dados);
		nomes_clientes = contClientes.getTodosClientesNomes();
		jlst = new JList<String>(nomes_clientes);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlst.addListSelectionListener(this);
		
		indice = 0; 
		jf = new JFrame("Clientes");
		jf.setSize(380, 560);
		jf.setLayout(new FlowLayout());
		jp = new JPanel();
		JPanel botoes_CRUD = new JPanel();
		JPanel titulo_secao = new JPanel(); 
		JPanel linha_nome = new JPanel();
		JPanel linha_ende = new JPanel();
		JPanel linha_tel = new JPanel();
		JPanel botoes_nova = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		botoes_CRUD.setLayout(new BoxLayout(botoes_CRUD, BoxLayout.X_AXIS));
		botoes_CRUD.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		titulo_secao.setLayout(new BoxLayout(titulo_secao, BoxLayout.X_AXIS));
		linha_nome.setLayout(new BoxLayout(linha_nome, BoxLayout.X_AXIS));
		linha_nome.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_ende.setLayout(new BoxLayout(linha_ende, BoxLayout.X_AXIS));
		linha_ende.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_tel.setLayout(new BoxLayout(linha_tel, BoxLayout.X_AXIS));
		linha_tel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		botoes_nova.setLayout(new BoxLayout(botoes_nova, BoxLayout.X_AXIS));
		jlst.setPreferredSize(new Dimension(360,400));
		jscp = new JScrollPane(jlst, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jscp.setPreferredSize(new Dimension(360,300));		
		nome_lab  = new JLabel("Nome: ");
		ende_lab  = new JLabel("Endereco: ");
		tel_lab  = new JLabel("Telefone: ");
		titulo = new JLabel("Cadastrar Cliente");  
		nome_cliente= new JTextField(15);
		endereco_cliente = new JTextField(15);
		telefone_cliente = new JTextField(15);
		btn_novo = new JButton("Novo");
		btn_editar = new JButton("Editar");
		btn_excluir = new JButton("Excluir"); 
		btn_salvar = new JButton("Salvar");
		btn_cancelar = new JButton("Cancelar");
		btn_salvar.setEnabled(false);
		btn_cancelar.setEnabled(false);
		btn_editar.setEnabled(false);
		btn_excluir.setEnabled(false);
		nome_cliente.setEnabled(false);
		endereco_cliente.setEnabled(false);
		telefone_cliente.setEnabled(false);
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
		linha_nome.add(nome_cliente);
		linha_ende.add(ende_lab);
		linha_ende.add(endereco_cliente);
		linha_tel.add(tel_lab);
		linha_tel.add(telefone_cliente);
		botoes_nova.add(btn_salvar);
		botoes_nova.add(btn_cancelar);
		jp.add(botoes_CRUD);
		jp.add(titulo_secao);
		jp.add(linha_nome);
		jp.add(linha_ende);
		jp.add(linha_tel);
		jp.add(botoes_nova);
		jf.add(jp);
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Novo")) {
			nome_cliente.setText("");
			endereco_cliente.setText("");
			telefone_cliente.setText("");
			nome_cliente.setEnabled(true);
			endereco_cliente.setEnabled(true);
			telefone_cliente.setEnabled(true);
			btn_salvar.setEnabled(true);
			btn_cancelar.setEnabled(true);		
			btn_excluir.setEnabled(false);
			btn_editar.setEnabled(false);
		} else if(ae.getActionCommand().equals("Salvar")) {
			String nome_novo = nome_cliente.getText(); 
			String ende_novo = endereco_cliente.getText();
			String tel_novo = telefone_cliente.getText();
			dados.adicionarClientes(nome_novo, ende_novo, tel_novo);
			nomes_clientes.addElement(nome_novo);
			nome_cliente.setText("");
			endereco_cliente.setText("");
			telefone_cliente.setText("");
		} else if(ae.getActionCommand().equals("Cancelar")) {
			nome_cliente.setText("");
			endereco_cliente.setText("");
			telefone_cliente.setText("");
			nome_cliente.setEnabled(false);
			endereco_cliente.setEnabled(false);
			telefone_cliente.setEnabled(false);
			btn_salvar.setEnabled(false);
			btn_cancelar.setEnabled(false);
		} else if(ae.getActionCommand().equals("Editar")) {
			nome_cliente.setEnabled(false);
			endereco_cliente.setEnabled(false);
			btn_editar.setEnabled(false);
			btn_excluir.setEnabled(false);
			telefone_cliente.setEnabled(false);
			dados.editarCliente(indice, nome_cliente.getText(), endereco_cliente.getText(), telefone_cliente.getText());
			nomes_clientes.set(indice, nome_cliente.getText()); 
			nome_cliente.setText("");
			endereco_cliente.setText("");
			telefone_cliente.setText("");
			btn_editar.setEnabled(false);
			btn_excluir.setEnabled(false);
		} else {
			nome_cliente.setEnabled(false);
			endereco_cliente.setEnabled(false);
			btn_editar.setEnabled(false);
			btn_excluir.setEnabled(false);
			dados.excluirCliente(indice);
			nomes_clientes.remove(indice);
			nome_cliente.setText("");
			endereco_cliente.setText("");
			telefone_cliente.setText("");
		}
	}
	
	public void valueChanged(ListSelectionEvent le) {
		indice = jlst.getSelectedIndex();
		if(indice < 0 || indice >= nomes_clientes.getSize()) {
			indice = 0;
		}
		nome_cliente.setText(contClientes.getClientesNomes(indice));
		endereco_cliente.setText(contClientes.getClientesEnderecos(indice));
		telefone_cliente.setText(contClientes.getClientesTelefones(indice));
		titulo.setText("Editar/Deletar Categoria");
		btn_salvar.setEnabled(false);
		btn_cancelar.setEnabled(false);
		btn_editar.setEnabled(true);
		btn_excluir.setEnabled(true);
		nome_cliente.setEnabled(true);
		endereco_cliente.setEnabled(true);
		telefone_cliente.setEnabled(true);
	}		
}
