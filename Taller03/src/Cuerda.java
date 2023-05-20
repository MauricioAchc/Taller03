public class Cuerda extends Instrumento{

    private String tipoCuerda;
    private int numeroCuerda;
    private String tipo;


    public Cuerda(String cvs, int precio, int stock, String tipoMaterial, String tipoCuerda, int numeroCuerda, String tipo) {
        super(cvs, precio, stock, tipoMaterial);
        this.tipoCuerda = tipoCuerda;
        this.numeroCuerda = numeroCuerda;
        this.tipo = tipo;
    }

    public String getTipoCuerda() {
        return tipoCuerda;
    }

    public void setTipoCuerda(String tipoCuerda) {
        this.tipoCuerda = tipoCuerda;
    }

    public int getNumeroCuerda() {
        return numeroCuerda;
    }

    public void setNumeroCuerda(int numeroCuerda) {
        this.numeroCuerda = numeroCuerda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
