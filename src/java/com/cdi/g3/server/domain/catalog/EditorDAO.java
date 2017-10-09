/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

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

public class EditorDAO extends AbstractDataAccessObject {

    private static final String TABLE = "EDITOR";
    private static final String COLUMNS = "IDEDITOR, NAMEEDITOR, STATUSEDITOR ";
    private static final String COLUMNS_PREP = " NAMEEDITOR, STATUSEDITOR, IDEDITOR";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "EDITOR";

    @Override
    protected String getCounterName() {
        return COUNTER_NAME;
    }

    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE + "(" + COLUMNS_PREP + ") VALUES(?,?,?)";
        return sql;
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE IDEDITOR = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;
        sql = "UPDATE " + TABLE + " SET NAMEEDITOR = ?, STATUSEDITOR = ? WHERE IDEDITOR = ?";
        return sql;
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE IDEDITOR = '" + id + "' ";
        return sql;
    }

    @Override
    protected String getSelectAllSqlStatement() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " ORDER BY NAMEEDITOR";
        return sql;
    }  

    @Override
    protected String getSelectSqlStatementByChamp(String column, String champ) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " , " + " BOOK "
                + " WHERE IDEDITOR = IDEDITORBOOK "
                + "AND  " + column + " = '" + champ + "'";

        return sql;
    }
    @Override
    protected String getSelectAllSqlStatementByChamp(String column, String champ) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " , " + " BOOK "
                + " WHERE IDEDITOR = IDEDITORBOOK "
                + "AND  " + column + " = '" + champ + "'";

        return sql;
    }
    protected String getSelectEditorByChamp(String column, String champ){
        final String sql;
        sql =  "SELECT " + COLUMNS + " FROM " + TABLE 
                + " WHERE " + column + " = '" + champ + "'";               

        return sql;
    }
    
    public DomainObject selectEditorByChamp(String column, String champ) throws ObjectNotFoundException {
        final String mname = "select";
        Trace.entering(getCname(), mname, champ);

        ResultSet resultSet = null;
        DomainObject object;
          // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
            // Select a Row
            resultSet = statement.executeQuery(getSelectEditorByChamp(column, champ));
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
    @Override
    protected DomainObject transformResultset2DomainObject(ResultSet resultSet) throws SQLException {
        final Editor editor;
        editor = new Editor(resultSet.getString(1), resultSet.getString(2));
        editor.setStatusEditor(resultSet.getInt(3));
        return editor;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {

            prestmt.setString(1, ((Editor) object).getNameEditor());
            prestmt.setInt(2, ((Editor) object).getStatusEditor());
            prestmt.setString(3, ((Editor) object).getIdEditor());

            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        }
        return retour;
    }

}
