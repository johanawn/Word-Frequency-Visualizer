 


/**
 * Clase App
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/12, final
 */
public class App{

    private Lista lista;
    private Arbol arbol;
    private Principal principal;
    
/**
 * Efectua: es el encargado de preparar la mayor parte de los elementos para la construccion de la clase VentanaPrincipal y ejecuta el programa
 * @param archivo- archivo de texto ingresado en la entrada del programa
 */
    public void ejecutar(String archivo){
        principal = new Principal();
        principal.cargarArchivo(archivo);
        principal.ordenamientoBurbuja();
        principal.calcularFrecuencias();
        principal.ordenarVectores();
       
        Interfaz ventanaInterfaz = new Interfaz(principal);
        
    }
}