package ejercicios;
import java.util.Scanner;

public class ManuelCruz {
    public String enc() throws Exception {

        Scanner lectura = new Scanner(System.in);
        String palabraencriptar = lectura.nextLine();
        String encriptado="";
        String abc = "abcdefghijklmnopqrstuvwxyz";// uso el abcdario como una palabra, luego para comparar solo uso un substring que vaya letra por letra

        String cuadrado = "";//la variable vacia es donde se va a almacenar la longitud de lado del cuadrado

        String espacios = "             ";//los espacios los uso para separar cada cuadrado
        String cuadradouno = ".............";//esta variable es para cuando la letra corresponda a la segunda mitad, para poder imprimir un cuadrado antes de imprimir el otro
        int lonpalabra = palabraencriptar.length();
        int lonabc = abc.length();
        for (int i = 0; i<=lonpalabra-1; i++){//primer for que va a ir letra por letra en la palabra

            String letraporletra = (palabraencriptar.substring(i, i+1)); 

            for (int e = 0; e<lonabc; e++){// segundo for que va a ir letra por letra en el abcdario

                String letras= (abc.substring(e, e+1));

                if (letraporletra.equals(letras)){//cuando las letras que pasan por los for coincidan se cumple la condicion

                        if (e <= 12){//esta primera condicion es donde me va a imprimir solo un cuadrado, esta va hasta la letra "m"

                            while ( cuadrado.length() <= e){
                                cuadrado = cuadrado + ".";
                                 /*
                                * los puntos son para hacer los cuadrados, la cantidad de puntos en setido horizontal corresponde a la posicionde la letra en el
                                * abcdario y en sentido vertical se lee segun si la letra pertenece a las 13 primeras o a las 13 segundas
                                */
                                }
                            for (int c = 0; c<=e; c++){
                                cuadrado+="\n"; 
                            }
                        }
                        if (e > 12){
                            while ( cuadrado.length() <= e - 13){
                                cuadrado = cuadrado + "."; /*
                                * los puntos son para hacer los cuadrados, la cantidad de puntos en setido horizontal corresponde a la posicionde la letra en el
                                * abcdario y en sentido vertical se lee segun si la letra pertenece a las 13 primeras o a las 13 segundas
                                */
                                }
                            for (int c = 0; c<=e - 13; c++){//este for me va  a imprimir la altura de la piramide, correspondiente al lado o pues a la posicion de la letra
                                cuadrado+=cuadradouno + espacios;
                            }
                        }
                
                    
                    System.out.println("____________________");//esto es para poder distinguir los cuadros que voy imprimiendo
                    System.out.println(e+1); //esto sirve como una pista de la posicion que ocupa la letra impresa en el abcdario
                }
            }
            encriptado+=cuadrado;
        }
        
        lectura.close();
        return encriptado;
    }
}
