package hello;


public class Aula {
	private String descricao;
	private String data;
	private String duracao;
	private String modalidade;
	private String emailProfessor;
	
	public Aula(String descricao, String data, String duracao, String modalidade, String emailProfessor) {
		this.descricao = descricao;
		this.data = data;
		this.duracao = duracao;
		this.modalidade = modalidade;
		this.emailProfessor = emailProfessor;
	}
	
	
	public String getEmailProfessor() {
		return emailProfessor;
	}


	public void setEmailProfessor(String emailProfessor) {
		this.emailProfessor = emailProfessor;
	}


	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}


	public String getModalidade() {
		return modalidade;
	}


	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	
	
	
}
