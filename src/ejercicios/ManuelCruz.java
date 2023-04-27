package ejercicios;

import java.util.Scanner;

        /*
         * Manuel Esteban Cruz 202310238
         * el programa me encripta la palabra de la siguiente manera:
         * divide el abcdario en dos, las primeras 13 letras y las segundas 13 letras
         * me imprime letra por letra
         * si la letra esta dentro de las 13 primeras me va a imprimir un solo cuadrado
         * pero si la letra esta en las 13 segundas me va a imprimir dos cuadrados,
         * esto con el fin de que se pueda leer con mas facilidad. Cada de que encripta
         * una letra aparece un separador y un numero, el numero corresponde a
         * la posicion de la letra en el abcdario
         * a continuacion dejo ejemplos para que se pueda entender mas facil
         * 
         * ejm1:
         * si yo pido imprimir "abc" me aparece esto
         * .
         * ____________________
         * 1
         * ..
         * ..
         * ____________________
         * 2
         * ...
         * ...
         * ...
         * ____________________
         * 3
         * 
         * ejm2:
         * si pido que imprima "nop" aparece esto
         * ............. .
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * 
         * _______________________________________________________
         * ............. ..
         * ............. ..
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * 
         * _______________________________________________________
         * ............. ...
         * ............. ...
         * ............. ...
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * .............
         * 
         * _______________________________________________________
         */

public class ManuelCruz {
    public static String manuelcruz_202310283(String palabraencriptar) {

        String abc = "abcdefghijklmnopqrstuvwxyz";// uso el abcdario como una palabra, luego para comparar solo uso un
                                                  // substring que vaya letra por letra
        String espacios = "             ";// los espacios los uso para separar los cuadros cuando la posicion de la
                                          // letra es > a 13
        String cuadradouno = ".............";
        String cuadrodefitivo = "";// en esta variable es en donde se va a ir guardando la encriptacion letra por letra
        String palabraecriptada = "";

        /* esta variable es para cuando la letra corresponda a la segunda mitad, para
         * poder imprimir un cuadrado antes de imprimir el otro */
        int lonpalabra = palabraencriptar.length();
        int lonabc = abc.length();


        for (int letraspalabra = 0; letraspalabra <= lonpalabra - 1; letraspalabra++) {// primer for que va a ir letra
                                                                                       // por letra en la palabra
            String letraporletra = (palabraencriptar.substring(letraspalabra, letraspalabra + 1));
            for (int letrasabc = 0; letrasabc < lonabc; letrasabc++) {// segundo for que va a ir letra por letra en el
                                                                      // abcdario
                String letras = (abc.substring(letrasabc, letrasabc + 1));
                if (letraporletra.equals(letras)) {// cuando las letras que pasan por los for coincidan se cumple la
                                                   // condicion
                    String cuadrado = "";// la variable vacia es donde se va a almacenar la longitud de lado del
                                         // cuadrado
                    if (letrasabc <= 12) {// esta primera condicion es donde me va a imprimir solo un cuadrado, esta va
                        // hasta la letra "m"

                        while (cuadrado.length() <= letrasabc) {
                            cuadrado = cuadrado + "."; /*
                                                        * los puntos son para hacer los cuadrados, la cantidad de puntos
                                                        * en sentido horizontal corresponde a la
                                                        * posicion de la letra en el
                                                        * abcdario y en sentido vertical se lee segun si la letra
                                                        * pertenece a las 13 primeras o a las 13 segundas
                                                        */
                        }

                        for (int primercuadrado = 0; primercuadrado <= letrasabc; primercuadrado++) {
                            cuadrodefitivo = cuadrodefitivo + cuadrado + "\n";
                        }
                        cuadrodefitivo = cuadrodefitivo + "\n"
                                + "_______________________________________________________" + "\n";
                        // esto solo es para ayudar a leer los cuadrados de una manera mas facil

                    }

                    if (letrasabc > 12) { // aqui entran las letras despues de la m

                        while (cuadrado.length() <= letrasabc - 13) {// aqui hago la longitud del segundo cuadrado
                            cuadrado = cuadrado + ".";
                        }
                        int cuadrado_dos = cuadrado.length();
                        for (int segundocuadrado = 1; segundocuadrado <= 13; segundocuadrado++) {
                            if (cuadrado_dos <= cuadrado.length() * cuadrado.length()) {// aqui entra mientras que aun
                                                                                        // no se haya impreso
                                                                                        // completamente el segundo
                                                                                        // cuadrado
                                cuadrodefitivo = cuadrodefitivo + cuadradouno + espacios + cuadrado + "\n";
                                cuadrado_dos = cuadrado_dos + cuadrado.length();
                            } else {
                                cuadrodefitivo = cuadrodefitivo + cuadradouno + espacios + "\n";
                                // esto es para cuando ya esta impreso el segundo cuadrado, lo unico que voy a
                                // imprimir sera el primer cuadrado
                                // y los saltos de linea
                            }

                        }
                        cuadrodefitivo = cuadrodefitivo + "\n"
                                + "_______________________________________________________" + "\n";
                    }
                    palabraecriptada = "\n" + cuadrodefitivo;// aqui se juntan todas las letras
                }
            }
        }
        return palabraecriptada;
    }

    public static String desencriptar(String palabra){
        String desencriptada= "";

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.substring(i, i+1).equals("\n")) {
                System.out.println("SI");
            }
        }

        return desencriptada;
    }
    public static void main(String[] args) throws Exception {
        
        Scanner lectura = new Scanner(System.in);

        System.out.print("De una palabra: ");
        String palabraencriptar = lectura.nextLine();
        
        String palabraencriptada = manuelcruz_202310283(palabraencriptar);
        String desencriptada = desencriptar(palabraencriptada);

        System.out.println("Encriptada: "+palabraencriptada);
        System.out.println("Desenciptada: "+ desencriptada);



        lectura.close();
    }
}
