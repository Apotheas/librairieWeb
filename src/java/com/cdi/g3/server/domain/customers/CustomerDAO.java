
package com.cdi.g3.server.domain.customers;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

/**
 * This class does all the database access for the class Customer.
 *
 * @see Customer
 */
public final class CustomerDAO extends AbstractDataAccessObject {
    
    

    // ======================================
    // =             Attributes             =
    // ======================================
    
     private static final AddressDAO _daoAdress = new AddressDAO();
    
    private static final String TABLE = "Customer";  
    
    private static final String COLUMNS = "LOGINCUSTOMER, LASTNAMECUSTOMER, FIRSTNAMECUSTOMER, EMAILCUSTOMER, PASSWORDCUSTOMER,telephoneCustomer"
            + ", NAMECOMPANYCUSTOMER, COMMENTCUSTOMER, STATUSCUSTOMER";
    private static final String COLUMNS_PREP= " LASTNAMECUSTOMER, FIRSTNAMECUSTOMER, EMAILCUSTOMER, PASSWORDCUSTOMER,telephoneCustomer"
            + ", NAMECOMPANYCUSTOMER, COMMENTCUSTOMER, STATUSCUSTOMER, LOGINCUSTOMER";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "CUSTOMER";

    // ======================================
    // =           Business methods         =
    // ======================================
    protected String getInsertSqlPreparedStatement() {        
        final String sql;
        
        sql =   "INSERT INTO " + TABLE + "(" +COLUMNS_PREP+ ") VALUES(?,?,?,?,?,?,?,?,?)";
        return sql;
    }

    protected String getDeleteSqlStatement(final String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE LOGINCUSTOMER = '" + id + "'";
        return sql;
    }

    protected String getUpdateSqlPreparedStatement() {        
        final String sql;        
        sql = "UPDATE " + TABLE + " SET LASTNAMECUSTOMER = ?, FIRSTNAMECUSTOMER = ?, EMAILCUSTOMER = ?,"
                + " PASSWORDCUSTOMER = ?, telephoneCustomer = ?, NAMECOMPANYCUSTOMER = ?, COMMENTCUSTOMER = ?, STATUSCUSTOMER = ? WHERE LOGINCUSTOMER = ?" ;
        return sql;
        
    }

    protected String getSelectSqlStatement(final String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE LOGINCUSTOMER = '" + id + "' ";
        return sql;
    }

    protected String getSelectAllSqlStatement() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE;
        return sql;
    }
    
    @Override
    protected String getSelectSqlStatementByChamp(String column, String champ){
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE  
                + " WHERE " + column + " = '"+ champ+"'";
        System.out.println(sql);
        return sql;
    }
   
    
    protected String getSelectLoginCheck(String login, String password) {

       final String sql;
       sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE LOGINCUSTOMER = '" + login + "' "
               + "AND  PASSWORDCUSTOMER = '" + password + "' ";
       return sql;

   }    
    public DomainObject selectByLogins(String login, String password) throws ObjectNotFoundException {
       final String mname = "select";
       Trace.entering(getCname(), mname, login);
       ResultSet resultSet = null;
       DomainObject object;
       // Gets a database connection
       try (Connection connection = getConnection();
               Statement statement = connection.createStatement()) {
           // Select a Row
           resultSet = statement.executeQuery(getSelectLoginCheck(login, password));
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


  
    protected DomainObject transformResultset2DomainObject(final ResultSet resultSet) throws SQLException {
        final Customer customer;
        customer = new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
        customer.setTelephoneCustomer(resultSet.getString(6));
        customer.setNameCompanyCustomer(resultSet.getString(7));
        customer.setCommentCustomer(resultSet.getString(8));
        customer.setStatusCustomer(resultSet.getInt(9));
        // RetreCollectionives the data for all the customer adress shipping//        
         try {
            final Collection  listAddressShipping = _daoAdress.findAllByChamp("loginCustomerShipAdress", customer.getLoginCustomer());
            customer.setlistAddressShipping(listAddressShipping);
         } 
           catch( ObjectNotFoundException e) {}
//        }        
        
        // Retreives the data for all the customer adress billing
        try {
        final Collection listAddressBilling;
        listAddressBilling = _daoAdress.findAllByChamp("loginCustomerBillAdress", customer.getLoginCustomer());
        customer.setlistAddressBilling(listAddressBilling);
          } 
           catch( ObjectNotFoundException e) {}     
        
        return customer;
    }

	protected String getCounterName() {
		return COUNTER_NAME;
	}
        
        
       @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {
            
            prestmt.setString(1, ((Customer) object).getLastNameCustomer());
            prestmt.setString(2, ((Customer) object).getFirstNameCustomer());
            prestmt.setString(3, ((Customer) object).getEmailCustomer());
            prestmt.setString(4, ((Customer) object).getPasswordCustomer());
            prestmt.setString(5, ((Customer) object).getTelephoneCustomer());
            prestmt.setString(6, ((Customer) object).getNameCompanyCustomer());            
            prestmt.setString(7, ((Customer) object).getCommentCustomer());
            prestmt.setInt(8, ((Customer) object).getStatusCustomer());
            prestmt.setString(9, ((Customer) object).getLoginCustomer());
            
            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            e.getStackTrace();
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        }
        return retour;
    }
     
        
        
}
