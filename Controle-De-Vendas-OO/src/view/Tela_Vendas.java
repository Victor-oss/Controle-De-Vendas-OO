package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controle.*;


public class Tela_Vendas implements ActionListener{
	private JList<String> jlst;	
	private JFrame jf;
	private JPanel jp;
	private int indice;
	private DefaultListModel<String> nomes_vendas = new DefaultListModel<String>();
	private JButton btn_nova;
	private JButton btn_refresh;
	private static ControleDados dados;
	private static ControleVendas contVendas;
	
	public void mostrarTela(ControleDados d){		
		dados = d;
		contVendas = new ControleVendas(dados);
		jlst = new JList<String>(nomes_vendas);
		jf = new JFrame("Vendas");
		btn_nova = new JButton("Nova");
		btn_refresh = new JButton("Recarregar");
		jlst.setBounds(20, 20, 350, 120);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlst.setVisibleRowCount(10);
		btn_nova.setBounds(100, 157, 100, 30);
		btn_refresh.setBounds(200, 157, 100, 30);
		jf.setLayout(null);
		jf.add(jlst);
		jf.add(btn_nova);
		jf.add(btn_refresh);
		jf.setSize(400, 250);
		jf.setVisible(true);
		btn_nova.addActionListener(this);
		btn_refresh.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Nova")) {
			new TelaDetalheVenda().mostrarTela(dados, contVendas);
		} else{
			for(int index=0; index<contVendas.getVendasSize(); index++) {
				nomes_vendas.addElement(contVendas.getClienteVendaNome(index) + " - R$" + String.format("%.2f", contVendas.getValorTotal(index)) + " - " + contVendas.getStatus(index));			
			}			
		}
	}	
}
