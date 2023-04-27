package ejercicios;

import java.util.Scanner;

public class NicolCepeda {
    /*
     * Nicol Sofia Cepeda Vanegas - 202213321
     * Con este ejercicio se pasa de una palabra en español a una en morse haciendo
     * uso de los vectores y sus posiciónes.
     * Se pide la palabra, se pasa a mayusculas y después dependiendo de las
     * posiciones cambia a morse
     */

    public static String[] letraEsp = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q",
     "R","S", "T", "U", "V", "W", "X", "Y", "Z" };

    public static String[] letraMorse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
     "--","-.", "--.--", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Por favor ingrese la palabra a encriptar"); 
        String palabraEsp = sc.nextLine(); // Scanner para ingresar palabra

        String palabraEnc= encriptar(palabraEsp);
        String palabraDes= desencriptar(palabraEnc);


        System.out.println("Encriptado: "+palabraEnc);
        System.out.println("Desencriptado: "+ palabraDes);

        sc.close();
    }

    public static String encriptar(String palabraEsp){
        /*
         * vector de abecedario y de morse correspondientemente,
         * las letras tienen la misma posición en morse que en el abecedario
         */

        String palabraMayus = palabraEsp.toUpperCase(); // pasar toda la palabra a mayusculas porque en el vector está
                                                        // así

        String palabraEnc = ""; // Inicializa palabraEnc con nada para poderse usar después en la impresión de
                                // la palabra encriptada
        // ciclo for desde 1 hasta la longitud de la palabra
        for (int i = 1; i <= palabraEsp.length(); i++) {
            /*
             * esa el substring para extraer la subcadena de texto de la palabra (Letra), va
             * desde el inicio de la letra hasta
             * el final de la letra (i-1, i)
             */
            String letra = palabraMayus.substring(i - 1, i);
            // ciclo for para establecer la posición morse
            for (int j = 0; j < letraEsp.length; j++) {
                // comparar la letra en la posición correspondiente con el vector de las letras
                // del abecedario en español
                if (letra.equals(letraEsp[j])) {
                    /*
                     * se muestra la letra en morse con la posición j que se había comparado en el
                     * vector de las letras en español,
                     * como tienen la misma posición en español y en morse solo hay que poner la j
                     * para que se entienda cual posición es en morse
                     * la letra encriptada se va almacenando en palabraEnc
                     */
                    palabraEnc = palabraEnc + letraMorse[j] + "|";
                }
            }
        }
        return palabraEnc; // imprime la palabra encriptada
        
    }
    public static String desencriptar(String palabra){
        
        String desencriptado ="";
        String letras="";

        for (int i = 0; i < palabra.length(); i++) {

            String letra = palabra.substring(i, i+1);

            if (letra.equals("|")) {

                for (int j = 0; j < letraEsp.length; j++) {
                    
                    if (letras.equals(letraMorse[j])) {
                        desencriptado+= letraEsp[j];
                    }
                }
                letras="";
                
            }else{
                letras+=letra;
            }            
        }

        return desencriptado;
    }
}
