package flujoBytes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UsoDataOutputInputStream {

    private static final File DIRECTORIO = new File("dir");
    private static final File ARCHIVO = new File(DIRECTORIO, "ficheroBinario2.dat");

    public UsoDataOutputInputStream() {
        DIRECTORIO.mkdir();
        System.out.println("Se ha guardado en: " + ARCHIVO.getAbsolutePath());
    }

    public void escribir(String nombre1, byte edad1, String nombre2, byte edad2) {
        try (FileOutputStream fos = new FileOutputStream(ARCHIVO); DataOutputStream escritor = new DataOutputStream(fos);) {
            escritor.writeUTF(nombre1);
            escritor.writeByte(edad1);

            escritor.writeUTF(nombre2);
            escritor.writeByte(edad2);

            escritor.flush();

        } catch (IOException ex) {
            System.out.println("ERROR - Al escribir el archivo.");
        }
    }

    public void leer() {
        try (FileInputStream fis = new FileInputStream(ARCHIVO); DataInputStream lector = new DataInputStream(fis);) {

            byte edad;
            String nombre;

            while (true) {
                nombre = lector.readUTF();
                edad = lector.readByte();
                System.out.println(nombre + " tiene una edad de " + Byte.toString(edad));
            }
        } catch (EOFException ex) {
            System.out.println("Se ha terminado de leer el archivo.");
        } catch (Exception ex) {
            System.out.println("ERROR - Al leer el archivo.");
        }
    }

    public static void main(String[] args) {
        UsoDataOutputInputStream control = new UsoDataOutputInputStream();
        control.escribir("Carlos", (byte) 25, "Sergio", (byte) 40);
        control.leer();
    }
}
