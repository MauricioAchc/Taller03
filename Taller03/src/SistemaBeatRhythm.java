public interface SistemaBeatRhythm {

    public boolean agregarInstrumentoCuerda(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento, String tipoCuerda, int numeroCuerda, String tipo);
    public boolean agregarInstrumentoPercusion(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento,String tipo, int altura);
    public boolean agregarInstrumentoViento(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento);
    public void venderInstrumento(String cvs);
    public String[] consultarInventario(String cvs, Instrumento instrumento);
    public String[] obtenerListadoCuerda();
    public String[] obtenerListadoPercusion();
    public String[] obtenerListadoViento();
    public void cierre();
}
