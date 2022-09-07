package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controle.*;

/**
 *	Classe Tela_Clientes que e responsavel pela tela onde e possivel ler/inserir/editar/excluir um cliente     
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

public class Tela_Clientes implements ActionListener, ListSelectionListener{
	private JList<String> jlst;	
	private JFrame jf;
	private JPanel jp;
	private JScrollPane jscp;
	private int indice;
	private DefaultListModel<String> nomes_clientes = new DefaultListModel<String>();
	private JLabel titulo; 
	private JButton btn_novo;
	private JButton btn_editar;
	private JButton btn_excluir;
	private JButton btn_salvar;
	private JButton btn_cancelar;
	private JButton btn_procurar;
	private JTextField procura_cliente;
	private JTextField nome_cliente;
	private JTextField endereco_cliente;
	private JTextField telefone_cliente;
	private static ControleDados dados;
	private static ControleClientes contClientes;
	
	/**
	 * Metodo que mostra a tela de clientes
	 * @param d Atributo que permite fazer a CRUD de clientes no banco de dados usando essa tela como interface  
	 * @see ControleDados
	 */
	public void mostrarTela(ControleDados d){		
		dados = d;
		contClientes = new ControleClientes(dados);
		nomes_clientes = contClientes.getTodosClientesNomes();
		jlst = new JList<String>(nomes_clientes);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlst.addListSelectionListener(this);
		indice = 0; 
		jf = new JFrame("Clientes");
		jf.setSize(380, 620);
		jf.setLayout(new FlowLayout());
		jp = new JPanel();
		JPanel botoes_CRUD = new JPanel();
		JPanel titulo_secao = new JPanel(); 
		JPanel linha_nome = new JPanel();
		JPanel linha_ende = new JPanel();
		JPanel linha_tel = new JPanel();
		JPanel linha_procurar = new JPanel();
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
		linha_procurar.setLayout(new BoxLayout(linha_procurar, BoxLayout.X_AXIS));
		linha_procurar.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		jlst.setPreferredSize(new Dimension(360,400));
		jscp = new JScrollPane(jlst, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jscp.setPreferredSize(new Dimension(360,300));		
		JLabel nome_lab  = new JLabel("Nome: ");
		JLabel ende_lab  = new JLabel("Endereco: ");
		JLabel tel_lab  = new JLabel("Telefone: ");
		titulo = new JLabel("Cadastrar Cliente");
		JLabel cliente = new JLabel("Cliente: ");  
		nome_cliente= new JTextField(15);
		endereco_cliente = new JTextField(15);
		telefone_cliente = new JTextField(15);
		procura_cliente = new JTextField(15);
		btn_procurar = new JButton("Procurar");
		btn_procurar.setBackground(Color.green);
		btn_procurar.setForeground(Color.WHITE);
		btn_novo = new JButton("Novo");
		btn_novo.setBackground(Color.green);
		btn_novo.setForeground(Color.WHITE);
		btn_editar = new JButton("Editar");
		btn_editar.setForeground(Color.WHITE);
		btn_editar.setBackground(Color.green);
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
		nome_cliente.setEnabled(false);
		endereco_cliente.setEnabled(false);
		telefone_cliente.setEnabled(false);
		btn_procurar.addActionListener(this);
		btn_novo.addActionListener(this);
		btn_editar.addActionListener(this);
		btn_excluir.addActionListener(this);
		btn_salvar.addActionListener(this);
		btn_cancelar.addActionListener(this); 
		jp.add(linha_procurar);
		jp.add(jscp);
		linha_procurar.add(cliente);
		linha_procurar.add(procura_cliente);
		linha_procurar.add(btn_procurar);
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
	
	/**
	 * Método responsável para que uma ação de CRUD seja realizada dependendo do botão clicado  
	 */
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
				if(!nome_novo.isEmpty() && !ende_novo.isEmpty() && !tel_novo.isEmpty()) {
					dados.adicionarClientes(nome_novo, ende_novo, tel_novo);
					nomes_clientes.addElement(nome_novo);
					nome_cliente.setText("");
					endereco_cliente.setText("");
					telefone_cliente.setText("");
				}					
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
		} else  if(ae.getActionCommand().equals("Excluir")){
			nome_cliente.setEnabled(false);
			endereco_cliente.setEnabled(false);
			btn_editar.setEnabled(false);
			btn_excluir.setEnabled(false);
			dados.excluirCliente(indice);
			nomes_clientes.remove(indice);
			nome_cliente.setText("");
			endereco_cliente.setText("");
			telefone_cliente.setText("");
		} else {
			String nome_procurado = procura_cliente.getText();
			int indice_procurado;
			indice_procurado = -1;
			for(int index = 0; index < nomes_clientes.getSize(); index++) {
				if(nome_procurado.equals(nomes_clientes.get(index))) {
					indice_procurado = index;
				}
			}
			procura_cliente.setText("");
			if(indice_procurado != -1) {
				jlst.setSelectedIndex(indice_procurado);
			} else {
				mensagemErroProcuraCliente();
			}
			
		}
	}
	
	/**
	 * Método responsável por detectar e responder ao clique do usuário em um componente de jlist
	 */
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
	
	/**
	 * Metodo responsavel por exibir uma mensagem de erro caso o cliente procurado nao tenha sido encontrado
	 */
	public void mensagemErroProcuraCliente() {
		JOptionPane.showMessageDialog(null,"ERRO AO PROCURAR DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nome digitado está incompleto ou com erro\n"
				+ "2. Cliente não existe", null, 
				JOptionPane.ERROR_MESSAGE);
	}
}
