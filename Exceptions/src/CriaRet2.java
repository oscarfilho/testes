
public class CriaRet2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			double lar = Double.parseDouble(args[0]);
			double alt = Double.parseDouble(args[1]);
			
			Retangulo2 ret2 = new Retangulo2(lar, alt);
			System.out.println(ret2);
			
		}catch(Exception ex) {
			System.out.println("Erro durante a execução: " + ex.getMessage());
		}
		
		
		
	}
}
