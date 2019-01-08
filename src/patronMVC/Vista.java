package patronMVC;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Carlos Aguirre Vozmediano
 */
public class Vista extends JFrame {

    private Controlador c;

    public Vista() {
        this.crearElementos();
        this.ponerTextoElementos();
        this.crearDistribucion();
        this.aniadirElementos();
        this.eventos();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    void setControlador(Controlador c) {
        this.c = c;
    }

    public void crearElementos() {
    }

    public void ponerTextoElementos() {
        this.setTitle("Carlos Aguirre Vozmediano");
    }

    public void crearDistribucion() {
        this.getContentPane().setLayout(new BorderLayout());
    }

    public void aniadirElementos() {
    }

    public void eventos() {
    }

    public void mostrar() {
        this.setVisible(true);
    }
}
