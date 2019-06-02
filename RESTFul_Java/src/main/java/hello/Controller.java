package hello;

import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {
	
	private Model model;
	
	
	public Controller(Model model){
		this.model = model;
	}
	
	
	public void loginUser(){
		get("/login/:email/:senha", (req, res) -> {
			Pessoa encontrado = model.loginUser(req.params(":email"),req.params(":senha"));	
			return new Gson().toJson(encontrado);
			
		});
	}
		
	public void buscarAulasAluno(){
		get("/aulas/:email", (req, res) -> {
			List<Aula> aulasEncontradas = model.buscarAulasAluno(req.params(":email"));	
			return new Gson().toJson(aulasEncontradas);	
		});
	}
	
	public void cadastrar(){
		get("/cadpessoa/:nome/:senha/:genero/:email/:ender/:tel/:cpf", (req, res) -> {
				model.cadastrarAluno(req.params(":nome"),req.params(":senha"),req.params(":genero"),req.params(":email"),req.params(":ender"),req.params(":tel"),req.params(":cpf"));	
				return new Gson().toJson("Cadastrado!");
		});
	}
	
	public void mostAlunos(){
		get("/most/aluno/", (req, res) -> {
			return new Gson().toJson(model.mostAlunos());	
		});
	}
	
	public void desmatAulaAluno(){
		get("/desmat/:email/aula/:id", (req, res) -> {
			return new Gson().toJson(model.desmatAulaAluno(req.params(":email"),req.params(":id")));	
		});
	}
	
		
		
	public void alterar(){
			get("/alterar/:nome/:senha/:genero/:email/:ender/:tel/:cpf", (req, res) -> {
					model.alteraAluno(req.params(":nome"),req.params(":senha"),req.params(":genero"),req.params(":email"),req.params(":ender"),req.params(":tel"),req.params(":cpf"));	
					return new Gson().toJson("Alterado!");
			});
	}
	
	public void adcAcessoAluno() {
			get("/adcAcesso/:email/:acessoDia/:acessoDurac", (req, res) -> {
				model.adcAcessoAluno(req.params(":email"), req.params(":acessoDia"), req.params(":acessoDurac"));
				return new Gson().toJson("Acesso adcioanado!");
			});
	}
	
	public void adcShapeAluno() {
		get("/adcShape/:email/:altura/:peso/:circAbdomen/:igc/:data",  (req, res) -> {
			model.adcShapeAluno(req.params(":email"), req.params(":altura") ,req.params(":peso"),req.params(":circAbdomen"),req.params(":igc"),req.params(":data"));
			return "Shape adcioanado!";
		});
	}
	
	public void getMuscAtual() {
		get("/getmuscatual/:email",  (req, res) -> {
			return new Gson().toJson(model.getMuscAtual(req.params(":email")));
		});
	}
	
	public void getHistSeries() {
		get("/gethistseries/:email/",  (req, res) -> {
			return new Gson().toJson(model.getHistSeries(req.params(":email")));
		});
	}
	
	public void cadastrarProf(){
		get("/cadprof/:nome/:senha/:genero/:email/:ender/:tel/:cpf/:expediente/:descricaocargo", (req, res) -> {
			Professor pf = model.cadastrarProf(req.params(":nome"),req.params(":senha"),req.params(":genero"),req.params(":email"),req.params(":ender"),req.params(":tel"),req.params(":cpf"),req.params(":expediente"),req.params(":descricaocargo"));
				return new Gson().toJson(pf);
		});
	}
	
	
	public void cadastrarAdmin(){
		get("/cadadm/:nome/:senha/:genero/:email/:ender/:tel/:cpf/", (req, res) -> {
			model.cadastrarAdmin(req.params(":nome"),req.params(":senha"),req.params(":genero"),req.params(":email"),req.params(":ender"),req.params(":tel"),req.params(":cpf"));
				return new Gson().toJson("Cadastrado");
		});
	}
	
	public void buscarAcessosAluno(){
		get("/acessos/:email", (req, res) -> {
			List<Acesso> acessosEncontrados = model.buscarAcessos(req.params(":email"));	
			return new Gson().toJson(acessosEncontrados);	
		});
	}
	
	public void buscarShapesAluno(){
		get("/shapes/:email", (req, res) -> {
			List<Shape> shapesEncontrados = model.buscarShapes(req.params(":email"));	
			return new Gson().toJson(shapesEncontrados);	
		});
	}
	
}
