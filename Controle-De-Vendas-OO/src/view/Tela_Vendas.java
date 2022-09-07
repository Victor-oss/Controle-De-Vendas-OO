package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controle.*;

/**
 *	Classe Tela_Vendas que permite que o usuario visualize as vendas registradas no banco de dados, podendo criar uma nova
 *	ou ver o status de uma venda      
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1 
 */

public class Tela_Vendas implements ActionListener, ListSelectionListener{
	private JList<String> jlst;	
	private JFrame jf;
	private int indice;
	private DefaultListModel<String> nomes_vendas = new DefaultListModel<String>();
	private JButton btn_nova;
	private JButton btn_refresh;
	private static ControleDados dados;
	private static ControleVendas contVendas;
	
	/**
	 * Metodo que mostra a tela com a vendas registradas
	 * @param d Atributo que permite acesso dessa tela ao banco de dados 
	 * @see ControleDados
	 */
	public void mostrarTela(ControleDados d){		
		dados = d;
		contVendas = new ControleVendas(dados);
		jlst = new JList<String>(nomes_vendas);
		String nome_venda;
		for(int i = 0; i < contVendas.getVendasSize(); i++) {
			nome_venda = contVendas.getClienteVendaNome(i) + " - R$" + String.format("%.2f", contVendas.getValorTotal(i)) + " - " + contVendas.getStatus(i);
			nomes_vendas.addElement(nome_venda);
		}		
		
		jf = new JFrame("Vendas");
		btn_nova = new JButton("Nova");
		btn_refresh = new JButton("Recarregar");
		jlst.setBounds(20, 20, 350, 200);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlst.setVisibleRowCount(10);
		btn_nova.setBounds(100, 237, 100, 30);
		btn_nova.setBackground(Color.green);
		btn_nova.setForeground(Color.WHITE);
		btn_refresh.setBounds(200, 237, 100, 30);
		btn_refresh.setBackground(Color.green);
		btn_refresh.setForeground(Color.WHITE);
		jf.setLayout(null);
		jf.add(jlst);
		jf.add(btn_nova);
		jf.add(btn_refresh);
		jf.setSize(400, 330);
		jf.setVisible(true);
		btn_nova.addActionListener(this);
		btn_refresh.addActionListener(this);
		jlst.addListSelectionListener(this);
	}
	
	/**
	 * Metodo responsavel para que um usuario cadastre uma venda ou recarregue a jlist para acompanhar as atualizacoes nas vendas
	 * dependendo do botao clicado 
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Nova")) {
			new TelaDetalheVenda().mostrarTela(dados, contVendas, 1, -1);
		} else{
			jlst.removeListSelectionListener(this);
			nomes_vendas.clear();
			for(int index=0; index<contVendas.getVendasSize(); index++) {
				nomes_vendas.addElement(contVendas.getClienteVendaNome(index) + " - R$" + String.format("%.2f", contVendas.getValorTotal(index)) + " - " + contVendas.getStatus(index));			
			}			
			jlst.addListSelectionListener(this);
		}
	}	
	
	/**
	 * Metodo responsavel por detectar e responder ao clique do usuario em um componente de jlist
	 */
	public void valueChanged(ListSelectionEvent le) {
		if(!le.getValueIsAdjusting()) {
			indice = jlst.getSelectedIndex();
			new TelaDetalheVenda().mostrarTela(dados, contVendas, 2, indice);
		}			
	}
}
