/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.orders;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author youssef
 */
public class ShipperDAO extends AbstractDataAccessObject{
    // ======================================
    // =             Attributes             =
    // ======================================
    private static final String TABLE = "Shipper";  
    
    private static final String COLUMNS = "nameShipper, commentShipper";
    private static final String COLUMNS_PREP = "commentShipper, nameShipper";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "Shipper";
    
    
     // ======================================
    // =           Business methods         =
    // ============

    
    
    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;        
        sql =   "INSERT INTO " + TABLE + "(" +COLUMNS_PREP+ ") VALUES(?,?)";
        return sql;
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
       final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE nameShipper = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;        
        sql = "UPDATE " + TABLE + " SET commentShipper = ? WHERE nameShipper = ?" ;
        return sql; 
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE nameShipper = '" + id + "' ";
        return sql;
    }

    @Override
    protected String getSelectAllSqlStatement() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE;
        return sql;
    }

    @Override
    protected DomainObject transformResultset2DomainObject(ResultSet resultSet) throws SQLException {
        final Shipper shipper;
        shipper = new Shipper(resultSet.getString(1));
               shipper.setCommentShipper(resultSet.getString(2)); 
        return shipper;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
       int retour = 0;
        try {
            prestmt.setString(1, ((Shipper) object).getCommentShipper());
            prestmt.setString(2, ((Shipper) object).getId());
            
         
            
            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        }
        return retour;
    }
    
    @Override
    protected String getCounterName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
