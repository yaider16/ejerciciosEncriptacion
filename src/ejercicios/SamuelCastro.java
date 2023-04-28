package ejercicios;

import java.util.Scanner;

/*Buenas compañeros y profesor mi ejercicio de encriptacion tiene como base que

si la posicion de la letra en la frase digitada es par la letra se cambia por la
 del abecedario chino en base en su numero del abecedario normal

si no es par pero la longitud de la frase digitada es par la letra se cambia por la letra del abecedario 
 japones en base a su numero en el abecedario normal
 
 y si no cumple ninguna de estas 
 condiciones la letra sera sustituida por la del abecedario al reves en base en su numero 
 del abecedario normal 
 ejemplos:
hola-コ苦セ色
holaa-q苦m色x
hola samuel-n特j艾?伊u和a鸡j
hola samuell-セ玉ツ日?黑キ丝ア卡ツ和
 
 */

 
public class SamuelCastro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Da la frase: ");
        String frase = sc.nextLine();

        String encriptado = encriptar(frase);
        String desencriptado= desencriptar(encriptado);

        System.out.println("Encriptado: "+ encriptado);
        System.out.println("Desencriptado: "+ desencriptado);
        sc.close();
    }




public static String encriptar(String palabra) {
		//Defino vector de el abecedario normal
				String[]vector=new String[27];
				
				//Defino variables
				//oalabranueva la cual va a ser la palabra encriptada
				String palabranueva="";
				//letra nueva la cual va a ser la nueva letra que va a formar la palabra encriptada
				String letranueva="";
				//esta variable defino los espacios entre palabras
				String espacio=" ";
				//el umero de la letra segun el abecedario
				int numeroletra=-1;
				//esta variable representa hasta que caracter se va a leer el substring
				int hasta=0;
				//esta variable va a guardar la longitud de la palabra 
				int longifrase=palabra.length();
				
				//defino los vectores
				vector[1]="a";
				vector[2]="b";
				vector[3]="c";
				vector[4]="d";
				vector[5]="e";
				vector[6]="f";
				vector[7]="g";
				vector[8]="h";
				vector[9]="i";
				vector[10]="j";
				vector[11]="k";
				vector[12]="l";
				vector[13]="m";
				vector[14]="n";
				vector[15]="o";
				vector[16]="p";
				vector[17]="q";
				vector[18]="r";
				vector[19]="s";
				vector[20]="t";
				vector[21]="u";
				vector[22]="v";
				vector[23]="w";
				vector[24]="x";
				vector[25]="y";
				vector[26]="z";
				
				//Defino el ciclo que guarada la posicion de cada letra
				for(int i=0; i<longifrase; i++) {

					//variable que me va a ayudar que se lea una sola palabra
					hasta=i+1;

					//mientras se repasa el abecedario hacer
					for(int q=1; q<27; q++) {

						//si la palabra de la frase es un espacio hacer
						if(palabra.substring(i,hasta).compareTo(espacio)==0) {
							//se cambia los espacios por signos de interrogacion 
							letranueva= "?";
							//sino 
						}else {
								//si la letra es igual a la letra que se encuentra en el vector hacer
								if(palabra.substring(i,hasta).compareTo(vector[q])==0) {
									//el numero de la letra es igual a donde esta
									numeroletra=q;
									//si la posicion de la letra es par hacer
									if(hasta%2==0 ) {
										//Defino el vector del abecedario chino
										String[] vectorchino=new String[27];

										//Defino el abecedario chino
										vectorchino[1]="阿";
										vectorchino[2]="贝";
										vectorchino[3]="色";
										vectorchino[4]="德";
										vectorchino[5]="饿";
										vectorchino[6]="艾";
										vectorchino[7]="日";
										vectorchino[8]="什";
										vectorchino[9]="伊";
										vectorchino[10]="鸡";
										vectorchino[11]="卡";
										vectorchino[12]="勒";
										vectorchino[13]="马";
										vectorchino[14]="娜";
										vectorchino[15]="哦";
										vectorchino[16]="佩";
										vectorchino[17]="苦";
										vectorchino[18]="和";
										vectorchino[19]="丝";
										vectorchino[20]="特";
										vectorchino[21]="玉";
										vectorchino[22]="维";
										vectorchino[23]="独";
										vectorchino[24]="伊";
										vectorchino[25]="黑";
										vectorchino[26]="贼";
										//mientras se recorre el abecedario chino hacer
										for (int w=1; w<27; w++) {
						//si la posicion en el abecedario de la letra es igual a w(letra que recorre el abecedario) hacer
											if (numeroletra==w) {
												//a la posicion se le suma la mitad de la longitud de la frase
												int nunumero=w+longifrase/2;
												//si el numero es mayor a las letras del abecedario hacer
												if(nunumero>26) {
													//numero menos el total de las letras del abecedario
													nunumero=nunumero-26;
												}
												//se cambia la letra por la que esta en el vector de ese numero
												letranueva=vectorchino[nunumero];
												break;
											}
										}
										//sino
									}else {
										//si la longitud de la frase es par
										if (longifrase%2==0) {
											//Defino el vector de el abecedario japones
											String[] vectorjapo=new String[27];
											//Defino el abecedario
											vectorjapo[1]="ア";
											vectorjapo[2]="イ";
											vectorjapo[3]="ウ";
											vectorjapo[4]="エ";
											vectorjapo[5]="オ";
											vectorjapo[6]="カ";
											vectorjapo[7]="キ";
											vectorjapo[8]="ク";
											vectorjapo[9]="ケ";
											vectorjapo[10]="コ";
											vectorjapo[11]="サ";
											vectorjapo[12]="シ";
											vectorjapo[13]="ス";
											vectorjapo[14]="セ";
											vectorjapo[15]="ソ";
											vectorjapo[16]="タ";
											vectorjapo[17]="チ";
											vectorjapo[18]="ツ";
											vectorjapo[19]="テ";
											vectorjapo[20]="ト";
											vectorjapo[21]="ナ";
											vectorjapo[22]="ニ";
											vectorjapo[23]="ぬ";
											vectorjapo[24]="ね";
											vectorjapo[25]="の";
											vectorjapo[26]="ひ";
											//mientras se recorre el abecedario japones hacer
											for (int w=1; w<27; w++) {
												//si la posicion en el abecedario de la letra es igual a w hacer
												if (numeroletra==w) {
												//a la posicion se le suma la mitad de la longitud de la frase
													int nunumero=w+longifrase/2;
													//si el numero es mayor a las letras del abecedario hacer
													if(nunumero>26) {
														//numero menos el total de las letras del abecedario
														nunumero=nunumero-26;
													}
												//se cambia la letra por la que esta en el vector de ese numero
													letranueva=vectorjapo[nunumero];
													break;
												}
											}
											//sino
										}else {
											//Defino el vector del abecedario alrevez
											String[] vectoral=new String[27];
											//Defino el abecedario alrevez
											vectoral[1]="z";
											vectoral[2]="y";
											vectoral[3]="x";
											vectoral[4]="w";
											vectoral[5]="v";
											vectoral[6]="u";
											vectoral[7]="t";
											vectoral[8]="s";
											vectoral[9]="r";
											vectoral[10]="q";
											vectoral[11]="p";
											vectoral[12]="o";
											vectoral[13]="n";
											vectoral[14]="m";
											vectoral[15]="l";
											vectoral[16]="k";
											vectoral[17]="j";
											vectoral[18]="i";
											vectoral[19]="h";
											vectoral[20]="g";
											vectoral[21]="f";
											vectoral[22]="e";
											vectoral[23]="d";
											vectoral[24]="c";
											vectoral[25]="b";
											vectoral[26]="a";
											//mientras se recorre el abecedario hacer
											for (int w=1; w<27; w++) {
												//si la posicion en el abecedario de la letra es igual a w hacer
												if (numeroletra==w) {
												//a la posicion se le suma la mitad de la longitud de la frase
													int nunumero=w+longifrase/2;
													//si el numero es mayor a las letras del abecedario hacer
													if(nunumero>26) {
														//numero menos el total de las letras del abecedario
														nunumero=nunumero-26;
													}
												//se cambia la letra por la que esta en el vector de ese numero
													letranueva=vectoral[nunumero];
													break;
												}
											}	
										}
									}
								}
							}
					}
					//aqui se va formando la palabra con las letras que nos arroja los condicionales
					palabranueva=palabranueva+letranueva;
				}
					
				//se retorna la palabra encriptada 
		return palabranueva;
		
	}


