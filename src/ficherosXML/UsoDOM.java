package ficherosXML;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

@XmlRootElement(name = "Modulo")
public class UsoDOM {

    private static final File DIRECTORIO = new File("dir");
    private static final File ARCHIVO = new File(DIRECTORIO, "ficheroXML1.xml");
    private ArrayList<POJOAsignatura> coleccionAsignaturas;

    public UsoDOM() {
        DIRECTORIO.mkdir();
        System.out.println("Se ha guardado en: " + ARCHIVO.getAbsolutePath());
    }

    public void escribir(POJOAsignatura... coleccion) {
        // Crear una fabrica de documentos:
        DocumentBuilderFactory fabricaDocumentos = DocumentBuilderFactory.newInstance();

        try {
            // Obtener un constructor de documentos de la fábrica de documentos:
            DocumentBuilder constructorDocumentos = fabricaDocumentos.newDocumentBuilder();

            // Crear una implementación:
            DOMImplementation implementacion = constructorDocumentos.getDOMImplementation();

            // Crear documento a partir de la implementación:
            Document documentoXml = implementacion.createDocument(null, "Asignatura", null);

            // Definir la versión del documento:
            documentoXml.setXmlVersion("1.0");

            // Escribir uno a uno los nodos en el XML:
            for (POJOAsignatura asignatura : coleccion) {
                // Crear elemento raíz:
                Element elementoRaiz = documentoXml.createElement("asignatura"); // Nodo Asignatura.

                // Añado el elemento raíz al documento XML:
                documentoXml.getDocumentElement().appendChild(elementoRaiz);

                // Añadir propiedades al nodo:
                crearElemento("codigo", Integer.toString(asignatura.getCodigo()), elementoRaiz, documentoXml);
                crearElemento("nombre", asignatura.getNombre(), elementoRaiz, documentoXml);
                crearElemento("horas", Integer.toString(asignatura.getCodigo()), elementoRaiz, documentoXml);
                crearElemento("precio", Double.toString(asignatura.getPrecio()), elementoRaiz, documentoXml);
                crearElemento("contenido", asignatura.getContenido(), elementoRaiz, documentoXml);
                crearElemento("descripcion", asignatura.getDescripcion(), elementoRaiz, documentoXml);
            }
            
            // Creo un nuevo recurso:
            Source recurso = new DOMSource(documentoXml);

            // Creo un resultado:
            Result result = new StreamResult(ARCHIVO);

            // Creo un objeto transformador:
            Transformer transformador = TransformerFactory.newInstance().newTransformer();

            // Transformo y escribo la estructura creada anteriormente en el archivo XML:
            transformador.transform(recurso, result);

        } catch (Exception ex) {
            System.out.println("ERROR - Al escribir. \n" + ex);
        }
    }

    // Dado que este proceso es redundante se crea un método para simplificar.
    // Inserta los datos:
    private void crearElemento(String nombrePropiedad, String valor, Element elementoRaiz, Document documento) {
        // Crea un elemento hijo:
        Element elementoHijo = documento.createElement(nombrePropiedad);
        
        // Crea un texto para el valor:
        Text text = documento.createTextNode(valor);
        
        // Añade al elemento raíz el elemento hijo:
        elementoRaiz.appendChild(elementoHijo);
        
        // Añade el texto al elemento hijo:
        elementoHijo.appendChild(text);
    }

    public void leer() {
        // Crear el ArrayList antes de nada:
        coleccionAsignaturas = new ArrayList<POJOAsignatura>();

        // Crear una fabrica de documentos:
        DocumentBuilderFactory fabricaDocumentos = DocumentBuilderFactory.newInstance();

        try {
            // Obtener un constructor de documentos de la fábrica de documentos:
            DocumentBuilder constructorDocumentos = fabricaDocumentos.newDocumentBuilder();

            // Especificar el documento XML con el que se va a trabajar:
            Document documentoXml = constructorDocumentos.parse(ARCHIVO);

            // Normalizar el documento XML:
            documentoXml.getDocumentElement().normalize();

            // Obtener una lista con los nodos:
            NodeList nodosAsignaturas = documentoXml.getElementsByTagName("asignatura");

            // Recorrer la lista:
            for (int i = 0; i < nodosAsignaturas.getLength(); i++) {
                Node nodoAsignatura = nodosAsignaturas.item(i);

                // Si el nodoAsignatura actual es de tipo ELEMENT_NODE entonces obten los datos de el:
                if (nodoAsignatura.getNodeType() == Node.ELEMENT_NODE) {

                    // Obtener elementos del nodo:
                    Element elemento = (Element) nodoAsignatura;

                    // Obtener los elementos uno a uno y almacenarlos en variables locales:
                    int codigo = Integer.parseInt(elemento.getElementsByTagName("codigo").item(0).getTextContent());
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    int horas = Integer.parseInt(elemento.getElementsByTagName("horas").item(0).getTextContent());
                    double precio = Double.parseDouble(elemento.getElementsByTagName("precio").item(0).getTextContent());
                    String contenido = elemento.getElementsByTagName("contenido").item(0).getTextContent();
                    String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();

                    // Poblar el ArrayList de nuevo:
                    coleccionAsignaturas.add(new POJOAsignatura(codigo, nombre, horas, precio, contenido, descripcion));
                }
            }

            // Muestro todos los objetos contenidos en el ArrayList:
            for (POJOAsignatura asig : coleccionAsignaturas) {
                System.out.println(asig);
            }

        } catch (Exception ex) {
            System.out.println("ERROR - Al leer. \n" + ex);
        }
    }

    /**
     * Este método lee el ArrayList y lo escribe en el XML.
     *
     * @return ArrayList de asignatura.
     */
    @XmlElementWrapper(name = "ListaAsignaturas")
    @XmlElement(name = "asignatura")
    public ArrayList<POJOAsignatura> getColeccionAsignaturas() {
        return coleccionAsignaturas;
    }

    public void setColeccionAsignaturas(ArrayList<POJOAsignatura> coleccion) {
        this.coleccionAsignaturas = coleccion;
    }

    public static void main(String[] args) {
        POJOAsignatura asig1 = new POJOAsignatura(1, "Lengua", 40, 12.30, "Gramatica y vocabulario.", "Se estudian varias cosas.");
        POJOAsignatura asig2 = new POJOAsignatura(2, "Mates", 52, 12.30, "Algebra", "Se estudian varias cosas.");

        UsoDOM control = new UsoDOM();
        control.escribir(asig1, asig2);
        control.leer();
    }
}
