import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Pizarra extends JPanel implements ActionListener {
    private int x;
    private int y;
    private int largo;
    private int ancho;
    private String titulo;
    private JFrame padre;
    private JScrollPane scrollPane;
    private JFrame ventana;
    private JTextArea textArea;
    private Principal principal;
    private boolean lista2;
    private boolean arbol;
    private boolean mapa;
    private JPanel miPanel;
   

    public Pizarra(JFrame padre, String titulo, Principal principal){
        this.padre = padre;
        this.titulo = titulo;
        this.principal = principal;
        ancho = 400;
        largo = 600;
        x = 100;
        y = 100;
        this.lista2 = false;
    }
    public void update(Graphics g) {
    	paintComponent(g);
    }
    public void paintComponent(Graphics g){
         g.drawImage(new ImageIcon("marco derecha.png").getImage(), x, y, 800, 600, null);
         g.setFont(new Font("Ink Free", Font.BOLD, 30));
         g.drawString(titulo, x+80, y-25);
         if(lista2==true){
        	 arbol = false;
        	 mapa = false;
        	 repaint();
        	 listaFrecuencia(g);
        	 repaint();
         }
         if(arbol==true){
        	 lista2 = false;
        	 mapa = false;
        	 repaint();
        	 arbolBinario(g);
        	 repaint();
         }
         if(mapa==true){
        	 lista2 = false;
        	 arbol = false;
        	 repaint();
        	 mapa(g);
        	 repaint();
         }
    }
    public void listaFrecuencia(Graphics g){
        //llenar
        
        int [] f = principal.getFrecuencia();
        String h [] = principal.getContenido();
        Lista lista = new Lista(f, h);
        lista.crearLista();
        lista.ordenarListaMayoraMenor();
        String lista1 = lista.toString();
        g.setFont(new Font("Ink Free", Font.ITALIC, 20));
        g.drawString("Lista de Palabras con Frecuencia", x+250, y+100);
        g.setFont(new Font("Ink Free", Font.ITALIC, 12));
        drawString(g, lista1, x+350, y+120);
       
    }
    void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
    public void mapa(Graphics g){
    	
    }
    public void arbolBinario(Graphics g){
        //llenar
    }
    public void salir(){
    	padre.setVisible(false);
    	padre.dispose();
        //llenar
    }
    public void actionPerformed(ActionEvent evento){
        switch( evento.getActionCommand()){
           case "POR FRECUENCIA":
        	    mapa = false;
          	    arbol = false;
        	    lista2 = true;
        	    repaint();
        	   
           break;
           case "MAPA":
        	    lista2 = false;
          	    arbol = false;
                mapa = true;
                repaint();
           break;         
           case "ARBOL BINARIO":
        	    lista2 = false;
            	mapa = false;
                arbol = true;
                repaint();
           break; 
           case "SALIR":
              this.salir();
           break; 
        }
     }
}

