
/**
 * Clase VentanaLista
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/12, final
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaLista{
    private JFrame frame;
    private Principal principal;
    /**
     * Constructor con parametro, se encarga de "construir", de ejecutar y hacer visible las graficaciones del JPanel de la clase PaneLista, es el disparador de la ventana para mostrar la lista de frecuencias 
     * @param principal- Pertenece a la clase Principal
     */
    public VentanaLista(Principal principal){

        this.principal = principal;
        frame = new JFrame("Lista de Frecuencia");
        frame.setSize(1000, 1000);
        frame.setIconImage( new ImageIcon("Letras.png").getImage());
        PaneLista lista = new PaneLista(frame, principal);
        lista.setBackground(Color.WHITE);
        Container contenedor = frame.getContentPane();
        contenedor.add(BorderLayout.CENTER ,lista);
        frame.add(lista);
        frame.setVisible(true);
    }


}
