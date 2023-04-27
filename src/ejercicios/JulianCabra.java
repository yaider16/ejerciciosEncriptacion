package ejercicios;

import java.util.Scanner;

/* la encriptacion se basa en dos metodos en el para pollito se va a representar 
 * la posicion en el abecedario con
  un simbolo que represente si es mayor a 10 o 20 y puntos que representen la unidad
  o si es menor a 10 con un simbolo que 
  represente unidad*/

  /* la encriptacion para tigre se utiliza un simbolo para representar si es mayor a 10 mayor a 20 o menor que 10 y en este 
  caso se crea una piramide con esos simbolos tomando como base el numero restante despues de realizarla resta 
  correspondiente al simbolo*/

public class JulianCabra {
    public static void main(String[] args) {

		Scanner teclado= new Scanner(System.in); //crear un scanner

		final int SALIR=0; 
		final int POLLITO=1;
		final int LEON=2;
		int opcion=-1;
		
        while(opcion != SALIR) {//mientras que opcion sea diferente a SALIR mostrar el menu
			
            System.out.println("----- M E N U -----");
			System.out.println("Introduzca 1 para encriptar con un nive de encriptacion pollito");
			System.out.println("Introduzca 2 para encriptar nivel leon");
			System.out.println("Introduzca 0 para salir");
			
            opcion= teclado.nextInt();//tomar la opcion que eligio el usuario
			
            switch(opcion){
				case POLLITO:
					System.out.println("Introduzca la palabra");
					String palabra= teclado.next();

                    String enc =paraPollito(palabra);
                    String desc2= desencriptado(enc);

					System.out.println("Encriptación: "+ enc);
                    System.out.println("Dese");
				break;
				case LEON:
					System.out.println("Introduzca la palabra");
					String palabra2= teclado.next();

                    String enc2= paraTigre(palabra2);
                    String desc= desencriptado(enc2);
					System.out.println("Encriptación: "+ enc2);
				break;
			}
		}
		teclado.close(); // cierra el scanner
    }

    public static String paraPollito(String palabra) {
		// crear una variable mostrar vacia
		String mostrar=""; 
		String mostrarFinal="";

		// se crea un string con el simbolo
		String puntos="✧";

		// se crea un string con el simbolo
		String punto="♥";

		String[] letras= new String[palabra.length()];
		String[] letrasAbc= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		
        // i va de 0 hasta el largo de la palabra
		for (int i = 0; i < palabra.length(); i++) { 
			
            letras[i]= palabra.substring(i,i+1);
			
            for (int j = 0; j < letrasAbc.length; j++) {
				
                String posicionAbc01= letrasAbc[j];
				
                if(posicionAbc01.equals(letras[i])) {
					
                    int posicionAbc= j;
					int posicionR=posicionAbc +1;
					
                    if( posicionR > 10) { // si posicionR es mayor que 10
						
                        if(posicionR > 20) {// si la posicion es mayor a 20
							
                            int resultado= posicionR - 20;// se le resta 20 a la posicionR
							String para20="♠"; // se crea un string exclusivamente para cuando es mayor a 20
							 // z va de 0 a resultado
							
                             for (int z = 0; z < resultado; z++) {
								mostrar += para20; // se suma una vez el simbolo especial
								mostrar += puntos; // se suma la cantidad de la variable puntos
								para20 ="";
							}

							mostrarFinal=mostrarFinal+mostrar+"\n";
							mostrar ="";
                            
						}else {
							
                            int resultado= posicionR - 10;
							String para10="♦"; // se crea un string exclusivamente para cuando es mayor a 10
							
							for (int y = 0; y < resultado; y++) {// y va de 0 a resultado
								mostrar+= para10; // se suma una vez el simbolo especial
								mostrar+=puntos; // se suma la cantidad de la variable puntos
								para10 ="";
							}
							mostrarFinal+=mostrar+"\n";
							mostrar="";
						}
					}else {
						for (int y = 0; y < posicionR; y++) { // y va de 0 posicionR ya que es menor a 10
							mostrar +=punto;// se suma la variable punto
						} 
						mostrarFinal=mostrarFinal+mostrar+"\n";
						mostrar="";
					}
				}
			}	
		}
		return mostrarFinal;
	}

