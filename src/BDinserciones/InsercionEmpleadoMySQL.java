package BDinserciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsercionEmpleadoMySQL {

    public static void main(String[] args) {
        try {
            // Cargar el driver:
            Class.forName("com.mysql.jdbc.Driver");

            // Establecer conexión con la BD:
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "curso1819");

            boolean esCorrecto = true;
            ResultSet resul = null;

            String emp_no = "10";
            String apellido = "NUEVO";
            String oficio = "Profesor";
            String dir = "5";
            String fecha_alt = "NULL";
            String salario = "12000";
            String comision = "800";
            String dept_no = "2";

            Statement sentencia;

            // CONSULTA DEPARTAMENTO:
            sentencia = conexion.createStatement();
            String sqlConsultaDepartamento = String.format("SELECT dept_no FROM departamentos WHERE dept_no = %s", dept_no);
            System.out.println(sqlConsultaDepartamento);
            resul = sentencia.executeQuery(sqlConsultaDepartamento);

            while (resul.next()) {
                resul.getInt(1);
                esCorrecto = false;
                break;
            }
            sentencia.close();

            // CONSULTA NUMERO EMPLEADO:
            sentencia = conexion.createStatement();
            String sqlConsultaEmpleado = String.format("SELECT emp_no FROM empleados WHERE emp_no = %s", emp_no);
            System.out.println(sqlConsultaEmpleado);
            resul = sentencia.executeQuery(sqlConsultaEmpleado);

            while (resul.next()) {
                resul.getInt(1);
                esCorrecto = false;
                break;
            }
            sentencia.close();

            // COMPROBAR SALARIO:
            int salarioEntero = Integer.parseInt(salario);
            if (salarioEntero <= 0) {
                esCorrecto = false;
            }

            System.out.println("Es correcto: " + esCorrecto);

            // EJECUTAR SI NO EXISTE:
            if (esCorrecto) {
                // Preparar el update:
                String sql2 = String.format("INSERT INTO EMPLEADOS VALUES(%s, '%s', '%s', %s, %s, %s, %s, %s)", emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no);
                
                // Mostrar la inserción:
                System.out.println(sql2);
                
                // Obtener el número de filas cambiadas:
                int filas = sentencia.executeUpdate(sql2);

                // Mostrar las filas afectadas:
                System.out.println("Filas afectadas: " + filas);
            }

            // CERRAR CONEXION:
            conexion.close();

        } catch (Exception ex) {
            System.out.println("ERROR - Al realizar el update.");
        }
    }
}
