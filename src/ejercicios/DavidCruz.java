package ejercicios;

import java.util.Scanner;

public class DavidCruz {
    public void main(String[] args) {

    }

    public static String Codificar1(String palabra) {

        /*
         * Esta funcion recibe el numero de palabras que se desean codificar, luego
         * recibe las palabras
         * para encriptarlas. Con el fin de escoger solo la primer letra de cada palabra
         * ingresada y en
         * base a estas primeras letras, formar una nueva palabra.
         */

        // Defino una variable para luego conocer el numero de palabras que se van a ingresar
         int numPalabras;
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Indique la cantidad de palabras que desea codificar: ");
        numPalabras = entrada.nextInt();

        System.out.println("Elija el tema de las palabras que va a ingresar, luego digite las palabras que desea codificar: ");
        palabra = entrada.nextLine();

        String[] palabras = new String[numPalabras];// Se crea un vector que vaya hasta el numero de palabras deseadas

        char primeraLetra;// Definimos un caracter para elegir solo el primer digito de la palabra
                          // ingresada

        for (int i = 0; i < numPalabras; i++) {// Creamos un for que procese y permita ingresar las palabras

            System.out.print("Ingresa la palabra " + (i + 1) + ": ");

            palabras[i] = entrada.nextLine();// Procesa las palabras

            primeraLetra = palabras[i].charAt(0); // Se elige solo el primer digito de cada palabra
            
            System.out.println("La primer letra de la palabra " + palabra + " es: " + primeraLetra);
        }
        entrada.close();
        return palabra; // La funcion me retorna la palabra encriptada
    }
}
