public class Percusion extends Instrumento{

    /**
     * Corresponde al tipo de percusión del instrumento(Membranófono, idiófono).
     */
    private String tipoPercusion;

    /**
     * Corresponde a la altura del instrumento(Definida, Indefinida).
     */
    private String altura;

    /**
     * Constructor de la clase Percusion.
     * @param cvs Corresponde al Cvs del instrumento heredado de la clase abstracta "Instrumento".
     * @param precio Corresponde al precio del instrumento heredado de la clase abstracta "Instrumento".
     * @param stock Corresponde al stock del instrumento heredado de la clase abstracta "Instrumento".
     * @param nombre Corresponde al nombre del instrumento heredado de la clase abstracta "Instrumento".
     * @param tipoMaterial Corresponde al tipo de material del instrumento heredado de la clase abstracta "Instrumento".
     * @param tipoInstrumento Corresponde al tipo del instrumento(Cuerda, Percusión o Viento) heredado de la clase abstracta "Instrumento".
     * @param tipoPercusion Corresponde al tipo de percusión del instrumento(Membranófono, idiófono).
     * @param altura Corresponde a la altura del instrumento(Definida, Indefinida).
     */
    public Percusion(String cvs, int precio, int stock,String nombre, String tipoMaterial, String tipoInstrumento, String tipoPercusion, String altura) {
        super(cvs, precio, stock, nombre, tipoMaterial, tipoInstrumento);
        this.tipoPercusion = tipoPercusion;
        this.altura = altura;
    }

    /**
     * Método que obtiene el tipo de percusión del instrumento(Membranófono, idiófono).
     * @return Tipo de percusión del instrumento.
     */
    public String getTipoPercusion() {
        return tipoPercusion;
    }

    /**
     * Método que obtiene la altura del instrumento(Definida, Indefinida).
     * @return Altura de instrumento.
     */
    public String getAltura() {
        return altura;
    }

    /**
     * Método que transforma la informacion de cada instrumento en un dato de tipo String.
     *
     * @return Información del Instrumento.
     */
    public String toString() {
        return "Cvs: "+super.getCvs()+"\nPrecio: "+super.getPrecio()+
                "\nNombre del Instrumento: "+super.getNombre()+"\nTipo: "+
                this.tipoPercusion+"\nAltura: "+this.altura;
    }
}
