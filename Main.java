 

/**
 * Clase Main es el disparador del programa.
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/12, final
 */
public class Main {

    public static void main(String trigger[]){
        String archivo = "";
        if(trigger.length > 0){
            archivo = trigger[0];
        }
        else{
            archivo = "ejemplo.txt";
        }
        App app = new App();
        app.ejecutar(archivo);
    }

}
