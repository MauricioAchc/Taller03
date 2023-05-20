import ucn.ArchivoSalida;
import ucn.Registro;

import java.io.IOException;

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

    public boolean agregarInstrumentoPercusion(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento,String tipo, String altura) {
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
    public String[] consultarInventario() {

        String[] listadoInstrumentos = new String[this.listaInstrumento.getCantActual()];

        for (int i = 0; i < listaInstrumento.getCantActual(); i++) {
            listadoInstrumentos[i] = this.listaInstrumento.obtenerInstrumento(i).toString();
        }
        return listadoInstrumentos;
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
            if (this.listaInstrumento.obtenerInstrumento(i).getTipoInstrumento().equals("percusion")){
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
    public boolean existeInstrumento(String cvs) {

        for (int i = 0; i < this.listaInstrumento.getCantActual(); i++) {
            if (this.listaInstrumento.getListaIntrumento()[i].getCvs().equalsIgnoreCase(cvs)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void cierre() throws IOException {

        ArchivoSalida archivoSalida = new ArchivoSalida("instrumentosSistema.txt");

        for (int i = 0; i < listaInstrumento.getCantActual(); i++) {

            Registro registro = new Registro(6);

            registro.agregarCampo(listaInstrumento.getListaIntrumento()[i].getCvs());
            registro.agregarCampo(listaInstrumento.getListaIntrumento()[i].getPrecio());
            registro.agregarCampo(listaInstrumento.getListaIntrumento()[i].getStock());
            registro.agregarCampo(listaInstrumento.getListaIntrumento()[i].getNombre());
            registro.agregarCampo(listaInstrumento.getListaIntrumento()[i].getTipoMaterial());
            registro.agregarCampo(listaInstrumento.getListaIntrumento()[i].getTipoInstrumento());
            archivoSalida.writeRegistro(registro);
        }
        archivoSalida.close();
    }
}
