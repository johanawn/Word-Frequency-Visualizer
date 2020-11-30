public class Arbol {
    public static final int IZQ = 0;
    public static final int DER = 1;
    private int [] frecuencias; 
    private String [] palabras;
    private Nodo[] nodos;
    private Nodo raiz;

    public Arbol(int [] frecuencias, String [] palabras){
        raiz = null;
        this.frecuencias = frecuencias;
        this.palabras =  palabras;
        nodos = new Nodo[1];
    }

    public void crearArbol(){
        String palabrasUsadas [] = new String[0];
        String palabrasUsadas2[] = new String[0];
        int i = 0;
        while(frecuencias.length > 1){
            Nodo nodo = new Nodo(frecuencias[0]+frecuencias[1]);
            palabrasUsadas = palabras[0].split(" ");
            palabrasUsadas2 = palabras[1].split(" ");
            if(palabrasUsadas.length > 1 || palabrasUsadas2.length > 1 ){
                if(i >= nodos.length){
                    Nodo p[] = new Nodo[nodos.length+1];
                    for(int j = 0; j < nodos.length; j++){
                        p[j] = nodos[j];
                    }
                    nodos = p;
                }
                if(palabrasUsadas.length > 1){
                    Nodo nodoArbol = buscarVector(frecuencias[0]);
                    nodo.insertar(nodoArbol);
                }
                else{
                     nodo.insertar(nodo, frecuencias[0], palabras[0]);
                }
                if(palabrasUsadas2.length > 1){
                    Nodo nodoArbol = buscarVector(frecuencias[1]);
                    nodo.insertar(nodoArbol);
                }
                else{
                     nodo.insertar(nodo, frecuencias[1], palabras[1]);
                }
                nodos[i] = nodo;
                i++;
            }
            else{
                if(i >= nodos.length){
                    Nodo p[] = new Nodo[nodos.length+1];
                    for(int j = 0; j < nodos.length; j++){
                        p[j] = nodos[j];
                    }
                    nodos = p;
                }
                nodo.insertar(nodo, frecuencias[0], palabras[0]);
                nodo.insertar(nodo, frecuencias[1], palabras[1]);
                nodos[i] = nodo;
                i++;
            }
            String palabra = conseguirPalabra(nodo);
            eliminarEnVector(nodo.getFrecuencia(), palabra);
            ordenarVectores();
        }
        raiz = nodos[nodos.length-1];
    }

    public void insertar(Nodo nodo){
        if(raiz==null){
            raiz =nodo; 
        }
        else {
            nodo.insertar(nodo); 
        } 
    }
    public String conseguirPalabra(Nodo nodo){
        String palabra = nodo.getPalabra();
        if(palabra == "1"){
           palabra = conseguirPalabra(nodo.hijos[IZQ]);
           palabra += " ";
           palabra += conseguirPalabra(nodo.hijos[DER]);
        }
        return palabra;
    }

    public void insertar(Nodo nodo, int frecuencia, String palabra){
        if(nodo==null){
            nodo = new Nodo(frecuencia, palabra); 
        }
        else {
            nodo.insertar(nodo, frecuencia, palabra); 
        } 
    }

    public void ordenarVectores(){
        int swap = 0;
        String cambio = "";
        for(int i = 0; i < frecuencias.length; i++){
            for(int j = 0; j < (frecuencias.length-i)-1; j++){
                if(frecuencias[j]> frecuencias[j+1]){
                    swap = frecuencias[j];
                    cambio = palabras[j];
                    frecuencias[j] = frecuencias[j+1];
                    palabras[j] = palabras[j+1];
                    frecuencias[j+1] = swap;
                    palabras[j+1] = cambio;
                } 
            }

        }
    }

    public Nodo buscarVector(int frecuencia){
        Nodo nodo = new Nodo(1);
        for(int i = 0; i < nodos.length; i++){
            if(nodos[i].getFrecuencia() == frecuencia){
                nodo = nodos[i];
                break;
            }
        }
        return nodo;
    }

    public void eliminarEnVector(int frecuenciaNueva, String palabraNueva){
        int [] p = new int [frecuencias.length -1];
        int j = 1;
        for( int i = 2; i < frecuencias.length; i++){
            p[j] = frecuencias[i];
            j++;
        }
        p[0] = frecuenciaNueva;
        frecuencias = p;
        String [] v = new String [palabras.length -1];
        j = 1;
        for( int i = 2; i < palabras.length; i++){
            v[j] = palabras[i];
            j++;
        }
        v[0] = palabraNueva;
        palabras = v;
    }

    public boolean estaVacio(){
        return raiz == null;
    }
    public Nodo getRaiz(){
        return raiz;
    }

    public String toString(){
        String elementos = "";
        if(raiz!=null){
            elementos+=""+raiz.toString(); 
        }
        return elementos;
    }

}
