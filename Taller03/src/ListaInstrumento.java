public class ListaInstrumento {

    private Instrumento[] listaInstrumento;
    private int cantActual;
    private int cantMax;

    public ListaInstrumento(int cantMax) {
        this.listaInstrumento = new Instrumento[cantMax];
        this.cantActual = 0;
        this.cantMax = cantMax;
    }

    public int buscarInstrumento(String cvs){

        for (int i = 0; i < this.cantMax; i++) {

            if (this.listaInstrumento[i] != null && this.listaInstrumento[i].getCvs().equals(cvs)){
                return i;
            }
        }
        return -1;
    }

    public Instrumento buscarIntrumento2(String cvs){
        for (int i = 0; i < this.cantActual; i++) {
            if (this.listaInstrumento[i].getCvs().equals(cvs)){
                return this.listaInstrumento[i];
            }
        }
        return null;
    }

    public Instrumento obtenerInstrumento(int posicion){

        if (posicion < 0 || posicion >= this.cantMax){
            throw new IllegalArgumentException("Posición no valida!");
        }
        return this.listaInstrumento[posicion];
    }

    public boolean agregarInstrumento(Instrumento instrumento){

        if (this.cantMax == this.cantActual){
            return false;
        }

        this.listaInstrumento[this.cantActual] = instrumento;
        this.cantActual++;
        return true;
    }

    public boolean eliminarInstrumento(String cvs){
        int posicion = this.buscarInstrumento(cvs);

        if (posicion <0){
            return false;
        }
        this.listaInstrumento[posicion] = null;
        this.cantActual--;
        return true;
    }

    public int getCantActual() {
        return cantActual;
    }

    public void setCantActual(int cantActual) {
        this.cantActual = cantActual;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public Instrumento[] getListaIntrumento() {
        return listaInstrumento;
    }

    public void setListaIntrumento(Instrumento[] listaIntrumento) {
        this.listaInstrumento = listaIntrumento;
    }
}
