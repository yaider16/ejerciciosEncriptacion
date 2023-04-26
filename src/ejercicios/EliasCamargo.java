package ejercicios;

import java.util.Scanner;

public class EliasCamargo {
    //Definimos el alfabeto
    public static String[] abcd = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public void main(String[] args) {
        
        //Conectamos el programa con el teclado
        Scanner teclado = new Scanner(System.in);
        
        //Pedimos una palabra con la que trabajar
        System.out.println("Ingrese una palabra");
        String palabra = teclado.nextLine();

        //Hacemos uso del procedimiento guardado en otra clase
        String resultado = encrip(palabra);
        String desencriptado = desencriptar(resultado);
        //Imprimimos el resultado
        System.out.println("la palabra "+palabra+" encriptada es: "+resultado+"\nY la desencriptación es: "+desencriptado);    

        //Cerramos la conexion con el teclado
        teclado.close();
    }

    public static int posiciones(String letra) {

        //Método para obtener la posición de una letra en el alfabeto
        int posicion=-1;

        String[] abcd = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        for (int pos=0; pos<abcd.length; pos++) {
            String letraAbc = abcd[pos];
            if (letraAbc.equals(letra)) {
                posicion=pos;        
                break; 
            }      
        }
        return posicion;
    }
    
    //Método para encriptar una palabra
    public static String encrip(String palabra) {

        

        //Con esto obtenemos la longitud de la palabra
        int longitudPalabra = palabra.length();

        //Con esto obtenemos la longitud del alfabeto que nos servir para hallar la posicion final de este
        int posicionFinal = abcd.length - 1;

        //Creamos una nueva cadena vacía para almacenar la palabra encriptada
        String nuevaPalabra="";
        
        //Recorremos la palabra letra por letra
        for (int pos = 0; pos < longitudPalabra; pos++) {

            //Obtenemos la letra actual
            String letra = palabra.substring(pos, pos+1);

            //Con esto la posición de la letra actual en el alfabeto
            int posicionActual = posiciones(letra);
            
            //Remplazamos letra con la letra anterior seguida de la siguiente letra
            int posicionAnterior = posicionActual - 1;
            int posicionSiguiente = posicionActual + 1;
            
            //Si se pasa del rango de letras 0-25 se ajusta la posición
            if (posicionAnterior < 0) {
                posicionAnterior = posicionFinal;
            }
            if (posicionSiguiente > posicionFinal) {
                posicionSiguiente = 0;
            }
            
            //Creamos la nueva letra uniendo la letra anterior y la siguiente
            String nuevaLetra = abcd[posicionAnterior] + abcd[posicionSiguiente];
        
            nuevaPalabra += nuevaLetra;
        }   
        return nuevaPalabra;
    }

    public static String desencriptar(String palabra){
        String desencriptado="";

        for (int i = 0; i < palabra.length(); i++) {
            String letra = toString(palabra.charAt(i));
            if (i%2==0) {
                desencriptado+=letra;
            }
        }

        String desencriptadoFinal ="";
        System.out.println(desencriptado);
        for (int k = 0; k < desencriptado.length(); k++) {

            String letra = toString(desencriptado.charAt(k));

            for (int j = 0; j < abcd.length-1; j++) {
                if (letra.equals(abcd[j])) {
                    desencriptadoFinal+=abcd[j+1];
                    break;
                }else if(letra.equals("z")){
                    desencriptadoFinal+=abcd[0];
                    break;
                }
            }
        }


        return desencriptadoFinal;
    }
    public static String toString(char ch) {
        return String.valueOf(ch);
    }
}
