package hello;

import java.util.Random;
import java.util.List;
import java.util.LinkedList;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;


public class Model {
	
	
	ObjectContainer alunos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/alunos.db4o");
	ObjectContainer aulas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/aulas.db4o");
	ObjectContainer adms = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/adms.db4o");
	ObjectContainer professores = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/professores.db4o");
	ObjectContainer acessos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/acessos.db4o");
	List<Musculacao> musculacaoPendente = new LinkedList<Musculacao>();
	List <Integer> codigos = new LinkedList<Integer>();
	
	//realiza login, retornando o objeto do tipo de usuario (Aluno, Professor, Admin)
	public Pessoa loginUser(String email, String senha)
	{
		Query query1 = alunos.query();
		query1.constrain(Aluno.class);
		List<Aluno> todosAlunos = query1.execute();

		Query query2 = professores.query();
		query2.constrain(Professor.class);
		List<Professor> todosProf = query2.execute();

		Query query3 = adms.query();
		query3.constrain(Admin.class);
		List<Admin> todosAdmins = query3.execute();

		for(Aluno aluno:todosAlunos) {
			if (aluno.getEmail().equals(email)&&aluno.getSenha().equals(senha))return aluno;
		}
		for(Professor prof:todosProf) {
			if (prof.getEmail().equals(email)&&prof.getSenha().equals(senha))return prof;
		}
		for(Admin admin:todosAdmins) {
			if (admin.getEmail().equals(email)&&admin.getSenha().equals(senha))return admin;
		}
		return null;
	}
	
	//cadastra um aluno e remove seu codigo de cadastro do sistema
	public void cadastrarAluno(String nome, String senha, String genero, String email, String ender, String tel,String cpf, String cod) {
		addAluno(new Aluno (Integer.valueOf(cpf),nome,ender,email,tel, senha, genero.charAt(0),1));
		codigos.remove((Integer.valueOf(cod)));
	}

	//adiciona aluno ao banco de dados
	public boolean addAluno (Aluno aluno) {
		if (isAlunoDisponivel(aluno.getEmail())) {
			aluno.addAula(new Aula ("Zumba", "segunda", "50min", "zumba", "min@m.com"));
			aluno.addAula(new Aula ("Boxe", "terca", "50min", "boxe", "min@m.com"));
			aluno.addAula(new Aula ("Spinning", "Quarta", "50min", "spinning", "min@m.com"));
			alunos.store(aluno);
			alunos.commit();
			return true;
		}
		return false;
	}

	//verifica se o email esta disponivel para cadastro do aluno
	public boolean isAlunoDisponivel(String email){
		Query query = alunos.query();
		query.constrain(Aluno.class);
		List<Aluno> todosAlunos = query.execute();

		for(Aluno aluno: todosAlunos){
			if(aluno.getEmail().equals(email)) return false;
		}

		return true;
	}

	//cadastra um professor no sistema
	public void cadastrarProf(String nome, String senha, String genero, String email, String ender, String tel,   String cpf, String expediente, String descricaoCargo  ) {
		addProf(new Professor (Integer.valueOf(cpf),nome,ender,email,tel, expediente, descricaoCargo, senha, genero.charAt(0),2));
	}

	//verifica se o email esta disponivel para cadastro do professor
	public boolean isProfDisponivel(String email){
		Query query = professores.query();
		query.constrain(Professor.class);
		List<Professor> todosProfs = query.execute();

		for(Professor prof: todosProfs){
			if(prof.getEmail().equals(email)) return false;
		}

		return true;
	}

	//adiciona o professor ao banco de dados
	public boolean addProf (Professor prof) {
		if (isProfDisponivel(prof.getEmail())) {
			professores.store(prof);
			professores.commit();
			return true;
		}
		else return false;
	}
	
	//cadastra novo admin
	public void cadastrarAdmin(String nome, String senha, String genero, String email, String ender, String tel,   String cpf) {
		addAdm(new Admin (Integer.valueOf(cpf),nome,ender,email,tel, senha, genero.charAt(0),0)); 

	}

	//verifica se email de admin esta disponivel
	public boolean isAdminDisponivel(String email){
		Query query = adms.query();
		query.constrain(Admin.class);
		List<Admin> todosAdms = query.execute();

		for(Admin admin: todosAdms){
			if(admin.getEmail().equals(email)) return false;
		}

		return true;
	}

	//cadastra admin no banco de dados
	public boolean addAdm (Admin adm) {
		if (isAdminDisponivel(adm.getEmail()))
			adms.store(adm);
		adms.commit();
		return true;
	}
				
