package ejercicios;

import java.util.Scanner;

        /*
         * El programa encripta la palabra asi:
         * Paso 1: Convierte cada letra a su equivalente en numero (a=1, b=2...)
         * 
         * Paso 2: Si el numero es par le suma la cantidad de letras de la palabra.
         * Si el numero es impar le resta la cantidad de letras de la palabra.
         * 
         * Paso 3: convierte el nuevo numero de vuelta a letra (1=a, 2=b...)
         * 
         * 
         * Paso 4: Busca la nueva letra en un vector de 13 columnas y 2 filas con el
         * abecedario escrito al reves
         * 
         * Paso 5: multiplica las coordenadas en las que se encontro la letra (z=1*1,
         * a=13*2...)
         * 
         * Paso 6: Si la fila es 1 añade A antes del numero, si la fila es 2 añade B.
         * 
         * Paso 7: Escribe la letra seguida del numero para cada letra (cada letra se
         * separa con un punto)
         * 
         * Ejemplo:
         * Vaca= A1.A4.A2.A4
         */

public class LauraCampiño {

            // vector que guarde dos filas de 13 columnas de letras para el paso 4
    public static char[][] paso4 = {
                { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n' },
                { 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a' },
    };
    public static void main(String[] args) {

        // Scanner que reciba la palabra a encriptar
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la palabra a encriptar: ");
        String palabra = scanner.nextLine();

        String encriptado = encriptar(palabra);
        String desencriptado = desencriptar(encriptado);

        System.out.println("Palabra encriptada: "+ encriptado);
        System.out.println("Palabra desencriptada: "+ desencriptado);
        scanner.close();
    }

    public static String encriptar(String palabra) {

        palabra.toLowerCase();

        String abc = "abcdefghijklmnopqrstuvwxyz";
        abc.toCharArray();
        palabra.toCharArray();

        // variable que guarde la posicion en el abecedario de la letra
        int valorNumero = 0;

        // variable que guarde el valor despues del paso 2
        int nuevoValor = 0;

        // variable que guarde la nueva letra en el paso 3
        char nuevaLetra = ' ';



        // variable que guarde la fila de la letra
        int coor1 = 0;

        // variable que guarde la columna de la letra
        int coor2 = 0;

        // variable que guarde la palabra encriptada
        String nuevaPalabra = "";

        // un ciclo for que recorra la palabra letra por letra
        // para i que es 0, mientras i sea menor a la longitud de la palabra, aumentar i
        // en 1
        for (int i = 0; i < palabra.length(); i++) {

            // un ciclo que recorra el abecedario letra por letra
            // para posicion que es 0, mientras sea menor a la longitud de abc, aumentar en
            // 1
            for (int posicion = 0; posicion < abc.length(); posicion++) {

                // un if que guarde en valorNumero la posicion de la letra en el abecedario
                if (palabra.charAt(i) == abc.charAt(posicion)) {
                    valorNumero = posicion + 1;

                    // un if que determine si el valorNumero es par o no
                    if (valorNumero % 2 == 0) {
                        // si es par, que sume a valorNumero (posicion de letra) el largo de palabra
                        nuevoValor = valorNumero + palabra.length();

                        // si nuevoValor se sale del largo de abc, que se reste el largo de abc
                        // este if hace que despues de z siga a
                        if (nuevoValor > abc.length()) {
                            nuevoValor = nuevoValor - abc.length();
                            nuevaLetra = abc.charAt(nuevoValor - 1);
                        } else {
                            nuevaLetra = abc.charAt(nuevoValor - 1);
                        }

                    } else {
                        // si no es par, que reste a valorNumero(posicion letra) el largo de palabra
                        nuevoValor = valorNumero - palabra.length();

                        // si nuevoValor se sale del largo de abc, que se sume el largo de abc
                        // este if hace que antes de a este z
                        if (nuevoValor < 1) {
                            nuevoValor = nuevoValor + abc.length();
                            nuevaLetra = abc.charAt(nuevoValor - 1);
                        } else {
                            nuevaLetra = abc.charAt(nuevoValor - 1);

                        }

                    }

                    // un for que recorra las filas del vector paso4
                    for (int fila = 0; fila < 2; fila++) {
                        // un for que recorra las columnas del vector paso4
                        for (int columna = 0; columna < 13; columna++) {

                            // un if que guarde la fila y columna en que se encuentra cada letra
                            // coor1 (fila), coor2 (columna)
                            if (nuevaLetra == paso4[fila][columna]) {
                                coor1 = fila + 1;
                                coor2 = columna + 1;

                                // la variable nuevoValor es el producto de las coordenadas
                                nuevoValor = coor1 * coor2;

                                // la nuevaPalabra es cada letra encriptada separada por punto

                                if (coor1 == 1) {
                                    nuevaPalabra = nuevaPalabra + 'A' + nuevoValor + ".";
                                } else {
                                    nuevaPalabra = nuevaPalabra + 'B' + nuevoValor + ".";
                                }
                            }
                        }
                    }
                }
            }
        }

        // imprimir la palabra encriptada
        return nuevaPalabra;

    }

    public static String desencriptar(String palabra) {
        String desencriptado = "";

        return desencriptado;
    }
}
