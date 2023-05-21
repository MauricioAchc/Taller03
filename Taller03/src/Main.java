import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SistemaBeatRhythm sistema = new SistemaBeatTheRhythmImpl();

        cargarInstrumentos(sistema);

        menuPrincipal(sistema);
    }

    //region LECTURA DE ARCHIVOS.

    /**
     * Subprograma para cargar y leer el archivo para guardarlo en la ListaInstrumento.
     * @param sistema Corresponde al llamamiento al SistemaBeatTheRhythmImpl.
     * @throws IOException Detiene la carga/escritura  del archivo si ocurre algun error.
     */
    public static void cargarInstrumentos(SistemaBeatRhythm sistema) throws IOException {
        ArchivoEntrada archivoEntrada = new ArchivoEntrada("instrumentos.txt");
        while (!archivoEntrada.isEndFile()){
            Registro registroEntrada = archivoEntrada.getRegistro();
            String cvs = registroEntrada.getString();
            int precio = registroEntrada.getInt();
            int stock = registroEntrada.getInt();
            String nombre = registroEntrada.getString();
            String tipoMaterial = registroEntrada.getString();
            String tipoInstrumento = registroEntrada.getString();

            String tipoInstrumentoS = tipoInstrumento.replace("","");

            switch (tipoInstrumento){
                case "cuerda":
                    String tipoCuerda = registroEntrada.getString();
                    int numeroCuerda = registroEntrada.getInt();
                    String tipo = registroEntrada.getString();

                    boolean estadoCuerda = sistema.agregarInstrumentoCuerda(cvs,precio,stock,nombre,tipoMaterial,tipoInstrumento,tipoCuerda,numeroCuerda,tipo);
                    if (estadoCuerda){
                        StdOut.println(nombre+" Fué agregado exitosamente.");
                    }else{
                        StdOut.println(nombre+" No fué agregado");
                    }
                    break;
                case "percusion":
                    String tipoPercusion = registroEntrada.getString();
                    String altura = registroEntrada.getString();

                    boolean estadoPercusion = sistema.agregarInstrumentoPercusion(cvs,precio,stock,nombre,tipoMaterial,tipoInstrumento,tipoPercusion,altura);
                    if (estadoPercusion){
                        StdOut.println(nombre+" Fué agregado exitosamente.");
                    }else{
                        StdOut.println(nombre+" No fué agregado");
                    }
                    break;
                case "viento":
                    boolean estadoViento = sistema.agregarInstrumentoViento(cvs,precio,stock,nombre,tipoMaterial,tipoInstrumento);
                    if (estadoViento){
                        StdOut.println(nombre+" Fué agregado exitosamente.");
                    }else{
                        StdOut.println(nombre+" No fué agregado");
                    }
                    break;
            }
        }
        archivoEntrada.close();
    }

    /**
     * Subprograma que lleva el menú principal del usuario.
     * @param sistema Corresponde al llamamiento al SistemaBeatTheRhythmImpl.
     * @throws IOException Detiene la carga/escritura del archivo si ocurre algun error.
     */
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

            switch (menu){
                case 1 -> subMenuAgregarInstrumento(sistema);
                case 2 -> subMenuVenderInstrumento(sistema);

                case 3 -> subMenuDesplegarInstrumentos(sistema);
                case 4 -> cierre(sistema);
            }
        }

    }

    private static void cierre(SistemaBeatRhythm sistema) throws  IOException{
        sistema.cierre();

        StdOut.println("Guardando datos y apagando el sistema...\n hasta luego");
    }

    /**
     * Subprograma que lleva el submenú de despliegue de los instrumentos.
     * @param sistema Corresponde al llamamiento al SistemaBeatRhythmImpl.
     */
    public static void subMenuDesplegarInstrumentos(SistemaBeatRhythm sistema){

        int opcionInt = 0;

        while (opcionInt != 3){
            StdOut.println("--------->Menú despliegue de Instrumentos<---------");
            StdOut.println("[1] Desplegar Instrumento específico.");
            StdOut.println("[2] Desplegar todos los Instrumentos.");
            StdOut.println("[3] Volver al menú anterior.");
            StdOut.print("Ingrese su opción: ");
            String opcionStr = StdIn.readLine();

            while (true){
                try{
                    opcionInt = Integer.parseInt(opcionStr);
                    if (1 <= opcionInt && opcionInt <= 3){
                        break;
                    }else{
                        StdOut.println("Error, la opción ingresada no existe");
                        StdOut.print("Ingrese su opción nuevamente: ");
                        opcionStr = StdIn.readString();
                    }
                }catch(Exception e){
                    StdOut.println("Error, la opción ingresada no existe");
                    StdOut.print("Ingrese su opción nuevamente: ");
                    opcionStr = StdIn.readString();
                }
            }

            switch (opcionInt) {
                case 1 -> desplegarInstrumentoPorCvs(sistema);
                case 2 -> desplegarTodosLosInstrumentos(sistema);
                case 3 -> StdOut.println("\nVolviendo al menú anterior...\n");
            }
        }
    }

    /**
     * Subprograma que lleva el submenú de agregar los instrumentos.
     * @param sistema Corresponde al llamamiento al SistemaBeatRhythmImpl.
     */
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
            switch (opcionInt){
                case 1 -> agregarInstrumentoCuerda(sistema);
                case 2 -> agregarInstrumentoPercusion(sistema);
                case 3 -> agregarInstrumentoViento(sistema);
            }
        }
    }

    /**
     * Subprograma que agrega los instrumentos de tipo cuerda al sistema.
     * @param sistema Corresponde al llamamiento al SistemaBeatRhythmImpl.
     */
    public static void agregarInstrumentoCuerda(SistemaBeatRhythm sistema){
        StdOut.println("--------->Agregar nuevo Instrumento de Cuerda al sistema<---------");
        StdOut.print("Ingrese cvs del Instrumento: ");
        String cvs = StdIn.readLine();

        boolean existe =  sistema.existeInstrumento(cvs);

        if (existe){
            StdOut.print("Instrumento ya existe en el sistema.\nVolviendo al menú anterior...\n");
        }else{
            StdOut.print("Ingrese precio del instrumento: ");
            int precio = Integer.parseInt(StdIn.readLine());

            StdOut.print("Ingrese stock del instrumento: ");
            int stock = Integer.parseInt(StdIn.readLine());

            StdOut.print("Ingrese nombre del instrumento: ");
            String nombre = StdIn.readLine();

            StdOut.print("Ingrese tipo de material el instrumento: ");
            String tipoMaterial = StdIn.readLine();

            StdOut.print("Ingrese tipo de instrumento (Cuerda, Percusión o Viento): ");
            String tipoInstrumento = StdIn.readLine();

            StdOut.print("Ingrese tipo de cuerda del instrumento: ");
            String tipoCuerda = StdIn.readLine();

            StdOut.print("Ingrese numero de cuerdas del instrumentos: ");
            int numeroCuerda = Integer.parseInt(StdIn.readLine());

            StdOut.print("Ingrese tipo (Acústico, Eléctrico): ");
            String tipo = StdIn.readLine();

            sistema.agregarInstrumentoCuerda(cvs,precio,stock,nombre,tipoMaterial,tipoInstrumento,tipoCuerda,numeroCuerda,tipo);
            StdOut.println("\n¡Instrumento registrado con éxito!\n");
        }
    }

    /**
     * Subprograma que agrega los instrumentos de tipo percusión al sistema.
     * @param sistema Corresponde al llamamiento al SistemaBeatRhythmImpl.
     */
    public static  void agregarInstrumentoPercusion(SistemaBeatRhythm sistema){
        StdOut.println("--------->Agregar nuevo Instrumento de Percusión al sistema<---------");
        StdOut.print("Ingrese cvs del Instrumento: ");
        String cvs = StdIn.readLine();

        boolean existe =  sistema.existeInstrumento(cvs);

        if (existe){
            StdOut.print("Instrumento ya existe en el sistema.\nVolviendo al menú anterior...\n");
        }else{
            StdOut.print("Ingrese precio el instrumento: ");
            int precio = Integer.parseInt(StdIn.readLine());

            StdOut.print("Ingrese stock el instrumento: ");
            int stock = Integer.parseInt(StdIn.readLine());

            StdOut.print("Ingrese nombre el instrumento: ");
            String nombre = StdIn.readLine();

            StdOut.print("Ingrese tipo de material el instrumento: ");
            String tipoMaterial = StdIn.readLine();

            StdOut.print("Ingrese tipo de instrumento (Cuerda, Percusión o Viento): ");
            String tipoInstrumento = StdIn.readLine();

            StdOut.print("Ingrese tipo de percusión: ");
            String tipoPercusion = StdIn.readLine();

            StdOut.print("Ingrese altura del instrumento (Definida o Indefinida): ");
            String altura = StdIn.readLine();


            sistema.agregarInstrumentoPercusion(cvs,precio,stock,nombre,tipoMaterial,tipoInstrumento,tipoPercusion,altura);
            StdOut.println("\n¡Instrumento registrado con éxito!\n");
        }
    }

    /**
     * Subprograma que agrega los instrumentos de tipo viento al sistema.
     * @param sistema Corresponde al llamamiento al SistemaBeatRhythmImpl.
     */
    public static  void agregarInstrumentoViento(SistemaBeatRhythm sistema){
        StdOut.println("--------->Agregar nuevo Instrumento de Percusión al sistema<---------");
        StdOut.print("Ingrese cvs del Instrumento: ");
        String cvs = StdIn.readLine();

        boolean existe =  sistema.existeInstrumento(cvs);

        if (existe){
            StdOut.print("Instrumento ya existe en el sistema.\nVolviendo al menú anterior...\n");
        }else{
            StdOut.print("Ingrese precio del instrumento: ");
            int precio = Integer.parseInt(StdIn.readLine());

            StdOut.print("Ingrese stock el instrumento: ");
            int stock = Integer.parseInt(StdIn.readLine());

            StdOut.print("Ingrese nombre del instrumento: ");
            String nombre = StdIn.readLine();

            StdOut.print("Ingrese tipo de material el instrumento: ");
            String tipoMaterial = StdIn.readLine();

            StdOut.print("Ingrese tipo de instrumento (Cuerda, Percusión, Viento): ");
            String tipoInstrumento = StdIn.readLine();

            sistema.agregarInstrumentoViento(cvs,precio,stock,nombre,tipoMaterial,tipoInstrumento);
            StdOut.println("\n¡Instrumento registrado con éxito!\n");
        }
    }

    /**
     * Subprograma que despliega todos los instrumentos del sistema.
     * @param sistema Corresponde al llamamiento al SistemaBeatRhythmImpl.
     */
    public static void desplegarTodosLosInstrumentos(SistemaBeatRhythm sistema){

        String[] instrumentos = sistema.consultarInventario();
        StdOut.println("--------->Despliegue de todos los Instrumentos del sistema<---------"+"\n");

        for (String instrumento : instrumentos){
            if (instrumento != null){
                StdOut.println(instrumento + "\n");
            }
        }
    }

    /**
     * Subprograma que despliega los instrumentos de acuerdo a sus cvs del sistema.
     * @param sistema Corresponde al llamamiento al SistemaBeatRhythmImpl.
     */
    public static void desplegarInstrumentoPorCvs(SistemaBeatRhythm sistema){


        StdOut.println("\n"+"Ingrese cvs del instrumento a buscar: "+"\n");
        String cvs = StdIn.readLine();

        if (sistema.existeInstrumento(cvs)){
            String[] instrumentos = sistema.consultarInventarioEspecifico(cvs);

            for (String instrumento : instrumentos){
                if (instrumento != null){
                    StdOut.println(instrumento + "\n");
                }
            }
        }else{
            StdOut.println("Cvs del instrumento no encontrado!"+"\n");
        }
    }

    /**
     * Subprograma que lleva el submenú de vender los instrumentos.
     * @param sistema Corresponde al llamamiento al SistemaBeatRhythmImpl.
     */
    public static void subMenuVenderInstrumento(SistemaBeatRhythm sistema){
            StdOut.println("--------->Venta de un Instrumento<---------");
            StdOut.print("Ingrese cvs del Instrumento: ");
            String cvs = StdIn.readLine();

            boolean existe =  sistema.existeInstrumento(cvs);


            if (existe){
                StdOut.print("Instrumento en stock"+"\n");

                StdOut.println("\n**************** Boleta ****************\n");
                sistema.venderInstrumento(cvs);
                StdOut.println("\n**¡Instrumento vendido con éxito!**\n");


            }else{
                StdOut.println("\n¡No se encuentra el instrumento!\n");
            }
    }
}