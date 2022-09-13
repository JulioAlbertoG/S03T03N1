import java.util.ArrayList;
import java.util.Scanner;

public class Ticket {


	//S’ha de crear una classe ticket, on poder registrar les compres en UNA sola llista.

	Floristeria floristeria;
	 ArrayList<Arbres> arbres;
	 ArrayList<Flors> flors;
	 ArrayList<Decoracio> decoracio;
	 

	

	public Ticket() {
		
		this.arbres = new ArrayList<Arbres>();
		this.flors = new ArrayList<Flors>();
		this.decoracio = new ArrayList<Decoracio>();	
	}

	
	public static Floristeria compra(Floristeria floris) {
		boolean comprar=true;
		
		Ticket t = new Ticket();

		do {
			
			System.out.println("Elige el producto que quieres incluir al ticket");
			System.out.println("1: Comprar flor");
			System.out.println("2: Comprar árbol");
			System.out.println("3: Comprar decoración");
			System.out.println("4: Salir de la sección comprar");
			Scanner choice = new Scanner(System.in);
			int selection = choice.nextInt();

			switch(selection) {
			case 1:{
				
				System.out.println("Introduce el nombre de la flor");
				Scanner nom_flor = new Scanner(System.in);
				String nomFlor = nom_flor.next();
			
				System.out.println("Introduce el color de la flor");
				Scanner color_flor = new Scanner(System.in);
				String colorFlor = color_flor.next();
				
				
				
				if(floris.flors.size() != 0) {

					boolean c = false;
					int i=0;
					do {
						if(floris.flors.get(i).nom_flor.equalsIgnoreCase(nomFlor) && floris.flors.get(i).color.equalsIgnoreCase(colorFlor)) {
							c=true;
							t.flors.add(floris.flors.get(i));
							floris.flors.remove(i);

						}
						if (i == (floris.flors.size())-1 && c == false) {
							System.out.println("No existe esta flor en el stock");
						}
						i++;
					}while(c==false);

				}
				break;
			}
			case 2:{
				
				System.out.println("Introduce el nombre del árbol");
				Scanner nom_arbre = new Scanner(System.in);
				String nomArbre = nom_arbre.next();
				
				System.out.println("Introduce la altura del árbol");
				Scanner alcada = new Scanner(System.in);
				double alcadaArbre = alcada.nextDouble();
				
				if(floris.arbres.size() != 0) {

					boolean c = false;
					int i=0;
					do {
						if(floris.arbres.get(i).nom_arbre.equalsIgnoreCase(nomArbre) && floris.arbres.get(i).alcada == alcadaArbre) {
							c=true;
							t.arbres.add(floris.arbres.get(i));
							floris.arbres.remove(i);

						}
						if (i == (floris.arbres.size())-1 && c == false) {
							System.out.println("No existe este árbol en el stock");
						}
						i++;
					}while(c==false);
				
				}
				
				break;
			}
			case 3:{
				
				System.out.println("Introduce el nombre del material de la decoración");
				Scanner mat_deco = new Scanner(System.in);
				String matDeco = mat_deco.next();
				
				if(floris.decoracio.size() != 0) {

					boolean c = false;
					int i=0;
					do {
						if(floris.decoracio.get(i).material.equalsIgnoreCase(matDeco)) {
							c=true;
							t.decoracio.add(floris.decoracio.get(i));
							floris.decoracio.remove(i);

						}
						if (i == (floris.decoracio.size())-1 && c == false) {
							System.out.println("No existe este material de decoración en el stock");
						}
						i++;
					}while(c==false);
					
			
				}
				break;
			}
			case 4:{

				comprar=false;
				double total=0;
				System.out.println("Compra finalizada: ");

				for(Flors f: t.flors) {
					total += f.preu;
					System.out.println(f.nom_flor + " " + f.preu);
				}
				for(Arbres a: t.arbres) {
					
					total += a.preu;
					System.out.println(a.nom_arbre + " " + a.preu);
				}
				for(Decoracio d: t.decoracio) {
					
					total += d.preu;
					System.out.println(d.material + " " + d.preu);
				}
				System.out.println("Total a pagar: " + total + "€");
				floris.tickets.add(t);

				break;
			}
		
			}
			Fitxer.escribirFit(floris.nom_floris, floris);
		}while(comprar!=false);

		return floris;
	}

	public void listar_contenido_ticket(Floristeria floris) {
		
		double total=0;
		for(Flors f: this.flors) {
			total += f.preu;
			System.out.println(f.nom_flor + " " + f.preu);
		}
		for(Arbres a: this.arbres) {
			total += a.preu;
			System.out.println(a.nom_arbre + " " + a.preu);
		}
		for(Decoracio d: this.decoracio) {
			total += d.preu;
			System.out.println(d.material + " " + d.preu);
		}
		System.out.println("Total a pagar: " + total + "€");
	}
	
	public double valor_ticket(Floristeria floris) {
		//La floristeria valor_ticketté un registre del valor total de l'stock que té.
		double valor_ticket=0;
		if(flors.size() != 0) {
			for(Flors flor:flors) { 
				valor_ticket += flor.preu;
			}
		}
		if(arbres.size() != 0) {
			for(Arbres arbre:arbres) {
				valor_ticket += arbre.preu;
			}
		}
		if(decoracio.size() != 0) {
			for(Decoracio decor:decoracio) {
				valor_ticket += decor.preu;
			}
		}
		return valor_ticket;
	
	}

}
