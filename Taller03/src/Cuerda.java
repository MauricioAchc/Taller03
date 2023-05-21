public class Cuerda extends Instrumento{

    /**
     * Corresponde al tipo de cuerda del instrumento.
     */
    private String tipoCuerda;

    /**
     * Corresponde al número de cuerdas del instrumento.
     */
    private int numeroCuerda;

    /**
     * Corresponde al tipo de instrumento(Acústico, Eléctrico).
     */
    private String tipo;

    /**
     * Constructor de la clase Cuerda.
     * @param cvs Corresponde al Cvs del instrumento heredado de la clase abstracta "Instrumento".
     * @param precio Corresponde al precio del instrumento heredado de la clase abstracta "Instrumento".
     * @param stock Corresponde al stock del instrumento heredado de la clase abstracta "Instrumento".
     * @param nombre Corresponde al nombre del instrumento heredado de la clase abstracta "Instrumento".
     * @param tipoMaterial Corresponde al tipo de material del instrumento heredado de la clase abstracta "Instrumento".
     * @param tipoInstrumento Corresponde al tipo del instrumento(Cuerda, Percusión o Viento) heredado de la clase abstracta "Instrumento".
     * @param tipoCuerda Corresponde al tipo de cuerda del instrumento.
     * @param numeroCuerda Corresponde al número de cuerdas del instrumento.
     * @param tipo Corresponde al tipo de instrumento(Acústico, Eléctrico).
     */
    public Cuerda(String cvs, int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento, String tipoCuerda, int numeroCuerda, String tipo) {
        super(cvs, precio, stock, nombre, tipoMaterial, tipoInstrumento);
        this.tipoCuerda = tipoCuerda;
        this.numeroCuerda = numeroCuerda;
        this.tipo = tipo;
    }

    /**
     * Método que obtiene el tipo de cuerda del instrumento.
     * @return Tipo de cuerda del instrumento.
     */
    public String getTipoCuerda() {
        return tipoCuerda;
    }

    /**
     * Método que obtiene el número de cuerdas del instrumento.
     * @return Número de cuerdas del instrumento.
     */
    public int getNumeroCuerda() {
        return numeroCuerda;
    }

    /**
     * Método que obtiene el tipo de instrumento.
     * @return Tipo de instrumento(Acústico, Eléctrico).
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método que transforma la información de cada instrumento en un dato de tipo String.
     *
     * @return Información del Instrumento.
     */
    public String toString() {
        return "Cvs: "+super.getCvs()+"\nPrecio: "+super.getPrecio()+
                "\nNombre del Instrumento: "+super.getNombre()+"\nTipo de cuerda: "+
                this.tipoCuerda+"\nNúmero de cuerdas: "+this.numeroCuerda+"\nTipo: "+this.tipo;
    }
}
