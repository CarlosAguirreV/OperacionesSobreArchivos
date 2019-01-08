package patronMVC;

/**
 *
 * @author Carlos Aguirre Vozmediano
 */
public class Controlador {

    private Vista v;
    private Modelo m;

    public Controlador(Vista v, Modelo m) {
        this.v = v;
        this.m = m;
    }
}
