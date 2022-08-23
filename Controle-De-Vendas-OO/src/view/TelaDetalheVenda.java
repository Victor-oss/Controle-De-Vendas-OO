package view;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controle.*;
import modelo.*; //APAGAR DPSSSSSSSSSSS

public class TelaDetalheVenda implements ActionListener, ItemListener{
	private JList<String> jlst;	
	private JFrame jf;
	private JPanel jp;
	private JScrollPane jscp;
	private int indice;
	private DefaultListModel<String> nomes_produtos = new DefaultListModel<String>();
	private JButton btn_procurarCli;
	private JButton btn_adicionarProd;
	private JButton btn_salvar;
	private JButton btn_cancelar;
	private JTextField nome_cliente;
	private JTextField nome_prod;
	private JTextField qtd_prod;
	private JTextField n_parc;
	private JTextField dt_vend;
	private JTextField dt_venc;
	private JTextField valor_tot;
	private ControleDados dados;
	private ControleVendas contVendas;
	private Cliente cliente_procurado;//APAGAR DPSSSSSSSSSSSSS
	private Notebook not_procurado;//APAGAR DPSSSSSSSSSSSSS
	private Fone fone_procurado;//APAGAR DPSSSSSSSSSSSSS
	private Impressora imp_procurada;//APAGAR DPSSSSSSSSSSSSS
	private Console_Video_Game console_procurado;//APAGAR DPSSSSSSSSSSSSS
	private JCheckBox checkNot = new JCheckBox("Notebook");
	private JCheckBox checkImp = new JCheckBox("Impressora");
	private JCheckBox checkFone = new JCheckBox("Fone");
	private JCheckBox checkGame = new JCheckBox("Console Video-Game");
	private int tipo;
	private double valor_venda = 0;
	
