public interface SistemaBeatRhythm {

    public boolean agregarInstrumentoCuerda(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoCuerda, int numeroCuerda, String tipo);
    public boolean agregarInstrumentoPercusion(String cvs,int precio, int stock, String nombre, String tipoMaterial,String tipo, int altura);
    public boolean agregarInstrumentoViento(String cvs,int precio, int stock, String nombre, String tipoMaterial);
    public Instrumento venderInstrumento(String cvs);
    public String[] consultarInventario(String cvs, Instrumento instrumento);
    public void cierre();
}
