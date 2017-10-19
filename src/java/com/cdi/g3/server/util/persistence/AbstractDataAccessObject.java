package com.cdi.g3.server.util.persistence;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.common.exception.DuplicateKeyException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.util.uidgen.UniqueIdGenerator;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * This class follows the Data Acces Object (DAO) Design Pattern. It uses JDBC
 * to store object values in a database. Every concrete DAO class should extends
 * this class.
 */
public abstract class AbstractDataAccessObject implements DataAccessConstants {

    // ======================================
    // =             Attributes             =
    // ======================================
    // Used for logging
    protected final transient String cname = this.getClass().getName();
    protected static final String sname = AbstractDataAccessObject.class.getName();
    private static  DataSource ds ;

    // ======================================
    // =            Static Block            =
    // ======================================
    static {
        // Loads the JDBC driver class
        InitialContext ct=null;
        try {
            ct = new InitialContext();
        } catch (NamingException ex) {
             Trace.throwing(sname, "static", ex);
        }
        try {
            ds = (DataSource) ct.lookup("jdbc/librairieDS");
        } catch (NamingException ex) {
            Trace.throwing(sname, "static", ex);
        }
        
//        try {
//            Class.forName(JDBC_DRIVER);
//        } catch (ClassNotFoundException e) {
//            Trace.throwing(sname, "static", e);
//        }
    }

    // ======================================
    // =           Business methods         =
    // ======================================
    
    public final DomainObject findByPrimaryKey(final String id) throws ObjectNotFoundException {
        return this.select(id);
    }
    
    private final DomainObject select(final String id) throws ObjectNotFoundException {
        final String mname = "select";
        Trace.entering(getCname(), mname, id);
        ResultSet resultSet = null;
        DomainObject object;
        // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
            
            // Select a Row
            resultSet = statement.executeQuery(getSelectSqlStatement(id));
            if (!resultSet.next()) {
                throw new ObjectNotFoundException();
            }

            // Set data to current object
            object = transformResultset2DomainObject(resultSet);

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("Cannot get data from the database: " + e.getMessage(), e);
        } finally {
            // Close
            try {
                if (resultSet != null) {
                    resultSet.close();
                }                
            } catch (SQLException e) {
                displaySqlException("Cannot close connection", e);
                throw new DataAccessException("Cannot close the database connection", e);
            }
        }

