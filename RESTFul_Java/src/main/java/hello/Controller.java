package hello;

import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {
	
	private Model model;
	
	
	public Controller(Model model){
		this.model = model;
	}
	
	
	//realiza login, retornando o objeto do tipo de usuario (Aluno, Professor, Admin)
	public void loginUser(){
		get("/login/:email/:senha", (req, res) -> {
			Pessoa encontrado = model.loginUser(req.params(":email"),req.params(":senha"));	
			return new Gson().toJson(encontrado);
			
		});
	}
	
	
	
	//realiza cadastro de aluno, sendo necessario o codigo de acesso enviado pelo Admini
	public void cadastrar(){
		get("/cadpessoa/:nome/:senha/:genero/:email/:ender/:tel/:cpf/:cod", (req, res) -> {
				model.cadastrarAluno(req.params(":nome"),req.params(":senha"),req.params(":genero"),req.params(":email"),req.params(":ender"),req.params(":tel"),req.params(":cpf"),req.params(":cod"));	
				return new Gson().toJson("Cadastrado!");
		});
	}
	
	
	//realiza cadastro de professor
	public void cadastrarProf(){
		get("/cadprof/:nome/:senha/:genero/:email/:ender/:tel/:cpf/:expediente/:descricaocargo", (req, res) -> {
				model.cadastrarProf(req.params(":nome"),req.params(":senha"),req.params(":genero"),req.params(":email"),req.params(":ender"),req.params(":tel"),req.params(":cpf"),req.params(":expediente"),req.params(":descricaocargo"));	
				return new Gson().toJson("Cadastrado!");
		});
	}
		
	
	//realiza cadastro de Admin
	public void cadastrarAdmin(){
		get("/cadadm/:nome/:senha/:genero/:email/:ender/:tel/:cpf/", (req, res) -> {
			model.cadastrarAdmin(req.params(":nome"),req.params(":senha"),req.params(":genero"),req.params(":email"),req.params(":ender"),req.params(":tel"),req.params(":cpf"));
				return new Gson().toJson("Cadastrado");
		});
	}
	
	//cadastra aula
	public void cadastraAula(){
		get("/prof/incluir/aula/:desc/:data/:dura/:modal/:emailprof", (req, res) -> {
			
			return new Gson().toJson(model.cadastraAula(req.params(":desc"),req.params(":data"),req.params(":dura"),req.params(":modal"), req.params(":emailprof")));	
		});
	}
	
	//altera dados de cadastro de aluno
	public void alterar(){
		get("/alterar/:oldEm/:nome/:senha/:genero/:email/:ender/:tel/:cpf", (req, res) -> {
				model.alteraAluno(req.params(":nome"),req.params(":senha"),req.params(":genero"),req.params(":email"),req.params(":ender"),req.params(":tel"),req.params(":cpf"),req.params(":oldEm"));	
				return new Gson().toJson("Alterado!");
		});
	}
	
	//adiciona Acesso a um aluno
	public void adcAcessoAluno() {
		get("/adcAcesso/:email/:acessoDia/:acessoDurac", (req, res) -> {
			model.adcAcessoAluno(req.params(":email"), req.params(":acessoDia"), req.params(":acessoDurac"));
			return new Gson().toJson("Acesso adcioanado!");
		});
	}
	
	//adiciona Shape a um aluno
	public void adcShapeAluno() {
		get("/adcShape/:email/:altura/:peso/:circAbdomen/:igc/:data",  (req, res) -> {
			model.adcShapeAluno(req.params(":email"), req.params(":altura") ,req.params(":peso"),req.params(":circAbdomen"),req.params(":igc"),req.params(":data"));
			return "Shape adcioanado!";
		});
	}
	
	//matricula um aluno em uma aula
	public void matAulaAluno(){
		get("/matricular/:email/aula/:id", (req, res) -> {
			return new Gson().toJson(model.matAulaAluno(req.params(":email"),req.params(":id")));	
		});
	}
	
	//desmatricula um aluno de uma aula
	public void desmatAulaAluno(){
		get("/desmat/:email/aula/:id", (req, res) -> {
			return new Gson().toJson(model.desmatAulaAluno(req.params(":email"),req.params(":id")));	
		});
	}
	
	//realiza o envio de uma série de musculação da lista de musculações provisórias para um aluno
		public void incluirMuscAluno(){
		get("/prof/incluir/musc/aluno/:emailal/:emailprof/:obj", (req, res) -> {				
				return new Gson().toJson(model.inclMuscAluno((req.params(":emailal")),req.params(":emailprof"),req.params(":obj")));	
			});
		}
	
	//inclui exercicios em uma lista de musculação provisoria do professor
	public void incluirSerie(){
		get("/prof/incluir/serie/:equi/:muscu/:rep/:emailprof", (req, res) -> {
				return new Gson().toJson(model.adcExercicio((req.params(":equi")),req.params(":muscu"),req.params(":rep"),req.params(":emailprof")));	
			});
		}
	
	//retorna todos os alunos cadastrados
	public void mostAlunos(){
		get("/most/aluno/", (req, res) -> {
			return new Gson().toJson(model.mostAlunos());	
		});
	}
	
	//retorna todos os professores cadastrados
	public void mostProf(){
		get("/most/prof/", (req, res) -> {
			return new Gson().toJson(model.mostProf());	
		});
	}
	
	//retorna todas as aulas salvas
	public void mostAulas(){
		get("/most/aulas/", (req, res) -> {
			return new Gson().toJson(model.mostAulas());	
		});
	}
	//retorna todos os acessos salvos
	public void mostAcessos(){
		get("/most/acessos/", (req, res) -> {
			return new Gson().toJson(model.mostAcessos());	
		});
	}	
	
	//retorna todos os codigos salvos
	public void mostCods(){
		get("/most/cods/", (req, res) -> {
			return new Gson().toJson(model.mostCods());	
		});
	}
	
	
	//retorna todas as aulas de um aluno
	public void buscarAulasAluno(){
		get("/aulas/:email", (req, res) -> {
			List<Aula> aulasEncontradas = model.buscarAulasAluno(req.params(":email"));	
			return new Gson().toJson(aulasEncontradas);	
		});
	}
	
	//retorna todos os acessos de um aluno	
	public void buscarAcessosAluno(){
		get("/acessos/:email", (req, res) -> {
			List<Acesso> acessosEncontrados = model.buscarAcessos(req.params(":email"));	
			return new Gson().toJson(acessosEncontrados);	
		});
	}
	
	//retorna todos os shapes de um aluno	
	public void buscarShapesAluno(){
		get("/shapes/:email", (req, res) -> {
			List<Shape> shapesEncontrados = model.buscarShapes(req.params(":email"));	
			return new Gson().toJson(shapesEncontrados);	
		});
	}
	
	//retorna a serie de musculacao atual de um aluno	
	public void getMuscAtual() {
		get("/getmuscatual/:email",  (req, res) -> {
			return new Gson().toJson(model.getMuscAtual(req.params(":email")));
		});
	}
	
	//retorna o historico de series de musculacao de um aluno	
	public void getHistSeries() {
		get("/gethistseries/:email/",  (req, res) -> {
			return new Gson().toJson(model.getHistSeries(req.params(":email")));
		});
	}
	
	//retorna as aulas cadastradas com o email de um professor
	public void aulaProf(){
		get("/most/aulasProf/:emailprof", (req, res) -> {
			return new Gson().toJson(model.aulaProf(req.params(":emailprof")));	
		});
	}
	
	//adiciona um codigo de acesso à lista de códigos disponíveis
	public void getAddCod() {
		get("/codigo/novo", (req, res) -> {
			return new Gson().toJson(model.novoCodigo());
		} );
	}
	
	//valida se um codigo esta na lista de codigos do sistema
	public void validaCode() {
		get("/valida/:code", (req, res) -> {
			if(model.validaCodigo(Integer.valueOf(req.params(":code")))==1) {
				return new Gson().toJson(1);
		}
			return new Gson().toJson(0);
		});
	}
	
	//remove um codigo da lista do sistema
	public void removeCode() {
		get("/codigo/remove/:valor", (req, res) -> {
			model.removeCodigo(Integer.parseInt(req.params(":valor")));
			return new Gson().toJson("Deletado!");
		});
	}

}
