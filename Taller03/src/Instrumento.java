public abstract class Instrumento {

    private String cvs;
    private int precio;
    private int stock;
    private String nombre;
    private String tipoMaterial;

    public Instrumento(String cvs, int precio, int stock, String nombre, String tipoMaterial) {
        this.cvs = cvs;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
    }

    public String getCvs() {
        return cvs;
    }

    public void setCvs(String cvs) {
        this.cvs = cvs;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
}
