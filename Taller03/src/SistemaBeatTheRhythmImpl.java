import ucn.ArchivoSalida;
import ucn.Registro;
import ucn.StdOut;

import java.io.IOException;

public class SistemaBeatTheRhythmImpl implements SistemaBeatRhythm {


    /**
     * Corresponde a la lista de los instrumentos del sistema.
     */
    ListaInstrumento listaInstrumento;


    /**
     * Corresponde al constructor de la clase SistemaBeatTheRhythmImpl.
     */
    public SistemaBeatTheRhythmImpl(){
        this.listaInstrumento = new ListaInstrumento(1000);
    }



    /**
     * Método que agrega instrumentos tipo cuerda al sistema.
     * @param cvs Corresponde al identificador del instrumento.
     * @param precio Corresponde al precio del instrumento.
     * @param stock Corresponde al  stock del instrumento.
     * @param nombre Corresponde al nombre del instrumento.
     * @param tipoMaterial Corresponde al material del instrumento.
     * @param tipoInstrumento Corresponde al tipo del instrumento.
     * @param tipoCuerda Corresponde al tipo de cuerda del instrumento.
     * @param numeroCuerda Corresponde al número de cuerdas que tenga el instrumento.
     * @param tipo Corresponde a que tipo de instrumento es.
     * @return "true" si se logró añadir la el instrumento tipo cuerda a la lista o "false" si no se logró.
     */

    @Override
    public boolean agregarInstrumentoCuerda(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento, String tipoCuerda, int numeroCuerda, String tipo) {
        Cuerda cuerda = new Cuerda(cvs,precio,stock,nombre,tipoMaterial, tipoInstrumento,tipoCuerda,numeroCuerda,tipo);
        return this.listaInstrumento.agregarInstrumento(cuerda);
    }


    /**
     * Método que agrega instrumentos tipo percusión al sistema.
     * @param cvs Corresponde al identificador del instrumento.
     * @param precio Corresponde al precio del instrumento.
     * @param stock Corresponde al  stock del instrumento.
     * @param nombre Corresponde al nombre del instrumento.
     * @param tipoMaterial Corresponde al material del instrumento.
     * @param tipoInstrumento Corresponde al tipo del instrumento.
     * @param tipoPercusion Corresponde al tipo de percusión del instrumento.
     * @param altura Corresponde a la altura del instrumento.
     * @return "true" si se logró añadir el instrumento tipo percusión a la lista o "false" si no se logró.
     */

    public boolean agregarInstrumentoPercusion(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento,String tipoPercusion, String altura) {
        Percusion percusion = new Percusion(cvs,precio,stock,nombre,tipoMaterial, tipoInstrumento,tipoPercusion,altura);
        return this.listaInstrumento.agregarInstrumento(percusion);

    }


    /**
     * Método que agrega instrumentos tipo viento al sistema.
     * @param cvs Corresponde al identificador del instrumento.
     * @param precio Corresponde al precio del instrumento.
     * @param stock Corresponde al  stock del instrumento.
     * @param nombre Corresponde al nombre del instrumento.
     * @param tipoMaterial Corresponde al material del instrumento.
     * @param tipoInstrumento Corresponde al tipo del instrumento.
     * @return "true" si se logró añadir el instrumento tipo viento a la lista o "false" si no se logró.
     */

    public boolean agregarInstrumentoViento(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento) {
        Viento viento = new Viento(cvs,precio,stock,nombre,tipoMaterial, tipoInstrumento);
        return this.listaInstrumento.agregarInstrumento(viento);
    }


    /**
     * Método que vende un instrumento en el sistema.
     * @param cvs Corresponde al identificador del instrumento.
     */
    @Override
    public void venderInstrumento(String cvs) {

        Instrumento instrumento = this.listaInstrumento.buscarIntrumento2(cvs);

        if (instrumento == null){
            throw new IllegalArgumentException("Instrumento con cvs " + cvs + " no existe o no se encuentra disponible.");
        }

        this.listaInstrumento.eliminarInstrumento(cvs);
        StdOut.println("Nombre de instrumento vendido: "+instrumento.getNombre()+"\n"+"El precio del instrumento vendido fue de: "+instrumento.getPrecio()+"\n");
    }


    /**
     * Método que permite consultar el inventario del sistema.
     */
    @Override
    public String[] consultarInventario() {

        String[] listadoInstrumentos = new String[this.listaInstrumento.getCantMax()];

        for (int i = 0; i < listaInstrumento.getCantMax(); i++) {
            try{
                Instrumento instrumentoi = this.listaInstrumento.obtenerInstrumento(i);
                if (instrumentoi != null){
                    listadoInstrumentos[i] = instrumentoi.toString();
                }
            }catch (Exception E){
                continue;
            }
        }
        return listadoInstrumentos;
    }


    /**
     * Método que permite ver el inventario de un instrumento en específico sistema.
     * @param cvs Corresponde al identificador del instrumento.
     */
    @Override
    public String[] consultarInventarioEspecifico(String cvs) {

        String[] listadoInstrumentos = new String[this.listaInstrumento.getCantMax()];

        for (int i = 0; i < this.listaInstrumento.getCantMax(); i++) {

            Instrumento instrumento = this.listaInstrumento.getListaIntrumento()[i];
            if (instrumento !=null && instrumento.getCvs().equals(cvs)){
                listadoInstrumentos[i] =instrumento.toString();
            }
        }
        return listadoInstrumentos;
    }


    /**
     * Método que permite ver si existe un instrumento en el sistema.
     * @param cvs Corresponde al identificador del instrumento.
     */

    @Override
    public boolean existeInstrumento(String cvs) {

        for (int i = 0; i < this.listaInstrumento.getCantActual(); i++) {
            if (this.listaInstrumento.getListaIntrumento()[i].getCvs().equalsIgnoreCase(cvs)){
                return true;
            }
        }
        return false;
    }


    /**
     * Método que cierra y actualiza el sistema.
     */
    @Override
    public void cierre() throws IOException {

        ArchivoSalida archivoSalida = new ArchivoSalida("instrumentosSistema.txt");

        for (int i = 0; i < listaInstrumento.getCantMax(); i++) {

            Registro registro = new Registro(6);

            Instrumento instrumentoi = this.listaInstrumento.obtenerInstrumento(i);
            if (instrumentoi != null){

                registro.agregarCampo(instrumentoi.getCvs());
                registro.agregarCampo(instrumentoi.getPrecio());
                registro.agregarCampo(instrumentoi.getStock());
                registro.agregarCampo(instrumentoi.getNombre());
                registro.agregarCampo(instrumentoi.getTipoMaterial());
                registro.agregarCampo(instrumentoi.getTipoInstrumento());
                archivoSalida.writeRegistro(registro);
            }

        }
        archivoSalida.close();
    }
}
