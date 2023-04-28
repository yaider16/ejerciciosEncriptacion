package ejercicios;

import java.util.Scanner;

public class SeleneDaza {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("De la palabra: ");
        String palabra= sc.nextLine();

        String encriptado = encriptar(palabra);
        String desencriptado = desencriptar(encriptado);

        System.out.println("Encriptado: "+ encriptado);
        System.out.println("Desencriptado: "+ desencriptado);

        sc.close();
    }

    public static String encriptar(String texto) {
        /*
         * esta función recibe una palabra para encriptarla, según la posición en el
         * abecedario de la letra, se realizará
         * la sucesión de fibonnaci, y se arrojara el número resultante
         */

        String fin = "";

        // array abecedario
        String[] abecedario = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

        // largo de la palabra ingresada para hacer un ciclo
        int large = texto.length();

        // ciclo que recorre las letras de la palabra
        for (int i = 0; i < large; i++) {

            // substring que toma cada letra
            String letra = texto.substring(i, i + 1);

            // ciclo que recorre el abecedario
            for (int j = 0; j <= 26; j++) {

                /* contadores que permiten realizar la sucesión de fibonnaci */
                int contadorUno = 0;
                int contadorDos = 1;
                int contadorTres = 1;

                if (letra.equals(abecedario[j])) {// cuando encuentre la letra en el abecedario

                    int posicion = j + 1;// la posición de la letra +1 para q "a" no sea igual a 0
                    for (int x = 0; x < posicion; x++) {// for para sucesión de fibonacci
                        // el contadorUno representará el número anterior por el que se va a sumar
                        // luego, el contadorDos la suma ya hecha y el contadorTres la suma como tal
                        contadorDos = contadorTres;
                        contadorTres = contadorDos + contadorUno;
                        contadorUno = contadorDos;
                    }
                    fin+= contadorDos+"-";// imprime el resultado de la encriptación letra por letra
                }
            }
        }
        return fin;
    }

    public static String desencriptar(String palabra){
        String desencriptado="";


        // array abecedario
        String[] abecedario = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

        String[] fibonacci= {"1", "1", "2", "3","5","8","13","21","34","55","89","144","233","377","610","987","1597","2584","4181","6765","10946","17711","28657","46368","75025","121393","196418"};
        // largo de la palabra ingresada para hacer un ciclo
        int large = palabra.length();
        String letras= "";
        // ciclo que recorre las letras de la palabra
        for (int i = 0; i < large; i++) {
            
            if (charAString(palabra.charAt(i)).equals("-")) {
                
                for (int j = 0; j < fibonacci.length; j++) {
                    
                    if (letras.equals(fibonacci[j])) {
                        desencriptado+= abecedario[j];
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
}
