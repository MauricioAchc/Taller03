public abstract class Instrumento {

    /**
     * Corresponde al Cvs del instrumento.
     */
    private String cvs;
    /**
     * Corresponde al precio del instrumento.
     */
    private int precio;
    /**
     * Corresponde al stock del instrumento.
     */
    private int stock;
    /**
     * Corresponde al nombre del instrumento.
     */
    private String nombre;
    /**
     * Corresponde al tipo de material del instrumento.
     */
    private String tipoMaterial;
    /**
     * Corresponde al tipo del instrumento(Cuerda, Percusión o Viento).
     */
    private String tipoInstrumento;

    /**
     * Constructor de la clase Cliente.
     * @param cvs Corresponde al Cvs del instrumento.
     * @param precio Corresponde al precio del instrumento.
     * @param stock Corresponde al stock del instrumento.
     * @param nombre Corresponde al nombre del instrumento.
     * @param tipoMaterial Corresponde al tipo de material del instrumento.
     * @param tipoInstrumento Corresponde al tipo del instrumento(Cuerda, Percusión o Viento).
     */
    public Instrumento(String cvs, int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento) {
        this.cvs = cvs;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.tipoInstrumento = tipoInstrumento;
    }

    /**
     * Método de la clase abstracta que obtiene el cvs del instrumento.
     * @return Cvs del instrumento solicitado.
     */
    public String getCvs() {
        return cvs;
    }

    /**
     * Método de la clase abstracta que obtiene el precio del instrumento.
     * @return Precio del instrumento solicitado.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Método de la clase abstracta que obtiene el stock del instrumento.
     * @return Stock del instrumento solicitado.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Método de la clase abstracta que obtiene el nombre del instrumento.
     * @return Nombre del instrumento solicitado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método de la clase abstracta que obtiene el tipo de material del instrumento.
     * @return Tipo de material del instrumento solicitado.
     */
    public String getTipoMaterial() {
        return tipoMaterial;
    }

    /**
     * Método de la clase abstracta que obtiene el tipo de instrumento del instrumento.
     * @return Tipo de instrumento del instrumento solicitado.
     */
    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    /**
     * Método que transforma la información de cada instrumento en un dato de tipo String.
     * @return Información del Instrumento.
     */
    public abstract String toString();
}
