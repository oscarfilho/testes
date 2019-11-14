package testes;

public class Object {

	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		
		Object c = a;
		
		System.out.println("Object \"a\" hashcode: " + a.hashCode());
		System.out.println("Object \"b\" hashcode: " + b.hashCode());
		System.out.println("Object \"c\" hashcode: " + c.hashCode());
		
		System.out.println("a==b " + a.equals(b) + " | b==a " + b.equals(a));
		System.out.println("b==c " + b.equals(c) + " | c==b " + c.equals(b));
		System.out.println("c==a " + c.equals(a) + " | a==c " + a.equals(c));
		
		
	}

}
