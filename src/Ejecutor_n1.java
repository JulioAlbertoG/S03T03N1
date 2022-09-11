import java.util.*;

public class Ejecutor_n1 {
	
	static Floristeria floris;

	public static void main(String[] args) {
		
		Scanner nomFloris = new Scanner(System.in);
		System.out.println("Escribe el nombre de la floristería");
		String nom_floris = nomFloris.nextLine();
		
		if(Fitxer.crearFit(nom_floris) == true) {
			System.out.println("El fichero existe.");
			floris = Fitxer.leerFit(nom_floris);
		} else {
			floris = new Floristeria(nom_floris);
			Fitxer.escribirFit(nom_floris, floris);
		}
		
		System.out.println("Elige la acción a realizar");
		System.out.println("1: Agregar Flor");
		System.out.println("2: Agregar Decoración");
		System.out.println("3: Agregar Árbol");
		System.out.println("4: Eliminar Flor");
		System.out.println("5: Eliminar Decoración");
		System.out.println("6: Eliminar Árbol");
		System.out.println("7: Consultar Stock y las cantidades");
		System.out.println("8: Consultar Valor Total de Stock de Floristería");
		System.out.println("9: Crear Ticket de compra");
		System.out.println("10: Consultar Historial de Tickets");
		System.out.println("11: Consultar Valor total de ventas");
		Scanner seleccion = new Scanner(System.in);
		int eleccion = seleccion.nextInt();
		
		switch(eleccion) {
			case 1:{
				//Tengo que introducir el objeto entero, en cada caso con todas las caracxterísticas
				floris = Flors.agregar(floris);
				Fitxer.escribirFit(floris.nom_floris, floris);
				break;
				}
			case 2:{
				floris = Decoracio.agregar(floris);
				Fitxer.escribirFit(floris.nom_floris, floris);
				break;
				}
			case 3:{
				floris = Arbres.agregar(floris);
				Fitxer.escribirFit(nom_floris, floris);
				break;
				}
			case 4:{
				floris = Flors.delete(floris);
				Fitxer.escribirFit(nom_floris, floris);
				break;
				}
			case 5:{
				floris = Decoracio.delete(floris);
				Fitxer.escribirFit(nom_floris, floris);
				break;
				}
			case 6:{
				floris = Arbres.delete(floris);
				Fitxer.escribirFit(nom_floris, floris);
				break;
				}
			case 7:{
				floris.stock_producte();
				break;
				}
			case 8:{
				floris.valor_stock();
				break;
				}
			case 9:{
				floris = Ticket.compra(floris);	
				break;
	
				}
			case 10:{
				floris.listar_tickets();
				break;
				}
			case 11:{
				System.out.println("El valor total de las ventas es de: " + floris.calcular_valor_ventas() + "€");
				}
				
			}
	
		nomFloris.close();

	}

}
