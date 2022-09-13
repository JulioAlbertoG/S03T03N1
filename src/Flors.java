import java.util.Objects;
import java.util.Scanner;

public class Flors {
	
	String nom_flor;
	String color;
	double preu;
//	int cantidadFlor;
	
	public Flors(String nom_flor, String color, double preu) {
		this.nom_flor = nom_flor;
		this.color = color;
		this.preu = preu;
		//this.cantidadFlor = 0;
	}

	//No puedo usar getters and setters porque tengo que construir y retornar el objeto entero para agregarlo al arreglo
	public static Floristeria agregar(Floristeria floris) {
		
		System.out.println("Introduce el nombre de la flor");
		Scanner nom_flor = new Scanner(System.in);
		String nomFlor = nom_flor.next();
		
		System.out.println("Introduce el color de la flor");
		Scanner color_flor = new Scanner(System.in);
		String colorFlor = color_flor.next();
		
		System.out.println("Introduce el precio de la flor");
		Scanner preu_flor = new Scanner(System.in);
		double preuFlor = preu_flor.nextDouble();
		int i =0;

		if(floris.flors.isEmpty()) {
			floris.flors.add(new Flors (nomFlor, colorFlor, preuFlor));
			//floris.flors.get(i).cantidadFlor = floris.flors.get(i).cantidadFlor +1;
			System.out.println("Se agrega primera flor al stock");
		}else {
			boolean c = false;
			floris.flors.add(new Flors (nomFlor, colorFlor, preuFlor));
			do {
				if(floris.flors.get(i).nom_flor.equalsIgnoreCase(nomFlor) && floris.flors.get(i).color.equalsIgnoreCase(colorFlor)) {
					c =true;
					System.out.println("Flor: " + floris.flors.get(i).nom_flor + "€ ya existe, se agrega al stock.");
				};
				if(i == (floris.flors.size())-1 && c == false)
				{	
					
					System.out.println("Se ha hecho la comprobación y la flor no existe, así que se agrega al stock");
				};
				i++;
				
			}while (c==false);
				
		}
		
		return floris;
	}

	public static Floristeria delete(Floristeria floris) {
		System.out.println("Introduce el nombre de la flor a eliminar");
		Scanner nom_flor = new Scanner(System.in);
		String nomFlor = nom_flor.next();
		
		System.out.println("Introduce el color de la flor a eliminar");
		Scanner color_flor = new Scanner(System.in);
		String colorFlor = color_flor.next();
		
		boolean c = false;
		int i=0;
		do {
			if(floris.flors.get(i).nom_flor.equalsIgnoreCase(nomFlor) && floris.flors.get(i).color.equalsIgnoreCase(colorFlor)) {
				c=true;
				floris.flors.remove(i);

			}
			if (i == (floris.flors.size())-1 && c == false) {
				System.out.println("No existe esta flor en el stock");
			}
			i++;
		}while(c==false);
		
		return floris;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, nom_flor, preu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flors other = (Flors) obj;
		return Objects.equals(color, other.color) && Objects.equals(nom_flor, other.nom_flor)
				&& Double.doubleToLongBits(preu) == Double.doubleToLongBits(other.preu);
	}


}
