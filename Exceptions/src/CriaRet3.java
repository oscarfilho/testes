
public class CriaRet3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			double lar = Double.parseDouble(args[0]);
			double alt = Double.parseDouble(args[1]);
			
			Retangulo3 ret3 = new Retangulo3(lar, alt);
			System.out.println(ret3);
			
		}catch(ArrayIndexOutOfBoundsException exc) {
			System.out.println("N�mero de argumentos insuficientes");
		}
		catch (NumberFormatException exc) {
			System.out.println("Argumentos inv�lidos");
		}
		catch (Exception exc) {
			System.out.println("Dimens�es inv�lidas");
		}
		
		
		
	}
}
