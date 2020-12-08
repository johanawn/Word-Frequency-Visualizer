
/**
 * Clase Arbol
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/12, final
 */

public class Arbol {

    public static final int IZQ = 0;
    public static final int DER = 1;
    private int [] frecuencias; 
    private String [] palabras;
    private Nodo[] nodos;
    private Nodo raiz;
    /**
     * Constructor con parametros
     * @param frecuencias- vector que contiene las frecuencias de cada palabra en el archivo de texto
     * @param palabras- vector que contiene las palabras sin repetir del archivo de texto
     */
    public Arbol(int [] frecuencias, String [] palabras){
        raiz = null;
        this.frecuencias = frecuencias;
        this.palabras =  palabras;
        nodos = new Nodo[1];
    }
    /**
     * Efectua: crea el arbol con el vector frecuencia ya ordenada de menor a mayor y el vector palabras que coincide con sus respectivas frecuencia
     * Modifica: el arbol
     */
    public void crearArbol(){
        String palabrasUsadas [] = new String[0];
        String palabrasUsadas2[] = new String[0];
        int i = 0;
        //Mientras que la longitud del vector frecuencias sea mayor a 1(al llegar a 1 como longitud del vector significa que se completo la creacion del "arbol")
        while(frecuencias.length > 1){
            // se crea un nuevo nodo(padre) en la que tiene como el atributo frecuencia la suma de las frecuencias que se encuentra en las dos primeras posiciones del vector frecuencia
            Nodo nodo = new Nodo(frecuencias[0]+frecuencias[1]);
   
            palabrasUsadas = palabras[0].split(" ");
            palabrasUsadas2 = palabras[1].split(" ");
            if(palabrasUsadas.length > 1 || palabrasUsadas2.length > 1 ){
                if(i >= nodos.length){
                    // se crea un vector Nodo p que tiene como longitud el tamaño que tiene el vector nodos+1, en donde se ira introduciendo en el vector Nodo p los elementos que se encuentra en el vector nodos, con el fin de luego igualarlo al vector nodos y obtener el vector nodos con el tamaño correspondiente 
                    Nodo p[] = new Nodo[nodos.length+1];
                    for(int j = 0; j < nodos.length; j++){
                        p[j] = nodos[j];
                    }
                    nodos = p;
                }
                //se inserta en el Nodo nodo(padre) los dos nodos hijos(subarboles)
                if(palabrasUsadas.length > 1){
                    Nodo nodoArbol = buscarVector(frecuencias[0]);
                    int pos = buscarPosicion(frecuencias[0]);
                    eliminarNodo(pos);
                    i--;
                    //eliminar
                    nodo.insertar(nodoArbol);
                }
                else{
                     nodo.insertar(nodo, frecuencias[0], palabras[0]);
                }
                if(palabrasUsadas2.length > 1){
                    Nodo nodoArbol = buscarVector(frecuencias[1]);
                    int pos = buscarPosicion(frecuencias[1]);
                    eliminarNodo(pos);
                    i--;
                    //eliminar
                    nodo.insertar(nodoArbol);
                }
                else{
                     nodo.insertar(nodo, frecuencias[1], palabras[1]);
                }
                nodos[i] = nodo;
                i++;
            }
            else{
                //cuando se acaba la creacion de los subarboles para el arbol
                if(i >= nodos.length){
                    Nodo p[] = new Nodo[nodos.length+1];
                    for(int j = 0; j < nodos.length; j++){
                        p[j] = nodos[j];
                    }
                    nodos = p;
                }
                // se inserta en el nodo(padre) creado, dos nodos que tiene como atributos las frecuencias y palabras que se encuentra en las primeras dos posiciones de los dos vectores
                nodo.insertar(nodo, frecuencias[0], palabras[0]);
                nodo.insertar(nodo, frecuencias[1], palabras[1]);
                //se guarda el nodo padre con sus nodos hijos al vector nodo
                nodos[i] = nodo;
                i++;
            }
            //ordena los vectores frecuencias y palabras con los nuevos elementos conjuntos
            String palabra = conseguirPalabra(nodo);
            eliminarEnVector(nodo.getFrecuencia(), palabra);
            ordenarVectores();
        }
        //cuando se tiene los nodos que conforma el arbol, el nodo que se encuentra en la ultima posicion de vector Nodos nodos se le hace referencia como la raiz del arbol
        raiz = nodos[nodos.length-1];
    }
    /**
     * Efectua: se encarga de insertar el nodo del parametro al arbol en su correspondiente lugar
     * Modifica: el arbol
     * @param nodo- pertenece a la clase Nodo
     */
    public void insertar(Nodo nodo){
        if(raiz==null){
            raiz =nodo; 
        }
        else {
            nodo.insertar(nodo); 
        } 
    }
    /**
     * Efectua:se encarga de conseguir el atributo palabra de los nodos hijos en referencia al nodo padre
     * @param nodo- pertenece a la clase Nodo
     * @return palabra- se encuentra el atributo palabra de los dos nodos hijos
     */
    public String conseguirPalabra(Nodo nodo){
        String palabra = nodo.getPalabra();
        if(palabra == "1"){
           palabra = conseguirPalabra(nodo.hijos[IZQ]);
           palabra += " ";
           palabra += conseguirPalabra(nodo.hijos[DER]);
        }
        return palabra;
    }
    /**
     * Efectua: se encarga de insertar el nodo del parametro al arbol en su correspondiente lugar con base a la frecuencia
     * @param nodo- pertenece a la clase Nodo
     * @param frecuencia- atributo que que le corresponde al nodo del parametro
     * @param palabra- atributo que le corresponde al nodo del parametro
     */
    public void insertar(Nodo nodo, int frecuencia, String palabra){
        if(nodo==null){
            nodo = new Nodo(frecuencia, palabra); 
        }
        else {
            nodo.insertar(nodo, frecuencia, palabra); 
        } 
    }
    /**
     * Efectua: ordena los vectores de frecuencias y palabras de menor a mayor frecuencia, permite que los dos vectores coincidan
     * Modifica: el orden de los elementos en los vectores
     */
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
    /**
     * Efectua: busca en el vector de nodos el nodo que tiene como atributo la frecuencia ingresado en el parametro y devuelve el nodo que le corresponde a respectiva frecuencia
     * @param frecuencia- hace referencia al atributo del nodo
     * @return nodo- pertenece a la clase Nodo
     */
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
    /**
     * Efectua: busca la posicion en el vector de nodos de un nodo ya usado.
     * @param frecuencia - el elemento del nodo a buscar.
     * @return pos - la posicion del nodo.
     */
     public int buscarPosicion(int frecuencia){
        int pos = -1;
        for(int i = 0; i < nodos.length; i++){
            if(nodos[i].getFrecuencia() == frecuencia){
                pos = i;
                break;
            }
        }
        return pos;
    }
    /**
     * Efectua: elimina el nodo indicado por la posicion.
     * @param pos - la posicion a eliminar.
     * Modifica: el vector de nodos.
     */
    public void eliminarNodo(int pos){
        Nodo [] aux = new Nodo[nodos.length-1];
        int j = 0;
        for(int i = 0; i < nodos.length; i++){
            if(pos != i){
                aux[j] = nodos[i];
                j++;
            }
        }
        nodos = aux;
    }
    /**
     * Efectua: en cada "ciclo" se elimina dos elementos de los vectores frecuencia y palabra, y se agrega un nuevo elemento que es la conjuncion de los elementos eliminados en los vectores
     * @param frecuenciaNueva- hace referencia al nuevo elemento conjunto creado del vector frecuencias
     * @param palabraNueva- hace referencia al nuevo elemento conjunto creado del vector palabras
     */
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
    /**
     * Efectua: se encarga de verificar si el arbol se encuentra vacio o con raiz presente
     * @return booleano- depende del raiz (si la raiz es nula es igual a verdadero, por lo contrario devuelve falso)
     */
    public boolean estaVacio(){
        return raiz == null;
    }
    /**
     * Efectua: devuelve la raiz del arbol
     * @return raiz- nodo raiz que conecta con todos los demas nodos
     */
    public Nodo getRaiz(){
        return raiz;
    }
    /**
     * Efectua: brinda la informacion del arbol
     * @return elementos- informacion del arbol
     */
    public String toString(){
        String elementos = "";
        if(raiz!=null){
            elementos+=""+raiz.toString(); 
        }
        return elementos;
    }

}
