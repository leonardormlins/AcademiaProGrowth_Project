package hello;

import java.util.LinkedList;
import java.util.List;

public class Musculacao{
	private String objetivo;
	private List<Exercicio> exercicios;
	private String emailProfessor;
	
	
	public Musculacao(String objetivo, String emailProfessor) {
		this.objetivo = objetivo;
		this.exercicios = new LinkedList<Exercicio>();
		this.emailProfessor = emailProfessor;
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
	public String getEmailProfessor() {
		return emailProfessor;
	}
	public void setEmailProfessor(String emailProfessor) {
		this.emailProfessor = emailProfessor;
	}
	
	
	
}
