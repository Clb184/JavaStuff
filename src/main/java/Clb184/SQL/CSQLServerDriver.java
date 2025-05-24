package Clb184.SQL;

import java.sql.*;

// Implementation for SQL Server
public class CSQLServerDriver extends ISQLDriver{

    // Default constructor
    public CSQLServerDriver() {

    }

    // CreateConnector() implementation for SQL Server
    @Override
    public boolean CreateConnector() {
        // Maybe we got connection or not
        boolean success = false;

        // Try getting the SQL driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e.getCause());
            return false;
        }

        // Credentials and URL
        String url = "jdbc:sqlserver://" + m_ServerURL;

        // Try to establish a connection, if failed, show the problem
        try {
            Connection con = DriverManager.getConnection(url + ";databaseName=" + m_Database + ";trustServerCertificate=true;", m_Username, m_Password);
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
