public class Viento extends Instrumento{

    /**
     * Constructor de la clase Percusion.
     * @param cvs Corresponde al Cvs del instrumento heredado de la clase abstracta "Instrumento".
     * @param precio Corresponde al precio del instrumento heredado de la clase abstracta "Instrumento".
     * @param stock Corresponde al stock del instrumento heredado de la clase abstracta "Instrumento".
     * @param nombre Corresponde al nombre del instrumento heredado de la clase abstracta "Instrumento".
     * @param tipoMaterial Corresponde al tipo de material del instrumento heredado de la clase abstracta "Instrumento".
     * @param tipoInstrumento Corresponde al tipo del instrumento(Cuerda, Percusión o Viento) heredado de la clase abstracta "Instrumento".
     */
    public Viento(String cvs, int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento) {
        super(cvs, precio, stock, nombre, tipoMaterial, tipoInstrumento);
    }

    /**
     * Método que transforma la información de cada instrumento en un dato de tipo String.
     *
     * @return Información del Instrumento.
     */
    public String toString() {
        return "Cvs: "+super.getCvs()+"\nPrecio: "+super.getPrecio()+
                "\nNombre del Instrumento: "+super.getNombre();
    }
}