	public void mostrarTela(ControleDados d, ControleVendas cv){		
		dados = d;
		contVendas = cv;
		//contClientes = new ControleClientes(dados);
		//nomes_produtos = contClientes.getTodosClientesNomes();
		jlst = new JList<String>(nomes_produtos);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//jlst.addListSelectionListener(this);
		indice = 0; 
		jf = new JFrame("Cadastrar Venda");
		jf.setSize(410, 730);
		jf.setLayout(new FlowLayout());
		jp = new JPanel();
		JPanel linha_cliente = new JPanel();
		JPanel linha_tipo = new JPanel();
		JPanel linha_produto = new JPanel(); 
		JPanel linha_qtd = new JPanel();
		JPanel linha_n_parc = new JPanel();
		JPanel linha_dt_vend = new JPanel();
		JPanel linha_dt_venc = new JPanel();
		JPanel linha_valor_tot = new JPanel();
		JPanel botoes_nova = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		linha_cliente.setLayout(new BoxLayout(linha_cliente, BoxLayout.X_AXIS));
		linha_cliente.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_produto.setLayout(new BoxLayout(linha_produto, BoxLayout.X_AXIS));
		linha_produto.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_qtd.setLayout(new BoxLayout(linha_qtd, BoxLayout.X_AXIS));
		linha_qtd.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_tipo.setLayout(new BoxLayout(linha_tipo, BoxLayout.X_AXIS));
		linha_tipo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		botoes_nova.setLayout(new BoxLayout(botoes_nova, BoxLayout.X_AXIS));
		botoes_nova.setLayout(new BoxLayout(botoes_nova, BoxLayout.X_AXIS));
		linha_n_parc.setLayout(new BoxLayout(linha_n_parc, BoxLayout.X_AXIS));
		linha_n_parc.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_dt_vend.setLayout(new BoxLayout(linha_dt_vend, BoxLayout.X_AXIS));
		linha_dt_vend.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		linha_dt_venc.setLayout(new BoxLayout(linha_dt_venc, BoxLayout.X_AXIS));
		linha_dt_venc.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));	
		linha_valor_tot.setLayout(new BoxLayout(linha_valor_tot, BoxLayout.X_AXIS));
		linha_valor_tot.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));	
		jscp = new JScrollPane(jlst);
		jscp.setPreferredSize(new Dimension(360,300));
		JLabel lab_cliente  = new JLabel("Cliente: ");
		JLabel lab_produto  = new JLabel("Produto: ");
		JLabel lab_qtd  = new JLabel("Quantidade: ");
		JLabel lab_nparc  = new JLabel("Número de Parcelas: ");
		JLabel lab_dt_vend  = new JLabel("Data Venda: ");
		JLabel lab_dt_venc  = new JLabel("Data Vencimento: ");
		JLabel lab_valor_tot  = new JLabel("Valor Venda: ");
		nome_cliente= new JTextField(15);
		nome_prod = new JTextField(15);
		qtd_prod = new JTextField(15);
		n_parc= new JTextField(15);
		dt_vend = new JTextField(15);
		dt_venc = new JTextField(15);
		valor_tot = new JTextField(15);
		btn_procurarCli = new JButton("Procurar");
		btn_adicionarProd = new JButton("Adicionar");
		btn_salvar = new JButton("Salvar"); 
		btn_cancelar = new JButton("Cancelar");
		checkFone.addItemListener(this);
		checkNot.addItemListener(this);
		checkGame.addItemListener(this);
		checkImp.addItemListener(this);
		limparTd();	
		btn_procurarCli.addActionListener(this);
		btn_adicionarProd.addActionListener(this);
		btn_salvar.addActionListener(this);
		btn_cancelar.addActionListener(this);
		linha_cliente.add(lab_cliente);
		linha_cliente.add(nome_cliente);
		linha_cliente.add(btn_procurarCli);
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
		botoes_nova.add(btn_salvar);
		botoes_nova.add(btn_cancelar);
		jp.add(linha_cliente);
		jp.add(linha_tipo);
		jp.add(linha_produto);
		jp.add(linha_qtd);		
		jp.add(jscp);
		jp.add(linha_n_parc);
		jp.add(linha_dt_vend);
		jp.add(linha_dt_venc);
		jp.add(linha_valor_tot);
		jp.add(botoes_nova);
		jf.add(jp);
		jf.setVisible(true);
	}
	
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
		nomes_produtos.clear();
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Procurar")) {
			String nome_digitado = nome_cliente.getText();
			cliente_procurado = contVendas.procuraCliente(nome_digitado);
			nome_prod.setEnabled(true);
			qtd_prod.setEnabled(true);
			checkFone.setEnabled(true);
			checkNot.setEnabled(true);
			checkGame.setEnabled(true);
			checkImp.setEnabled(true);
			btn_adicionarProd.setEnabled(true);			
		} else if (ae.getActionCommand().equals("Adicionar")) {
			String produto_digitado = nome_prod.getText();
			int n_produtos = Integer.parseInt(qtd_prod.getText());
			double valor_unitario = 0; 
			if(tipo == 1) {
				not_procurado = contVendas.procuraNotebook(produto_digitado);
				valor_unitario = not_procurado.getValorVenda(); 
				valor_venda += valor_unitario*n_produtos;			
			} else if (tipo == 2) {
				fone_procurado = contVendas.procuraFone(produto_digitado);
				valor_unitario = fone_procurado.getValorVenda(); 
				valor_venda += valor_unitario*n_produtos;	
			} else if (tipo == 3) {
				imp_procurada = contVendas.procuraImpressora(produto_digitado);
				valor_unitario = imp_procurada.getValorVenda();
				valor_venda += valor_unitario*n_produtos;
			} else if (tipo == 4) {
				console_procurado = contVendas.procuraConsole(produto_digitado);
				valor_unitario = console_procurado.getValorVenda();
				valor_venda += valor_unitario*n_produtos;
			}	
			valor_tot.setText(String.format("%.2f", valor_venda));
			nomes_produtos.addElement(produto_digitado+" "+"R$"+valor_unitario+" x"+n_produtos);
			nome_prod.setText("");
			qtd_prod.setText("");
			n_parc.setEnabled(true);
			dt_vend.setEnabled(true);
			dt_venc.setEnabled(true);			
			btn_salvar.setEnabled(true);
		}  else if (ae.getActionCommand().equals("Salvar")) {
			String data_venda = dt_vend.getText();
			String data_venci = dt_venc.getText();
			String qtd_meses_parcelados = n_parc.getText();
			dados.adicionarVenda(cliente_procurado, data_venda, data_venci, valor_venda,Integer.valueOf(qtd_meses_parcelados));
			limparTd();
		} else {
			limparTd();
		}
	}
	
	public void itemStateChanged(ItemEvent evento) {
	   if(checkNot.isSelected()) {   
		   tipo = 1;		   
	   }
	   
	   if(checkFone.isSelected()) {   
		   tipo = 2;
	   }
	   
	   if(checkImp.isSelected()) {   
		   tipo = 3;
	   }
	   
	   if(checkGame.isSelected()) {   
		   tipo = 4;
	   }  			  
	 }
}
