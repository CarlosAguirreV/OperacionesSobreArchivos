package patronMVC;

/**
 *
 * @author Carlos Aguirre Vozmediano
 */
public class Comenzar {
    public static void main(String[] args) {
        Vista v = new Vista();
        Modelo m = new Modelo();
        Controlador c = new Controlador(v, m);
        v.setControlador(c);
        
        v.mostrar();
    }
}