    public static String paraTigre(String palabra2) {
		String mostrar="";
		String mostrarFinal="";
		String[] letras= new String[palabra2.length()];
		String[] letrasAbc= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		
		for (int i = 0; i < palabra2.length(); i++) {
			letras[i]= palabra2.substring(i,i+1);
			for (int y = 0; y < letrasAbc.length; y++) {
				String posicionAbc01= letrasAbc[y];
				if(posicionAbc01.equals(letras[i])) {
					int posicionAbc= y;
					int posicionR=posicionAbc +1;
					 /*se crea la variable que va a manejar los ciclos que suma la cantidad 
					de 
					simbolo*/
					int cantSimbolo= 1; 
					
					if( posicionR > 10) {
						if(posicionR > 20) { // cuando es mayor a 20
							int resultado= posicionR - 20;
							int cantEspacios= resultado-1; // se define la variable cantEspacios
							String para20="♠"; // se crea un string para cuando es mayor de 20
							
							for (int j = 0; j < resultado; j++) {
								mostrar=""; // se reinicia la variable mostrar
								for (int z =0 ; z < cantEspacios ; z++) {
									mostrar += " "; // se suma un espacio
								}
								for (int z = 0; z < cantSimbolo; z++) {
									mostrar += para20; // se suma el simbolo
								}
								cantSimbolo += 2; 
								cantEspacios -=1;
								mostrar+=mostrar+"\n";
								mostrarFinal+=mostrar+ "\n";
							}
							mostrarFinal+= "\n";
						}else {// cuando es mayor a 10
							int resultado= posicionR - 10;
							String para10="♦";// se crea un string para cuando es mayor de 10 
							mostrar="";// se reinicia la variable mostrar
							for (int asteriscos = 0; asteriscos < resultado ; asteriscos++) {
								mostrar +=para10; // se suma un simbolo
								mostrarFinal=mostrarFinal+mostrar+"\n";
							}
							for (int posicion = 0; posicion < resultado -1; posicion++) {
								mostrar="";// se reinicia la variable mostrar
								for (int j = posicion; j < resultado - 1; j++) {
									mostrar +=para10; //se suma el simbolo
								}
								mostrarFinal=mostrarFinal+mostrar+"\n";
							}
						}
						mostrarFinal+= "\n";
					}else {// cuando es menor a 10
						int resultado=posicionR;
						String para0="♣";// se crea un simbolo para cuando es menor de 10
						int cantEspacios= resultado-1; // se define canEspacios
						for (int j = 0; j < resultado; j++) {
							mostrar=""; // se reinicia la variable mostrar
							for (int espacios = 0; espacios< cantEspacios; espacios++) {
								mostrar +=" "; // se suma un espacio
							}
							for (int j1 = 0; j1 < cantSimbolo; j1++) { 
								mostrar +=para0; // se suma el simbolo
							}
							mostrarFinal=mostrarFinal+mostrar+"\n";
							cantSimbolo += 1; // se le suma 1 a cantSimbolo
							cantEspacios -=1; // se le resta 1 acantEspacios
						}
						cantEspacios=1; // se reinicia la variable
						cantSimbolo=resultado-1; // se reinicia la variable
						for (int p = 0; p < resultado-1; p++) {
							mostrar="";// se reinicia la variable mostrar
							for (int espacios = 0; espacios< cantEspacios; espacios++) {
								mostrar +=" "; // se suma un espacio
							}
							for (int j1 = 0; j1 < cantSimbolo; j1++) {
								mostrar +=para0; // se le suma un simbolo
							}
							mostrarFinal=mostrarFinal+mostrar+"\n";
							cantSimbolo -= 1; // se reinicia la variable
							cantEspacios +=1; // se reinicia la variable
						}
						
					}					
				}
				
			}
		}
		return mostrarFinal;
	}

    public static String desencriptado(String palabra){
        String desencrip = "";


        return desencrip;
        

    }
}
