package flujoBytes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UsoObjectOutputInputStream {

    private static final File DIRECTORIO = new File("dir");
    private static final File ARCHIVO = new File(DIRECTORIO, "archivoBinario3.bin");

    public UsoObjectOutputInputStream() {
        DIRECTORIO.mkdir();
        System.out.println("Se ha guardado en: " + ARCHIVO.getAbsolutePath());
    }

    public void escribir(POJOPersona... objPersona) {
        try (FileOutputStream fos = new FileOutputStream(ARCHIVO); ObjectOutputStream escritor = new ObjectOutputStream(fos);) {
            for(POJOPersona persona : objPersona){
                escritor.writeObject(persona);
            }
        } catch (Exception ex) {
            System.out.println("ERROR - Al escribir.");
        }
    }

    public void leer() {

        try (FileInputStream fis = new FileInputStream(ARCHIVO); ObjectInputStream lector = new ObjectInputStream(fis);) {
            for (;;) {
                System.out.println(lector.readObject());
            }

        } catch (EOFException ex) {
            System.out.println("Ya no hay nada más que leer.");
        } catch (Exception ex) {
            System.out.println("ERROR - Al leer.");
        }
    }

    public static void main(String[] args) {
        UsoObjectOutputInputStream control = new UsoObjectOutputInputStream();
        control.escribir(new POJOPersona("Carlos", 25), new POJOPersona("Jaime", 27));
        control.leer();
    }
}
