public class SistemaBeatTheRhythmImpl implements SistemaBeatRhythm {

    ListaInstrumento listaInstrumento;

    public SistemaBeatTheRhythmImpl(){
        listaInstrumento = new ListaInstrumento(1000);
    }

    @Override
    public boolean agregarInstrumentoCuerda(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoCuerda, int numeroCuerda, String tipo) {
        Cuerda cuerda = new Cuerda(cvs,precio,stock,nombre,tipoMaterial,tipoCuerda,numeroCuerda,tipo);
        return this.listaInstrumento.agregarInstrumento(cuerda);

    }

    public boolean agregarInstrumentoPercusion(String cvs,int precio, int stock, String nombre, String tipoMaterial,String tipo, int altura) {
        Percusion percusion = new Percusion(cvs,precio,stock,nombre,tipoMaterial,tipo,altura);
        return this.listaInstrumento.agregarInstrumento(percusion);

    }

    public boolean agregarInstrumentoViento(String cvs,int precio, int stock, String nombre, String tipoMaterial) {
        Viento viento = new Viento(cvs,precio,stock,nombre,tipoMaterial);
        return this.listaInstrumento.agregarInstrumento(viento);

    @Override
    public Instrumento venderInstrumento(String cvs) {

        return null;
    }

    @Override
    public String[] consultarInventario() {
        return new String[0];
    }

    @Override
    public void cierre() {

    }
}
