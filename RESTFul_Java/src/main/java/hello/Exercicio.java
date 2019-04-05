package hello;

public class Exercicio {
	private String equipamento;
	private String musculo;
	private int repeticao;
	
	
	public Exercicio(String equipamento, String musculo, int repeticao) {
		super();
		this.equipamento = equipamento;
		this.musculo = musculo;
		this.repeticao = repeticao;
	}


	public String getEquipamento() {
		return equipamento;
	}


	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}


	public String getMusculo() {
		return musculo;
	}


	public void setMusculo(String musculo) {
		this.musculo = musculo;
	}


	public int getRepeticao() {
		return repeticao;
	}


	public void setRepeticao(int repeticao) {
		this.repeticao = repeticao;
	}
	
	
}
