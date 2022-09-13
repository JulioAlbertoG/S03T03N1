
import java.io.*;
import com.google.gson.*;


public class Fitxer {
	
	static File fichero;
	
	public static boolean crearFit(String nomFit) {
		boolean exists = false;
		fichero = new File("/Users/julio/Desktop/" + nomFit + ".txt");
		
		if(!fichero.exists()) {
			try {
				fichero.createNewFile();
				System.out.println("Se ha creao el archivo");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			exists=true;
		}
		return exists;
	}
	
	public static void escribirFit(String nomFit, Floristeria floris) {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
			//lo que escribimos se agrega aquí, recibe objeto pero debo pasarlo a String
			Gson gson = new Gson();
			String info_floris = gson.toJson(floris);
			bw.write(info_floris);
			bw.close();
			System.out.println("Se ha guardado correctamente");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Ha habido un error");
		}
	
	}
	
	public static Floristeria leerFit(String nom_floris) {
		BufferedReader br = null;
		String strCurrentLine; 
		Floristeria floristeria = null;
		try {
			br = new BufferedReader(new FileReader(fichero)); 
			while ((strCurrentLine = br.readLine()) != null) { 
				
				//Nos trae un String, pero debemos devolver un objeto floristeria.
				Gson gson = new Gson();
				floristeria= gson.fromJson(strCurrentLine, Floristeria.class) ;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch(IOException ex) {
					System.err.println("No se ha podido cerrar el fichero");
				}
			}
		}
		
		return floristeria;
		
	}
	
	

}
	
