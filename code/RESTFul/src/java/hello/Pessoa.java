package hello;

public class Pessoa {
	private int id;
	private String nome;
	private String adress;
	private String email;
	private String telefone;
	private String senha;
	private int tipo;
	
	public Pessoa(int id, String nome, String adress, String email, String telefone, String senha, int tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.adress = adress;
		this.email = email;
		this.telefone = telefone;
		this.tipo = tipo;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public  int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
