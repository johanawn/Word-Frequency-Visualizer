/**
 * Clase Lista, contiene a la clase Celda
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/12, final
 */
public class Lista {
    private Celda primera;
    private Celda ultima;
    private int [] frecuencia;
    private String [] palabras;
    /**
     * Constructor con parametros
     * @param frecuencia- vector que contiene las frecuencias de cada palabra en el archivo de texto
     * @param palabras- vector que contiene las palabras sin repetir del archivo de texto
     */
    public Lista(int []frecuencia, String []palabras){
        primera = null;
        ultima = null;
        this.frecuencia = frecuencia;
        this.palabras = palabras;
    }
//Clase Celda
    private class Celda{
        public int frecuencia;
        public String palabra;
        public Celda siguiente;
        /**
         * Constructor con parametros
         * @param frecuencia- cantidad de veces que aparece una palabra en el archivo de texto
         * @param palabra- palabra de respectiva frecuencia
         */
        public Celda(int frecuencia, String palabra){
            this.frecuencia = frecuencia;
            this.palabra = palabra;
            this.siguiente = null;
        }
        /**
         * Efectua: da la informacion de la celda
         * @return tira- la informacion de la celda
         */
        public String toString(){
            String tira = "";
            tira+= palabra +"  "+ frecuencia;
            if(siguiente!= null){
                tira+="\n"+siguiente;
            }
            return tira;
        }
    }
    /**
     * Efectua: se encarga de verificar si la lista se encuentra vacia o con celdas presentes
     * @return un booleano- representa si la lista se encuentra vacia
     */
    public boolean estaVacia(){
        return primera==null;
     }
    /**
     * Efectua: agrega al inicio de la lista una celda de la clase Celda con sus respectivos atributos
     * Modifica: el orden de la lista
     * @param frecuencia- cantidad de veces que aparece una palabra en el archivo de texto
     * @param palabra- palabra de respectiva frecuencia
     */
     public void agregarAlInicio(int frecuencia, String palabra){
         Celda nueva = new Celda(frecuencia, palabra);
         if(estaVacia()){
             this.primera = nueva;
             this.ultima = nueva;
         }
         else{
             nueva.siguiente = this.primera;
             this.primera = nueva;
         }
     }
     /**
      * Efectua: inserta la celda en la posicion de la lista ingresado en el parametro
      * Modifica: el orden de la lista
      * @param pos- posicion de la lista 
      * @param frecuencia- cantidad de veces que aparece una palabra en el archivo de texto
      * @param palabra- palabra de respectiva frecuencia
      */
     public void insertar(int pos, int frecuencia, String palabra){
        Celda nueva = new Celda(frecuencia, palabra);
        Celda actual = primera;
        int i = 0;
        if(pos == 0){
            agregarAlInicio(frecuencia, palabra);
        }
        else{
            while(i < pos-1 && actual!=null){
                actual = actual.siguiente;
                i++;
            }
            if(i == pos-1){
                 nueva.siguiente = actual.siguiente;
                 actual.siguiente = nueva;
                 if(ultima == actual){
                    ultima = ultima.siguiente;
               }
            }
            else {
               System.err.println("Warning: posicion no válida "+pos);
            }           
        }
    }
     /**
      * Efectua: agrega la celda al final de la lista 
      * @param frecuencia- cantidad de veces que aparece una palabra en el archivo de texto
      * @param palabra- palabra de respectiva frecuencia
      */
    public void agregarAlFinal(int frecuencia, String palabra){
       Celda nueva = new Celda(frecuencia, palabra);
       if(estaVacia()){
             this.primera = nueva;
             this.ultima = nueva;
        } 
       else {
             this.ultima.siguiente = nueva;
             this.ultima = nueva;
        }
    }
    public void crearLista(){
        for(int i =0; i < frecuencia.length; i++){
            if(i == 0){
                agregarAlInicio(frecuencia[i], palabras[i]);
            }
            else{
                agregarAlFinal(frecuencia[i], palabras[i]);
            }
        }
    }
    /**
     *Efectua: ordena la lista deacuerdo de mayor a menor frecuencia
     *Modifica: el orden de las celdas en la lista
     */
    public void ordenarListaMayoraMenor() {
        boolean cambio;
        do {
            Celda actual = this.primera;
            Celda anterior = null;
            Celda siguiente = primera.siguiente;
            cambio = false;
            while ( siguiente != null ) {
                if (actual.frecuencia < siguiente.frecuencia) {
                    cambio = true;
                    if ( anterior != null ) {
                        Celda sig = siguiente.siguiente;
                        anterior.siguiente = siguiente;
                        siguiente.siguiente = actual;
                        actual.siguiente = sig;
                    } 
                    else {
                        Celda sig = siguiente.siguiente;
                        this.primera = siguiente;
                        siguiente.siguiente = actual;
                        actual.siguiente = sig;
                    }
                    anterior = siguiente;
                    siguiente = actual.siguiente;
                } 
                else { 
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.siguiente;
                }
            } 
        } while( cambio );
    }
    
    /**
     * Efectua: ordena la lista de menor a mayor frecuencia de cada celda
     * Modifica: el orden de las celdas en la lista
     */
        public void ordenarListaMenoraMayor() {
        boolean cambio;
        do {
            Celda actual = this.primera;
            Celda anterior = null;
            Celda siguiente = primera.siguiente;
            cambio = false;
            while ( siguiente != null ) {
                if (actual.frecuencia > siguiente.frecuencia) {
                    cambio = true;
                    if ( anterior != null ) {
                        Celda sig = siguiente.siguiente;
                        anterior.siguiente = siguiente;
                        siguiente.siguiente = actual;
                        actual.siguiente = sig;
                    } 
                    else {
                        Celda sig = siguiente.siguiente;
                        this.primera = siguiente;
                        siguiente.siguiente = actual;
                        actual.siguiente = sig;
                    }
                    anterior = siguiente;
                    siguiente = actual.siguiente;
                } 
                else { 
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.siguiente;
                }
            } 
        } while( cambio );
    }
        /**
         * Efectua: devuelve la primera celda de la lista
         * @return primera- hace referencia a la primera celda de la lista
         */
    public Celda getLista(){
        return primera;
    }
    /**
     * Efectua: da la informacion de la lista
     * @return tira- la informacion de la lista
     */
    public String toString(){
        String tira="";
        if(primera!=null){
           tira+= primera;  
        }
        return tira;
      }
}