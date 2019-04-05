package hello;

public class User {

	private String nome;
	private String senha;
	private int tipo;
	public User(String nome, String senha, int tipo) {
		this.nome = nome;
		this.senha = senha;
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String tipo) {
		this.senha = tipo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
