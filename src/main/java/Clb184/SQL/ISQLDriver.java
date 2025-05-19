package clb184.SQL;

import java.sql.*;

// Interface the C++ way, I should throw stuff just in case
public abstract class ISQLDriver {

    protected Connection m_Connector = null;

    protected static String m_Username = "";
    protected static String m_Password = "";

    protected static String m_ServerURL = "";
    protected static String m_Database = "";

    
    // Set the user and password to use to access the database
    public static void SetCredentials(String user, String pass) {
        m_Username = user;
        m_Password = pass;
    }

    // Set the server's URL
    public static void SetServerURL(String server_url) {
        m_ServerURL = server_url;
    }

    // Set the name of the database to use
    public static void SetDatabaseName(String database) {
        m_Database = database;
    }

    // Connector's base methods
    abstract public boolean CreateConnector();
    abstract public Connection GetConnector();
}