package hello;

import java.util.List;

public class Musculacao extends Modalidade{
	private String objetivo;
	private List<Exercicio> exercicios;
	
	public Musculacao(int id, String descricao, String objetivo, List<Exercicio> exercicios) {
		super(id, descricao);
		this.objetivo = objetivo;
		this.exercicios = exercicios;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
	
	
}