public static String desencriptar(String palabras) {
		
		String[]vector=new String[27];
		int longifrase=palabras.length();
		String palabra=palabras;
		

		String desencriptado="";
		String letrades="";
		String letra="";
		
		int hasta=0;
		int numletra=0;
		
		
		vector[1]="a";
		vector[2]="b";
		vector[3]="c";
		vector[4]="d";
		vector[5]="e";
		vector[6]="f";
		vector[7]="g";
		vector[8]="h";
		vector[9]="i";
		vector[10]="j";
		vector[11]="k";
		vector[12]="l";
		vector[13]="m";
		vector[14]="n";
		vector[15]="o";
		vector[16]="p";
		vector[17]="q";
		vector[18]="r";
		vector[19]="s";
		vector[20]="t";
		vector[21]="u";
		vector[22]="v";
		vector[23]="w";
		vector[24]="x";
		vector[25]="y";
		vector[26]="z";
		
		
		for (int e=0; e<longifrase; e++) {

			hasta=e+1;

			//letra es igual a la letra de la frase con los parametros
			letra=palabra.substring(e,hasta);

			//si la letra es igual a un signo de interrogacion hacer
			if(letra.equals("?")){
				
				letrades=" ";
				
			}
            else {
				
				if (hasta%2==0) {
					//Defino el vector
					String[] vectorchino=new String[27];
					
					//Defino el abecedario
					vectorchino[1]="阿";
					vectorchino[2]="贝";
					vectorchino[3]="色";
					vectorchino[4]="德";
					vectorchino[5]="饿";
					vectorchino[6]="艾";
					vectorchino[7]="日";
					vectorchino[8]="什";
					vectorchino[9]="伊";
					vectorchino[10]="鸡";
					vectorchino[11]="卡";
					vectorchino[12]="勒";
					vectorchino[13]="马";
					vectorchino[14]="娜";
					vectorchino[15]="哦";
					vectorchino[16]="佩";
					vectorchino[17]="苦";
					vectorchino[18]="和";
					vectorchino[19]="丝";
					vectorchino[20]="特";
					vectorchino[21]="玉";
					vectorchino[22]="维";
					vectorchino[23]="独";
					vectorchino[24]="<";
					vectorchino[25]="黑";
					vectorchino[26]="贼";
					//mientras se recorre el abecedario
					for (int w=1; w<27; w++) {
						//si la letra es igual a la del vector con la variable
						if (letra.compareTo(vectorchino[w])==0) {
							//se define el numero
							numletra=w-longifrase/2;
							//si el numero es menor a 1
							if(numletra<1) {
								// se le suma el total de las letras del abecedario
								numletra=numletra+26;
							}
							break;
						}
					}
					 //sino
				}else {
					
					if(longifrase%2==0) {

						String[] vectorjapo=new String[27];
						//Defino el abecedario
						vectorjapo[1]="ア";
						vectorjapo[2]="イ";
						vectorjapo[3]="ウ";
						vectorjapo[4]="エ";
						vectorjapo[5]="オ";
						vectorjapo[6]="カ";
						vectorjapo[7]="キ";
						vectorjapo[8]="ク";
						vectorjapo[9]="ケ";
						vectorjapo[10]="コ";
						vectorjapo[11]="サ";
						vectorjapo[12]="シ";
						vectorjapo[13]="ス";
						vectorjapo[14]="セ";
						vectorjapo[15]="ソ";
						vectorjapo[16]="タ";
						vectorjapo[17]="チ";
						vectorjapo[18]="ツ";
						vectorjapo[19]="テ";
						vectorjapo[20]="ト";
						vectorjapo[21]="ナ";
						vectorjapo[22]="ニ";
						vectorjapo[23]="ぬ";
						vectorjapo[24]="ね";
						vectorjapo[25]="の";
						vectorjapo[26]="ひ";
						

						for (int w=1; w<vector.length; w++) {
							
							if (letra.equals(vectorjapo[w])) {
							
								numletra=w-longifrase/2;
							
								if(numletra<1) {
							
									numletra=numletra+26;
								}
								break;
							}
						}
						//sino
					}else {
						//Defino el vector
						String[] vectoral=new String[27];

						
						//Defino el abecedario
						vectoral[1]="z";
						vectoral[2]="y";
						vectoral[3]="x";
						vectoral[4]="w";
						vectoral[5]="v";
						vectoral[6]="u";
						vectoral[7]="t";
						vectoral[8]="s";
						vectoral[9]="r";
						vectoral[10]="q";
						vectoral[11]="p";
						vectoral[12]="o";
						vectoral[13]="n";
						vectoral[14]="m";
						vectoral[15]="l";
						vectoral[16]="k";
						vectoral[17]="j";
						vectoral[18]="i";
						vectoral[19]="h";
						vectoral[20]="g";
						vectoral[21]="f";
						vectoral[22]="e";
						vectoral[23]="d";
						vectoral[24]="c";
						vectoral[25]="b";
						vectoral[26]="a";
						//mientras se recorre el abecedario
						for (int w=1; w<27; w++) {
							//si la letra es igual a la del vector con la variable
							if (letra.compareTo(vectoral[w])==0) {
								//se define el numero
								numletra=w-longifrase/2;
								//si el numero es menor a 1
								if(numletra<1) {
									// se le suma el total de las letras del abecedario
									numletra=numletra+26;
								}
								break;
							}
						}
					}
				}


				
				for(int u=1; u<vector.length; u++) {

					
					if(numletra==u) {
					
						letrades=vector[u];
						break;
					}
				}
			}
			desencriptado+=letrades;
		}
			
		return desencriptado;
	}
}
