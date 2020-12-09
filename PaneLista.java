 

/**
 * Clase PaneLista
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/12, final
 */
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PaneLista extends JPanel  {
    
    private JPanel panel;
    private Graphics g;
    private JFrame frame;
    private Principal principal;
    
    /**
     * Constructor con parametros
     * @param frame- hace referencia al JFrame de la clase ventanaLista
     * @param principal- pertenece a la clase Principal
     */
    public PaneLista(JFrame frame, Principal principal) {
    	this.frame = frame;
    	this.principal = principal;
    }
    /**
     * Efectua: el metodo se encarga de crear la graficacion o el dibujo de la lista de frecuencia
     * @param g- pertenece a la clase Graphics, se encarga de "dibujar" los elementos
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
       
        int [] f = principal.getFrecuencia();
        String h [] = principal.getContenido();
        Lista lista = new Lista(f, h);
        lista.crearLista();
        lista.ordenarListaMayoraMenor();
        String lista1 = lista.toString();  
       
        g.setFont(new Font("Ink Free", Font.ITALIC, 20));
        g.drawString("Lista de Palabras con Frecuencia", 360, 60);
       
        drawString(g, lista1, 430, 100);
     
        
    }
    /**
     * Efectua: se encarga de graficar o dibujar las palabras dando un salto de linea cada vez que aparezca una palabra en la variable que contiene la lista de frecuencia
     * @param g- pertenece a la clase Graphics, se encarga de "dibujar" los elementos
     * @param text- hace referencia a la variable que contiene la lista de frecuencia
     * @param x- posicion en el eje x
     * @param y- posicion en el eje y
     */
     public void drawString(Graphics g, String text, int x, int y) {
            for (String line : text.split("\n"))
                g.drawString(line, x, y += g.getFontMetrics().getHeight());
            
        }




    
}