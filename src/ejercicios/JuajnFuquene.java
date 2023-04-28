package ejercicios;

import java.util.Random;
import java.util.Scanner;

public class JuajnFuquene {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("De la palabra: ");
        String palabra= sc.nextLine();

        String encriptado = encriptarPalabra(palabra);
        String desencriptado = desencriptar(encriptado);

        System.out.println("Encriptado: "+ encriptado);
        System.out.println("Desencriptado: "+ desencriptado);

        sc.close();
    }

/*
 * Juan José Fúquene Rodríguez - Código: 202310276
 * Hola! Este es el primer ejercicio que corregimos en clase de los corchetes :>
 * La manera en la que quise encriptar la palabra era que por cada letra de la palabra ingresada imprimiera una palabra elegida entre 
 * dos opciones, aleatoreamente.
 * Un ejemplo podría ser casa, el return sería: acoge dados usual farol .
 */

    public static String encriptarPalabra(String palabraEncriptar) {

        String palabraEncriptada = ""; // Este string almacenará el resultado de la encriptación

        Random randomOpcion = new Random(); // Nombro la función random para usarla durante el proceso

        int longitudPalabra = palabraEncriptar.length(); // Utilizo este length para saber la longitud de la palabra

        for (int interno = 0; interno < longitudPalabra; interno++) { // Ciclo "para" para recorrer cada letra de la
                                                                      // palabra ingresada

            String letraComp = palabraEncriptar.substring(interno, interno + 1); // El String letraComp almacenará cada
                                                                                 // letra de la palabra que tome en ese
                                                                                 // momento
            for (int posiciones = 0; posiciones < abecedario.length; posiciones++) { // Ciclo "para" para recorrer el
                                                                                     // vector abecedario
                String letra = abecedario[posiciones]; // El String letra tomará la letra según el número de posición
                                                       // del for anterior
                if (letraComp.equals(letra)) { // Si la letra a comparar es igual a la letra del abecedario en la que
                                               // nos encontramos en el momento entonces:
                    final int opcionA = 0; // Determino las constantes para saber cúal
                    final int opcionB = 1; // Vector de palabras tomará para codificar
                    int opcionPalabra = randomOpcion.nextInt(2); // Creo el int opcionPalabra para que sea random con un
                                                                 // limite de 2
                                                                 // Para que tome las opciones 0 y 1.
                    switch (opcionPalabra) { // Switch dependiendo de la opcion elegida por el random
                        case opcionA: // Primer caso

                            // Vector con palabras para el primer caso
                            palabraEncriptada+= palabrasA[posiciones];
                            // Se agrega la palabra que corresponde a la letra al string de
                            // palabraEncriptada
                            break; // Termina esta parte del proceso
                        case opcionB: // Segundo caso

                            palabraEncriptada += palabrasB[posiciones];
                            // Se agrega la palabra que corresponde a la letra al string de
                            // palabraEncriptada
                    }
                }
            }
        }
        return palabraEncriptada; // Retorna las palabras con las que codificamos la palabra inicial!
    }

    public static String desencriptar(String palabra){
        String desencriptado= "";
        String letras="";

        for (int i = 0; i < palabra.length(); i++) {
            
            if (charAString(palabra.charAt(i)).equals(" ")) {
                
                for (int j = 0; j < palabrasA.length; j++) {
                    
                    if (palabrasA[j].equals(letras)) {
                        System.out.println(palabrasA[j]+"---->"+letras);
                    }

                }

                letras="";
            }else{
                letras+=charAString(palabra.charAt(i));
            }

        }

        return desencriptado;
    }

    public static String charAString(char ch){
        return String.valueOf(ch);
    }


    public static String[] abecedario = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
    "r", "s", "t", "u", "v", "w", "x", "y", "z" }; // Vector abecedario

    public static String[] palabrasA = { "farol ", "abaco ", "acido ", "odiar ", "celda ", "afan ", "egida ",
    "chelo ", "giga ", "ojo ", "akilo ", "llave ", "amor ", "unico ",
    "dolar ", "apolo ", "equis ", "bravo ", "aspas ", "ataud ", "cuidar ", "evitar ",
    "ewall ", "oxido ", "lycra ", "ozono " };

    public static String[] palabrasB = { "dados ", "obrar ", "acoge ", "ideas ", "delta ", "eficaz ",
    "igual ", "short ", "hiena ", "ajuste ", "akafir ", "oliva ",
    "omega ", "angel ", "logos ", "epoca ", "aquel ", "trozo ", "usual ", "otoño ",
    "lulo ", "avisa ", "uwisky ", "extra ", "ayate ", "azota " };

}
