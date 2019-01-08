package flujoCaracteres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsoBufferedReaderWriter {

    private static final File DIRECTORIO = new File("dir");
    private static final File ARCHIVO = new File(DIRECTORIO, "ficherotexto2.txt");

    public UsoBufferedReaderWriter() {
        DIRECTORIO.mkdir();
        System.out.println("Se ha guardado en: " + ARCHIVO.getAbsolutePath());
    }

    public void escribir(String cadena1) {
        // No hace falta hacer un .close si y solo si se mete usando la estructura try-with-resources y no el try-catch-finally
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARCHIVO, true));) {
            escritor.write(cadena1);
            escritor.newLine();
            escritor.flush();
        } catch (IOException ex) {
            System.out.println("ERROR - Al escribir el archivo.");
        }
    }

    public void leer() {
        try (BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO));){
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            lector.close();

        } catch (Exception ex) {
            System.out.println("ERROR - Al leer el archivo.");
        }
    }

    public static void main(String[] args) {
        UsoBufferedReaderWriter control = new UsoBufferedReaderWriter();
        control.escribir("Acabo de escribir una linea");
        control.leer();
    }
}
