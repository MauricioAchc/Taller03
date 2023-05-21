import java.io.IOException;

public interface SistemaBeatRhythm {


    /**
     * Método que agrega instrumentos al sistema.
     * @param cvs Corresponde al identificador del instrumento.
     * @param precio Corresponde al precio del instrumento.
     * @param stock Corresponde al  stock del instrumento.
     * @param nombre Corresponde al nombre del instrumento.
     * @param tipoMaterial Corresponde al material del instrumento.
     * @param tipoInstrumento Corresponde al tipo del instrumento.
     * @param tipoCuerda Corresponde al tipo de cuerda del instrumento.
     * @param numeroCuerda Corresponde al número de cuerdas que tenga el instrumento.
     * @param tipo Corresponde a que tipo de instrumento es.
     */
    public boolean agregarInstrumentoCuerda(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento, String tipoCuerda, int numeroCuerda, String tipo);

    /**
     * Método que agrega instrumentos al sistema.
     * @param cvs Corresponde al identificador del instrumento.
     * @param precio Corresponde al precio del instrumento.
     * @param stock Corresponde al  stock del instrumento.
     * @param nombre Corresponde al nombre del instrumento.
     * @param tipoMaterial Corresponde al material del instrumento.
     * @param tipoInstrumento Corresponde al tipo del instrumento.
     * @param tipoPercusion Corresponde al tipo de percusión del instrumento.
     * @param altura Corresponde a la altura que tenga el instrumento.
     */
    public boolean agregarInstrumentoPercusion(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento,String tipoPercusion, String altura);


    /**
     * Método que agrega instrumentos al sistema.
     * @param cvs Corresponde al identificador del instrumento.
     * @param precio Corresponde al precio del instrumento.
     * @param stock Corresponde al  stock del instrumento.
     * @param nombre Corresponde al nombre del instrumento.
     * @param tipoMaterial Corresponde al material del instrumento.
     * @param tipoInstrumento Corresponde al tipo del instrumento.
     */
    public boolean agregarInstrumentoViento(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento);


    /**
     * Método que vender instrumentos en el sistema.
     * @param cvs Corresponde al identificador del instrumento.
     */
    public void venderInstrumento(String cvs);

    /**
     * Método que consulta el inventario de los instrumentos en el sistema.
     */
    public String[] consultarInventario();

    /**
     * Método que permite consultar el inventario de los instrumentos en específico dentro del sistema.
     * @param cvs Corresponde al identificador del instrumento.
     */
    public String[] consultarInventarioEspecifico(String cvs);



    /**
     * Método que permite ver si existe un instrumento en el sistema.
     * @param cvs Corresponde al identificador del instrumento.
     */
    public boolean existeInstrumento(String cvs);

    /**
     * Método que cierra y guarda los datos del sistema.
     */
    public void cierre() throws IOException;
}
