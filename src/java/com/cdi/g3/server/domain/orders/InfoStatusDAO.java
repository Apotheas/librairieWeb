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
import com.cdi.g3.server.domain.company.EmployeRight;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
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
public class InfoStatusDAO extends AbstractDataAccessObject{
    // ======================================
    // =             Attributes             =
    // ======================================
    private static final String TABLE = "InfoStatus";  
    
    private static final String COLUMNS = "nameInfoStatus, valueInfoStatus";
    private static final String COLUMNS_PREP = "valueInfoStatus, nameInfoStatus";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "InfoStatus";
    
    
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
        sql = "DELETE FROM " + TABLE + " WHERE nameInfoStatus = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;        
        sql = "UPDATE " + TABLE + " SET valueInfoStatus = ? WHERE nameInfoStatus = ?" ;
        return sql; 
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE nameInfoStatus = '" + id + "' ";
        return sql;
    }

    @Override
    protected String getSelectAllSqlStatement() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + "ORDER BY valueInfoStatus";
        return sql;
    }
    
    protected String getSelectAllStatusSqlStatement(String condition) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE valueInfoStatus " +condition;
        return sql;
    }
    
    public final Collection findAllStatusByCondition(String condition) throws ObjectNotFoundException {
        final String mname = "selectAll";
        Trace.entering(getCname(), mname);
        ResultSet resultSet = null;
        final Collection objects = new ArrayList();
         // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
         
            // Select a Row
            resultSet = statement.executeQuery(getSelectAllStatusSqlStatement(condition));

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
       final InfoStatus infoStatus;
        infoStatus = new InfoStatus(resultSet.getString(1));
               infoStatus.setValueInfoStatus(resultSet.getInt(2)); 
        return infoStatus;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {
            prestmt.setInt(1, ((InfoStatus) object).getValueInfoStatus());
            prestmt.setString(2, ((InfoStatus) object).getId());
            
         
            
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
       return COUNTER_NAME;
    }
    
    
    
}
