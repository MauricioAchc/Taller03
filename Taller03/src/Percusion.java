public class Percusion extends Instrumento{

    private String tipo;
    private int altura;

    public Percusion(String cvs, int precio, int stock, String tipoMaterial, String tipo, int altura) {
        super(cvs, precio, stock, tipoMaterial);
        this.tipo = tipo;
        this.altura = altura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
