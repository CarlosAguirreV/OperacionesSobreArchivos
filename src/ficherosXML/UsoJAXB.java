package ficherosXML;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UsoJAXB {

    private static final File DIRECTORIO = new File("dir");
    private static final File ARCHIVO = new File(DIRECTORIO, "ficheroXML2.xml");

    public UsoJAXB() {
        DIRECTORIO.mkdir();
        System.out.println("Se ha guardado en: " + ARCHIVO.getAbsolutePath());
    }

    public void escribir(POJOModulo modulo) {
        try {
            // Indicar clase raíz:
            JAXBContext contexto = JAXBContext.newInstance(POJOModulo.class);

            // Crear el Marshaller que convierte el java bean en una cadena XML:
            Marshaller conversorJavaAXML = contexto.createMarshaller();

            // Dar formato al XML:
            conversorJavaAXML.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Visualizar los resultados por consola:
//            conversorJavaAXML.marshal(modulo, System.out);

            // Escribir el archivo XML:
            conversorJavaAXML.marshal(modulo, ARCHIVO);

        } catch (Exception ex) {
            System.out.println("ERROR - Al escribir. \n" + ex);
        }
    }

    public void leer() {
        try {
            // Indicar clase raíz:
            JAXBContext contexto = JAXBContext.newInstance(POJOModulo.class);

            // Crear el Unmarshaller que lee el XML y crea el java bean:
            Unmarshaller conversorXMLaJava = contexto.createUnmarshaller();

            // Leo el archivo XML y genero un objeto de POJOModulo:
            POJOModulo modulo = (POJOModulo) conversorXMLaJava.unmarshal(new FileReader(ARCHIVO));

            // Obtengo el ArrayList del módulo:
            ArrayList<POJOAsignatura> coleccionAsignaturas = modulo.getColeccionAsignaturas();

            // Muestro todas las POJOAsigatura contenidas en el ArrayList:
            for (POJOAsignatura asig : coleccionAsignaturas) {
                System.out.println(asig);
            }
        } catch (Exception ex) {
            System.out.println("ERROR - Al leer. \n" + ex);
        }
    }

    public static void main(String[] args) {
        // Creo un ArrayList:
        ArrayList<POJOAsignatura> coleccionAsignaturas = new ArrayList<POJOAsignatura>();

        // Creo y añado al ArrayList dos asignaturas:
        coleccionAsignaturas.add(new POJOAsignatura(1, "Lenguage", 12, 12.3, "Gramatica y vocabulario", "Se estudia lengua castellana"));
        coleccionAsignaturas.add(new POJOAsignatura(2, "Matemáticas", 90, 12.9, "Algebra, y otros", "Una asignatura de cuidado"));

        // Creo un objeto POJOModulo que contendrá las asignaturas:
        POJOModulo modulo = new POJOModulo(coleccionAsignaturas);

        UsoJAXB control = new UsoJAXB();
        control.escribir(modulo);
        control.leer();
    }
}
