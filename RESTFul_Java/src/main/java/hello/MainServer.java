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

		inicializarAlunos();
		Controller controller = new Controller(model);
		
		controller.loginUser();
	    	controller.buscarAulasAluno();
	    	controller.cadastrar();
	    	controller.mostAlunos();
	    	controller.alterar();
	    	controller.desmatAulaAluno();
	    	controller.adcAcessoAluno();
	    	controller.adcShapeAluno();
	    	controller.buscarAcessosAluno();
	    	controller.buscarShapesAluno();
	    	controller.cadastrarProf();
	    	controller.mostAulas();
	    	controller.matAulaAluno();
	    	controller.cadastrarAdmin();
	    	controller.getMuscAtual();
	    	controller.getHistSeries();


		
    }
    
   
    
    
    public static void inicializarAlunos() {
    	model.addAluno(new Aluno(1, "Jess", "Rua 1", "C@A.com", "123", "C", 'F',  1, null, null, new LinkedList<Aula>()));
    	model.addAula(new Aula (null, "Zumba", "segunda", "50min", new Modalidade (01,"Zumba")));
    	model.addAula(new Aula (null, "Boxe", "terça", "50min",  new Modalidade (02,"Boxe")));
    	model.addAula(new Aula (null, "Spinning", "Quarta", "50min", new Modalidade (03,"Spinning")));

    
    	
    }
}
