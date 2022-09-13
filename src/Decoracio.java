import java.util.Objects;
import java.util.Scanner;

public class Decoracio {

	String material;
	double preu;
	//int cantidad_deco;
	
	public Decoracio(String material, double preu) {
		this.material = material;
		this.preu = preu;
		//this.cantidad_deco =0;
	}
	
public static Floristeria agregar(Floristeria floris) {
		
		System.out.println("Introduce el material de la decoración");
		Scanner mat_deco = new Scanner(System.in);
		String matDeco = mat_deco.next();
		
		System.out.println("Introduce el precio de la decoración");
		Scanner preu_deco = new Scanner(System.in);
		double preuDeco = preu_deco.nextDouble();
	
		int i =0;

		
		if(floris.decoracio.isEmpty()) {
			floris.decoracio.add(new Decoracio (matDeco, preuDeco));
			//floris.decoracio.get(i).cantidad_deco = floris.decoracio.get(i).cantidad_deco +1;
			System.out.println("Se agrega primera decoración al stock");
		}else {

			boolean c = false;
			floris.decoracio.add(new Decoracio (matDeco, preuDeco));
			do {
				if(floris.decoracio.get(i).material.equalsIgnoreCase(matDeco)) {
					c =true;
					
					//floris.decoracio.get(i).cantidad_deco = (floris.decoracio.get(i).cantidad_deco) + 1;
					System.out.println("Decoración: " + floris.decoracio.get(i).material +  " ya existe, se agrega al stock.");
				};
				if(i == (floris.decoracio.size())-1 && c == false)
				{	
					
					System.out.println("Se ha hecho la comprobación y la decoración no existe, así que se agrega al stock");
				};
				i++;
				
			}while (c==false);
				
		}
		
		return floris;
	}

public static Floristeria delete(Floristeria floris) {
	// TODO Auto-generated method stub
	System.out.println("Introduce el nombre del material de la decoración a eliminar");
	Scanner mat_deco = new Scanner(System.in);
	String matDeco = mat_deco.next();
	
	boolean c = false;
	int i=0;
	do {
		if(floris.decoracio.get(i).material.equalsIgnoreCase(matDeco)) {
			c=true;
			floris.decoracio.remove(i);
		}
		if (i == (floris.decoracio.size())-1 && c == false) {
			System.out.println("No existe esta decoración en el stock");
		}
		i++;
	}while(c==false);
	
	return floris;
}

@Override
public int hashCode() {
	return Objects.hash(material, preu);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Decoracio other = (Decoracio) obj;
	return Objects.equals(material, other.material)
			&& Double.doubleToLongBits(preu) == Double.doubleToLongBits(other.preu);
}

}
