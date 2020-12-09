 


/**
 * Clase Intefaz
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/12, final
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
public class Interfaz implements ActionListener {

    private JFrame ventana;
    private JPanel panel;
    private JButton boton_arbol;
    private JButton boton_mapa;
    private JButton boton_lista;
    private JButton salir;
    private VentanaLista ventanaLista;
    private VentanaArbol ventanaArbol;
    private VentanaMapa ventanaMapa;
    private Principal principal;
/**
 * Constructor con parametros, es el encargado de preparar la ventana de inicio o menu del programa
 * @param principal- pertenece a la clase Principal
 */
    public Interfaz(Principal principal){
        this.principal = principal;
        ventana = new JFrame();
        panel = new JPanel();

        ventana.setTitle("ANALIZADOR DE FRECUENCIA DE PALABRAS EN UN TEXTO - MENU");
        ventana.setSize(500, 100);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setIconImage( new ImageIcon("Letras.png").getImage());
        //botones
        salir = new JButton("salir");
        salir.setBounds(100, 100,100, 100);
        salir.addActionListener(this);
        salir.setSize(50, 50);
        boton_arbol = new JButton("Arbol Binario");
        boton_arbol.addActionListener(this);
        boton_arbol.setBounds(10, 50,100, 100);
        boton_arbol.setSize(50, 50);
        boton_lista = new JButton("Lista de Frecuencia");
        boton_lista.addActionListener(this);
        boton_lista.setBounds(20, 60,100, 100);
        boton_lista.setSize(50, 50);
        boton_mapa = new JButton("Mapa");
        boton_mapa.addActionListener(this);
        boton_mapa.setBounds(30, 70,30, 20);
        boton_mapa.setSize(50, 50);
        panel.add(boton_arbol);
        panel.add(boton_lista);
        panel.add(boton_mapa);
        panel.add(salir);
        ventana.add(panel, BorderLayout.CENTER);
        ventana.setVisible(true);

    }

/**
 * Efectua: pertenece a la clase ActionListener, es el encargado de ejecutar las respectivas acciones o los eventos despues de detectar la escogencia del boton por el usuario
 * @param event- hace referencia a la escogencia de los botones del programa
 */
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
        if(event.getSource() ==  boton_lista) {
            ventanaLista = new VentanaLista(principal);

        }else {
            if(event.getSource() == boton_arbol ) {
                ventanaArbol = new VentanaArbol(principal);

            }else {
                if(event.getSource() == boton_mapa) {
                    ventanaMapa = new VentanaMapa(principal);

                }else {
                    if(event.getSource()==salir) {
                        ventana.setVisible(false);

                    }
                }
            }
        }

    }

}