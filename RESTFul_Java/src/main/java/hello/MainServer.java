package hello;

import static spark.Spark.*;

import java.util.LinkedList;
import java.util.List;


public class MainServer {
	
	final static Model model = new Model();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8081;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializarCarros();
		inicializarAlunos();
		Controller controller = new Controller(model);
		
		//controller.buscarCarro();
		//controller.buscarCarroPlaca();
		//controller.buscarCarroModelo();
		controller.mostrarAulas();
		controller.loginUser();
		
    }
    
   
    
    public static void inicializarCarros(){
    	model.addCarro(new Carro("AAA-1111", new Especificacao("gol", "vw", "verde")));
    	
    	model.addCarro(new Carro("BBB-1111", new Especificacao("gol", "vw", "verde")));
    	model.addUser(new User("C@A.com","C",1));
    }
    
    //falta inicializar o aluno
    public static void inicializarAlunos() {
    	model.addAluno(new Aluno(1, "Jess", "Rua 1", "C@A.com", "123", "123", 1, null, null, new LinkedList<Aula>()));
    	model.addAula(new Aula (null, "Zumba", "segunda", "50min", null));
    	model.inclAula("Jess", "Zumba");
    	
    }
}
