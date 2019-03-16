import java.util.List;

public class Academia {
	private String nome;
	private String address;
	private String email;
	private List<Acesso> acesso;
	private List<Pessoa> pessoa;
	private List<Aula> aula;
	
	
	public Academia(String nome, String address, String email, List<Acesso> acesso, List<Pessoa> pessoa,
			List<Aula> aula) {
		super();
		this.nome = nome;
		this.address = address;
		this.email = email;
		this.acesso = acesso;
		this.pessoa = pessoa;
		this.aula = aula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Acesso> getAcesso() {
		return acesso;
	}


	public void setAcesso(List<Acesso> acesso) {
		this.acesso = acesso;
	}


	public List<Pessoa> getPessoa() {
		return pessoa;
	}


	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}


	public List<Aula> getAula() {
		return aula;
	}


	public void setAula(List<Aula> aula) {
		this.aula = aula;
	}
	
	
}
