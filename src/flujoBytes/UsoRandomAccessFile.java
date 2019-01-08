package flujoBytes;

import java.io.File;
import java.io.RandomAccessFile;

public class UsoRandomAccessFile {

    private static final File DIRECTORIO = new File("dir");
    private static final File ARCHIVO = new File(DIRECTORIO, "archivoBinario4.bin");

    public UsoRandomAccessFile() {
        DIRECTORIO.mkdir();
        System.out.println("Se ha guardado en: " + ARCHIVO.getAbsolutePath());
    }

    public void escribir(String nombre, int edad) {
        try (RandomAccessFile escritorArchRand = new RandomAccessFile(ARCHIVO, "rw")) {
            // Posicionar el puntero en el último byte escrito.
            long posicion = escritorArchRand.length();
            escritorArchRand.seek(posicion);

            // Escribir entero, recuerda un "int" son 4 bytes.
            escritorArchRand.writeInt(edad);

            // Escribir cadena, cada caracter son dos bytes.
            StringBuffer buffer = new StringBuffer(nombre);
            buffer.setLength(20);
            escritorArchRand.writeChars(buffer.toString());

        } catch (Exception ex) {
            System.out.println("ERROR - Al escribir.");
        }
    }

    public void leer() {
        String nombre;
        int edad;

        try (RandomAccessFile lectorArchRand = new RandomAccessFile(ARCHIVO, "r")) {
            
            // Posiciono el puntero al inicio del archivo.
            lectorArchRand.seek(0);
            
            for (int indiceRegistro = 0; indiceRegistro < lectorArchRand.length() / 44; indiceRegistro++) {
                // Leer entero.
                edad = lectorArchRand.readInt();

                // Leer cadena.
                char cadena[] = new char[20];
                for (int indiceByte = 0; indiceByte < cadena.length; indiceByte++) {
                    cadena[indiceByte] = lectorArchRand.readChar();
                }

                // Formo la cadena.
                nombre = new String(cadena);

                // Al mostrar las cadenas recuerda quitar los espacios sobrantes con .trim ya que la cadena escrita puede ser mas pequeña que su tamaño en bytes por lo que el resto serán espacios.
                System.out.println(nombre.trim() + " tiene una edad de " + Integer.toString(edad));
            }

        } catch (Exception ex) {
            System.out.println("ERROR - Al leer.");
        }
    }

    public static void main(String[] args) {
        UsoRandomAccessFile control = new UsoRandomAccessFile();
        control.escribir("Charlie", 25);
        control.leer();
    }
}
