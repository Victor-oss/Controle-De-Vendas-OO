package view;
import java.awt.Color;
import java.awt.event.*;
import controle.*;
import javax.swing.*;

/**
 *	Classe Tela_Menu que e responsavel pelo menu inicial da aplicacao   
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

public class Tela_Menu implements ActionListener{
	private JFrame janela = new JFrame();
	private JLabel nome_loja = new JLabel("Bem-vindo a loja Lázaro Eletronics");
	private JButton btn_clientes = new JButton("Clientes");
	private JButton btn_produtos = new JButton("Produtos");
	private JButton btn_vendas = new JButton("Vendas");
	private ControleDados d = new ControleDados();
	
	/**
	 * Metodo construtor que imprime a tela de menu
	 */
	public Tela_Menu() {
		janela.setSize(400, 230);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		janela.setLayout(null);
		nome_loja.setBounds(100, 0, 200, 30);
		btn_clientes.setBounds(140, 30, 100, 30);
		btn_clientes.setBackground(Color.green);
		btn_clientes.setForeground(Color.WHITE);
		btn_produtos.setBounds(140, 80, 100, 30);
		btn_produtos.setBackground(Color.green);
		btn_produtos.setForeground(Color.WHITE);
		btn_vendas.setBounds(140, 130, 100, 30);
		btn_vendas.setForeground(Color.WHITE);
		btn_vendas.setBackground(Color.green);
		btn_clientes.addActionListener(this);
		btn_produtos.addActionListener(this);		
		btn_vendas.addActionListener(this);
		janela.add(nome_loja); 
		janela.add(btn_clientes);
		janela.add(btn_produtos);
		janela.add(btn_vendas);	
		janela.setVisible(true);
	}
	
	/**
	 * Metodo que direciona o usuario para uma tela diferente dependendo do botao clicado
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Clientes")) {
			new Tela_Clientes().mostrarTela(d);
		} else if(ae.getActionCommand().equals("Produtos")) {
			new Tela_Produtos().mostrarTela(d);
		} else {
			new Tela_Vendas().mostrarTela(d); 
		} 
	}
	
	public static void main(String [] args) {
		new Tela_Menu();
	}	
}
