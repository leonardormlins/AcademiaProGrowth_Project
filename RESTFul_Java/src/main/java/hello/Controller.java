package hello;

import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {
	
	private Model model;
	
	
	public Controller(Model model){
		this.model = model;
	}
	
	
	
	public void mostrarAulas(){
		get("/:usuario/aulas", (req, res) -> {
			List<Aula> aulas = model.aulaAluno(req.params(":usuario"));
			return new Gson().toJson(aulas);
		});
	}
	
	public void loginUser(){
		get("/login/:email/:senha", (req, res) -> {
			User encontrado = model.loginUser(req.params(":email"),req.params(":senha"));	
			return new Gson().toJson(encontrado);
			
		});
	}
		
	public void buscarAulasAluno(){
		get("/aulas/:user", (req, res) -> {
			List<Aula> aulasEncontradas = model.buscarAulasAluno(req.params(":user"));	
			return new Gson().toJson(aulasEncontradas);	
		});
	}

}
