package controle;
import modelo.*;
import java.util.Calendar;

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.fillWithSomeData();
	}
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}
	
	//Clientes	
	public Cliente[] getClientes() {
		return this.d.getClientes();
	}
	
	public int getClientesSize() {
		return this.d.getClientesSize();
	}	
		
	public void adicionarClientes(String nome_novo, String ende_novo, String tel_novo) {
		this.d.adicionarClientes(new Cliente(nome_novo, ende_novo, tel_novo)); 
	}
	
	public void editarCliente(int indice, String nome_edit, String ende_edit, String tel_edit) {
		this.d.editarCliente(indice, nome_edit, ende_edit, tel_edit);
	}
	
	public void excluirCliente(int indice_excluido) {
		this.d.excluirCliente(indice_excluido);		
	}
	
	//Fones
	public Fone[] getFones(){
		return this.d.getFones();
	}
	
	public int getFonesSize(){
		return this.d.getFonesSize();
	}
	
	public void adicionarFone(String nome_novo, String fab_novo, double vlvend_novo, double vlcust_novo, String tpfone_novo, String teccon_novo) {
		this.d.adicionarFone(new Fone(nome_novo, fab_novo, vlvend_novo, vlcust_novo, tpfone_novo, teccon_novo)); 
	}
	
	public void editarFone(int indice, String nome_edit, String fab_edit, double valcust_edit, double valvend_edit, String tp_fone_edit, String tec_con_edit) {
		this.d.editarFone(indice, nome_edit, fab_edit, valcust_edit, valvend_edit, tp_fone_edit, tec_con_edit);
	}
	
	public void excluirFone(int indice_excluido) {
		this.d.excluirFone(indice_excluido);	
	}
	
	//Notebooks
	public Notebook[] getNotebooks() {
		return this.d.getNotebooks();
	}
	
	public int getNotebooksSize() {
		return this.d.getNotebooksSize();
	}
	
	public void adicionarNotebook(String nome_novo, String fab_novo, double vlvend_novo, double vlcust_novo, int arm_novo, String so_novo) {
		this.d.adicionarNotebook(new Notebook(nome_novo, fab_novo, vlvend_novo, vlcust_novo, arm_novo, so_novo)); 
	}
	
	public void editarNotebook(int indice, String nome_edit, String fab_edit, double valcust_edit, double valvend_edit, int arm_edit, String so_edit) {
		this.d.editarNotebook(indice, nome_edit, fab_edit, valcust_edit, valvend_edit, arm_edit, so_edit);
	}
	
	public void excluirNotebook(int indice_excluido) {
		this.d.excluirNotebook(indice_excluido);		
	}
	
	//Impressoras
	public Impressora[] getImps() {
		return this.d.getImps();
	}
	
	public int getImpsSize() {
		return this.d.getImpsSize();
	}	
		
	public void adicionarImp(String nome_novo, String fab_novo, double vlvend_novo, double vlcust_novo, String tec_imp_nova, String tamfol_nova) {
		this.d.adicionarImp(new Impressora(nome_novo, fab_novo, vlvend_novo, vlcust_novo, tec_imp_nova, tamfol_nova)); 
	}
	
	public void editarImpressora(int indice, String nome_edit, String fab_edit, double valcust_edit, double valvend_edit, String tec_imp_edit, String tam_fol_edit) {
		this.d.editarCliente(indice, nome_edit, nome_edit, tam_fol_edit);
	}
	
	public void excluirImpressora(int indice_excluido) {
		this.d.excluirImpressora(indice_excluido);		
	}
	
	//Consoles Video Game
	public Console_Video_Game[] getConsoles() {
		return d.getConsoles();
	}
	
	public int getConsolesSize() {
		return d.getConsolesSize();
	}
		
	public void adicionarConsole(String nome_novo, String fab_novo, double vlvend_novo, double vlcust_novo, int qtdcont_novo, int qtdjogo_novo) {
		this.d.adicionarConsole(new Console_Video_Game(nome_novo, fab_novo, vlvend_novo, vlcust_novo, qtdcont_novo, qtdjogo_novo)); 
	}	
	
	public void editarConsole(int indice, String nome_edit, String fab_edit, double valcust_edit, double valvend_edit, int qtd_cont_edit, int qtd_jogo_edit) {
		this.d.editarConsole(indice, nome_edit, fab_edit, valcust_edit, valvend_edit, qtd_cont_edit, qtd_jogo_edit);
	}
	
	public void excluirConsole(int indice_excluido) {
		this.d.excluirConsole(indice_excluido);		
	}
	
	//Vendas
	public Venda[] getVendas() {
		return d.getVendas();
	}
	
	public int getVendasSize() {
		return d.getVendasSize();
	}
	
	public void adicionarVenda(Cliente cliente, String data_venda, String data_vencimento, double valor_total, int qtd_meses) {
		/*try {
			if(data_venda.length() == 10 && data_venda.length() == 10) {
				int dia_vend = Integer.parseInt(data_venda.substring(0, 2));
				int mes_vend = Integer.parseInt(data_venda.substring(3, 5));
				int ano_vend = Integer.parseInt(data_venda.substring(6));
				int dia_venc = Integer.parseInt(data_vencimento.substring(0, 2));
				int mes_venc = Integer.parseInt(data_vencimento.substring(3, 5));
				int ano_venc = Integer.parseInt(data_vencimento.substring(6));
				Calendar c_vend = Calendar.getInstance();
				c_vend.set(ano_vend, mes_vend, dia_vend);
				Calendar c_venc = Calendar.getInstance();
				c_venc.set(ano_venc, mes_venc, dia_venc);
				if(c_vend.compareTo(c_venc) > 0 || (dia_vend == dia_venc && mes_vend == mes_venc && ano_vend == ano_venc)) {
					this.d.adicionarVenda(new Venda(cliente, data_venda, data_vencimento, valor_total, qtd_meses));
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (NullPointerException exc1) {
			return false;
		}*/
		this.d.adicionarVenda(new Venda(cliente, data_venda, data_vencimento, valor_total, qtd_meses));
	}	
}      
