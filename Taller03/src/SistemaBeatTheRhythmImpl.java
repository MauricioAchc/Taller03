public class SistemaBeatTheRhythmImpl implements SistemaBeatRhythm {

    ListaInstrumento listaInstrumento;

    public SistemaBeatTheRhythmImpl(){
        listaInstrumento = new ListaInstrumento(1000);
    }

    @Override
    public boolean agregarInstrumentoCuerda(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento, String tipoCuerda, int numeroCuerda, String tipo) {
        Cuerda cuerda = new Cuerda(cvs,precio,stock,nombre,tipoMaterial, tipoInstrumento,tipoCuerda,numeroCuerda,tipo);
        return this.listaInstrumento.agregarInstrumento(cuerda);

    }

    public boolean agregarInstrumentoPercusion(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento,String tipo, int altura) {
        Percusion percusion = new Percusion(cvs,precio,stock,nombre,tipoMaterial, tipoInstrumento,tipo,altura);
        return this.listaInstrumento.agregarInstrumento(percusion);

    }

    public boolean agregarInstrumentoViento(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento) {
        Viento viento = new Viento(cvs,precio,stock,nombre,tipoMaterial, tipoInstrumento);
        return this.listaInstrumento.agregarInstrumento(viento);
    }

    @Override
    public void venderInstrumento(String cvs) {

    }

    @Override
    public String[] consultarInventario(String cvs, Instrumento instrumento) {
        return new String[0];
    }

    @Override
    public String[] obtenerListadoCuerda() {

        String[] listadoCuerda = new String[this.listaInstrumento.getCantActual()];
        for (int i = 0; i < listaInstrumento.getCantActual(); i++) {
            if (this.listaInstrumento.obtenerInstrumento(i).getTipoInstrumento().equals("cuerda")){
                listadoCuerda[i] = this.listaInstrumento.obtenerInstrumento(i).toString();
            }
        }

        return listadoCuerda;
    }

    @Override
    public String[] obtenerListadoPercusion() {

        String[] listadoPercusion = new String[this.listaInstrumento.getCantActual()];
        for (int i = 0; i < listaInstrumento.getCantActual(); i++) {
            if (this.listaInstrumento.obtenerInstrumento(i).getTipoInstrumento().equals("percusión")){
                listadoPercusion[i] = this.listaInstrumento.obtenerInstrumento(i).toString();
            }
        }

        return listadoPercusion;
    }

    @Override
    public String[] obtenerListadoViento() {

        String[] listadoViento = new String[this.listaInstrumento.getCantActual()];
        for (int i = 0; i < listaInstrumento.getCantActual(); i++) {
            if (this.listaInstrumento.obtenerInstrumento(i).getTipoInstrumento().equals("viento")){
                listadoViento[i] = this.listaInstrumento.obtenerInstrumento(i).toString();
            }
        }

        return listadoViento;
    }

    @Override
    public void cierre() {

    }
}
