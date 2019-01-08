package BDdelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BorradoSQLite {

    public static void main(String[] args) {
        try {
            // Cargar el driver:
            Class.forName("org.sqlite.JDBC");
            
            // Establecer conexión con la BD:
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\alumno\\Desktop\\SQLite\\ejemploDB.db");
            
            
            
            // Preparar la sentencia:
            Statement sentencia = conexion.createStatement();
            String sql = "DELETE FROM EJEMPLO.DEPT WHERE DEPTNO = 10";
            int cantidadBorrados = sentencia.executeUpdate(sql);
            
            if(cantidadBorrados > 0){
                System.out.println("Se borraron " + cantidadBorrados + " registros.");
            }
            else{
                System.out.println("No se ha borrado ningún registro.");
            }

            // Cerrar archivos:
            sentencia.close();
            conexion.close();
            
        } catch(Exception ex){
            System.out.println("ERROR - Al realizar la consulta.");
        }
    }

}
