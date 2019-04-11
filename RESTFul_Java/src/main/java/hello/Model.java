package hello;


import java.util.List;
import java.util.LinkedList;

public class Model {

	private List<Aluno> alunos = new LinkedList<Aluno>();
	private List<User> users = new LinkedList<User>();

	
	static List<Aula> aulas = new LinkedList<Aula>();
	    
	public void addAula (Aula aula) {
			aulas.add(aula);
		}
	  
	public void inclAula (String nAluno, String nAula) {
		for (Aluno aluno: alunos ) {
			if (aluno.getNome().equals(nAluno))
			{
				for (Aula aula: aulas) {
					if (aula.getDescricao().equals(nAula)){
						aluno.addAula(aula);
					}
						
					}
				}
		}
	}


	public void addAluno (Aluno aluno) {
		alunos.add(aluno);
	}

	
	public List<Aula> aulaAluno(String email){
		for (Aluno aluno:alunos) {
			if (aluno.getEmail().equals(email))
				return aluno.getAula();
		}
		return null;
	}
	
	public void addUser(User user){
		users.add(user);
	}
	
	public User loginUser(String username, String senha)
	{
		
		for(User user:users) {
			if (user.getNome().equals(username)&&user.getSenha().equals(senha))return user;
		}
		return null;
	}
	
	public List<Aula> buscarAulasAluno(String user){
		for(Aluno aluno: alunos) {
			if(aluno.getEmail()==user) return aluno.getAula();
		}
		return null;
	}


}
