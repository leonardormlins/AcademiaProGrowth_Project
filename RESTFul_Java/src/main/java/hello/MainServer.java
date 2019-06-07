package hello;

import static spark.Spark.*;




public class MainServer {
	
	final static Model model = new Model();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 9090;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");


		Controller controller = new Controller(model);
		
			controller.loginUser();
    		controller.cadastrar();
    		controller.cadastrarProf();
    		controller.cadastrarAdmin();
    		controller.cadastraAula();
    		controller.alterar();
    		controller.adcAcessoAluno();
	    	controller.adcShapeAluno();
	    	controller.matAulaAluno();
	    	controller.desmatAulaAluno();
	    	controller.incluirMuscAluno();
	    	controller.incluirSerie();
    		controller.mostAlunos();
    		controller.mostProf();
	    	controller.mostAulas();
	    	controller.mostAcessos();
	    	controller.mostCods();
	    	controller.buscarAulasAluno();
	    	controller.buscarAcessosAluno();
	    	controller.buscarShapesAluno();
	    	controller.getMuscAtual();
	    	controller.getHistSeries();
	    	controller.aulaProf();
	    	controller.getAddCod();
	    	controller.validaCode();
	    	controller.removeCode();
	    	teste();
	    	
		
    }
    
    static void teste() {
    	model.addAluno(new Aluno (123,"Aluno1", "Endereco", "aluno@aluno.com","11", "A", 'M',  1));
    	model.cadastrarProf("Prof", "P", "M", "prof@prof.com", "Endereco", "111", "124", "Diurno", "Professor de musculacao");
    	model.cadastrarAdmin("Admin", "A", "M", "admin@admin.com", "Endereco", "111", "125");
    }
   
}
