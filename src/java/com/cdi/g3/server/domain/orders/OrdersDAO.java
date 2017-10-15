/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.orders;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.domain.customers.Address;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author youssef
 */
public class OrdersDAO extends AbstractDataAccessObject {

    // ======================================
    // =             Attributes             =
    // ======================================

    private static final String TABLE = "Orders";
    private static final String COLUMNS = "IDORDER, IDADRESSSHIPPINGORDER, LOGINCUSTOMERORDER,"
            + " DATEORDER, NAMEINFOSTATUSORDER, IDADRESSBILLINGORDER, IDPACKAGESHIPPERORDER, INTERNALNUMORDER,"
            + "PAYMENTSYSTEMORDER, IPORDER, DATEPACKAGESHIPPERORDER";

    private static final String COLUMNS_PREP = "IDADRESSSHIPPINGORDER, LOGINCUSTOMERORDER,"
            + " DATEORDER, NAMEINFOSTATUSORDER, IDADRESSBILLINGORDER, IDPACKAGESHIPPERORDER, INTERNALNUMORDER,"
            + "PAYMENTSYSTEMORDER, IPORDER, DATEPACKAGESHIPPERORDER, IDORDER";

    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "Orders";

    // ======================================
    // =           Business methods         =
    // ======================================
    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE + "(" + COLUMNS_PREP + ") VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        return sql;
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE IDORDER = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;
        sql = "UPDATE " + TABLE + " SET IDADRESSSHIPPINGORDER = ?, LOGINCUSTOMERORDER = ?, DATEORDER = ?,"
                + " NAMEINFOSTATUSORDER = ?, IDADRESSBILLINGORDER = ?, IDPACKAGESHIPPERORDER = ?, INTERNALNUMORDER = ?, PAYMENTSYSTEMORDER = ?,"
                + " IPORDER = ?, DATEPACKAGESHIPPERORDER = ? WHERE IDORDER = ?";
        return sql;
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE IDORDER = '" + id + "'";
        
        return sql;
    }

    @Override
    protected String getSelectAllSqlStatement() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE;
        return sql;
    }
    
    @Override
    protected String getSelectAllSqlStatementByChamp(String column, String champ){
        final String sql;
        sql = "SELECT " + COLUMNS+ " FROM " + TABLE  +" ord "+" join Customer cus " +
              "On ord.LOGINCUSTOMERORDER = cus.LOGINCUSTOMER "+
              " WHERE "+  column + " = '"+ champ+"'";   
 
        
        return sql;
    }
    
    @Override
    protected String getSelectSqlStatementByChamp(String column, String champ){
        final String sql;
        sql = "SELECT " + COLUMNS+ " FROM " + TABLE  +
              " WHERE "+  column + " = '"+ champ+"'"; 
        return sql;
    }
    
    public final Collection getOrdersByStatus(String column, String champ) throws ObjectNotFoundException {
        final String mname = "getOrdersByStatus";
        Trace.entering(getCname(), mname);

        final String sql;
        sql = "SELECT " + COLUMNS+ " FROM " + TABLE  +" ord "+" join InfoStatus infs " +
              "On ord.NAMEINFOSTATUSORDER = infs.NAMEINFOSTATUS "+
              " WHERE "+  column + " = '"+ champ+"'";
        
        ResultSet resultSet = null;
        final Collection objects = new ArrayList();
         // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
        
            // Select a Row
            resultSet = statement.executeQuery(sql);

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
    
    
    
    
    

    @Override
    protected DomainObject transformResultset2DomainObject(ResultSet resultSet) throws SQLException {
        final Orders order;       
        order = new Orders(resultSet.getString(1), new Address(resultSet.getString(2)),
                new Customer(resultSet.getString(3)), resultSet.getDate(4), new InfoStatus(resultSet.getString(5)));
        
        order.setAdressBilling(new Address(resultSet.getString(6)));
        
        order.setPachageShipper(new PachageShipper(resultSet.getString(7)));
        order.setInternalNumOrder(resultSet.getString(8));
        order.setPaymentSystemOrder(resultSet.getString(9));
        order.setIpOrder(resultSet.getString(10));
        order.setDatepachageShipperOrder(resultSet.getDate(11));
        return order;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {

            if (((Orders) object).getAdressShipping() != null) {
                prestmt.setString(1, ((Orders) object).getAdressShipping().getId());
            } else {
                prestmt.setString(1, null);
            }
            prestmt.setString(2,((Orders) object).getCustomer().getId());  
            
            prestmt.setDate(3,(Date) ((Orders) object).getDateOrder());  
           
//             prestmt.setString(4, ((Orders) object).getNameInfoStatus().getId());
            
             if (((Orders) object).getNameInfoStatus() != null) {
                prestmt.setString(4, ((Orders) object).getNameInfoStatus().getId());
            } else {
                prestmt.setString(4, new InfoStatus().getId());
            }
            if (((Orders) object).getAdressBilling() != null) {
                prestmt.setString(5, ((Orders) object).getAdressBilling().getId());
            } else {
                prestmt.setString(5, null);
            }
            if (((Orders) object).getPachageShipper() != null) {
                prestmt.setString(6, ((Orders) object).getPachageShipper().getId());
            } else {
                prestmt.setString(6, null);
            }
            prestmt.setString(7, ((Orders) object).getInternalNumOrder());
            prestmt.setString(8, ((Orders) object).getPaymentSystemOrder());
            prestmt.setString(9, ((Orders) object).getIpOrder());
            prestmt.setDate(10, (java.sql.Date) (Date) ((Orders) object).getDatepachageShipperOrder());
            prestmt.setString(11, ((Orders) object).getId());

            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            e.printStackTrace();
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return retour;
    }

    @Override
    protected String getCounterName() {
        return COUNTER_NAME;
    }

}
