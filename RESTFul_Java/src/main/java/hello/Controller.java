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
			Aluno encontrado = model.loginUser(req.params(":email"),req.params(":senha"));	
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
		
		
	public void alterar(){
			get("/alterar/:nome/:senha/:genero/:email/:ender/:tel/:cpf", (req, res) -> {
					model.alteraAluno(req.params(":nome"),req.params(":senha"),req.params(":genero"),req.params(":email"),req.params(":ender"),req.params(":tel"),req.params(":cpf"));	
					return new Gson().toJson("Alterado!");
			});
	}

}
