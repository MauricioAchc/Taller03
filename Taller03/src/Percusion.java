public class Percusion extends Instrumento{

    private String tipoPercusion;
    private String altura;

    public Percusion(String cvs, int precio, int stock,String nombre, String tipoMaterial, String tipoInstrumento, String tipoPercusion, String altura) {
        super(cvs, precio, stock, nombre, tipoMaterial, tipoInstrumento);
        this.tipoPercusion = tipoPercusion;
        this.altura = altura;
    }

    public String getTipoPercusion() {
        return tipoPercusion;
    }

    public void setTipoPercusion(String tipoPercusion) {
        this.tipoPercusion = tipoPercusion;
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
                this.tipoPercusion+"\nAltura: "+this.altura;
    }
}
