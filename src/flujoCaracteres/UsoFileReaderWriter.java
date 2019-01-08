package flujoCaracteres;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsoFileReaderWriter {

    private static final File DIRECTORIO = new File("dir");
    private static final File ARCHIVO = new File(DIRECTORIO, "ficherotexto1.txt");

    public UsoFileReaderWriter() {
        DIRECTORIO.mkdir();
        System.out.println("Se ha guardado en: " + ARCHIVO.getAbsolutePath());
    }

    public void escribir(String cadena) {
        try {
            FileWriter escritor = new FileWriter(ARCHIVO, true);
            escritor.write(cadena);
            escritor.write("\n");
            escritor.flush(); // Vacía el buffer de escritura.
            escritor.close();
        } catch (IOException ex) {
            System.out.println("ERROR - Al escribir el archivo.");
        }
    }

    public void leer() {
        try {
            FileReader lector = new FileReader(ARCHIVO);

            int caracterASCII;
            while ((caracterASCII = lector.read()) != -1) {
                System.out.print((char) caracterASCII);
            }
            lector.close();

        } catch (Exception ex) {
            System.out.println("ERROR - Al leer el archivo.");
        }
    }

    public static void main(String[] args) {
        UsoFileReaderWriter control = new UsoFileReaderWriter();
        control.escribir("Hola mundo");
        control.leer();
    }
}
