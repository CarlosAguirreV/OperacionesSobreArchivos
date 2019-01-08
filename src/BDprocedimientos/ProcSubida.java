package BDprocedimientos;

import java.sql.*;

public class ProcSubida {

    public static void main(String[] args) {
        try {
            // Cargar el driver:
            Class.forName("oracle.jdbc.OracleDriver");

            // Establecer conexión con la BD:
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "curso1819");
            
            
            
            // Recuperar parametros de main:
            String dep = args[0];   //"10"; // departamento
            String subida = args[1];//"1000"; // subida

            // Construir orden de llamada:
            String sql = "{ call subida_sal (?, ?) } ";

            // Preparamos la llamada:
            CallableStatement llamada = conexion.prepareCall(sql);
            
            // Damos valor a los argumentos:
            llamada.setInt(1, Integer.parseInt(dep)); // primer argumento-dep
            llamada.setFloat(2, Float.parseFloat(subida)); // segundo arg

            // Ejecutar el procedimiento:
            llamada.executeUpdate(); 
            System.out.println("Subida realizada....");
            
            // Cerrar todo:
            llamada.close();
            conexion.close();
            
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }// fin de main
}// fin de la clase
