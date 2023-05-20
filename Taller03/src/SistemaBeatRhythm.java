import java.io.IOException;

public interface SistemaBeatRhythm {

    public boolean agregarInstrumentoCuerda(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento, String tipoCuerda, int numeroCuerda, String tipo);
    public boolean agregarInstrumentoPercusion(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento,String tipo, String altura);
    public boolean agregarInstrumentoViento(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento);
    public void venderInstrumento(String cvs);
    public String[] consultarInventario();
    public String[] obtenerListadoCuerda();
    public String[] obtenerListadoPercusion();
    public String[] obtenerListadoViento();
    public boolean existeInstrumento(String cvs);
    public void cierre() throws IOException;
}
