package BDconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainOracle {

    public static void main(String[] args) {
        try {
            // Cargar el driver:
            Class.forName("oracle.jdbc.OracleDriver");

            // Establecer conexión con la BD:
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "curso1819");
            
            

            // Preparar la consulta:
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM EJEMPLO.DEPT";
            ResultSet resul = sentencia.executeQuery(sql);

            // Recorre,os el resultado para visualizar cada fila:
            while (resul.next()) {
                System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
            }

            // Cerrar archivos:
            resul.close();
            sentencia.close();
            conexion.close();

        } catch (Exception ex) {
            System.out.println("ERROR - Al realizar la consulta.");
        }
    }

}
