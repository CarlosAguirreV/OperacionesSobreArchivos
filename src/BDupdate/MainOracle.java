package BDupdate;

import BDconexion.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainOracle {

    public static void main(String[] args) {
        try {
            // Cargar el driver:
            Class.forName("com.mysql.jdbc.Driver");

            // Establecer conexión con la BD:
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "curso1819");
            
            

            // Preparar la consulta:
            Statement sentencia = conexion.createStatement();
            String sql = "UPDATE EJEMPLO.EMP SET ENAME='KAWEN' WHERE EMPNO = 7839";
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
