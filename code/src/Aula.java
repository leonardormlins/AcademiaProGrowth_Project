import java.util.List;

public class Aula {
	private List<Aluno> aluno;
	private String descricao;
	private String data;
	private String duracao;
	private Modalidade modalidade;
	
	public Aula(List<Aluno> aluno, String descricao, String data, String duracao, Modalidade modalidade) {
		super();
		this.aluno = aluno;
		this.descricao = descricao;
		this.data = data;
		this.duracao = duracao;
	}
	
	
	public List<Aluno> getAluno() {
		return aluno;
	}
	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
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


	public Modalidade getModalidade() {
		return modalidade;
	}


	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	
	
	
}
