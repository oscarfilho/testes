package br.com.estudos;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite um valor inteiro: ");
		i = scan.nextInt();
		
		System.out.print("Valor Digitado: " + i);
		
		scan.close();
	}

}
