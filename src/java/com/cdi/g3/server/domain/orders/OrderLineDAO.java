/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.orders;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.customers.Appreciation;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author youssef
 */
public class OrderLineDAO extends AbstractDataAccessObject {

// ======================================
    // =             Attributes             =
    // ======================================
    private static final String TABLE = "OrderLine";
    private static final String COLUMNS = "IDORDERLINE, QUANTITYORDERLINE, UNITCOSTORDERLINE,"
            + " IDORDER, NUMISBNBOOK, DISCOUNTORDERLINE, RATETVAORDERLINE, IDAPPRECIATE";
    
    private static final String COLUMNS_PREP = "QUANTITYORDERLINE, UNITCOSTORDERLINE,"
            + " IDORDER, NUMISBNBOOK, DISCOUNTORDERLINE, RATETVAORDERLINE, IDAPPRECIATE, IDORDERLINE";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "OrderLine";

    // ======================================
    // =           Business methods         =
    // ======================================
    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        
        sql =   "INSERT INTO " + TABLE + "(" +COLUMNS_PREP+ ") VALUES(?,?,?,?,?,?,?,?)";
        return sql;
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
       final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE IDORDERLINE = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;        
        sql = "UPDATE " + TABLE + " SET QUANTITYORDERLINE = ?, UNITCOSTORDERLINE = ?, IDORDER = ?,"
                + " NUMISBNBOOK = ?, DISCOUNTORDERLINE = ?, RATETVAORDERLINE = ?, IDAPPRECIATE = ? WHERE IDORDERLINE = ?" ;
        return sql;
    }

    @Override
    protected String getSelectSqlStatement(String id) {
       final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE IDORDERLINE = '" + id + "' ";
        return sql;
    }
    protected String getSelectAllSqlStatement(final String orderId) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE IDORDER = '" + orderId + "' ";
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
        sql = "SELECT " + "IDORDERLINE, QUANTITYORDERLINE, UNITCOSTORDERLINE,"
            + " ordl.IDORDER, NUMISBNBOOK, DISCOUNTORDERLINE, RATETVAORDERLINE, IDAPPRECIATE"
                + " FROM " + TABLE  +" ordl "+" join Orders  ord " +
              "On ord.IDORDER = ordl.IDORDER "+
              " WHERE ordl."+  column + " = '"+ champ+"'"; 
        return sql;
    }
    
    @Override
    protected String getSelectSqlStatementByChamp(String column, String champ){
        final String sql;
        sql = "SELECT " + COLUMNS+ " FROM " + TABLE  +
              " WHERE "+  column + " = '"+ champ+"'"; 
        
        System.out.println(sql);
        return sql;
    }
    

    @Override
    protected DomainObject transformResultset2DomainObject(ResultSet resultSet) throws SQLException {
        final OrderLine orderLine;
        orderLine = new OrderLine(resultSet.getString(1),resultSet.getInt(2), 
                Float.parseFloat(resultSet.getString(3)),
                new Orders(resultSet.getString(4)),
                new Book(resultSet.getString(5)));
        orderLine.setDiscountOrderLine(resultSet.getFloat(6));
        orderLine.setRateTvaOrderLine(resultSet.getFloat(7));
        orderLine.setAppreciation(new Appreciation(resultSet.getString(8)));
      
        return orderLine;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {
            
            prestmt.setInt(1, ((OrderLine) object).getQuantityOrderLine());
            
            prestmt.setFloat(2, ((OrderLine) object).getUnitCostOrderLine());
            
            prestmt.setString(3, ((OrderLine) object).getOrder().getId());
            
            prestmt.setString(4, ((OrderLine) object).getBook().getId());
            
            prestmt.setFloat(5, ((OrderLine) object).getDiscountOrderLine());
            
            prestmt.setFloat(6, ((OrderLine) object).getRateTvaOrderLine());            
            
             if (((OrderLine) object).getAppreciation() != null) {
            prestmt.setString(7, ((OrderLine) object).getAppreciation().getId());
            }
             else
                 {
                prestmt.setString(7, null);
            }
            prestmt.setString(8, ((OrderLine) object).getIdOrderLine());
            
            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        }
        return retour;
    }
    
    
//    public final Collection findAll(final String orderId) throws ObjectNotFoundException {
//   	return selectAll(orderId);
//   }
//    
//    
//    public final Collection selectAll(final String orderId) throws ObjectNotFoundException {
//       final String mname = "selectAll";
//       Trace.entering(cname, mname);
//
//       ResultSet resultSet = null;
//       final Collection objects = new ArrayList();
//       // Gets a database connection
//        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
//         
//           // Select a Row
//           resultSet = statement.executeQuery(getSelectAllSqlStatement(orderId));
//
//           while (resultSet.next()) {
//               // Set data to the collection
//               objects.add(transformResultset2DomainObject(resultSet));
//           }
//
//           if (objects.isEmpty())
//               throw new ObjectNotFoundException();
//
//       } catch (SQLException e) {
//           // A Severe SQL Exception is caught
//           displaySqlException(e);
//           throw new DataAccessException("Cannot get data from the database: " + e.getMessage(), e);
//       } finally {
//           // Close
//           try {
//               if (resultSet != null) resultSet.close();
//           } catch (SQLException e) {
//               displaySqlException("Cannot close connection", e);
//               throw new DataAccessException("Cannot close the database connection", e);
//           }
//       }
//
//       Trace.exiting(cname, mname, new Integer(objects.size()));
//       return objects;
//   }
    
    
    
    
    @Override
    protected String getCounterName() {
        return COUNTER_NAME;
    }
    


}
