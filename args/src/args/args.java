//package args;

public class args {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length > 0) {
			for(int j = Integer.parseInt(args[0]); j > 0; j--)
			{
				System.out.println(j);
			}
		}else
		{
			System.out.println("Digite um parametro após o nome do programa na linha de comando.");
		}
	}

}
