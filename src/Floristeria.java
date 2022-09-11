import java.util.ArrayList;

public class Floristeria {
	
	String nom_floris;
	ArrayList<Arbres> arbres;
	ArrayList<Flors> flors;
	ArrayList<Decoracio> decoracio;
	ArrayList<Ticket> tickets;
	
	public Floristeria(String nom_floris) {
		this.nom_floris= nom_floris;
		this.flors = new ArrayList<Flors>();
		this.arbres = new ArrayList<Arbres>();
		this.decoracio = new ArrayList<Decoracio>();
		this.tickets = new ArrayList<Ticket>();
		
	}
	
	public void crearFloris(String nom_floris) {
		Floristeria floristeria = new Floristeria(nom_floris);
	}
	
	public void stock_producte() {
		//Una floristeria ha de tenir un stock de cada un dels productes (arbres, flors i decoració).
		if(flors.size() != 0) {
			for(Flors flor:flors) {
				System.out.println("Flor: " + flor.nom_flor + ", precio: " + flor.preu + ", color: " + flor.color + ", cantidad: " + flor.cantidadFlor + ".");
			}
		}else {
			System.out.println("No hay flores que mostrar.");
		}
		if(arbres.size() != 0) {
			for(Arbres arbre:arbres) {
				System.out.println("Árbol: " + arbre.nom_arbre + ", precio: " + arbre.preu + ", altura: " + arbre.alcada + ", cantidad:  " + arbre.cantidad_arb + ".");
			}
		}else {
			System.out.println("No hay árboles que mostrar.");
		}
		if(decoracio.size() != 0) {
			for(Decoracio decor:decoracio) {
				System.out.println("Decoración: " + decor.material + ", precio: " + decor.preu + ", cantidad: " + decor.cantidad_deco + ".");
			}
		}else {
			System.out.println("No hay decoraciones que mostrar.");
		}
	}
	


	public void valor_stock() {
		//La floristeria té un registre del valor total de l'stock que té.
		double total_stock_value=0;
		if(flors.size() != 0) {
			for(Flors flor:flors) { 
				total_stock_value += flor.preu * flor.cantidadFlor;
				
			}
		}
		if(arbres.size() != 0) {
			for(Arbres arbre:arbres) {
				total_stock_value += arbre.preu * arbre.cantidad_arb;
				
			}
		}
		if(decoracio.size() != 0) {
			for(Decoracio decor:decoracio) {
				total_stock_value += decor.preu * decor.cantidad_deco;
				
			}
		}
		
		System.out.println("El valor total del stock es: " + total_stock_value + " €.");
		
	}
	
	public void listar_tickets() {
		for(Ticket t: tickets) {	
			t.listar_contenido_ticket(this);	
		}
	}
	public double calcular_valor_ventas() {
		double value=0;
		for(Ticket t: tickets) {
			value +=t.valor_ticket(this);
		}
		return value;
	}
	
	

}
