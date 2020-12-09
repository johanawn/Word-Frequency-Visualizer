 


 /**
 * Clase Nodo
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/12, final
 */
public class Nodo{  
    public static final int IZQ = 0;
    public static final int DER = 1;
    private String palabra;
    private int frecuencia;
    public Nodo[] hijos;

    /**
     * Constructor con parametros
     * @param frecuencia- cantidad de veces que aparece una palabra en el archivo de texto
     * @param palabra- palabra de respectiva frecuencia
     */
    public Nodo (int frecuencia, String palabra){
        this.frecuencia = frecuencia;
        this.palabra = palabra;
        this.hijos = new Nodo [2];
    }
    /**
     * Constructor con parametros (referencia a raices)
     * @param frecuencia- cantidad de veces que aparece una palabra en el archivo de texto
     */
    public Nodo(int frecuencia){
        this.frecuencia = frecuencia;
        this.palabra = "1";
        this.hijos = new Nodo[2];
    }
    /**
     * Efectua: inserta desde el nodo que le hace referencia, el nodo del parametro, hasta en su correspondiente posicion tomando de base la frecuencia
     * Modifica: el nodo que se le hace referencia
     * @param nodo- pertenece a la clase Nodo
     * @param frecuencia- cantidad de veces que aparece una palabra en el archivo de texto
     * @param palabra- palabra de respectiva frecuencia
     */
    public void insertar(Nodo nodo, int frecuencia, String palabra){
        int lado = DER;
        if(frecuencia < this.frecuencia){
            lado = IZQ;  
        }
        if(this.hijos[IZQ]!= null && frecuencia == this.hijos[IZQ].frecuencia){
            lado = DER;
        }
          if(this.hijos[DER] != null && frecuencia == this.hijos[DER].frecuencia){
            lado = IZQ;
        }
        if(hijos[IZQ] != null){
            lado = DER;
        }
        if(hijos[DER] != null){
            lado = IZQ;
        }
        if(hijos[lado] == null){
            hijos[lado] = new Nodo( frecuencia, palabra);  
        }
        else {
            hijos[lado].insertar( nodo, frecuencia, palabra);  
        }
    }
    /**
     * Efectua: inserta desde el nodo que le hace referencia, el nodo del parametro, hasta en su correspondiente posicion tomando de base la frecuencia
     * Modifica: el nodo que se le hace referencia
     * @param nodo- pertenece a la Clase Nodo
     */
     public void insertar(Nodo nodo){
        int lado = DER;
        if(nodo.frecuencia < this.frecuencia){
            lado = IZQ;  
        }
         if(this.hijos[IZQ]!= null && frecuencia == this.hijos[IZQ].frecuencia){
            lado = DER;
        }
          if(this.hijos[DER] != null && frecuencia == this.hijos[DER].frecuencia){
            lado = IZQ;
        }
          if(hijos[IZQ] != null){
            lado = DER;
        }
        if(hijos[DER] != null){
            lado = IZQ;
        }
        if(hijos[lado] == null){
            hijos[lado] = nodo;  
        }
        else {
            hijos[lado].insertar( nodo);  
        }
    }
     /**
      * Efectua: devuelve el atributo frecuencia de la clase Nodo
      * @return frecuencia- la frecuencia que le corresponde al nodo
      */
    public int getFrecuencia(){
        return this.frecuencia;
    }
    /**
     * Efectua: devuelve el atributo palabra de la clase Nodo
     * @return palabra- la palabra que le corresponde al nodo
     */
    public String getPalabra(){
        return this.palabra;
    }
    /**
     * Efectua: da la informacion del nodo
     * @return elemento- la informacin del Nodo
     */

       public String toString(){
          String elementos="";
          if(hijos[IZQ]!=null){
             elementos+= hijos[IZQ]; // LLAMA A hijo[IZQ].toString();   
          }  
          elementos+= " "+frecuencia;    
          if(hijos[DER]!=null){
             elementos+= hijos[DER];  // LLAMA A hijo[DER].toString(); 
          }
          return elementos;
       }
}

