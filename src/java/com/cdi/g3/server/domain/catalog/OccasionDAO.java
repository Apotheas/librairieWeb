/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author youssef
 */
public class OccasionDAO extends AbstractDataAccessObject{
    
    
    // ======================================
    // =             Attributes             =
    // ======================================
    private static final String TABLE = "OCCASION";

    private static final String COLUMNS = "NAMEOCCASION, DATEDEBUTOCCASION , DATEFINOCCASION, DISCOUNTOCCASION";
            
    private static final String COLUMNS_PREP = " DATEDEBUTOCCASION , DATEFINOCCASION, DISCOUNTOCCASION, NAMEOCCASION";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "OCCASION";
    
    
    
    @Override
    protected String getCounterName() {
        return COUNTER_NAME;
    }

    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE + "(" + COLUMNS_PREP + ") VALUES(?,?,?,?)";
        return sql;
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE NAMEOCCASION = '" + id + "'";
        return sql; 
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;
        sql = "UPDATE " + TABLE + " SET DATEDEBUTOCCASION = ?, DATEFINOCCASION = ?, DISCOUNTOCCASION = ?"
                + " WHERE NAMEOCCASION = ?";
        return sql;
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE NAMEOCCASION = '" + id + "' ";
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
        final Occasion occasion;
        occasion = new Occasion(resultSet.getString(1), resultSet.getDate(2), resultSet.getDate(3));
        occasion.setDiscountOccasion((resultSet.getFloat(4)));
        
        return occasion;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {

            
            prestmt.setDate(1, (Date) ((Occasion) object).getDateDebutOccasion());
            prestmt.setDate(2, (Date) ((Occasion) object).getDateFinOccasion());
            prestmt.setFloat(3, ((Occasion) object).getDiscountOccasion());
            prestmt.setString(4, ((Occasion) object).getNameOccasion());

            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        }
        return retour;
    }
    
    
}
