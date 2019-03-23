package hello;

public class Danca extends Modalidade{
	private String ritmo;
	private int level;
	
	public Danca(int id, String descricao, String ritmo, int level) {
		super(id, descricao);
		this.ritmo = ritmo;
		this.level = level;
	}

	public String getRitmo() {
		return ritmo;
	}

	public void setRitmo(String ritmo) {
		this.ritmo = ritmo;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
