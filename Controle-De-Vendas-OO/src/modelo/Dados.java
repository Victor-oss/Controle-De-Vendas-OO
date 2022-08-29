package modelo;

public class Dados {
	private Notebook[] notebooks = new Notebook[50];
	private int n_notebooks = 2;
	private Fone[] fones = new Fone[50];
	private int n_fones = 2;
	private Impressora[] impressoras = new Impressora[50];
	private int n_impressoras = 2;
	private Console_Video_Game[] consoles_video_game = new Console_Video_Game[50];
	private int n_consoles = 2;
	private Venda[] vendas = new Venda[50];
	private int n_vendas = 0;
	private Cliente[] clientes = new Cliente[50];
	private int n_clientes = 2;
	
	public void fillWithSomeData() {
		Cliente cliente1 = new Cliente("Geuza Souza", "Rua dos Cravos N 81", "99999-9999");
		Cliente cliente2 = new Cliente("Roberto Soares", "Rua dos Alecrins Bloco A Ap 13", "00000-0000");
		clientes[0] = cliente1;
		clientes[1] = cliente2;
		Notebook notebook1 = new Notebook("Lenovo Ideapad", "Samsung", 2567.50, 3012.54, 256, "Windows 11");
		Notebook notebook2 = new Notebook("Mackbook Air M1", "Apple", 5000.00, 7000.00, 256, "macOS");
		notebooks[0] = notebook1;
		notebooks[1] = notebook2;
		Fone fone1 = new Fone("Fone de Ouvido Azul", "JBL", 224.50, 412.15, "Sem fio", "Bluetooth");
		Fone fone2 = new Fone("Fone de Ouvido Preto", "Samsung", 15.0, 27.85, "Com fio", "Por fio");
		fones[0] = fone1;
		fones[1] = fone2;
		Impressora impr1 = new Impressora("Multifuncional Smart Tank", "HP", 700.50, 999.99, "Folha A4", "Jato de Tinta");
		Impressora impr2 = new Impressora("Impressora Branca", "HP", 897.34, 1004.12, "Folha A4", "Laser");
		impressoras[0] = impr1;
		impressoras[1] = impr2;
		Console_Video_Game console1 = new Console_Video_Game("Xbox Series S", "Microsoft", 1576.50, 2000.99, 2, 3);
		Console_Video_Game console2 = new Console_Video_Game("PlayStation 5", "Sony", 3001.54, 4511.55, 2, 6);
		consoles_video_game[0] = console1;
		consoles_video_game[1] = console2;
	}
	
	
	//Clientes
	public Cliente[] getClientes() {
		return this.clientes;
	}
	
	public int getClientesSize() { 
		return this.n_clientes;
	}
	
	public void aumentarNClientes() {
		this.n_clientes++;
	}	
		
	public void adicionarClientes(Cliente novo) {
		aumentarNClientes();
		this.clientes[this.n_clientes - 1] = novo; 
	}
		
	public void editarCliente(int indice, String nome_edit, String ende_edit, String tel_edit) {
		this.clientes[indice].setNome(nome_edit);
		this.clientes[indice].setEndereco(ende_edit);
		this.clientes[indice].setTelefone(tel_edit);
	}
	
	public void excluirCliente(int indice_excluido) {
		this.n_clientes--;
		int i = 0; 
		for(int index = 0; index < this.n_clientes ; index++) {
			if(i == indice_excluido) {
				i++;				
			}
			
			this.clientes[index] = this.clientes[i];
			i++;
		}	
	}
	
	//Fones
	public Fone[] getFones() {
		return this.fones;
	}
	
	public int getFonesSize() {
		return this.n_fones;
	}
	
	public void aumentarNFones() {
		this.n_fones++;
	}
	
		
	public void adicionarFone(Fone novo_fone) {
		aumentarNFones();
		this.fones[this.n_fones - 1] = novo_fone; 
	}
	
	public void editarFone(int indice, String nome_edit, String fab_edit, double valcust_edit, double valvend_edit, String tp_fone_edit, String tec_con_edit) {
		this.fones[indice].setNome(nome_edit);
		this.fones[indice].setFabricante(fab_edit);
		this.fones[indice].setValorCusto(valcust_edit);
		this.fones[indice].setValorVenda(valvend_edit);
		this.fones[indice].setTipoFone(tp_fone_edit);
		this.fones[indice].setTecConexao(tec_con_edit);
	}
	
	public void excluirFone(int indice_excluido) {
		this.n_fones--;
		int i = 0; 
		for(int index = 0; index < this.n_fones ; index++) {
			if(i == indice_excluido) {
				i++;				
			}			
			this.fones[index] = this.fones[i];
			i++;
		}
		
	}
	
	//Notebooks	
	public Notebook[] getNotebooks() {
		return this.notebooks;
	}
	
	public int getNotebooksSize() {
		return this.n_notebooks;
	}
	
	public void aumentarNNotebooks() {
		this.n_notebooks++;
	}
			
	public void adicionarNotebook(Notebook novo_not) {
		aumentarNNotebooks();
		this.notebooks[this.n_notebooks - 1] = novo_not; 
	}
		
