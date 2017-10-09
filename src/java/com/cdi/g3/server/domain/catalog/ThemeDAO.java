/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;

/**
 *
 * @author youssef
 */
public class ThemeDAO extends AbstractDataAccessObject {

    // ======================================
    // =             Attributes             =
    // ======================================
    private static final String TABLE = "THEME";

    private static final String COLUMNS = "NAMETHEME";

    private static final String COLUMNS_PREP = "NAMETHEME";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "THEME";

    @Override
    protected String getCounterName() {
        return COUNTER_NAME;
    }

    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE + "(" + COLUMNS_PREP + ") VALUES(?)";
        return sql;
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE NAMETHEME = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;
        sql = "UPDATE " + TABLE + " SET NAMETHEME = ? WHERE NAMETHEME = ?";
        return sql;
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE NAMETHEME = '" + id + "' ";
        return sql;
    }
     @Override
    protected String getSelectSqlStatementByChamp(String column, String champ) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE " + column + " = '" + champ + "' ";
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
        final Theme theme;
        theme = new Theme(resultSet.getString(1));

        return theme;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {

            prestmt.setString(1,((Theme) object).getNameTheme());

            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get Occasion data from the database: " + e.getMessage(), e);
        }
        return retour;
    }

}
