package BDupdate;

import BDconexion.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainSQLite {

    public static void main(String[] args) {
        try{
            // Cargar el driver:
            Class.forName("org.sqlite.JDBC");
            
            // Establecer conexión con la BD:
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\alumno\\Desktop\\SQLite\\ejemploDB.db");
            
            
            
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
            
        }catch(Exception ex){
            System.out.println("ERROR - Al realizar la consulta.");
        }
    }

}
