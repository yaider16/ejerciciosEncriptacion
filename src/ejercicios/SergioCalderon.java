package ejercicios;

import java.util.Scanner;

public class SergioCalderon {

    public static String[] vector = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
    "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static String[] binarios = {"00000","00001","00010","00011","00100","00101","00110","00111","01000","01001","01010","01011","01100","01101","01110","01111","10000","10001","10010","10011","10100","10101","10110","10111","11000","11001"};

    public void main(String[] args) {
        // Scanner que reciba la palabra a encriptar
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la palabra a encriptar: ");
        String palabra = scanner.nextLine();

        String encriptado = encriptar(palabra);
        String desencriptado = desencriptar(encriptado);

        System.out.println("Palabra encriptada: "+ encriptado);
        System.out.println("Palabra desencriptada: "+ desencriptado);
        scanner.close();
    }

    // En el programa se ingresa una palabra y el sistema lo pasa a binario de
    // 2elevado a la 4 hasta 2 elevado a la 0
    // cada letra es representada por 5 espacios los cuales puedes estar
    // encendidos"*" o apagados" "
    // un ejemplo es con la letra s la cual es * **/ lo cual representa 16 +2+1=19
    // que es la posicion de la letra
    // las letras estan separadas cada 6 espacios * **/ ****/** **/ * **/ ****/ **
    // /* * / /* **/* * / * /
    public static String encriptar(String palabra) {
        


        String encriptado = "";

        for (int i = 0; i < palabra.length(); i++) {// ciclo desde la primera letra hasta la ultima

            String letra = palabra.substring(i, i + 1);

            for (int x = 0; x < vector.length; x++) {// ciclo de a hasta z

                if (vector[x].equals(letra)) {

                    int y = x;

                    for (int z = 16; z >= 1; z = z / 2) {// comprueba la cuatro potencias para cada letra
                        
                        if (y / z >= 1) {// este ciclo prueba con las potencias de 2 y si es mayor que alguna de esta
                                         // agrega un asterisco
                            encriptado += "1";
                        } else {
                            encriptado += "0";// si no es divisible entonces me suma un espacio que es la opcion apagado
                        }


                        if (y / z >= 1) {// en este ciclo tambien prueba las potencias de 2
                            y = y % z;// con esto al agregar un * le saca el modulo del valor de esa potencia
                        }

                    }

                    encriptado += "/";// separa cada letra
                    x = 27;// acaba con el ciclo
                }
            }
        }
        return encriptado;

    }

    public static String desencriptar(String palabra){
        String desencriptado = "";
        String letras = "";

        for (int i = 0; i < palabra.length(); i++) {
            
            if (charAString(palabra.charAt(i)).equals("/")) {
                
                for (int j = 0; j < binarios.length; j++) {
                    
                    if (letras.equals(binarios[j])) {
                        desencriptado+= vector[j];
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
