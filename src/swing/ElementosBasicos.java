package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class ElementosBasicos extends JFrame {

    private JList lstListado;
    private JComboBox cmbBox;
    private JTextArea txtArea;
    private JPanel pnlCentral, pnl2;
    private JScrollPane pnl1, pnl3;
    private JButton btnBoton;
    private DefaultListModel modeloLista;
    private DefaultComboBoxModel modeloCmbBox;

    public ElementosBasicos() {
        this.crearElementos();
        this.ponerTextoElementos();
        this.definirEstilos();
        this.crearDistribucion();
        this.aniadirElementos();
        this.eventos();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 300);
    }

    // JList, JComboBox, JTextArea
    public void crearElementos() {
        this.lstListado = new JList();
        this.cmbBox = new JComboBox();
        this.txtArea = new JTextArea();
        this.pnlCentral = new JPanel();
        this.pnl1 = new JScrollPane();
        this.pnl2 = new JPanel();
        this.pnl3 = new JScrollPane();
        this.btnBoton = new JButton();

        this.modeloLista = new DefaultListModel();
        this.modeloCmbBox = new DefaultComboBoxModel();
    }

    public void ponerTextoElementos() {
        this.setTitle("Carlos Aguirre Vozmediano");
        this.btnBoton.setText("Boton");

        this.lstListado.setModel(modeloLista);
        modeloLista.addElement("Lunes");
        modeloLista.addElement("Martes");
        modeloLista.addElement("Miercoles");

        this.cmbBox.setModel(modeloCmbBox);
        this.modeloCmbBox.addElement("Lunes");
        this.modeloCmbBox.addElement("Martes");
        this.modeloCmbBox.addElement("Miércoles");
        this.modeloCmbBox.addElement("Jueves");
        this.modeloCmbBox.addElement("Viernes");
        this.modeloCmbBox.addElement("Sábado");
        this.modeloCmbBox.addElement("Domingo");

        this.txtArea.setText("Hola mundo.\nEsto es otra línea.");
    }

    public void definirEstilos() {

    }

    public void crearDistribucion() {
        this.getContentPane().setLayout(new BorderLayout());
        this.pnlCentral.setLayout(new GridLayout(1, 3, 5, 5));
    }

    public void aniadirElementos() {
        this.getContentPane().add(this.pnlCentral, BorderLayout.CENTER);
        this.pnlCentral.add(this.pnl1);
        this.pnlCentral.add(this.pnl2);
        this.pnlCentral.add(this.pnl3);
        this.pnl1.setViewportView(this.lstListado);
        this.pnl2.add(this.cmbBox);
        this.pnl3.setViewportView(this.txtArea);
        this.getContentPane().add(this.btnBoton, BorderLayout.SOUTH);
    }

    private void mensajeSaliente(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void eventos() {
        this.btnBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloLista.addElement("Otra cosa");
                modeloCmbBox.addElement("Otro nuevo");
                txtArea.setText(txtArea.getText() + "\nOtra linea");
                
                mensajeSaliente("ListBox: " + lstListado.getSelectedValue() + "\n" + 
                        "ComboBox: " + cmbBox.getSelectedItem());
            }
        });
    }

    public void mostrar() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ElementosBasicos v = new ElementosBasicos();
        v.mostrar();
    }
}
