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
            port = 8180;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializarCarros();

		Controller controller = new Controller(model);
		
		controller.buscarCarro();
		controller.buscarCarroPlaca();
		controller.buscarCarroModelo();
		
		controller.mostrarInfo();
		
    }
    
    public static void inicializarCarros(){
    	model.addCarro(new Carro("AAA-1111", new Especificacao("gol", "vw", "verde")));
    	
    	model.addCarro(new Carro("BBB-1111", new Especificacao("gol", "vw", "verde")));
    }

	
}
