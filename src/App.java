import java.util.Scanner;

import ejercicios.AngelaPeña;
import ejercicios.DavidCruz;
import ejercicios.EliasCamargo;
import ejercicios.NicolCepeda;
import ejercicios.SamirYate;
import ejercicios.SamuelCamargo;
import ejercicios.SamuelCastro;
import ejercicios.SeleneDaza;
import ejercicios.TomasEspinel;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        /*
         * Aqui ejecutaré la función principal e importaré los ejercicios de mis compañeros cada
         * Uno en un archivo distinto para así tener un orden mayor
         */
        
        final int ANGELA=1;
        final int DAVID=2;
        final int ELIAS=3;
        final int JULIAN=4;
        final int LAURA=5;
        final int MANUEL=6;
        final int NICOL=7;
        final int SAMIR=8;
        final int SAMUEL1=9;
        final int SAMUEL2=10;
        final int SELENE=11;
        final int SERGIO=12;
        final int TOMAS=13;
        final int LAURA2=14;
        final int JUAN=15;

        System.out.println("--------------Menú de los ejercicios de encriptación------------");
        System.out.println("1. Angela Peña\n2 David Cruz\n3 EliasCamargo\n4 Julian Cabra\n5 Laura Campiño\n6 Manuel Cruz\n7 Nicol Cepeda\n8 Samir Yate\n9 Samuel Camargo\n10 Samuel Castro\n11 Selene Daza\n12 Sergio Calderón\n13 Para Tomas Espinel\n14 Para Laura Campiño\n15 Para Juan\n0 Para salir");
        System.out.print("Cual ejercicio desea hacer: ");
        int des = sc.nextInt();

        System.out.println("\n");

        switch (des) {
            case ANGELA:
                AngelaPeña angela = new AngelaPeña();
                angela.main(args);
                System.out.println("\n\n\n");
                break;

            case DAVID:
                DavidCruz david = new DavidCruz();
                david.main(args);
                System.out.println("\n\n\n");
                break;
            
            case ELIAS:
                EliasCamargo elias = new EliasCamargo();
                elias.main(args);
                System.out.println("\n\n\n");
                break;

            case JULIAN:
                break;

            case LAURA:
                break;

            case MANUEL:
                break;
            
            case NICOL:
                NicolCepeda nicol = new NicolCepeda();
                nicol.main(args);
                System.out.println("\n\n\n");
                break;
            
            case SAMIR:
                SamirYate samir = new SamirYate();
                samir.main(args);
                System.out.println("\n\n\n");
                break;
            
            case SAMUEL1:
                SamuelCamargo samuelcamargo = new SamuelCamargo();
                samuelcamargo.main(args);
                System.out.println("\n\n\n");
                break;

            case SAMUEL2:
                SamuelCastro samuelcastro = new SamuelCastro();
                samuelcastro.main(args);
                System.out.println("\n\n\n");
                break;

            case SELENE:
                SeleneDaza selene = new SeleneDaza();
                selene.main(args);
                System.out.println("\n\n\n");
                break;
            
            case SERGIO:
                break;

            case TOMAS:
                TomasEspinel tomas = new TomasEspinel();
                tomas.main(args);
                System.out.println("\n\n\n");
                break;

            case LAURA2:

                break;

            case JUAN:

                break;
            
            default:
                break;
        }
        sc.close();
    }
}
    