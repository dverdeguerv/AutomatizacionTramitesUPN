import java.sql.*;

public class Main {
    // Configura la información de conexión a la base de datos
    private static String url = "jdbc:sqlserver://10.145.71.157;databaseName=BD_AUTOMATIZACION_CERT;trustServerCertificate=true;";
    private static String usuario = "cert_upnsac1";
    private static String contraseña = "E71t9aMuz#";

    public static String consultarDatoDesdeBaseDeDatos(String consultaSQL) {
        String resultado = null;

        try {
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = connection.createStatement();

            // Ejecuta la consulta SQL
            ResultSet resultSet = statement.executeQuery(consultaSQL);

            // Verifica si se obtuvo un resultado
            if (resultSet.next()) {
                // Obtiene el valor de la columna deseada (en este caso, asumimos una columna llamada 'resultado')
                resultado = resultSet.getString("usuario");
            }

            // Cierra los recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }
/*
    public static void main(String[] args) {
        String consultaSQL = "select usuario from webs_Contraseñas_SOX where grupo='Administrativos intranet' and nombreWeb='Payroll'";

        String resultado = consultarDatoDesdeBaseDeDatos(consultaSQL);

        if (resultado != null) {
            System.out.println("El resultado de la consulta es: " + resultado);
        } else {
            System.out.println("No se encontraron resultados.");
        }
*/
/*
        try {
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = connection.createStatement();

            String consulta = "select pass from webs_Contraseñas_SOX where grupo='Administrativos intranet' and nombreWeb='Payroll'";
            ResultSet resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                // Aquí obtienes los datos de cada fila de la tabla y los muestras

                String nombre = resultSet.getString("pass");
                System.out.println(", Usuario: " + nombre);
            }

            // Cierra los recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

*/

}