	//cadastra nova Aula 
		public boolean cadastraAula(String descricao, String data, String duracao, String modalidade, String emailProfessor) {
			addAula(new Aula(descricao, data, duracao, modalidade, emailProfessor));
			return true;
		}
	
	
	//adiciona nova aula ao banco de dados
	public void addAula (Aula aula) {
			aulas.store(aula);
			aulas.commit();
		}
	 
	
	//altera dados de cadastro do aluno
		public void alteraAluno(String nome, String senha, String genero, String email, String ender, String tel, String cpf, String oldEm) {
			Aluno aluno = buscaAluno(oldEm);
			if (!(aluno.getNome().equals(nome))) aluno.setNome(nome);
			if (!(aluno.getSenha().equals(senha))) aluno.setSenha(senha);
			if (!(aluno.getGenero()==genero.charAt(0))) aluno.setGenero(genero.charAt(0));
			if (!(aluno.getEmail().equals(email))) aluno.setEmail(email);
			if (!(aluno.getAdress().equals(ender))) aluno.setAdress(ender);
			if (!(aluno.getTelefone().equals(tel))) aluno.setTelefone(tel);
			alunos.store(aluno);
			alunos.commit();
		}

		//adiciona novo Acesso a Aluno
		public void adcAcessoAluno (String email, String data, String durac){
			Query query = alunos.query();
			query.constrain(Aluno.class);
			List<Aluno> todosAlunos = query.execute();
			for (Aluno aluno:todosAlunos) {
				aluno.getAcessos().add(new Acesso(data, aluno.getId() ,Integer.valueOf(durac)));
				alunos.store(aluno);
				alunos.commit();
				acessos.store(new Acesso(data, aluno.getId() ,Integer.valueOf(durac)));
				acessos.commit();
			}
		}

		//adiciona novo Shape a Aluno
		public void adcShapeAluno (String email, String altura ,String peso ,String circAbdomen ,String igc ,String data) {
			Query query = alunos.query();
			query.constrain(Aluno.class);
			List<Aluno> todosAlunos = query.execute();
			for (Aluno aluno:todosAlunos) {
				if (aluno.getEmail().equals(email)) {
					aluno.getHistoricoShape().add(new Shape(Float.valueOf(altura), Float.valueOf(peso), Float.valueOf(circAbdomen), Float.valueOf(igc),data));
					alunos.store(aluno);
					alunos.commit();
				}
			}
		}

		//adiciona Aula salva no sistema a um aluno
		public Aula matAulaAluno(String email, String nAula){
			Query query = alunos.query();
			query.constrain(Aluno.class);
			List<Aluno> todosAlunos = query.execute();
			Query query2 = aulas.query();
			query.constrain(Aula.class);
			List<Aula> todasAulas = query2.execute();
			for (Aluno aluno:todosAlunos) {
				if (aluno.getEmail().equals(email)) {
					for (Aula aula: todasAulas) {
						if (todasAulas.indexOf(aula)==Integer.valueOf(nAula)){
							Aula aulaMat=aula;
							aluno.getAula().add(aula);
							alunos.store(aluno);
							alunos.commit();
							return aulaMat;
						}
					}
				}
			}
			return null;
		}


		//remove Aula de Aluno
		public Aula desmatAulaAluno(String email, String nAula){
			Query query = alunos.query();
			query.constrain(Aluno.class);
			List<Aluno> todosAlunos = query.execute();
			for (Aluno aluno:todosAlunos) {
				if (aluno.getEmail().equals(email)) {
					for (Aula aula: aluno.getAula()) {
						if (aluno.getAula().indexOf(aula)==Integer.valueOf(nAula)){
							Aula aulaRem=aula;
							aluno.getAula().remove(aula);
							alunos.store(aluno);
							alunos.commit();
							return aulaRem;
						}
					}
				}
			}
			return null;
		}
		
		
		//envia musculacao da lista temporaria do sistema para um aluno
		public boolean inclMuscAluno(String emailAl, String emailProf, String objetivo) {

			Query queryAlun = alunos.query();
			queryAlun.constrain(Aluno.class);
			
			List<Aluno>  todosalunos = queryAlun.execute();
		
			for (Musculacao musc: musculacaoPendente) {
				if (musc.getEmailProfessor().equals(emailProf)) {
					musc.setObjetivo(objetivo);
					for (Aluno alun:todosalunos) {
						if(emailAl.equals(alun.getEmail())) {
							if (alun.getMusculacaoAtual()!=null) {
								alun.getMusculacoes().add(alun.getMusculacaoAtual());
							}
							alun.setMusculacaoAtual(musc);
							musculacaoPendente.remove(musc);
							alunos.store(alun);
							alunos.commit();
							return true;
							
						}
					}	
				}
			}
			
			return false;
		}
		
