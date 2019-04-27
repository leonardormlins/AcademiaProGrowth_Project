package hello;


import java.util.List;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;


public class Model {

	
	ObjectContainer alunos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/alunos.db4o");
	ObjectContainer aulas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/aulas.db4o");
	
	private List<User> users = new LinkedList<User>();

	
	
	//ok
	public void addAula (Aula aula) {
			aulas.store(aula);
			aulas.commit();
		}
	 
	
	//ok
	public void inclAula (String nAluno, String nAula) {
		Query query1 = alunos.query();
		query1.constrain(Aluno.class);
		
		List<Aluno> todosAlunos = query1.execute();
		
		Query query2 = aulas.query();
		query2.constrain(Aula.class);
		
		List<Aula> todasAulas = query2.execute();
		
		for (Aluno aluno: todosAlunos) {
			if (aluno.getNome().equals(nAluno))
			{
				for (Aula aula: todasAulas) {
					if (aula.getDescricao().equals(nAula)){
						aluno.addAula(aula);
					}
						
					}
				}
		}
	}


	//ok
	public void addAluno (Aluno aluno) {
		alunos.store(aluno);
		alunos.commit();
	}

	//ok
	public List<Aula> buscarAulasAluno(String email){
		Query query = alunos.query();
		query.constrain(Aluno.class);
		
		List<Aluno> todosAlunos = query.execute();
		
		for (Aluno aluno:todosAlunos) {
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
	


}
