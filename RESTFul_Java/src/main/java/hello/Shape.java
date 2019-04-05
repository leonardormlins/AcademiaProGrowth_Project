package hello;

public class Shape {
	private float altura;
	private float peso;
	private float circAbdomen;
	private float igc;
	private String data;
	
	
	public Shape(float altura, float peso, float circAbdomen, float igc, String data) {
		super();
		this.altura = altura;
		this.peso = peso;
		this.circAbdomen = circAbdomen;
		this.igc = igc;
		this.data = data;
	}


	public float getAltura() {
		return altura;
	}


	public void setAltura(float altura) {
		this.altura = altura;
	}


	public float getPeso() {
		return peso;
	}


	public void setPeso(float peso) {
		this.peso = peso;
	}


	public float getCircAbdomen() {
		return circAbdomen;
	}


	public void setCircAbdomen(float circAbdomen) {
		this.circAbdomen = circAbdomen;
	}


	public float getIgc() {
		return igc;
	}


	public void setIgc(float igc) {
		this.igc = igc;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
	
}
