
public class Retangulo3 {
	
	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * try {
	 * 
	 * Retangulo3 r = new Retangulo3(); r.setTamanho(Double.parseDouble(args[0]),
	 * Double.parseDouble(args[1])); System.out.println(r.toString());
	 * 
	 * }catch(Exception ex) { System.out.println(ex.getMessage()); }
	 * 
	 * 
	 * 
	 * }
	 */
	
	private double largura, altura;

	public Retangulo3() throws Exception {
		this(2, 1);
	}
	
	
	public Retangulo3(double lar, double alt) throws Exception{
		this.setTamanho(lar, alt);
	}

	public double getLargura() {
		return largura;
	}

	public double getAltura() {
		return altura;
	}
	
	public void setTamanho(double largura, double altura) throws Exception{
		if(largura > 0 && altura > 0) {
			this.largura = largura;
			this.altura = altura;
		}else {
			throw new Exception("Dimensões inválidas!");
		}
	}
	
	@Override
	public String toString()
	{
		return "Retangulo3[largura=" + largura + "], altura=" + altura + "]";
	}
	
}
