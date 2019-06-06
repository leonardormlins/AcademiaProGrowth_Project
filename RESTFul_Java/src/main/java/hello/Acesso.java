package hello;

public class Acesso {
	private String data;
	private int cpf;
	private int duracao;
	
	public Acesso(String data, int cpf, int duracao) {
		this.data = data;
		this.cpf = cpf;
		this.duracao = duracao;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
}
