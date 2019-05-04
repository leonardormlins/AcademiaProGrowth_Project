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
	ObjectContainer adms = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/adms.db4o");
	ObjectContainer professores = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/professores.db4o");
	ObjectContainer funcionarios = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/funcionarios.db4o");
	ObjectContainer acessos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/acessos.db4o");
	ObjectContainer shapes = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/shapes.db4o");
	ObjectContainer modalidades = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/modalidades.db4o");
	ObjectContainer codigosAcesso = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/codigosAcesso.db4o");
	
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

	public boolean isAlunoDisponivel(String email){
		Query query = alunos.query();
		query.constrain(Aluno.class);
	    List<Aluno> todosAlunos = query.execute();
	    
	    for(Aluno aluno: todosAlunos){
	    	if(aluno.getEmail().equals(email)) return false;
	    }
	    
	    return true;
	}


	//ok
	public boolean addAluno (Aluno aluno) {
		if (isAlunoDisponivel(aluno.getEmail())) {
			aluno.addAula(new Aula (null, "Zumba", "segunda", "50min", new Modalidade (01,"zumba")));
			aluno.addAula(new Aula (null, "Boxe", "terÃ§a", "50min",  new Modalidade (02,"boxe")));
			aluno.addAula(new Aula (null, "Spinning", "Quarta", "50min", new Modalidade (03,"spinning")));
			alunos.store(aluno);
			alunos.commit();
			return true;
		}
		return false;
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
