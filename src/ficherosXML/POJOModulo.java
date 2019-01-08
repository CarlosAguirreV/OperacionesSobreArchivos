package ficherosXML;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Modulo")
public class POJOModulo {

    private ArrayList<POJOAsignatura> coleccionAsignaturas;

    public POJOModulo() {
    }

    public POJOModulo(ArrayList<POJOAsignatura> coleccion) {
        this.coleccionAsignaturas = coleccion;
    }

    @XmlElementWrapper(name = "listaAsignaturas")
    @XmlElement(name = "asignatura")
    public ArrayList<POJOAsignatura> getColeccionAsignaturas() {
        return coleccionAsignaturas;
    }

    public void setColeccionAsignaturas(ArrayList<POJOAsignatura> coleccionAsignaturas) {
        this.coleccionAsignaturas = coleccionAsignaturas;
    }
}
