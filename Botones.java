import javax.swing.*;
import java.awt.*;
public class Botones extends JPanel {
    public static final String nombre [] = {"POR FRECUENCIA", "MAPA", "ARBOL BINARIO", "SALIR"};
    private JButton[] botones;
    private Pizarra pizarra;

    public Botones(Pizarra pizarra){
        this.pizarra = pizarra;
        this.setLayout(new GridLayout(2,2));
        botones = new JButton [nombre.length];
        for(int i = 0; i < nombre.length; i++){
            botones[i] = new JButton( nombre[i]);
            botones[i].addActionListener(pizarra);
            add(botones[i]);
         }
    }
}

