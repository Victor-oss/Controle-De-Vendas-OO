package view;

import javax.swing.JButton;

import javax.swing.JFrame;
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
	
	public void mostrarTela(ControleDados d) {
		dados = d;
		janela.setSize(400, 280);
		janela.setLayout(null);
		
		btn_notebooks.setBounds(100, 30, 200, 30);
		btn_impressoras.setBounds(100, 80, 200, 30);
		btn_fones.setBounds(100, 130, 200, 30);
		btn_consoles.setBounds(100, 180, 200, 30);		
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
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Notebooks")) {
			new Tela_Notebooks().mostrarTela(dados);
		} else if(ae.getActionCommand().equals("Impressoras")) {
			new Tela_Impressoras().mostrarTela(dados);
		} else if(ae.getActionCommand().equals("Fones")) {
			new Tela_Fones().mostrarTela(dados);
		}  else {
			new Tela_Consoles().mostrarTela(dados);			
		}	
	}
}
