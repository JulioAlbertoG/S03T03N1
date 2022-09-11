import java.util.Scanner;

public class Arbres {
	
	String nom_arbre;
	double alcada;
	double preu;
	int cantidad_arb;
	
	public Arbres(String nom_arbre, double alcada, double preu) {
		this.nom_arbre = nom_arbre;
		this.alcada = alcada;
		this.preu = preu;
		this.cantidad_arb = 0;
	}
	
public static Floristeria agregar(Floristeria floris) {
		
		System.out.println("Introduce el nombre del árbol");
		Scanner nom_arbre = new Scanner(System.in);
		String nomArbre = nom_arbre.next();
		
		System.out.println("Introduce la altura del árbol");
		Scanner alcada = new Scanner(System.in);
		double alcadaArbre = alcada.nextDouble();
		
		System.out.println("Introduce el precio del árbol");
		Scanner preu = new Scanner(System.in);
		double preuArbre = preu.nextDouble();
	
		int i =0;
		if(floris.arbres.isEmpty()) {
			floris.arbres.add(new Arbres (nomArbre, alcadaArbre, preuArbre));
			floris.arbres.get(i).cantidad_arb = floris.arbres.get(i).cantidad_arb +1;
			System.out.println("Se agrega primer árbol al stock");
		}else {
			
			
			boolean c = false;
			do {
				if(floris.arbres.get(i).nom_arbre.equalsIgnoreCase(nomArbre) && floris.arbres.get(i).alcada == alcadaArbre) {
					c =true;
					floris.arbres.get(i).cantidad_arb = (floris.arbres.get(i).cantidad_arb) + 1;
					System.out.println("Árbol: " + floris.arbres.get(i).nom_arbre + ", Cantidad: " + floris.arbres.get(i).cantidad_arb);
				};
				if(i == (floris.arbres.size())-1 && c == false)
				{	
					floris.arbres.add(new Arbres (nomArbre, alcadaArbre, preuArbre));
					
					System.out.println("Se ha hecho la comprobación y el árbol no existe, así que se agrega al stock");
				};
				i++;
				
			}while (c==false);
				
		}
		
		return floris;
		
	}

public static Floristeria delete(Floristeria floris) {
	// TODO Auto-generated method stub
	System.out.println("Introduce el nombre del árbol a eliminar");
	Scanner nom_arbre = new Scanner(System.in);
	String nomArbre = nom_arbre.next();
	
	System.out.println("Introduce la altura del árbol a eliminar");
	Scanner alcada = new Scanner(System.in);
	double alcadaArbre = alcada.nextDouble();
	
	boolean c = false;
	int i=0;
	do {
		if(floris.arbres.get(i).nom_arbre.equalsIgnoreCase(nomArbre) && floris.arbres.get(i).alcada == alcadaArbre) {
			c=true;
			if(floris.arbres.get(i).cantidad_arb == 0) {
				floris.arbres.remove(i);
			}else {
				floris.arbres.get(i).cantidad_arb = (floris.arbres.get(i).cantidad_arb)-1;
			}
		}
		if (i == (floris.arbres.size())-1 && c == false) {
			System.out.println("No existe este árbol en el stock");
		}
		i++;
	}while(c==false);
	
	return floris;
}


}
