import ucn.ArchivoSalida;
import ucn.Registro;
import ucn.StdOut;

import java.io.IOException;

public class SistemaBeatTheRhythmImpl implements SistemaBeatRhythm {

    ListaInstrumento listaInstrumento;

    public SistemaBeatTheRhythmImpl(){
        this.listaInstrumento = new ListaInstrumento(1000);
    }

    @Override
    public boolean agregarInstrumentoCuerda(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento, String tipoCuerda, int numeroCuerda, String tipo) {
        Cuerda cuerda = new Cuerda(cvs,precio,stock,nombre,tipoMaterial, tipoInstrumento,tipoCuerda,numeroCuerda,tipo);
        return this.listaInstrumento.agregarInstrumento(cuerda);
    }

    public boolean agregarInstrumentoPercusion(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento,String tipoPercusion, String altura) {
        Percusion percusion = new Percusion(cvs,precio,stock,nombre,tipoMaterial, tipoInstrumento,tipoPercusion,altura);
        return this.listaInstrumento.agregarInstrumento(percusion);

    }

    public boolean agregarInstrumentoViento(String cvs,int precio, int stock, String nombre, String tipoMaterial, String tipoInstrumento) {
        Viento viento = new Viento(cvs,precio,stock,nombre,tipoMaterial, tipoInstrumento);
        return this.listaInstrumento.agregarInstrumento(viento);
    }

    @Override
    public void venderInstrumento(String cvs) {

        Instrumento instrumento = this.listaInstrumento.buscarIntrumento2(cvs);

        if (instrumento == null){
            throw new IllegalArgumentException("Instrumento con cvs " + cvs + " no existe o no se encuentra disponible.");
        }

        this.listaInstrumento.eliminarInstrumento(cvs);
    }

    @Override
    public String[] consultarInventario() {

        String[] listadoInstrumentos = new String[this.listaInstrumento.getCantMax()];

        for (int i = 0; i < listaInstrumento.getCantMax(); i++) {
            try{
                Instrumento instrumentoi = this.listaInstrumento.obtenerInstrumento(i);
                if (instrumentoi != null){
                    listadoInstrumentos[i] = instrumentoi.toString();
                }
            }catch (Exception E){
                continue;
            }
        }
        return listadoInstrumentos;
    }

    @Override
    public String[] consultarInverntarioEspecifico(String cvs) {

        String[] listadoInstrumentos = new String[this.listaInstrumento.getCantMax()];

        for (int i = 0; i < this.listaInstrumento.getCantMax(); i++) {

            Instrumento instrumento = this.listaInstrumento.getListaIntrumento()[i];
            if (instrumento !=null && instrumento.getCvs().equals(cvs)){
                listadoInstrumentos[i] =instrumento.toString();
            }
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

        for (int i = 0; i < listaInstrumento.getCantMax(); i++) {

            Registro registro = new Registro(6);

            Instrumento instrumentoi = this.listaInstrumento.obtenerInstrumento(i);
            if (instrumentoi != null){

                registro.agregarCampo(instrumentoi.getCvs());
                registro.agregarCampo(instrumentoi.getPrecio());
                registro.agregarCampo(instrumentoi.getStock());
                registro.agregarCampo(instrumentoi.getNombre());
                registro.agregarCampo(instrumentoi.getTipoMaterial());
                registro.agregarCampo(instrumentoi.getTipoInstrumento());
                archivoSalida.writeRegistro(registro);
            }

        }
        archivoSalida.close();
    }
}
