import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SistemaBeatRhythm sistema = new SistemaBeatTheRhythmImpl();
        menuPrincipal(sistema);


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
                AgregarInstrumento(sistema);
            }
        }

    }

    private static void AgregarInstrumento(SistemaBeatRhythm sistema) throws IOException{

    }
}


