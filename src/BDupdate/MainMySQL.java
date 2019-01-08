package BDupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainMySQL {

    public static void main(String[] args) {
        try {
            // Cargar el driver:
            Class.forName("com.mysql.jdbc.Driver");

            // Establecer conexión con la BD:
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "curso1819");
            
            

            // Preparar la consulta:
            Statement sentencia = conexion.createStatement();
            String sql = "UPDATE empleados SET apellido='KAWEN' WHERE emp_no = 10";
            int filasAfectadas = sentencia.executeUpdate(sql);

            if(filasAfectadas > 0){
                System.out.println("Se actualizaron " + filasAfectadas + " registros.");
            }
            else{
                System.out.println("No se ha actualizado ningún registro.");
            }
            
            // Cerrar archivos:
            sentencia.close();
            conexion.close();

        } catch (Exception ex) {
            System.out.println("ERROR - Al realizar la consulta.");
        }
    }
}
