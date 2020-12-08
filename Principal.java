
/**
 * Clase Principal
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/12, final
 */
import java.io.*;
import java.util.Scanner;
public class Principal{
    private String palabras [];
    private int frecuencia [];
    private String contenido[];
    /**
     * Constructor sin parametros
     */
    public Principal(){
        palabras = new String [1];
    }

    /**
     * Efectua: carga el archivo de texto introducido al programa y verifica si es compatible con el programa, ademas guarda las palabras que que encuentra en un vector
     * @param archivo- archivo de texto
     * @return existeArchivo- booleano que verifica si el archivo de texto fue cargado correctamente en el programa
     */
    public boolean cargarArchivo(String archivo){
        boolean existeArchivo = true;
        int i = 0;
       try{
            Scanner lector = new Scanner(new File(archivo));
            while(lector.hasNext()){
                if(i == palabras.length){
                    String v[] = new String[palabras.length+1];
                    for(int j = 0; j < palabras.length; j++){
                        v[j] = palabras[j];
                    }
                    palabras = v;
                }
                palabras[i] = lector.next();
                i++;
            }
        }
        catch(Exception e){
            System.err.println("No el existe archivo con el nombre: "+archivo);
            existeArchivo = false;
        }
        return existeArchivo;
    }
    /**
     * Efectua: ordena alfabeticamente las palabras que se encuentra en el vector palabras
     * Modifica: el orden de los elementos del vector
     */
    public void ordenamientoBurbuja(){
        String swap = "";
         for(int i = 0; i < palabras.length; i++){
             for(int j = 0; j < (palabras.length-i)-1; j++){
                if(palabras[j].compareTo(palabras[j+1])>0){
                     swap = palabras[j];
                     palabras[j] = palabras[j+1];
                     palabras[j+1] = swap;
                } 
            }
        }
    }
    /**
     * Efectua: crea el vector frecuencia y calcula la frecuencia que tiene cada palabra distinta en el archivo de texto y crea el vector contenido en la cual contiene las palabras sin repetir
     * 
     */
    public void calcularFrecuencias(){
        frecuencia = new int [1];
        contenido = new String[1];
        int contador = 0;
        int j = 0;
        int i = 0;
        String palabra = palabras[0];
        contenido[0] = palabra;
        while( i < palabras.length){
            if(palabras[i].equals(palabra)){
                if(j == frecuencia.length){
                    int v[] = new int[frecuencia.length+1];
                    for(int x = 0; x < frecuencia.length; x++){
                        v[x] = frecuencia[x];
                    }
                    frecuencia = v;
                }
                contador++;
                frecuencia[j] = contador;
                i++;
            }
            else{
                palabra = palabras[i];
                contador = 0;
                j++;
                String p []= new String [contenido.length+1];
                for(int x = 0; x < frecuencia.length; x++){
                    p[x] = contenido[x];
                }
                contenido = p;
                contenido[j]= palabra;
            }
        }
    }
    
    /**
     * Efectua: ordena el vector de menor a mayor frecuencia, y lo hace coincidir con el vector contenido, en referente a su frecuencia y respectivo palabra
     * Modifica: el orden de los elementos de los vectores
     */
    public void ordenarVectores(){
         int swap = 0;
        String cambio = "";
        for(int i = 0; i < frecuencia.length; i++){
            for(int j = 0; j < (frecuencia.length-i)-1; j++){
                if(frecuencia[j]> frecuencia[j+1]){
                    swap = frecuencia[j];
                    cambio = contenido[j];
                    frecuencia[j] = frecuencia[j+1];
                    contenido[j] = contenido[j+1];
                    frecuencia[j+1] = swap;
                    contenido[j+1] = cambio;
                } 
            }

        }
    }
    
    /**
     * Efectua: devuelve la variable vector frecuencia de la clase Principal
     * @return frecuencia- vector que contiene las frecuencias de cada palabra en el archivo de texto
     */
    public int [] getFrecuencia(){
        return frecuencia;
    }
    
    /**
     * Efectua: devuelve la variable vector palabras de la clase Principal
     * @return palabras- vector que contiene las palabras del archivo de texto
     */
    public String[] getPalabras(){
        return palabras;
    }
    
    /**
     * Efectua: devuelve la variable vector contenido de la clase Principal
     * @return palabras- vector que contiene las palabras sin repetir del archivo de texto
     */
    public String [] getContenido(){
        return contenido;
    }
}