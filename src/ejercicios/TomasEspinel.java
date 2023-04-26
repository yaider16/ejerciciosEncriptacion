package ejercicios;

public class TomasEspinel {

    public static String[] abc = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
    "t", "u", "v","w","x", "y", "z" };// array con abecedario


    public static void main(String[] args) {

        String encriptado =encriptacion("alejandro", 1, false); 
        System.out.println(encriptado);

        String desencriptado=desencriptar(encriptado, 1, true);
        System.out.println(desencriptado);

        
    }

    public static int buscadorLugar(String letra) {// creamos metodo para asignar posicion a cada letra del abecedario
        int lugar = -1;

        // ciclo para avanzar letra por letra
        for (int i = 0; i < abc.length; i++) {

            // asignamos variable a letra sola en posicion i
            String letraABC = abc[i];

            if (letraABC.equals(letra)) {// se compara con la letra utilizada en el siguiente metodo
                lugar = i;// asignamos posicion
                break;
            }
        }

        return lugar;// retornamos posicion
    }

    public static String encriptacion(String palabra, int numero, boolean desicion) {// creamos metodo para encriptar la
                                                                                     // palabra
        String palabraEncriptada = "";// creamos variable para ir agragando letra encriptada
        
        
        for (int i = 0; i < palabra.length(); i++) {// ciclo que recorre la longitud de la palabra a encriptar
            
            String caracter = palabra.substring(i, i + 1);// substring para sacar letra por letra
            
            int zona = buscadorLugar(caracter);// asigno variable con la posición    de la letra
            
            if (zona < 0) {
                palabraEncriptada += caracter;// si se cumple la condicion agregar caracter directamente
            } else {
            
                int zonaNueva = 0;// si no se cumple zona == 0
            
                if (desicion) {// recordar: desicion = true
                    zonaNueva = zona + numero;// le sumamos a zona el número del dorsal
            
                    if (zonaNueva > abc.length - 1) {// condicion: mayor al número de posiciones
                        zonaNueva = zonaNueva - abc.length - 1;// restamos el número de posiciones
                    }
                } else {
                    zonaNueva = zona - numero;// restamos el número del dorsal
                    if (zonaNueva < 0) {
                        zonaNueva +=abc.length;// sumamos el número de posiciones
                    }

                }
                String letraNueva = abc[zonaNueva];// toma la posicion zona nueva
                palabraEncriptada += letraNueva;// agragamos letra encriptada

            }
        }

        return palabraEncriptada;// retorna palabra encriptada
    }

    public static String desencriptar(String palabra, int numero, boolean desicion){
        
        String desencriptado = "";

        for (int i = 0; i < palabra.length(); i++) {

            String letra = toString(palabra.charAt(i));
            
            for (int j = 0; j < abc.length; j++) {
                
                if (desicion && letra.equals(abc[j])) {

                    if (j+numero>=abc.length) {
                        System.out.println("entro1");
                        System.out.println((j+numero)-abc.length);
                        desencriptado+= abc[(j+numero)-abc.length];
                    }else{
                        System.out.println("entro2");
                        desencriptado+= abc[j+numero];
                    }
                }

                else if (!desicion && letra.equals(abc[j])) {

                    if (j-numero<0) {

                        desencriptado+= abc[(j-numero)+abc.length-1];
                    }else{

                        desencriptado+= abc[j-numero];
                    }
                    
                }

            }
        }

        return desencriptado;
    }


    public static String toString(char ch){
        return String.valueOf(ch);
    }
    
}
