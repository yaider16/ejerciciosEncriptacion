package ejercicios;

import java.util.Scanner;

public class SamuelCamargo {

    public static String[] abecedario = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
            "r", "s", "t", "u", "v", "w", "x", "y", "z" }; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("De una palabra: ");
        String palabraEncriptar = sc.nextLine();
        
        String encriptado = encriptarPalabra(palabraEncriptar);
        String desencriptado = desencriptar(encriptado);

        System.out.println("encriptado: "+encriptado);
        System.out.println("Desencriptado: " +desencriptado);
    }

    public static String encriptarPalabra(String palabraE) {
        String encriptarPalabra = ""; // se inicializa una varianle para contener el resultado

        String[] deletreo = new String[palabraE.length()]; // se inicializa un vector para almacenar la palabra a
                                                           // encriptar
        for (int i = 0; i < palabraE.length(); i++) { 

            // se toma la palagra ingresada y se separa letra por letra
            deletreo[i] = palabraE.substring(i, 1 + i); 
        }

        for (int j = 0; j < deletreo.length; j++) { 

            String deletras = deletreo[j];

            for (int i = 0; i < abecedario.length-1; i++) { 

                String letras = abecedario[i]; // se inicializa una variable que almacene las letras del abecedario
                
                /* Se inicializa una variable que 
                almacena las condiciones de encriptacion 
                que es restar el numero de espacios del 
                largo de la palabra y se multiplica ese valor en 2*/
                int condicion = i - palabraE.length() * 2; 
            
                
                
                if (condicion < 0) {
                    condicion += abecedario.length;
                }
                if (deletras.contains(letras)) { // se crea la condicion para encriptar la palabra
                    encriptarPalabra += abecedario[condicion];
                }
            }
        }
        return encriptarPalabra;
    }

    public static String desencriptar(String palabra){
        String desencriptado="";

        for (int i = 0; i < palabra.length(); i++) {
            
            String letra = charAString(palabra.charAt(i));

            for (int j = 0; j < abecedario.length-1; j++) {
                
                String letraAbc=abecedario[j];

                int condicion= j+ palabra.length()*2;
                
                if (condicion>abecedario.length-1) {
                    condicion-=abecedario.length;
                }

                if(letra.equals(letraAbc)){
                    desencriptado+=abecedario[(int)condicion];
                }

            }

        }

        return desencriptado;
    }

    public static String charAString(char ch){
        return String.valueOf(ch);
    }

    // public static int doubleTOInt(){
        
    // }

}
