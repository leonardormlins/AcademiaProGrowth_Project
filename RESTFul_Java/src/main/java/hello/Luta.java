package hello;

public class Luta extends Modalidade{
	private String tipo; //seria modalidade, mas creio que tipo seria melhor para não confundir com a classe modalidade

	public Luta(int id, String descricao, String tipo) {
		super(id, descricao);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
