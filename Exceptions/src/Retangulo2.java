
public class Retangulo2 {
	
	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * Retangulo2 r = new Retangulo2(Double.parseDouble(args[0]),
	 * Double.parseDouble(args[1]));
	 * 
	 * System.out.println(r.toString());
	 * 
	 * }
	 */
	
	private double largura, altura;

	public Retangulo2() {
		this(2, 1);
	}
	
	public Retangulo2(double largura, double altura) {
		this.setTamanho(largura, altura);
	}
	
	public double getLargura() {
		return largura;
	}

	public double getAltura() {
		return altura;
	}
	
	public void setTamanho(double largura, double altura) {
		if(largura > 0 && altura > 0) {
			this.largura = largura;
			this.altura = altura;
		}else {
			throw new RuntimeException("Dimensões inválidas!");
		}
	}
	
	@Override
	public String toString()
	{
		return "Retangulo[largura=" + largura + "], altura=" + altura + "]";
	}
	
}
