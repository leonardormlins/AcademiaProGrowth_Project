package hello;

import java.util.List;

public class Aluno extends Pessoa {
	private List<Modalidade> modalidade;
	private List<Shape> historicoShape;
	private List<Aula> aulas;
	
	
	public Aluno(int id, String nome, String adress, String email, String telefone,  String senha, int tipo, List<Modalidade> modalidade,
			List<Shape> historicoShape, List<Aula> aulas) {
		super(id, nome, adress, email, telefone, senha, tipo);
		this.modalidade = modalidade;
		this.historicoShape = historicoShape;
		this.aulas = aulas;

	}
	public List<Modalidade> getModalidade() {
		return modalidade;
	}
	public void setModalidade(List<Modalidade> modalidade) {
		this.modalidade = modalidade;
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