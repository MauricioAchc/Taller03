public class Percusion extends Instrumento{

    private String tipo;
    private String altura;

    public Percusion(String cvs, int precio, int stock,String nombre, String tipoMaterial, String tipoInstrumento, String tipo, String altura) {
        super(cvs, precio, stock, nombre, tipoMaterial, tipoInstrumento);
        this.tipo = tipo;
        this.altura = altura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String toString() {
        return "Cvs: "+super.getCvs()+"\nPrecio: "+super.getPrecio()+
                "\nNombre del Instrumento: "+super.getNombre()+"\nTipo: "+
                this.tipo+"\nAltura: "+this.altura;
    }
}
