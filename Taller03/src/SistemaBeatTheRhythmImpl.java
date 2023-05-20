public class SistemaBeatTheRhythmImpl implements SistemaBeatRhythm {

    ListaInstrumento listaInstrumento;

    public SistemaBeatTheRhythmImpl(){
        listaInstrumento = new ListaInstrumento(1000);
    }

    @Override
    public void agregarInstrumento() {
    }

    @Override
    public Instrumento venderIntrumento() {
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
