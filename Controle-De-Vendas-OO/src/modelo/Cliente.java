package modelo;

/**
 *	Classe Cliente que representa um cliente da loja
 *	@author Victorio Lazaro Rocha de Morais
 *	@since 2022
 * 	@version 1.1
 */

public class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String endereco, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
