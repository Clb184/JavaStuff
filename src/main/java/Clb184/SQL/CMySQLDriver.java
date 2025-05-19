package clb184.SQL;

import java.sql.*;

public class CMySQLDriver extends ISQLDriver {
    // Default constructor
    public CMySQLDriver() {

    }

    // CreateConnector() implementation for MySQL
    @Override
    public boolean CreateConnector() {
        // Maybe we got connection or not
        boolean success = false;

        // Try getting the SQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getCause());
            return false;
        }

        // Credentials and URL
        String url = "jdbc:mysql://" + m_ServerURL + "/" + m_Database;

        // Try to establish a connection, if failed, show the problem
        try {
            Connection con = DriverManager.getConnection(url + "?user=" + m_Username + "&password=" + m_Password);
            System.out.print("Connection established!\n");
            this.m_Connector = con;
            success = true;
        } catch (Exception e) {
            System.out.print("Connection failed: " + e + "\n");
        }
        return success;
    }

    // Just get the connector, should be ready before use
    @Override
    public Connection GetConnector() {
        return this.m_Connector;
    }

}
