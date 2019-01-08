package flujoBytes;

import java.io.Serializable;

/**
 * Esta clase es usada para pruebas con ObjectOutputStream y ObjectInputStream
 * @author Carlos
 */
public class POJOPersona implements Serializable{
    private String nombre;
    private int edad;
    
    public POJOPersona(){}
    
    public POJOPersona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "POJOPersona{" + "Nombre: " + nombre + ", Edad:" + edad + '}';
    }
}
