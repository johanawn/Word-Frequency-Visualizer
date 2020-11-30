public class Lista {
    private Celda primera;
    private Celda ultima;
    private int [] frecuencia;
    private String [] palabras;

    public Lista(int []frecuencia, String []palabras){
        primera = null;
        ultima = null;
        this.frecuencia = frecuencia;
        this.palabras = palabras;
    }
    private class Celda{
        public int frecuencia;
        public String palabra;
        public Celda siguiente;

        public Celda(int frecuencia, String palabra){
            this.frecuencia = frecuencia;
            this.palabra = palabra;
            this.siguiente = null;
        }
        public String toString(){
            String tira = "";
            tira+= palabra +"  "+ frecuencia;
            if(siguiente!= null){
                tira+="\n"+siguiente;
            }
            return tira;
        }
    }
    public boolean estaVacia(){
        return primera==null;
     }
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
    public Celda getLista(){
        return primera;
    }
    public String toString(){
        String tira="";
        if(primera!=null){
           tira+= primera;  
        }
        return tira;
      }
}