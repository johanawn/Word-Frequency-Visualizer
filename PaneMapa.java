/**
 * Clase PaneMapa
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

public class PaneMapa extends JPanel {
    private int x;
    private int y;
    private int largo;
    private int ancho;
    private Principal principal;
    private Arbol arbol1;
    private Graphics g;
    private JFrame frame;

    /**
     * Constructor con parametros
     * 
     * @param frame- hace referencia al JFrame de la clase ventanaArbol
     * @param principal- pertenece a la clase Principal
     * @param arbol- pertenece a la clase Arbol(ordenamiento de estructura arbol binario)
     */
    public PaneMapa(JFrame frame, Principal principal, Arbol arbol){

        ancho = 400;
        largo = 600;
        x = 100;
        y = 100;
        this.principal = principal;
        this.frame = frame;
        this.arbol1 = arbol;

    }

    /**
     * Efectua: se encarga de de graficar el mapa en el JPanel.
     * @param g- pertenece a la clase Graphics, se encarga de "dibujar" los elementos
     * Modifica: el JPanel
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Agency FB", Font.PLAIN, 40));
        g.drawString("MAPA", 610, 50);
        mapa(g, arbol1.getRaiz(), 400, 100, 500, 500, false);
    }
    /**
     * Efectua: dibuja el mapa de las frecuencias.
     * @param g - pertenece a la clase Graphics, se encarga de "dibujar" los elementos
     * @param nodoActual - el nodo por dibujar en determinado momento.
     * @param xInicio - la coordenada x donde se empieza a dibujar el rectangulo determinado.
     * @param yInicio - la coordenada y donde se empieza a dibujar el rectangulo determinado.
     * @param ancho - ancho del rectangulo.
     * @param longitud - largo del rectangulo.
     * @param horizontal - indica si el rectangulo se tiene que partir vertical u horizontalmente.
     * Modifica: el JPanel
     */
    public void mapa(Graphics g, Nodo nodoActual, int xInicio, int yInicio, double ancho, double longitud, boolean horizontal){
        double porcentajeDer = 0;
        double nuevaLongDer = 0;
        double nuevoAnchoDer = 0;
        double porcentajeIzq = 0;
        double nuevaLongIzq = 0;
        double nuevoAnchoIzq = 0;
        if(nodoActual == arbol1.getRaiz()) {//caso: si el nodo es la raíz del aŕbol.
            g.drawRect(xInicio, yInicio,  (int) longitud,  (int) ancho);
            if(nodoActual.hijos[0] != null && nodoActual.hijos[1] != null){//caso en que la raiz tiene 2 hijos
                porcentajeDer = ((double) nodoActual.hijos[0].getFrecuencia() / (double) nodoActual.getFrecuencia());
                nuevaLongDer = longitud * porcentajeDer;
                nuevoAnchoDer = ancho * porcentajeDer;
                porcentajeIzq = ((double) nodoActual.hijos[1].getFrecuencia() / (double) nodoActual.getFrecuencia());
                nuevaLongIzq = longitud * porcentajeIzq;
                nuevoAnchoIzq = ancho * porcentajeIzq;
                g.drawRect(xInicio, yInicio, (int) nuevoAnchoIzq, (int) longitud);
                if(nodoActual.hijos[1].getPalabra().equals("1") == false){
                    g.setFont(new Font("Arial", Font.ITALIC, 9));
                    g.drawString(nodoActual.hijos[1].getPalabra(), (xInicio + ((int) (nuevoAnchoIzq*0.5)))-15, yInicio + ((int)(longitud*0.5)));
                }
                if(nodoActual.hijos[0].getPalabra().equals("1") == false){
                    g.setFont(new Font("Arial", Font.ITALIC, 9));
                    g.drawString(nodoActual.hijos[0].getPalabra(),(((int)(xInicio+nuevaLongIzq))+((int) (nuevoAnchoDer*0.5)))-15, yInicio+((int)(longitud*0.5)));
                }
                g.drawRect((int)(xInicio+nuevaLongIzq), yInicio, (int) nuevoAnchoDer, (int) longitud);
                mapa(g, nodoActual.hijos[1], xInicio, yInicio, nuevoAnchoIzq, longitud, true);
                mapa(g, nodoActual.hijos[0], (int)(xInicio+nuevoAnchoIzq), yInicio, nuevoAnchoDer, longitud, true);
            }
            else {
                if (nodoActual.hijos[0] != null && nodoActual.hijos[1] == null) {// caso si la raiz solo tiene el hijo izquierdo
                    porcentajeIzq = ((double) nodoActual.hijos[0].getFrecuencia() / (double) nodoActual.getFrecuencia());
                    nuevaLongIzq = longitud * porcentajeIzq;
                    nuevoAnchoIzq = ancho * porcentajeIzq;
                    if(nodoActual.hijos[0].getPalabra().equals("1") == false){
                        g.setFont(new Font("Arial", Font.ITALIC, 9));
                        g.drawString(nodoActual.hijos[0].getPalabra(),(xInicio +((int) ((nuevoAnchoIzq)*0.5)))-15, yInicio+((int)(nuevaLongIzq*0.5)));
                    }
                    g.drawRect(xInicio, yInicio, (int) nuevoAnchoIzq,(int) nuevaLongIzq);
                    mapa(g, nodoActual.hijos[0], xInicio, yInicio, nuevoAnchoIzq, nuevaLongIzq, true);
                }
                else {//caso en que la raiz solo tiene el hijo derecho
                    if (nodoActual.hijos[1] != null && nodoActual.hijos[0] == null) {
                        porcentajeDer = ((double) nodoActual.hijos[1].getFrecuencia() / (double) nodoActual.getFrecuencia());
                        nuevaLongDer = longitud * porcentajeDer;
                        nuevoAnchoDer = ancho * porcentajeDer;
                        if(nodoActual.hijos[0].getPalabra().equals("1") == false){
                            g.setFont(new Font("Arial", Font.ITALIC, 9));
                            g.drawString(nodoActual.hijos[0].getPalabra(),(xInicio +((int) ((nuevoAnchoDer)*0.5)))-15, yInicio+((int)(nuevaLongDer*0.5)));
                        }
                        g.drawRect(xInicio, yInicio, (int) nuevoAnchoDer, (int) nuevaLongDer);
                        mapa(g, nodoActual.hijos[1], xInicio, yInicio, nuevoAnchoDer, nuevaLongDer, true);
                    }
                }
            }
        }
        else{// caso en que nodoActual es diferente a la raiz
            if(nodoActual.hijos[0] != null && nodoActual.hijos[1] != null){ // caso si el nodo actual tiene ambos hijos
                porcentajeDer = ((double) nodoActual.hijos[0].getFrecuencia() / (double) nodoActual.getFrecuencia());
                nuevaLongDer = longitud * porcentajeDer;
                nuevoAnchoDer = ancho * porcentajeDer;
                porcentajeIzq = ((double) nodoActual.hijos[1].getFrecuencia() / (double) nodoActual.getFrecuencia());
                nuevaLongIzq = longitud * porcentajeIzq;
                nuevoAnchoIzq = ancho * porcentajeIzq;
                if(horizontal == true) {// si el cuadrado actual se tiene que partir horizontalmente
                    if(nodoActual.hijos[1].getPalabra().equals("1") == false){
                        g.setFont(new Font("Arial", Font.ITALIC, 9));
                        g.drawString(nodoActual.hijos[1].getPalabra(), (xInicio + ((int) (ancho*0.5)))-15, yInicio + ((int)(nuevaLongIzq*0.5)));
                    }
                    if(nodoActual.hijos[0].getPalabra().equals("1") == false){
                        g.setFont(new Font("Arial", Font.ITALIC, 9));
                        g.drawString(nodoActual.hijos[0].getPalabra(),(xInicio+((int) (ancho*0.5)))-15, ((int) (yInicio + nuevaLongIzq))+((int)(nuevaLongDer*0.5)));
                    }
                    g.drawRect(xInicio, yInicio, (int) ancho, (int) nuevaLongIzq);
                    g.drawRect(xInicio, (int) (yInicio + nuevaLongIzq), (int) ancho, (int) nuevaLongDer);
                    mapa(g, nodoActual.hijos[1], xInicio, yInicio, ancho, nuevaLongIzq, false);
                    mapa(g, nodoActual.hijos[0], xInicio, (int) (yInicio + nuevaLongIzq), ancho, nuevaLongDer, false);
                }
                else{//si el cuadrado se parte verticalmente
                    if(nodoActual.hijos[1].getPalabra().equals("1") == false){
                        g.setFont(new Font("Arial", Font.ITALIC, 9));
                        g.drawString(nodoActual.hijos[1].getPalabra(), (xInicio + ((int) (nuevoAnchoIzq*0.5)))-15, yInicio + ((int)(longitud*0.5)));
                    }
                    if(nodoActual.hijos[0].getPalabra().equals("1") == false){
                        g.setFont(new Font("Arial", Font.ITALIC, 9));
                        g.drawString(nodoActual.hijos[0].getPalabra(),(((int)(xInicio+nuevoAnchoIzq))+((int) (nuevoAnchoDer*0.5)))-15, yInicio+((int)(longitud*0.5)));
                    }
                    g.drawRect(xInicio, yInicio, (int) nuevoAnchoIzq, (int) longitud);
                    g.drawRect((int)(xInicio+nuevoAnchoIzq), yInicio, (int) nuevoAnchoDer, (int) longitud);
                    mapa(g, nodoActual.hijos[1], xInicio, yInicio, nuevoAnchoIzq, longitud, true);
                    mapa(g, nodoActual.hijos[0], (int)(xInicio+nuevoAnchoIzq), (int) yInicio, nuevoAnchoDer, longitud, true);
                }

            }
            else {
                if (nodoActual.hijos[0] != null && nodoActual.hijos[1] == null) { // caso si el nodoActual diferente a la raiz, solo tiene hijo izquierdo
                    porcentajeIzq = ((double) nodoActual.hijos[0].getFrecuencia() / (double) nodoActual.getFrecuencia());
                    nuevaLongIzq = longitud * porcentajeIzq;
                    nuevoAnchoIzq = ancho * porcentajeIzq;
                    if(horizontal == true) {
                        g.drawRect(xInicio, yInicio, (int) ancho, (int) nuevaLongIzq);
                        mapa(g, nodoActual.hijos[0], xInicio, yInicio, ancho, nuevaLongIzq, false);
                    }
                    else{
                        g.drawRect(xInicio, yInicio, (int) nuevoAnchoIzq, (int) longitud);
                        mapa(g, nodoActual.hijos[0], xInicio, yInicio, nuevoAnchoIzq, longitud, true);
                    }

                }
                else {// caso si el nodoActual, que es diferente a la raiz, solo tiene hijo derecho
                    if (nodoActual.hijos[1] != null && nodoActual.hijos[0] == null) {
                        porcentajeDer = ((double) nodoActual.hijos[1].getFrecuencia() / (double) nodoActual.getFrecuencia());
                        nuevaLongDer = longitud * porcentajeDer;
                        nuevoAnchoDer = ancho * porcentajeDer;
                        if(horizontal == true) {
                            g.drawRect(xInicio, yInicio, (int) ancho, (int) nuevaLongDer);
                            mapa(g, nodoActual.hijos[1], xInicio, yInicio, ancho, nuevaLongDer, false);
                        }
                        else{
                            g.drawRect(xInicio, yInicio, (int) nuevoAnchoDer, (int) longitud);
                            mapa(g, nodoActual.hijos[1], xInicio, yInicio, nuevoAnchoDer, longitud, true);
                        }

                    }
                }
            }

        }

    }

}