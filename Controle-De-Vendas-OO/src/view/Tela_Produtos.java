package view;
/**
 *	Classe Tela_Produtos que é o menu onde o usuário pode decidir qual tela de produto deseja ver    
 *	@author Victório Lázaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */
import javax.swing.JButton;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controle.*;

public class Tela_Produtos implements ActionListener{
	private JFrame janela = new JFrame("Produtos");
	private JButton btn_notebooks = new JButton("Notebooks");
	private JButton btn_impressoras = new JButton("Impressoras");
	private JButton btn_fones = new JButton("Fones");
	private JButton btn_consoles = new JButton("Consoles de Video Games");
	private ControleDados dados;
	
	/**
	 * Método que mostra o menu de produtos 
	 */
	public void mostrarTela(ControleDados d) {
		dados = d;
		janela.setSize(400, 280);
		janela.setLayout(null);
		
		btn_notebooks.setBounds(100, 30, 200, 30);
		btn_notebooks.setBackground(Color.green);
		btn_notebooks.setForeground(Color.WHITE);
		btn_impressoras.setBounds(100, 80, 200, 30);
		btn_impressoras.setBackground(Color.green);
		btn_impressoras.setForeground(Color.WHITE);
		btn_fones.setBounds(100, 130, 200, 30);
		btn_fones.setBackground(Color.green);
		btn_fones.setForeground(Color.WHITE);
		btn_consoles.setBounds(100, 180, 200, 30);
		btn_consoles.setBackground(Color.green);
		btn_consoles.setForeground(Color.WHITE);
		btn_notebooks.addActionListener(this);		
		btn_impressoras.addActionListener(this);		
		btn_fones.addActionListener(this);
		btn_consoles.addActionListener(this); 
		janela.add(btn_notebooks);
		janela.add(btn_impressoras);
		janela.add(btn_fones);
		janela.add(btn_consoles);		
		janela.setVisible(true);
	}
	
	/**
	 * Método responsável para que certa tela de produto seja mostrada dependendo do botão clicado  
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Notebooks")) {
			new Tela_Detalhe_Produtos().mostrarTela(dados, 1);
		} else if(ae.getActionCommand().equals("Impressoras")) {
			new Tela_Detalhe_Produtos().mostrarTela(dados, 2);
		} else if(ae.getActionCommand().equals("Fones")) {
			new Tela_Detalhe_Produtos().mostrarTela(dados, 3);
		}  else {
			new Tela_Detalhe_Produtos().mostrarTela(dados, 4);			
		}	
	}
}
