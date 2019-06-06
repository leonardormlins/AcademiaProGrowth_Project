package hello;

import java.util.LinkedList;
import java.util.List;

public class Aluno extends Pessoa {
	private List<Musculacao> musculacoes;
	private Musculacao musculacaoAtual;
	private List<Shape> historicoShape;
	private List<Aula> aulas;
	private List<Acesso> acessos;
	
	
	public Aluno(int id, String nome, String adress, String email, String telefone,  String senha, char genero, int tipo) {
		super(id, nome, adress, email, telefone, senha, genero, tipo);
		this.musculacoes = new LinkedList<Musculacao>();
		this.musculacaoAtual = null;
		this.historicoShape = new LinkedList<Shape>();
		this.aulas = new LinkedList<Aula>();
		this.acessos = new LinkedList<Acesso>();

	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}

	public List<Musculacao> getMusculacoes() {
		return musculacoes;
	}
	public void setMusculacoes(List<Musculacao> musculacoes) {
		this.musculacoes = musculacoes;
	}
	public Musculacao getMusculacaoAtual() {
		return musculacaoAtual;
	}
	public void setMusculacaoAtual(Musculacao musculacaoAtual) {
		this.musculacaoAtual = musculacaoAtual;
	}

	public List<Shape> getHistoricoShape() {
		return historicoShape;
	}
	public void setHistoricoShape(List<Shape> historicoShape) {
		this.historicoShape = historicoShape;
	}
	public List<Aula> getAula() {
		return aulas;
	}
	public void setAula(List<Aula> aulas) {
		this.aulas = aulas;
	}
	
	public void addAula (Aula aula) {
		aulas.add(aula);
	}
}
