
/**
 * Write a description of class Nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nodo{  
    public static final int IZQ = 0;
    public static final int DER = 1;
    private String palabra;
    private int frecuencia;
    public Nodo[] hijos;
    public Nodo (int frecuencia, String palabra){
        this.frecuencia = frecuencia;
        this.palabra = palabra;
        this.hijos = new Nodo [2];
    }
    public Nodo(int frecuencia){
        this.frecuencia = frecuencia;
        this.palabra = "1";
        this.hijos = new Nodo[2];
    }
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
    public int getFrecuencia(){
        return this.frecuencia;
    }
    public String getPalabra(){
        return this.palabra;
    }
      
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

