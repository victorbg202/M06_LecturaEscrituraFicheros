import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
	
	public static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args) {
		mostrarMenuPrincipal();
	}

	// Mostrar menu encriptacio
	public static void mostrarMenuPrincipal(){
		
		// Printar menu
		limpiarPantalla();
		System.out.println(" \t\t ----------------------------------");
		System.out.println("\t\t||"+"*****"+"||"+"  MENU PRINCIPAL  "+"||"+"*****"+"||");
		System.out.println("\t\t ----------------------------------");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t||    "+"************************"+"    ||");
		System.out.println("\t\t||  //                        \\\\  ||");
		System.out.println("\t\t|| ||     "+"1) Mostrar poema"+"     || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| || "+"2) Mostrar primer verso  "+"|| ||");
		System.out.println("\t\t|| ||      de cada estrofa     || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||  "+"3) Eliminar las líneas "+" || ||");
		System.out.println("\t\t|| ||          en blanco       || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||"+"4) Sobrescribir todas las "+"|| ||");
		System.out.println("\t\t|| ||         ‘a’ por ‘@’      || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||"+"5)Eliminar las líneas cuya"+"|| ||");
		System.out.println("\t\t|| ||     primera palabra sea  || ||");
		System.out.println("\t\t|| ||   igual que la anterior  || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| || "+"6) Escribir al final del "+"|| ||");
		System.out.println("\t\t|| || texto la primera estrofa || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||"+"7)Volver al poema original"+"|| ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t|| ||          "+"0) SALIR "+"       || ||");
		System.out.println("\t\t|| ||                          || ||");
		System.out.println("\t\t||   "+"**************************"+"   ||");
		System.out.println("\t\t||                                ||");
		System.out.println("\t\t ----------------------------------");
		System.out.println();
		
		//Eligir opcion
		opcionMenuPrincipal();
	}
	
	// Elegir opcion del menu principal
	public static void opcionMenuPrincipal() {
		int opcion = 0;
		
		// Controlar que se introduzca una opcion valida
		do {
			// Introducir opcion
			System.out.print("Introduce que opcion vas a escojer:");
			opcion = sc.nextInt();
			
			// Accion segun opcion
			if (opcion == 0) {
			// Salir del programa
				salir();
			}
			// Mostrar poema
			else if (opcion == 1) {
				mostrarPoema();
			}
			// Mostrar primer verso de cada estrofa
			else if (opcion == 2) {
				mostrarPrimerVerso();
			}
			// Eliminar lineas en blanco
			else if (opcion == 3) {
				eliminarLineasBlanco();
			}
			// Sobreescribir a po @
			else if (opcion == 4) {
				sobrescribirA();
			}
			// Eliminar lineas con la primera palabra igual que la anterior
			else if (opcion == 5) {
				eliminarPrimeraIgual();
			}
			// Escribir al final del texto la primera estrofa
			else if (opcion == 6) {
				escribirPrimerFinal();
			}
			//Reescribir poema original
			else if (opcion == 7) {
				reescribirPoema();
			}
		} while (opcion < 0 || opcion > 7);
		
	}
	
	//Escribir al final del texto la primera estrofa
	private static void escribirPrimerFinal() {
//        try {
//    		BufferedReader br = null;
//			br = new BufferedReader(new FileReader("poema.txt"));
//			String lineaPoema;
//			String PrimeraEstrofa = "";
//			lineaPoema = br.readLine();
//			
//			
//			
//			while (lineaPoema != "") {
//					PrimeraEstrofa += lineaPoema;
//			}
//
//			System.out.println(PrimeraEstrofa);
//				
//			br.close();			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		limpiarPantalla();
		try {
            Scanner poema = new Scanner(new File("poema.txt"));
            String estrofa = "";
            String line = poema.nextLine();
            
            while (!line.equals("")) {
                estrofa += poema.nextLine() + "\n";
            }
            System.out.println(poema + estrofa);
            //guardarResultado(poema + estrofa);
            
            // Volver al menu
            volverMenu();         
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

	// Eliminar las lineas cuya primera palabra sea igual que la anterior
	private static void eliminarPrimeraIgual() {
		limpiarPantalla();
		try {
            Scanner poema = new Scanner(new File("poema.txt"));
            String Pfinal = "";
            String palabraAnterior = "";
            
            while (poema.hasNextLine()) {
                String line = poema.nextLine();
                String[] splitLinea = line.split(" ");
                String palabraActual = splitLinea[0];

                

            	System.out.println("Panterior" + palabraAnterior);
            	System.out.println("ACTUAL" + palabraActual);
                
//                if (palabraActual.equals(palabraAnterior)) {
//                }

                palabraAnterior = palabraActual;
                
                Pfinal += Pfinal+poema.nextLine();
                
            }
            //guardarResultado(Pfinal);
            
            // Volver al menu
            volverMenu();         
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

	// Volver al poema original
	private static void reescribirPoema() {
		try {
			limpiarPantalla();
			String text = readFileAsString("poemaCopia.txt");
            guardarResultado(text);
            System.out.println(text);
            
            // Volver al menu
            volverMenu();         
        } catch (Exception ex) {
            ex.printStackTrace();
        }	
	}
	
	// Mostrar todo el poema por consola
	private static void mostrarPoema() {
		limpiarPantalla();
		try {
            Scanner poema = new Scanner(new File("poema.txt"));
            while (poema.hasNextLine()) {
                String line = poema.nextLine();
                System.out.println(line);
            }
            poema.close();
            
            // Volver al menu
            volverMenu();         
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

	// Mostrar primer verso de cada estrofa
	private static void mostrarPrimerVerso() {
		limpiarPantalla();
		try {
            Scanner poema = new Scanner(new File("poema.txt"));
            String Pfinal = poema.nextLine() + "\n";
            while (poema.hasNextLine()) {
                String line = poema.nextLine();
                if (line.equals("")) {
                	Pfinal += poema.nextLine() + "\n";
                }
            }
            guardarResultado(Pfinal);
            
            // Volver al menu
            volverMenu();         
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	//Eliminar las lineas en blanco
	private static void eliminarLineasBlanco() {
		try {
			limpiarPantalla();
			String text = readFileAsString("poema.txt");
			text = text.replaceAll("\n\r", "");
            guardarResultado(text);
            System.out.println(text);
            
            // Volver al menu
            volverMenu();         
        } catch (Exception ex) {
            ex.printStackTrace();
        }		
	}
	
	//Eliminar las lineas en blanco
	private static void sobrescribirA() {
		try {
			limpiarPantalla();
			String text = readFileAsString("poema.txt");
			text = text.replaceAll("a", "@");
			text = text.replaceAll("A", "@");
            guardarResultado(text);
            System.out.println(text);
            
            // Volver al menu
            volverMenu();         
        } catch (Exception ex) {
            ex.printStackTrace();
        }		
	}
	

	//SObreescribir fixero
	private static void guardarResultado(String text) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("poema.txt"))){
			System.out.println(text);
			bw.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	//Leer como string
	private static String readFileAsString(String contenido) throws IOException {
		FileInputStream fis = new FileInputStream(contenido);
		byte[] buffer = new byte[10];
		StringBuilder sb = new StringBuilder();
		while (fis.read(buffer) != -1) {
			sb.append(new String(buffer));
			buffer = new byte[10];
		}
		fis.close();

		String content = sb.toString();
		
		return content;
	}
	
	// Volver al menu principal
	private static void volverMenu() {
		System.out.println();
		int opcion = 0;
		
		// Introducir opcion
		do {
	        System.out.print("Pulsa 0 para volver: ");
	        opcion = sc.nextInt();
	        
	        // Volver al menu
	        if (opcion == 0) {
	            mostrarMenuPrincipal();   
			}
		} while (opcion != 0);
	}

	//Salir del programa
	private static void salir() {
		sc.close();
		limpiarPantalla();
		System.out.println("Adioos!! :D");
	}
	
	//Limpiar consola
	private static void limpiarPantalla() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
}
