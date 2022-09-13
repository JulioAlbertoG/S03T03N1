import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
			
			Set<Flors> distinct = new HashSet<>(flors);
			for (Flors s: distinct) {
	            System.out.println("Flor: " + s.nom_flor +", color: " + s.color + ", cantidad: " + Collections.frequency(flors, s));
	        }
		
		}else {
			System.out.println("No hay flores que mostrar.");
		}
		if(arbres.size() != 0) {
			Set<Arbres> dis_arb = new HashSet<>(arbres);
			for(Arbres arbre:dis_arb) {
				System.out.println("Árbol: " + arbre.nom_arbre + ", precio: " + arbre.preu + ", altura: " + arbre.alcada +", cantidad: "+ Collections.frequency(arbres, arbre));
			}
		}else {
			System.out.println("No hay árboles que mostrar.");
		}
		if(decoracio.size() != 0) {
			Set<Decoracio> dis_deco = new HashSet<>(decoracio);
			for(Decoracio decor:dis_deco) {
				System.out.println("Decoración: " + decor.material + ", precio: " + decor.preu+", cantidad: "+ Collections.frequency(decoracio, decor));
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
				total_stock_value += flor.preu;
				
			}
		}
		if(arbres.size() != 0) {
			for(Arbres arbre:arbres) {
				total_stock_value += arbre.preu;
				
			}
		}
		if(decoracio.size() != 0) {
			for(Decoracio decor:decoracio) {
				total_stock_value += decor.preu;
				
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
