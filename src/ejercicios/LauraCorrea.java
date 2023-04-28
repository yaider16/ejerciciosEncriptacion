package ejercicios;

import java.util.Scanner;

public class LauraCorrea {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("De la palabra: ");
        String palabra= sc.nextLine();

        String encriptado = encriptarPalabra(palabra);
        String desencriptado = desencriptar(encriptado);

        System.out.println("Encriptado: "+ encriptado);
        System.out.println("Desencriptado: "+ desencriptado);

        sc.close();
    }

    // array abecedario
    public static String[] abc = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

    public static String encriptarPalabra(String palabra) {

        int largoPalabra = palabra.length(); // Variable de tipo entero para obtener el largo de la palabra dada

        String encriptada = ""; // Variable string para agregar la palabra ya encriptada

        // Vector de strings con las palabras que se retornan por letra encriptada
        String[] lista_palabras = { "magdalena", "fishburne", "crucial", "kendrik", "suena", "perfume", "goodgirls",
                "bahia", "swift", "semejante", "akkas", "ambulance", "tiempos", "mango", "ghost", "zepet", "buque",
                "world", "misma", "anestecia", "uchuvas", "alvin", "williamwilson", "boxeo", "nsync", "gozar" };

        for (int i = 0; i < largoPalabra; i++) { // Ciclo for para recorrer la palabra por caracteres

            String caracter = palabra.substring(i, i + 1); // Variable string para tomar cada caracter de la palabra

            for (int j = 0; j < lista_palabras.length; j++) { // Ciclo for para recorrer el vector de palabras

                String letraPalabra = lista_palabras[j]; // Variable string para tomar la palabra en cada posicion del
                                                         // vector

                int buscar = (letraPalabra.length() - 1) / 2; // Variable de tipo entero para tomar la letra central en
                                                              // la palabra del vector

                // Variable string para tomar la letra central de la palabra

                String coincidenciaPalabra = letraPalabra.substring(buscar, buscar + 1);

                // Condicional en caso de que la letra en la palabra sea igual a la letra
                // extraida

                if (coincidenciaPalabra.equals(caracter)) {

                    encriptada += letraPalabra + "-";// Si coinciden se agrega a la variable encriptar
                    break;
                }
            }

        }
        return (encriptada);
    }

    public static String desencriptar(String palabra) {
        String desencriptado = "";
        String letras = "";

        for (int i = 0; i < palabra.length(); i++) {

            if (charAString(palabra.charAt(i)).equals("-")) {

                letras = charAString(letras.charAt(letras.length() / 2));

                for (int j = 0; j < abc.length; j++) {

                    if (letras.equals(abc[j])) {
                        desencriptado += letras;
                    }
                }

                letras = "";
            } else {
                letras += charAString(palabra.charAt(i));
            }

        }

        return desencriptado;
    }

    public static String charAString(char ch) {
        return String.valueOf(ch);
    }
}
