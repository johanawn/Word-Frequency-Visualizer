public class Main {
    public static void main(String trigger[]){
        Principal principal = new Principal();
        principal.cargarArchivo("ejemplo.txt");
        principal.ordenamientoBurbuja();
        String p[] = principal.getPalabras();
        principal.calcularFrecuencias();
        for(int i = 0; i < p.length; i++){
            System.out.println(""+p[i]);
        }
        System.out.println(""+p.length);
        int [] f = principal.getFrecuencia();
        for(int i = 0; i < f.length; i++){
            System.out.println(""+f[i]);
        }
        String g [] = principal.getContenido();
        for(int i = 0; i < g.length; i++){
            System.out.println(""+g[i]);
        }
        Lista lista = new Lista(f, g);
        lista.crearLista();
        lista.ordenarListaMenoraMayor();
        String lista2 = lista.toString();
        System.out.println(""+lista2);
        principal.ordenarVectores();
        Arbol arbol = new Arbol(principal.getFrecuencia(), principal.getContenido());
        arbol.crearArbol();
        String arbol1 = arbol.toString();
        System.out.print(""+arbol1);
        VentanaPrincipal ventana = new VentanaPrincipal(principal);
    }
    
}