        Trace.exiting(getCname(), mname, object);
        return object;
    }
    
       public final Collection findAllByChampTitre(String column,String champ) throws ObjectNotFoundException {
        return selectAllTitreByChamp(column, champ);
    }
     
    private final Collection selectAllTitreByChamp(String column, String champ) throws ObjectNotFoundException {
        final String mname = "selectAll";
        Trace.entering(getCname(), mname);

        
        ResultSet resultSet = null;
        final Collection objects = new ArrayList();
         // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
        
            // Select a Row
            resultSet = statement.executeQuery(getSelectBookByTitreSqlStatement(column ,champ));

            while (resultSet.next()) {
                // Set data to the collection
                objects.add(transformResultset2DomainObject(resultSet));
            }

            if (objects.isEmpty()) {
                throw new ObjectNotFoundException();
            }

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("Cannot get data from the database: " + e.getMessage(), e);
        } finally {
            // Close
            try {
                if (resultSet != null) {
                    resultSet.close();
                }             
            } catch (SQLException e) {
                displaySqlException("Cannot close connection", e);
                throw new DataAccessException("Cannot close the database connection", e);
            }
        }

        Trace.exiting(getCname(), mname, new Integer(objects.size()));
        return objects;
    }
    
    
    
    public final DomainObject findByChamp(String column,String champ) throws ObjectNotFoundException {
        return selectByChamp(column, champ);
    }
    
    private final DomainObject selectByChamp(String column, String champ) throws ObjectNotFoundException {
        final String mname = "select";
        Trace.entering(getCname(), mname, champ);

        ResultSet resultSet = null;
        DomainObject object;
          // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
            // Select a Row
            resultSet = statement.executeQuery(getSelectSqlStatementByChamp(column,champ));
            if (!resultSet.next()) {
                throw new ObjectNotFoundException();
            }

            // Set data to current object
            object = transformResultset2DomainObject(resultSet);

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("Cannot get data from the database: " + e.getMessage(), e);
        } finally {
            // Close
            try {
                if (resultSet != null) {
                    resultSet.close();
                }                
            } catch (SQLException e) {
                displaySqlException("Cannot close connection", e);
                throw new DataAccessException("Cannot close the database connection", e);
            }
        }

        Trace.exiting(getCname(), mname, object);
        return object;
    }
    
    
     public final Collection findAllByChamp(String column,String champ) throws ObjectNotFoundException {
        return selectAllByChamp(column, champ);
    }
    
    private final Collection selectAllByChamp(String column, String champ) throws ObjectNotFoundException {
        final String mname = "selectAll";
        Trace.entering(getCname(), mname);

        
        ResultSet resultSet = null;
        final Collection objects = new ArrayList();
         // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
        
            // Select a Row
            resultSet = statement.executeQuery(getSelectAllSqlStatementByChamp(column ,champ));

            while (resultSet.next()) {
                // Set data to the collection
                objects.add(transformResultset2DomainObject(resultSet));
            }

            if (objects.isEmpty()) {
                throw new ObjectNotFoundException();
            }

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("Cannot get data from the database: " + e.getMessage(), e);
        } finally {
            // Close
            try {
                if (resultSet != null) {
                    resultSet.close();
                }             
            } catch (SQLException e) {
                displaySqlException("Cannot close connection", e);
                throw new DataAccessException("Cannot close the database connection", e);
            }
        }

        Trace.exiting(getCname(), mname, new Integer(objects.size()));
        return objects;
    }
    
    
    
    
    public final Collection findAll() throws ObjectNotFoundException {
        return selectAll();
    }
    
    private final Collection selectAll() throws ObjectNotFoundException {
        final String mname = "selectAll";
        Trace.entering(getCname(), mname);
        ResultSet resultSet = null;
        final Collection objects = new ArrayList();
         // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
         
            // Select a Row
            resultSet = statement.executeQuery(getSelectAllSqlStatement());

            while (resultSet.next()) {
                // Set data to the collection
                objects.add(transformResultset2DomainObject(resultSet));
            }

            if (objects.isEmpty()) {
                throw new ObjectNotFoundException();
            }

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("Cannot get data from the database: " + e.getMessage(), e);
        } finally {
            // Close
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
               
            } catch (SQLException e) {
                displaySqlException("Cannot close connection", e);
                throw new DataAccessException("Cannot close the database connection", e);
            }
        }

        Trace.exiting(getCname(), mname, new Integer(objects.size()));
        return objects;
    }
    

    
    public final void insert(final DomainObject object) throws DuplicateKeyException {
        final String mname = "insert";
        Trace.entering(getCname(), mname, object);
             // Gets a database connection
        try (Connection connection = getConnection(); PreparedStatement prstatement = connection.prepareStatement(getInsertSqlPreparedStatement())) {
            // Sets the object Id if necessary
            if (object.getId() == null) {
                object.setId("" + getUniqueId());
            }
           
            // Inserts a Row
        executePreparedSt(prstatement, object);
        } catch (SQLException e) {
            // The data already exists in the database
            if (e.getErrorCode() == DATA_ALREADY_EXIST) {
                throw new DuplicateKeyException();
            } else {
                // A Severe SQL Exception is caught
                displaySqlException(e);
                throw new DataAccessException("Cannot insert data into the database", e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public final void update(final DomainObject object) throws ObjectNotFoundException {
        final String mname = "update";
        Trace.entering(getCname(), mname, object);
         // Gets a database connection
        try (Connection connection = getConnection(); PreparedStatement prstatement = connection.prepareStatement(getUpdateSqlPreparedStatement())) {
                      
            // Update a Row
            int retour = executePreparedSt(prstatement, object);
            if (retour == 0) {
                throw new ObjectNotFoundException();
            }

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("Cannot update data into the database", e);
        }
    }

    public final void remove(final String id) throws ObjectNotFoundException {
        final String mname = "remove";
        Trace.entering(getCname(), mname, id);

         // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
      
            // Delete a Row
            if (statement.executeUpdate(getDeleteSqlStatement(id)) == 0) {
                throw new ObjectNotFoundException();
            }

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("Cannot remove data into the database", e);

        } 
    }

    
    public final String getUniqueId() {
        return UniqueIdGenerator.getInstance().getUniqueId(getCounterName());
    }

    public final String getUniqueId(final String domainClassName) {
        return UniqueIdGenerator.getInstance().getUniqueId(domainClassName);
    }

    protected abstract String getCounterName();

    
    public static final Connection getConnection() throws SQLException {
        final Connection connection;
//        connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWD_DB);        
        connection =ds.getConnection();
        return connection;
    }

    /**
     * This method displays all information of an SQL exception. Its error code,
     * state, sql message and ultimately the stacktrace of the Exception
     *
     * @param e SQLException that you want to display
     */
    public static void displaySqlException(final SQLException e) {
        final String mname = "displaySqlException";

        Trace.severe(sname, mname, "Error code  : " + e.getErrorCode());
        Trace.severe(sname, mname, "SQL state   : " + e.getSQLState());
        Trace.severe(sname, mname, "SQL message : " + e.getMessage());
        Trace.throwing(sname, mname, e);
    }

    /**
     * This method displays all information of an SQL exception and a custom
     * message. Display the sql error code, state, sql message and ultimately
     * the stacktrace of the Exception
     *
     * @param message custom message to display
     * @param e SQLException that you want to display
     */
    public static void displaySqlException(final String message, final SQLException e) {
        final String mname = "displaySqlException";

        Trace.severe(sname, mname, "Message     : " + message);
        Trace.severe(sname, mname, "Error code  : " + e.getErrorCode());
        Trace.severe(sname, mname, "SQL state   : " + e.getSQLState());
        Trace.severe(sname, mname, "SQL message : " + e.getMessage());
        Trace.throwing(sname, mname, e);
    }

    
    protected abstract String getInsertSqlPreparedStatement();
    
    protected abstract String getDeleteSqlStatement(String id);

    protected abstract String getUpdateSqlPreparedStatement();
    
    protected abstract String getSelectSqlStatement(String id);
    
    protected abstract String getSelectAllSqlStatement();
    
    protected String getSelectSqlStatementByChamp(String column, String champ){
        return "A redéfinir dans les classes filles si necéssaire";
    }
     protected  String getSelectBookByTitreSqlStatement(String column,String id){
        
        return "A redéfinir dans les classes filles si necéssaire";
    }    
    
    protected  String getSelectAllSqlStatementByChamp(String column,String id){
        return "A redéfinir dans les classes filles si necéssaire";
    }    

    protected abstract int executePreparedSt(PreparedStatement prestmt, DomainObject object);

    
    protected abstract DomainObject transformResultset2DomainObject(ResultSet resultSet) throws SQLException;

    protected String getCname() {
        return cname;
    }
}
