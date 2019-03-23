package hello;


import java.util.List;
import java.util.LinkedList;

public class Model {
	
	private List<Carro> carros = new LinkedList<Carro>();
	private List<Aluno> alunos = new LinkedList<Aluno>();

	
	public void addCarro(Carro carro){
		carros.add(carro);
	}
	
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	public Carro buscarPlaca(String placa){
		for(Carro carro:carros){
			if(carro.getPlaca().equals(placa)) return carro;
		}
		
		return null;
	}
	
	
	public List<Carro> buscarEspecificacao(Especificacao esp){
		List<Carro> carrosEncontrados = new LinkedList<Carro>();
		
		for(Carro carro:carros){
			 if(esp.comparar(carro.getEspc())) carrosEncontrados.add(carro);
		}
		
		return carrosEncontrados;
		
	}
	
	
	public List<Carro> buscarModelo(String modelo){
		List<Carro> carrosEncontrados = new LinkedList<Carro>();
		for(Carro carro:carros) {
			if(carro.getEspc().getModelo().equals(modelo)) carrosEncontrados.add(carro);
		}
		return carrosEncontrados;
	}
	
	public List<Carro> getCarros(){
		return carros;
	}
	
	/**public List<Aula> mostrarAulas(String email){
		List<Aula> aulasMatriculadas = new LinkedList<Aula>();
		for (Aluno aluno:alunos) {
			if (aluno.getEmail()==email) aulasMatriculadas = (aluno.getAula());
		}
		return aulasMatriculadas;
	}**/
	public Aluno mostrarInfo(String nome) {
		for (Aluno aluno:alunos) {
			if (aluno.getNome().equals(nome)) return aluno;
		}
		return null;
	}
}
