package hello;

public class Acesso {
	private int data;
	private Pessoa pessoa;
	private int duracao;
	
	public Acesso(int data, Pessoa pessoa, int duracao) {
		super();
		this.data = data;
		this.pessoa = pessoa;
		this.duracao = duracao;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
}
