public class ListaInstrumento {

    private Instrumento[] listaIntrumento;
    private int cantActual;
    private int cantMax;

    public ListaInstrumento(int cantMax) {
        this.listaIntrumento = new Instrumento[this.cantMax];
        this.cantActual = 0;
        this.cantMax = cantMax;
    }

    public int buscarInstrumento(String cvs){

        for (int i = 0; i < this.cantMax; i++) {
            if (this.listaIntrumento[i].getCvs().equals(cvs)){
                return i;
            }
        }
        return -1;
    }

    public Instrumento obtenerInstrumento(int posicion){

        if (posicion < 0 || posicion >= this.cantMax){
            throw new IllegalArgumentException("Posición no valida!");
        }
        return this.listaIntrumento[posicion];
    }

    public void agregarInstrumento(Instrumento instrumento){

        if (this.buscarInstrumento(instrumento.getCvs()) != -1){
            throw new IllegalArgumentException("El instrumento ya existe!");
        }

        if (this.cantActual == this.cantMax){
            throw new IllegalArgumentException("Capacidad maxima ya utilizada!");
        }

        for (int i = 0; i < this.cantMax; i++) {
            if (this.listaIntrumento[i] == null){
                this.listaIntrumento[i] = instrumento;
                this.cantActual++;
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró espacio disponible!");
    }

    public boolean eliminarInstrumento(String cvs){

        int posicion = this.buscarInstrumento(cvs);

        if (posicion < 0){
            return false;
        }
        this.listaIntrumento[posicion] = null;
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
}
