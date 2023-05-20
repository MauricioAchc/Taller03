public class Viento extends Instrumento{

    public Viento(String cvs, int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento) {
        super(cvs, precio, stock, nombre, tipoMaterial, tipoInstrumento);
    }

    public String toString() {
        return "Cvs: "+super.getCvs()+"\nPrecio: "+super.getPrecio()+
                "\nNombre del Instrumento: "+super.getNombre();
    }
}
