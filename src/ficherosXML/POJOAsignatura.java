
package ficherosXML;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class POJOAsignatura {
    private int codigo;
    private String nombre;
    private int horas;
    private double precio;
    private String contenido;
    private String descripcion;

    public POJOAsignatura(int codigo, String nombre, int horas, double precio, String contenido, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horas = horas;
        this.precio = precio;
        this.contenido = contenido;
        this.descripcion = descripcion;
    }
    
    public POJOAsignatura(){}

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHoras() {
        return horas;
    }

    public double getPrecio() {
        return precio;
    }

    public String getContenido() {
        return contenido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "Codigo: " + codigo + ", Nombre: " + nombre + ", Horas: " + horas + ", Precio: " + precio + ", Contenido: " + contenido + ", Descripcion: " + descripcion + '}';
    }
}
