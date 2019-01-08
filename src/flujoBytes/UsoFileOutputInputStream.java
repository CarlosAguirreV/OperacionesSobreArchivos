package flujoBytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UsoFileOutputInputStream {

    private static final File DIRECTORIO = new File("dir");
    private static final File ARCHIVO = new File(DIRECTORIO, "ficherobinario1.bin");

    public UsoFileOutputInputStream() {
        DIRECTORIO.mkdir();
        System.out.println("Se ha guardado en: " + ARCHIVO.getAbsolutePath());
    }

    public void escribir() {
        // Recuerda que al meterlo dentro de un try-with-resources no hace falta cerrar el archivo ya que llama al auto-close.
        try (FileOutputStream escritor = new FileOutputStream(ARCHIVO)) {
            for (int i = 0; i < 10; i++) {
                escritor.write(i);
            }
        } catch (Exception ex) {
            System.out.println("ERROR - Al escribir.");
        }
    }

    public void leer() {
        try (FileInputStream lector = new FileInputStream(ARCHIVO)) {
            int i;
            while ((i = lector.read()) != -1) {
                System.out.print(Integer.toString(i) + " ");
            }
            System.out.println("\n");
        } catch (Exception ex) {
            System.out.println("ERROR - Al leer.");
        }
    }

    public static void main(String[] args) {
        UsoFileOutputInputStream control = new UsoFileOutputInputStream();
        control.escribir();
        control.leer();
    }
}
