package hello;

import java.util.LinkedList;
import java.util.List;

public class Professor extends Funcionario {
	
	
	
	public Professor(int id, String nome, String adress, String email, String telefone, String expediente,
			String descricaoCargo, String senha, char genero, int tipo) {
		super(id, nome, adress, email, telefone, expediente, descricaoCargo, senha, genero, tipo);
		this.aula = new LinkedList<Aula>();
	}
	

	
	
	
}

