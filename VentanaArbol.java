 

/**
 * Clase VentanaArbol
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
public class VentanaArbol extends JFrame {
    private JFrame frame;
    private Arbol arbol;
    private Principal principal;
    /**
     * Constructor con parametro, se encarga de preparar los elementos necesarios y de "construir", de ejecutar y hacer visible las graficaciones del JPanel de la clase PaneArbol, es el disparador de la ventana para mostrar el arbol
     * @param principal- Pertenece a la clase Principal
     */
    public VentanaArbol(Principal principal){

        this.principal = principal;
        frame = new JFrame("Arbol Binario");
        frame.setSize(1200, 1200);
        frame.setIconImage( new ImageIcon("Letras.png").getImage());
        int [] f = principal.getFrecuencia();
        String h [] = principal.getContenido();
        arbol = new Arbol(principal.getFrecuencia(), principal.getContenido());
        arbol.crearArbol();
        PaneArbol panel = new PaneArbol(frame, principal, arbol);
        panel.setBackground(Color.WHITE);

        Container contenedor = frame.getContentPane();
        contenedor.add(BorderLayout.CENTER ,panel);

        frame.setVisible(true);
    }


}

