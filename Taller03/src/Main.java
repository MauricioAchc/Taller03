import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SistemaBeatRhythm sistema = new SistemaBeatTheRhythmImpl();
        menuPrincipal(sistema);
        subMenuAgregarInstrumento(sistema);


    }

    public static void menuPrincipal(SistemaBeatRhythm sistema) throws IOException{
        int menu = 0;

        while(menu != 4){
            StdOut.println("------------------------>Bienvenido a Beat the Rhythm<------------------------");
            StdOut.println("[1]  Agregar Instrumento");
            StdOut.println("[2]  Vender Instrumento");
            StdOut.println("[3]  Consultar Inventario");
            StdOut.println("[4]  Cierre");
            StdOut.println("Ingrese una opción por favor:");
            String menuStr = StdIn.readLine().strip();
            int menuInt;


            while(true){
                try{
                    menuInt = Integer.parseInt(menuStr);
                    if(1 <= menuInt && menuInt <=4){
                        break;
                    }else{
                        StdOut.println("error la opcion ingresada no existe");
                        StdOut.println("Ingrese una opción valida por favor");
                        menuStr = StdIn.readString();
                    }

                }catch(Exception e){
                    StdOut.println("error la opcion ingresada no existe");
                    StdOut.println("Ingrese una opción valida por favor");
                    menuStr = StdIn.readString();
                }
            }
            menu = menuInt;

            if (menu == 1) {
                subMenuAgregarInstrumento(sistema);
                venderInstrumento(sistema);
                consultarInventario(sistema);
                cierre(sistema);
            }
        }

    }


    private static void venderInstrumento(SistemaBeatRhythm sistema) throws  IOException{

    }
    private static void consultarInventario(SistemaBeatRhythm sistema) throws  IOException{

    }

    private static void cierre(SistemaBeatRhythm sistema) throws  IOException{
        sistema.cierre();
        StdOut.println("Cerrando el sistema...\n hasta luego");

    }











    public  static void subMenuAgregarInstrumento(SistemaBeatRhythm sistema){
        int opcionInt = 0;

        while(opcionInt != 4){
            StdOut.println("------------------------>Menú agregar Instrumentos<------------------------");
            StdOut.println("[1]  Agregar Instrumento de Cuerda");
            StdOut.println("[2]  Agregar Instrumento de Percusión");
            StdOut.println("[3]  Agregar Instrumento de Viento");
            StdOut.println("[4]  Volver al menú anterior");
            StdOut.println("Ingrese una opción por favor:");
            String opcionStr = StdIn.readLine();

            while(true){
                try{
                    opcionInt = Integer.parseInt(opcionStr);
                    if(1 <= opcionInt && opcionInt <=4){
                        break;
                    }else{
                        StdOut.println("error la opcion ingresada no existe");
                        StdOut.println("Ingrese una opción valida por favor");
                        opcionStr = StdIn.readString();
                    }

                }catch(Exception e){
                    StdOut.println("error la opcion ingresada no existe");
                    StdOut.println("Ingrese una opción valida por favor");
                    opcionStr = StdIn.readString();
                }
            }
            if (opcionInt == 1) {
                agregarInstrumentoCuerda(sistema);
                agregarInstrumentoPercusion(sistema);
                agregarInstrumentoViento(sistema);
                StdOut.println("...Volviento al menú anterior...");
            }

        }
    }

    public static  void agregarInstrumentoCuerda(SistemaBeatRhythm sistema){

    }
    public static  void agregarInstrumentoPercusion(SistemaBeatRhythm sistema){

    }
    public static  void agregarInstrumentoViento(SistemaBeatRhythm sistema){

    }


}


