import java.util.Scanner;

public class AngelaPeña {

    /*
     * ahora defino un vector de caracteres especiales o signos que voy a
     * utilizar para encriptar segun la posicion del abecedario.
     * Este vector toma como base los numeros, son diferentes hasta 9 y luego son
     * combinaciones
     */
    public static String[] caracteres_diferentes = { "+", "*", "-", "?", "!", "~", "#", "$", "&", "%", "*+", "**", "*-",
            "*?", "*!", "*~", "*#", "*$", "*&", "*%", "-+", "-*", "--", "-?", "-!", "-~", };

    // defino en un vector el abecedario
    public static String[] abecedario = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int ENCRIPTAR =1;
        final int DESENCRIPTAR=2;

        System.out.println("1 Para encriptar\n2 Para desencriptar");
        int enc = sc.nextInt();

        sc.nextLine();
        System.out.print("De la palabra: ");
        String palabra = sc.nextLine();

        switch (enc) {

            case ENCRIPTAR:
                System.out.println("La palabra encriptada es: "+ encriptar_palabra_202310483(palabra));
                break;
        
            case DESENCRIPTAR:
                System.out.println("La palabra desencriptada es: "+ desencriptar(palabra));
                break;
            default:
                break;
        }


        sc.close();
    }

    public static String encriptar_palabra_202310483(String palabra) {
        /*
         * Esta funcion recibe una palabra para encriptarla, primero toma la palabra
         * ingresada y la vuelve al reves, luego toma la
         * palabra al reves y segun la distancia que hay desde el inicio del abecedario
         * hasta cada letra de la palabra, toma esa misma
         * distancia desde el final del abecedario y genera una nueva posicion,
         * finalmete toma en un vector de caracteres especiales
         * esta nueva posicion y lo que hay en ella lo mete dentro de una variable que
         * va a ser la que retorna mi funcion
         */

        /*
         * en el primer paso para encriptar tomo la palabra al reves
         * hago un ciclo que tome cada valor desde la longitud total de la palabra hasta
         * 0
         */

        String resultante1 = ""; // defino una variable tipo String donde voy a incluir la nueva palabra formada
                                 // letra por letra

        int longitud_palabra = palabra.length();// hallo la longitud de la palabra con .length para hacer un ciclo

        for (int contador = longitud_palabra; contador > 0; contador--) {
            // hago un ciclo que tome cada valor desde la longitud total de la palabra hasta
            // 0
            String letra = palabra.substring(contador - 1, contador); // tomo cada letra de la palabra
            resultante1 += letra; // agrego la letra en que va el ciclo a la variable de la palabra al revés
        }

        /*
        defino una variable vacia, tipo string en la que voy a meter la palabra
        encriptada dentro del ciclo
         */
        String palabra_encriptada = "";

        // defino en una variable la longitud de la palabra resultante1
        int longitud_palabra2 = resultante1.length();

        // Recorro la palabra resultante1 tomando cada letra, para esto utilizo la
        // longitud asignada a la anterior variable
        for (int posicion_letra = 0; posicion_letra < longitud_palabra2; posicion_letra++) {

            // en la variable letra_palabra voy tomando cada letra de la palabra ingresada
            String letra_palabra = resultante1.substring(posicion_letra, posicion_letra + 1);

            // Dentro de este ciclo hacer otro ciclo anidado que recorra el vector
            for (int posicion_vector = 0; posicion_vector < abecedario.length; posicion_vector++) {

                // comparo la letra en la que esta el ciclo de la palabra, con la letra que esta
                // en el ciclo del arreglo de abecedario
                String letra_vector = abecedario[posicion_vector];

                // la funcion.equals compara strings. Si la letra de la palabra es igual a la
                // letra del vector entra al condicional
                if (letra_palabra.equals(letra_vector)) {

                    /*
                     * tomo la posicion en que va el vector y la resto a la longitud del abecedario,
                     * este resultado lo asigno a una
                     * nueva variable como la nueva posicion con la que se va a tomar la letra para
                     * la palabra resultante2
                     */
                    int nueva_posicion = (abecedario.length - 1) - posicion_vector;

                    // tomo esa nueva posicion en el vector de caracteres especiales y la agrego a
                    // la palabra encriptada resultante
                    palabra_encriptada += caracteres_diferentes[nueva_posicion]+" ";
                }
            }
        }
        // finalmente la funcion me retorna la palabra encriptada
        return (palabra_encriptada);
    }

    public static String desencriptar(String palabra) {
        String desencriptado = "";
        String[] letras = new String[palabra.length()];
        for (int i = 1; i < palabra.length()-1; i++) {
           
            String a = toString(palabra.charAt(i+1));
            
            String b= toString(palabra.charAt(i-1));    
            
            String letra = toString(palabra.charAt(i));


            if (i==1 && !(b.equals(" ")) && letra.equals(" ")) {

                letra =b;

            }else if(i==palabra.length()-2 && !(a.equals(" ")) && letra.equals(" ")){
                
                letra =a;

            }else{

                if ((a.equals(" ") && !b.equals(" ")) || (!a.equals(" ") && !b.equals(" "))) {

                    letra="";

                }else if (!a.equals(" ") && b.equals(" ")){
                    letra+=toString(palabra.charAt(i+1));
                }
            }

            letras[i-1] = letra;
            }

            int nuevaPosicion=0;

            for (int j = 0; j < letras.length-2; j++) {
                
                for (int i = 0; i < caracteres_diferentes.length; i++) {

                    if (letras[j].equals(caracteres_diferentes[i])) {
                        nuevaPosicion=(abecedario.length-1)-i;
                        desencriptado+=abecedario[nuevaPosicion];
                        break;
                    }
                }

            }
            
            int longitud_palabra= desencriptado.length();
            String desencriptadoFinal="";

            for (int contador = longitud_palabra; contador > 0; contador--) {

                String letra = desencriptado.substring(contador - 1, contador); 
                desencriptadoFinal += letra;
            }
            
            return desencriptadoFinal;
        }

    public static String toString(char c) {
        return String.valueOf(c);
    }
}
