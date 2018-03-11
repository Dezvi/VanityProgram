package ddsi;

import java.sql.ResultSet;
import java.sql.*;

public class DBConnection {

	private String address;
	private int port;
	private String dbName;
        Connection connection;

        
	/**
	 * 
     * @return 
	 */
        
        public Connection getConnection() {
            return connection;
        }   
        
        
	/**
	 * 
	 * @param connection
	 */
        
        public void setConnection(Connection connection) {
                this.connection = connection;
        }
        
        
	/**
	 * 
	 * @param addressp
	 * @param port
	 * @param dbNamep
	 * @param user
	 * @param passwd
	 */
        
	public DBConnection(String addressp, int portp, String dbNamep, String user, String passwd) {
        try {
            address = addressp;
            dbName = dbNamep;
            port = portp;
            // We register the MySQL (MariaDB) driver
            // Registramos el driver de MySQL (MariaDB)
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
            // Database connect
            // Conectamos con la base de datos
            setConnection(DriverManager.getConnection(
                    "jdbc:mysql://"+address+"/"+dbName,
                    user, passwd));
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }  
        
    public boolean execute(String order) {
        try {
            Statement sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(order);
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }

	/**
	 * 
	 * @param query
     * @return 
	 */
	public ResultSet query(String query) {
            // TODO - implement DBConnection.query
            ResultSet resultado;
            try {
                Statement sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                resultado = sentencia.executeQuery(query);
            } catch (SQLException e) {
                return null;
            }        
            return resultado;
	}

}