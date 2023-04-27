package ejercicios;

import java.util.Scanner;

public class DavidCruz {

    public static String[] abc = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
    "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", };
    public void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Da la palabra a encriptar: ");
        String palabra = entrada.nextLine();

        String encriptado=EncriptarDavid(palabra);
        String desencriptado= desencriptar(encriptado);

        System.out.println("Encriptado: "+encriptado);
        System.out.println("Desencriptado: "+ desencriptado);
        
        entrada.close();
    }

    public static String EncriptarDavid(String palabra) {
        /*
         * Recibe una palabra cualquiera, si el numero de letras que tiene esa palabra
         * es par el programa le definira un
         * valor a cada letra con numeros pares y si es impar le definira un valor a
         * cada letra con numeros impares.
         * 1.Ejemplo: abcd (4 letras= par), por lo que definira a=0, b=2, c=4, d=6.
         * 2.Ejemplo: abc (3 letras=impar), por los que definira a=1, b=3, c=5.
         */
        
        int numeroPar = 0;
        int numeroImpar = 1;//
        int[] abecedario = new int[26];// Se establece un vector que vaya hasta la posicion 26
        String encriptado="";

        if (palabra.length() % 2 == 0) {// Se procesa cuando el numero de palabras ingresadas es par

            for (int i = 0; i < abecedario.length; i++) {// Se imprimen los numeros pares hasta la posicion 26
                abecedario[i] = numeroPar;
                numeroPar += 2;
            }

            for (int i = 0; i < palabra.length(); i++) { // Se imprimen los números pares correspondientes a la palabra
                char caracter = palabra.charAt(i);
                int numero1 = abecedario[caracter - 'a'];
                encriptado+=numero1+"/";

            }
        } else {// Se procesa cuando el numero de palabras ingresadas es impar
            for (int i = 0; i < abecedario.length; i++) {// Se imprimen los numeros pares hasta la posicion 26
                abecedario[i] = numeroImpar;
                numeroImpar += 2;
            }

            for (int i = 0; i < palabra.length(); i++) { // Se imprimen los números impares correspondientes a la
                                                         // palabra
                char caracter = palabra.charAt(i);
                int numero2 = abecedario[caracter - 'a'];
                encriptado+=numero2+"-";
            }

        }
        
        
        return encriptado;
    }
    public static String desencriptar(String palabra){

        String desencriptado="";
        int[] impares = new int[abc.length];
        int[] pares = new int[abc.length];

        // Impares
        int contador = 0;

        // Los primeros 26 numeros impares
        for (int i = 1; i <= 51; i += 2) {
          impares[contador] = i;
          contador++;
        }

        contador=0;

        // Primeros 26 pares
        for (int i = 2; i <= 52; i += 2) {
            pares[contador] = i;
            contador++;
        }

        for (int i = 0; i < palabra.length()-1; i++) {
            
            String letra1= charAString(palabra.charAt(i));
            String letra2= charAString(palabra.charAt(i+1));
            String letra="";

            if (i==0) {

                if (!letra2.equals("-")) {
                    letra=letra1+letra2;
                }else{
                    letra=letra1;
                }

            }else{
                String letra0 =charAString(palabra.charAt(i-1));

                if (!letra1.equals("-")) {
                    if (letra0.equals("-") && letra2.equals("-")) {
                        letra=letra1;
                    }
                    
                    else if(letra0.equals("-") && !letra2.equals("-")){
                        letra=letra1+letra2;
                    }
                }
            }

            for (int j = 0; j < abc.length; j++) {
                
                if (letra.equals("")) {
                    
                }else{
                    if (aNumero(letra) % 2 !=0 && aNumero(letra)==impares[j]) {
                        desencriptado+= abc[j];
                    }else if(aNumero(letra)%2==0 && aNumero(letra)==pares[j]){
                        desencriptado+= abc[j];
                    }
                }
            }

        }

        return desencriptado;
    }


    public static int aNumero(String num){
        return Integer.parseInt(num);
    }
    public static String charAString(char ch){
        return String.valueOf(ch);
    }
}
