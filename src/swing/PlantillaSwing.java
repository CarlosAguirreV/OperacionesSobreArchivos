package swing;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class PlantillaSwing extends JFrame{
    public PlantillaSwing(){
        this.crearElementos();
        this.ponerTextoElementos();
        this.crearDistribucion();
        this.aniadirElementos();
        this.eventos();
        
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }
    
    public void crearElementos(){}
    
    public void ponerTextoElementos(){
        this.setTitle("Carlos Aguirre Vozmediano");
    }
    
    public void crearDistribucion(){
        this.getContentPane().setLayout(new BorderLayout());
    }
    
    public void aniadirElementos(){}
    
    public void eventos(){}
    
    public void mostrar(){
        this.setVisible(true);
    }
}
