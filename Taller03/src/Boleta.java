public class Boleta {

    private ListaInstrumento instrumentoVendido;
    private int precio;

    public Boleta(ListaInstrumento instrumentoVendido, int precio) {
        this.instrumentoVendido = instrumentoVendido;
        this.precio = precio;
    }

    public ListaInstrumento getInstrumentoVendido() {
        return instrumentoVendido;
    }

    public void setInstrumentoVendido(ListaInstrumento instrumentoVendido) {
        this.instrumentoVendido = instrumentoVendido;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
