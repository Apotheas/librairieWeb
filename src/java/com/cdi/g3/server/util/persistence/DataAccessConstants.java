package com.cdi.g3.server.util.persistence;

/**
 * This interface lists all the constants that the system uses to get a Database connection.
 */
public interface DataAccessConstants {

    /**
     * Database error code when we want to insert an id that already exists.
     */
    int DATA_ALREADY_EXIST = 1062;

    /**
     * JDBC Driver class to instanciate.
     */
    String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
     /**
     * server name      * 
     */
    
    String SERVER_NAME = "localhost";
     /**
     * PORT of where the server is located.
     */
     String PORT_NUMBER = "1433";     
     
     /**
     * Database name      * 
     */
     
     String DATABASE_NAME = "librairieDB";

    /**
     * URL of where the database is located.
     */
    String URL_DB = "jdbc:sqlserver://localhost:" + PORT_NUMBER+ ";databaseName=" +DATABASE_NAME;

    /**
     * Username to access the database.
     */
    String USER_DB = "sa";

    /**
     * Password to access the database.
     */
    String PASSWD_DB = "sa";
}
