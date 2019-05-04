package hello;

import java.util.List;

public class Professor extends Funcionario {
	private List<Modalidade> modalidade;
	private List<Aula> aula;
	
	
	public Professor(int id, String nome, String adress, String email, String telefone, String expediente,
			String descricaoCargo, List<Modalidade> modalidade, List<Aula> aula, String senha, char genero, int tipo) {
		super(id, nome, adress, email, telefone, expediente, descricaoCargo, senha, genero, tipo);
		this.modalidade = modalidade;
		this.aula = aula;
	}
	
	public List<Modalidade> getModalidade() {
		return modalidade;
	}
	public void setModalidade(List<Modalidade> modalidade) {
		this.modalidade = modalidade;
	}
	public List<Aula> getAula() {
		return aula;
	}
	public void setAula(List<Aula> aula) {
		this.aula = aula;
	}
	
	
}

