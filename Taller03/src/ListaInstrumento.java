public class ListaInstrumento {

    /**
     * Entidad que representa a la lista de instrumentos del sistema.
     */
    private Instrumento[] listaInstrumento;

    /**
     * Corresponde a la cantidad actual de instrumentos del sistema.
     */
    private int cantActual;

    /**
     * Corresponde a la cantidad máxima del arreglo.
     */
    private int cantMax;

    /**
     * Constructor de la clase ListaInstrumento.
     * @param cantMax Corresponde a la cantidad máxima del arreglo.
     */
    public ListaInstrumento(int cantMax) {
        this.listaInstrumento = new Instrumento[cantMax];
        this.cantActual = 0;
        this.cantMax = cantMax;
    }

    /**
     * Método que busca a un instrumento en la lista según su cvs.
     * @param cvs Corresponde al Cvs del instrumento.
     * @return Atributos del instrumento encontrado.
     */
    public int buscarInstrumento(String cvs){

        for (int i = 0; i < this.cantMax; i++) {

            if (this.listaInstrumento[i] != null && this.listaInstrumento[i].getCvs().equals(cvs)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Método que busca a un instrumento en la lista según su cvs.
     * @param cvs Corresponde al Cvs del instrumento.
     * @return Atributos del instrumento encontrado.
     */
    public Instrumento buscarIntrumento2(String cvs){
        for (int i = 0; i < this.cantActual; i++) {
            if (this.listaInstrumento[i].getCvs().equals(cvs)){
                return this.listaInstrumento[i];
            }
        }
        return null;
    }

    /**
     * Método que obtiene un instrumento según una posición dada.
     * @param posicion Posición entregada para buscar un instrumento.
     * @return Instrumento según posición entregada.
     */
    public Instrumento obtenerInstrumento(int posicion){

        if (posicion < 0 || posicion >= this.cantMax){
            throw new IllegalArgumentException("Posición no valida!");
        }
        return this.listaInstrumento[posicion];
    }

    /**
     * Método que agrega instrumentos al sistema.
     * @param instrumento Corresponde al instrumento que se agregará al sistema.
     * @return "true" si se agregó correctamente al sistema, o "false" si no se pudo arreglar.
     */
    public boolean agregarInstrumento(Instrumento instrumento){

        if (this.cantMax == this.cantActual){
            return false;
        }

        this.listaInstrumento[this.cantActual] = instrumento;
        this.cantActual++;
        return true;
    }

    /**
     * Método que elimina instrumentos al sistema.
     * @param cvs Corresponde al Cvs del instrumento.
     * @return "true" si se eliminó correctamente al sistema, o "false" si no se pudo eliminar.
     */
    public boolean eliminarInstrumento(String cvs){
        int posicion = this.buscarInstrumento(cvs);

        if (posicion <0){
            return false;
        }
        this.listaInstrumento[posicion] = null;
        this.cantActual--;
        return true;
    }

    /**
     * Método que obtiene la cantidad de instrumentos dentro del sistema.
     * @return Cantidad de instrumentos en el sistema.
     */
    public int getCantActual() {
        return cantActual;
    }

    /**
     * Método que obtiene la cantidad máxima de instrumentos dentro del sistema.
     * @return Cantidad máxima de instrumentos en el sistema.
     */
    public int getCantMax() {
        return cantMax;
    }

    /**
     * Método que obtiene la lista de instrumentos dentro del sistema.
     * @return Lista de instrumentos en el sistema.
     */
    public Instrumento[] getListaIntrumento() {
        return listaInstrumento;
    }
}