		//insere exercicio na musculacao temporaria cirada pelo professor
		public List<Exercicio> adcExercicio(String equi, String muscu, String rep, String emailProf) {
			Exercicio ex = new Exercicio(equi, muscu, Integer.valueOf(rep));
			for (Musculacao musc: musculacaoPendente) {
				if (musc.getEmailProfessor().equals(emailProf)) {
					musc.getExercicios().add(ex);
					return musc.getExercicios();
					
				}
			}
			Musculacao musc = new Musculacao(null, emailProf);
			musc.getExercicios().add(ex);
			musculacaoPendente.add(musc);
			return musc.getExercicios();
		}
		
		//retorna todos os alunos salvos
		public List<Aluno> mostAlunos () {
			Query query1 = alunos.query();
			query1.constrain(Aluno.class);
			List<Aluno> todosAlunos = query1.execute();
			return todosAlunos;
			
		}
		
		//retorna todos os professores salvos
			public List<Professor> mostProf () {
				Query query1 = professores.query();
				query1.constrain(Professor.class);
				List<Professor> todosProfs = query1.execute();
				return todosProfs;
				
			}

			//retorna todas as aulas salvas
			public List<Aula> mostAulas(){
				Query query = aulas.query();
				query.constrain(Aula.class);
				return query.execute();
			}
			
			//retorna os acessos salvos
			public List<Acesso> mostAcessos () {
				Query query1 = acessos.query();
				query1.constrain(Acesso.class);
				List<Acesso> todosAcessos = query1.execute();
				return todosAcessos;
				}
			
			//retorna os codigos de acesso disponiveis
			public List<Integer> mostCods () {
				return codigos;			
				}
			

	//retorna a lista de aulas de um aluno
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

	//retorna acessos de um aluno
	public List<Acesso> buscarAcessos(String email){
		Query query = alunos.query();
		query.constrain(Aluno.class);

		List<Aluno> todosAlunos = query.execute();

		for (Aluno aluno:todosAlunos) {
			if (aluno.getEmail().equals(email))
				return aluno.getAcessos();
		}
		return null;
	}

	//retorna shapes de um aluno
	public List<Shape> buscarShapes(String email){
		Query query = alunos.query();
		query.constrain(Aluno.class);

		List<Aluno> todosAlunos = query.execute();

		for (Aluno aluno:todosAlunos) {
			if (aluno.getEmail().equals(email))
				return aluno.getHistoricoShape();
		}
		return null;
	}

	//retorna musculacao atual de um aluno
	public Musculacao getMuscAtual (String email){
		Query query = alunos.query();
		query.constrain(Aluno.class);

		List<Aluno> todosAlunos = query.execute();

		for (Aluno aluno:todosAlunos) {
			if (aluno.getEmail().equals(email)) {
				return aluno.getMusculacaoAtual();
			}
		}
		return null;
	}

	//retorna historico de musculacoes de um aluno
	public List<Musculacao> getHistSeries (String email){
		Query query = alunos.query();
		query.constrain(Aluno.class);

		List<Aluno> todosAlunos = query.execute();

		for (Aluno aluno:todosAlunos) {
			if (aluno.getEmail().equals(email)) {
				return aluno.getMusculacoes();
			}
		}
		return null;
	}

	//retorna aulas criadas por um professor
	public List<Aula> aulaProf(String emailProfessor){
		Query query = aulas.query();
		query.constrain(Aula.class);

		List<Aula> todasAulas = query.execute();
		List<Aula> aulasencontradas = new LinkedList<Aula>();
		for (Aula aula: todasAulas) {
			if (aula.getEmailProfessor().equals(emailProfessor)) {
				aulasencontradas.add(aula);
			}
		}
		return aulasencontradas;
	}


	//busca aluno por cpf
	public Aluno buscaAluno(String email) {
		Query query = alunos.query();
		query.constrain(Aluno.class);
		List<Aluno> todosAlunos = query.execute();
		for (Aluno aluno: todosAlunos) {
			if (aluno.getEmail().equals(email)) return aluno;
		}
		return null;
	}

	//Cria um codigo valido na lista do sistema
	public int novoCodigo(){
		int valorParaInserir = gerarValorCode();
		codigos.add(valorParaInserir);
		return valorParaInserir;
	}

	//Gera um codigo aleatorio
	public int gerarValorCode(){
		Random gerador = new Random();
		int aux = gerador.nextInt(10000);
		return aux;	
	}


	//Valida se codigo esta na lista do sistema
	public int validaCodigo(int passado){
		for(Integer aux: codigos) {
			if(passado == aux) {
				return 1;
			}
		}
		return 0;
	}

	//Remove codigo da lista do sistema
	public void removeCodigo(Integer codigo) {
		for(Integer vez: codigos) {
			if(vez==codigo) {
				codigos.remove(vez);
			}
		}
	}
}
