/**
 * Clase PaneArbol
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/12, final
 */
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaneArbol extends JPanel {
    private int x;
    private int y;
    private int largo;
    private int ancho;
    private Principal principal;
    private Arbol arbol1;
    private JFrame frame;
    /**
     * Constructor con parametros
     * 
     * @param frame- hace referencia al JFrame de la clase ventanaArbol
     * @param principal- pertenece a la clase Principal
     * @param arbol- pertenece a la clase Arbol(ordenamiento de estructura arbol binario)
     */

    public PaneArbol(JFrame frame, Principal principal, Arbol arbol){
        this.frame = frame;
        this.principal = principal;
        this.arbol1 = arbol;
        ancho = 400;
        largo = 600;
        x = 10;
        y = 0;

    }

    /**
     * Efectua: se encarga de de graficar el arbol binario en el JPanel
     * @param g- pertenece a la clase Graphics, se encarga de "dibujar" los elementos
     * Modifica: el JPanel
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Agency FB", Font.PLAIN, 40));
        g.drawString("Arbol Binario", 550, 35);
        arbolBinario(g, arbol1.getRaiz(), 550, 5, 500);

		
    }

    /**
     * Efectua: se encarga del dibujo o graficacion del arbol binario
     * @param g- pertenece a la clase Graphics, se encarga de "dibujar" los elementos
     * @param nodoActual- hace referencia al raiz del arbol
     * @param coordenadaX- posicion en eje x (horizontal)
     * @param coordenadaY- posicion en eje y (vertical)
     * @param dimensiones- se le hace referencia a nulo
     */
    public void arbolBinario(Graphics g, Nodo nodoActual, int coordenadaX, int coordenadaY, int dimensiones){
        //Si el nodoActual es igual al raiz del arbol 
        if(nodoActual == arbol1.getRaiz()){
            //Se dibuja o grafica el atributo frecuencia del nodo raiz
            g.setFont(new Font("Arial", Font.ITALIC, 10));
            g.drawString(""+nodoActual.getFrecuencia(), coordenadaX+50, coordenadaY +90);
            //Si tiene hijo se dibuja o grafica una linea que conecte el nodo raiz con el hijo
            if(nodoActual.hijos[0] != null) {
                g.drawLine(coordenadaX + 55, coordenadaY + 95, coordenadaX - 20, coordenadaY + 105);
            }
            if(nodoActual.hijos[1] != null){
                g.drawLine(coordenadaX + 55, coordenadaY + 95, coordenadaX +140, coordenadaY + 140);
            }
            //recursividad para continuar la creacion de la graficacion del arbol a traves de los nodos hijos del nodo raiz
            arbolBinario(g,  nodoActual.hijos[0], coordenadaX-80,coordenadaY+70, dimensiones);
            arbolBinario(g,  nodoActual.hijos[1], coordenadaX+80, coordenadaY+70,dimensiones);
        }
        else{
            if(nodoActual != arbol1.getRaiz() && nodoActual != null){
                //cuando el nodo actual no es una hoja
                if(nodoActual.getPalabra().equals("1") == false) {
                    g.setFont(new Font("Arial", Font.BOLD, 10));
                    g.drawString("" + nodoActual.getPalabra(), coordenadaX + 50, coordenadaY + 50);
                    g.setFont(new Font("Arial", Font.ITALIC, 10));
                    g.drawString("" + nodoActual.getFrecuencia(), coordenadaX + 50, coordenadaY + 70);
                    arbolBinario(g, nodoActual.hijos[0], coordenadaX - 80, coordenadaY + 70, dimensiones);
                    arbolBinario(g, nodoActual.hijos[1], coordenadaX + 80, coordenadaY + 70, dimensiones);
                }
                else{
                    g.setFont(new Font("Arial", Font.ITALIC, 10));
                    g.drawString("" + nodoActual.getFrecuencia(), coordenadaX + 50, coordenadaY + 90);
                    if(nodoActual.hijos[0] != null) {
                        //si los nodos hijos del nodoActual no son nulos, los casos al igual se dividen al aquellos nodos que tengan de atributo palabra un 1 y atributo frecuencia como una suma de frecuencias o no
                        if(nodoActual.hijos[0].getPalabra().equals("1") == false) {
                            g.drawLine(coordenadaX + 55, coordenadaY + 95, coordenadaX - 20, coordenadaY + 105);
                        }
                        else{
                            g.drawLine(coordenadaX + 55, coordenadaY + 95, coordenadaX - 25, coordenadaY + 140);
                        }
                    }
                    if(nodoActual.hijos[1] != null){
                        if(nodoActual.hijos[1].getPalabra().equals("1") == false) {
                            g.drawLine(coordenadaX + 55, coordenadaY + 95, coordenadaX + 130, coordenadaY + 105);
                        }
                        else{
                            g.drawLine(coordenadaX + 55, coordenadaY + 95, coordenadaX + 140, coordenadaY + 140);
                        }
                    }
                    arbolBinario(g, nodoActual.hijos[0], coordenadaX - 80, coordenadaY + 70, dimensiones);
                    arbolBinario(g, nodoActual.hijos[1], coordenadaX + 80, coordenadaY + 70, dimensiones);
                }
            }
        }

    }

    /**
     * Efectua: devuelve la variable x de la clase Pizarra
     * @return x- posicion en eje x(horizontal)
     */
    public int getX(){
        return x;
    }

    /**
     * 
     * Efectua: devuelve la variable y de la clase Pizarra
     * @return y- posicion en eje y(vertical)
     */
    public int getY(){
        return y;
    }

}
