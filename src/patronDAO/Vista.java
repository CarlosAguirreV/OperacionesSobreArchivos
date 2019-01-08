package patronDAO;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Carlos Aguirre Vozmediano
 */
public class Vista extends JFrame implements Interfaz{

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

    
    @Override
    public void mostrar() {
        this.setVisible(true);
    }
}
