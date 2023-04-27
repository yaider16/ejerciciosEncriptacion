package ejercicios;

import java.util.Scanner;

public class SamirYate {

    public static String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("De la palabra a desencriptar: ");
        String texto = entrada.nextLine();

        String encriptada = samirYate(texto);
        String desencriptado = desencriptar(encriptada);

        System.out.println("Encriptada:" + encriptada);
        System.out.println("Desencriptado: " + desencriptado);

        entrada.close();
    }

    public static String samirYate(String texto) {

        // Creo un String para que me guarde el texto codificado dentro de esta
        // variable:
        String textoCodificado = "(-_-)";

        /*
         * Lo que me permite es que el texto ingresado me devuelva la encriptación en
         * mayuscula para eso se usa el metodo (toUpperCase), ya que el abecedario esta
         * en mayuscula:
         */
        texto = texto.toUpperCase();

        Boolean cond = true;

        /*
         * Este ciclo tiene la funcion de recorrerme todo el texto, que para esto,
         * nos ayuda tambien el texto.length() y nos incrementa en 1:
         */
        for (int i = 0; i < texto.length(); i++) {

            // Creo un String en el que me guarda caracter por caracter:
            String caracter = texto.substring(i, i + 1);
            int posicion = 0;

            // Me reinicia la condicion de los espacios:
            cond = true;

            // Me dice la posición donde esta un caracter:
            for (int x = 0; x < abc.length(); x++) {

                // Si el caracter es igual a una letra, ya no puede ser un espacio, me compara
                // con el abecedario:
                if (caracter.equals(abc.substring(x, x + 1))) {
                    posicion = x;

                    // Ya no es un espacio:
                    cond = false;

                    // Este if me va a diriguir al comienzo del abecedarios si se pasa:
                    if (posicion + 3 > abc.length()) {
                        posicion += -abc.length();
                    }

                    // Al texto codificado me suma la letra nueva
                    textoCodificado += abc.substring(posicion + 3, posicion + 4);
                }
            }

            // Si la condicion es verdadera tiene que ir un espacio:
            if (cond) {

                // Al texto codificado me suma un espacio:
                textoCodificado += " ";
            }
        }

        // Me retorna el String (textoCodificado) a la clase main para mostrarlos en
        // pantalla por dicha clase:
        return textoCodificado;
    }

    public static String desencriptar(String palabra) {
        String desencriptado = "";

        for (int i = 0; i < palabra.length(); i++) {
            
            for (int j = 0; j < abc.length(); j++) {
                if (palabra.substring(i, i+1).equals(abc.substring(j, j+1))) {
                    
                    if (j-3 < 0) {
                        desencriptado+= charAString(abc.charAt(j-3+abc.length()-1));
                    }else{
                        desencriptado+= charAString(abc.charAt(j-3));
                    }
                }
            }

        }

        return desencriptado;
    }

    public static String charAString(char ch){
        return String.valueOf(ch);
    }
}
