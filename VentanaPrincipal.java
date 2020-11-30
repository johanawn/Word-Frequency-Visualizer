import javax.swing.*;
import java.awt.*;
public class VentanaPrincipal extends JFrame {
private Principal principal;
    public VentanaPrincipal(Principal principal){
        
        super("ANALIZADOR DE FRECUENCIA DE PALABRAS EN UN TEXTO");
        this.principal = principal;
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage( new ImageIcon("Letras.png").getImage());
        Pizarra pizarra = new Pizarra(this, "REPRESENTACIÓN: ", principal); 
        Container contenedor = getContentPane();
        contenedor.add(BorderLayout.CENTER ,pizarra);
        Botones botones = new Botones(pizarra);
        contenedor.add(BorderLayout.SOUTH, botones);
        setVisible(true);
    }
}

