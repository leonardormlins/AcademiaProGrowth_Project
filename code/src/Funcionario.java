
public class Funcionario extends Pessoa{
	private String expediente;
	private String descricaoCargo;
		
	
	public Funcionario(int id, String nome, String adress, String email, String telefone, String expediente,
			String descricaoCargo, String senha) {
		super(id, nome, adress, email, telefone, senha);
		this.expediente = expediente;
		this.descricaoCargo = descricaoCargo;
	}
	
	
	public String getExpediente() {
		return expediente;
	}
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	public String getDescricaoCargo() {
		return descricaoCargo;
	}
	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}
	
}