	public void editarNotebook(int indice, String nome_edit, String fab_edit, double valcust_edit, double valvend_edit, int arm_edit, String so_edit) {
		this.notebooks[indice].setNome(nome_edit);
		this.notebooks[indice].setFabricante(fab_edit);
		this.notebooks[indice].setValorCusto(valcust_edit);
		this.notebooks[indice].setValorVenda(valvend_edit);
		this.notebooks[indice].setArmazenamento(arm_edit);
		this.notebooks[indice].setSistemaOp(so_edit);
	}
	
	public void excluirNotebook(int indice_excluido) {
		this.n_notebooks--;
		int i = 0; 
		for(int index = 0; index < this.n_notebooks ; index++) {
			if(i == indice_excluido) {
				i++;				
			}			
			this.notebooks[index] = this.notebooks[i];
			i++;
		}
	}
	
	//Impressoras
	public Impressora[] getImps() {
		return this.impressoras;
	}
	
	public int getImpsSize() {
		return this.n_impressoras;
	}
	
	public void aumentarNImps() {
		this.n_impressoras++;
	}
	
		
	public void adicionarImp(Impressora nova_imp) {
		aumentarNImps();
		this.impressoras[this.n_impressoras - 1] = nova_imp; 
	}
			
	public void editarImpressora(int indice, String nome_edit, String fab_edit, double valcust_edit, double valvend_edit, String tec_imp_edit, String tam_fol_edit) {
		this.impressoras[indice].setNome(nome_edit);
		this.impressoras[indice].setFabricante(fab_edit);
		this.impressoras[indice].setValorCusto(valcust_edit);
		this.impressoras[indice].setValorVenda(valvend_edit);
		this.impressoras[indice].setTecImpressao(tec_imp_edit);;
		this.impressoras[indice].setTamanhoFolha(tam_fol_edit);
	}
	
	public void excluirImpressora(int indice_excluido) {
		this.n_impressoras--;
		int i = 0; 
		for(int index = 0; index < this.n_impressoras ; index++) {
			if(i == indice_excluido) {
				i++;				
			}			
			this.impressoras[index] = this.impressoras[i];
			i++;
		}
		
	}
	
	//Consoles de Video Games	
	public Console_Video_Game[] getConsoles() {
		return this.consoles_video_game;
	}
	
	public int getConsolesSize() {
		return this.n_consoles;
	}
	
	public void aumentarNConsoles() {
		this.n_consoles++;
	}
	
		
	public void adicionarConsole(Console_Video_Game novo_console) {
		aumentarNConsoles();
		this.consoles_video_game[this.n_consoles - 1] = novo_console; 
	}	
	
	public void editarConsole(int indice, String nome_edit, String fab_edit, double valcust_edit, double valvend_edit, int qtd_cont_edit, int qtd_jogo_edit) {
		this.consoles_video_game[indice].setNome(nome_edit);
		this.consoles_video_game[indice].setFabricante(fab_edit);
		this.consoles_video_game[indice].setValorCusto(valcust_edit);
		this.consoles_video_game[indice].setValorVenda(valvend_edit);
		this.consoles_video_game[indice].setQtdControle(qtd_cont_edit);
		this.consoles_video_game[indice].setQtdJogos(qtd_jogo_edit);
	}
	
	public void excluirConsole(int indice_excluido) {
		this.n_consoles--;
		int i = 0; 
		for(int index = 0; index < this.n_consoles ; index++) {
			if(i == indice_excluido) {
				i++;				
			}			
			this.consoles_video_game[index] = this.consoles_video_game[i];
			i++;
		}		
	}
	
	//Vendas
	public Venda[] getVendas() {
		return this.vendas;
	}
	
	public int getVendasSize() {
		return this.n_vendas;
	}
	
	public void aumentarNVendas() {
		this.n_vendas++;
	}
	
	public void adicionarVenda(Venda nova_venda) {
		aumentarNVendas();
		this.vendas[this.n_vendas - 1] = nova_venda;
	}
	
	public void excluirVenda(int indice_excluido) {
		this.n_vendas--;
		int i = 0; 
		for(int index = 0; index < this.n_vendas ; index++) {
			if(i == indice_excluido) {
				i++;				
			}			
			this.vendas[index] = this.vendas[i];
			i++;
		}		
	}
	
	public String[] getCarrinho(int indice_selecionado) {
		return this.vendas[indice_selecionado].getCarrinho();
	}
	
	public String[] getParcelasString(int indice_selecionado) {
		String[] parcelas_string = new String[20];
		Pagamento pagamento = vendas[indice_selecionado].getPagamento();
		Parcela[] parcelas = pagamento.getParcelas();
		for(int i = 0; i < parcelas.length; i++) {
			if(parcelas[i] != null) {
				parcelas_string[i] = String.format("%.2f", parcelas[i].getValor()) + " - " + parcelas[i].getDataPag() + " - " + parcelas[i].getStatus();
			}
		}
		return parcelas_string;
	}
	
	
	 
	
}
