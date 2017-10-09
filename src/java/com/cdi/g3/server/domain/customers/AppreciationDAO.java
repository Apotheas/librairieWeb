/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.customers;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.domain.company.Company;
import com.cdi.g3.server.domain.company.Employe;
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
public class AppreciationDAO extends AbstractDataAccessObject {

    private static final String TABLE = "Appreciation";
    private static final String COLUMNS = "idAppreciate, loginCustomerAppreciate,"
            + " idOrderlineAppreciate, numIsbnBookAppreciate,  dateAppreciate, ipAppreciate, commentAppreciate,"
            + " ratingAppreciate,loginEmployeAppreciate, moderateAppreciate, dateModerateAppreciate, statusappreciate ";

    private static final String COLUMNS_PREP = " loginCustomerAppreciate,"
            + " idOrderlineAppreciate, numIsbnBookAppreciate,  dateAppreciate, ipAppreciate, commentAppreciate,"
            + " ratingAppreciate, loginEmployeAppreciate, moderateAppreciate, dateModerateAppreciate, statusappreciate, idAppreciate";

    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "Appreciation";

    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE + "(" + COLUMNS_PREP + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        return sql;
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE idAppreciate = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;
        sql = "UPDATE " + TABLE + " SET loginCustomerAppreciate = ?, idOrderlineAppreciate = ?, NumIsbnBookAppreciate = ?,"
                + " dateAppreciate = ?, ipAppreciate = ?, commentAppreciate = ?, ratingAppreciate = ?, loginEmployeAppreciate = ?,"
                + " moderateAppreciate = ?, dateModerateAppreciate = ? , statusappreciate = ? WHERE idAppreciate = ?";
        return sql;
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE idAppreciate = '" + id + "' ";
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
        final Appreciation appreciation;
        appreciation = new Appreciation();
        appreciation.setIdAppreciate(resultSet.getString(1));        
        appreciation.setLoginCustomerAppreciate(new Customer(resultSet.getString(2)));
        appreciation.setIdOrderlineAppreciate(resultSet.getString(3));
        appreciation.setNumIsbnBookAppreciate(resultSet.getString(4));
        appreciation.setDateAppreciate(resultSet.getString(5));
         appreciation.setIpAppreciate(resultSet.getString(6));
        appreciation.setCommentAppreciate(resultSet.getString(7));
        appreciation.setRatingAppreciate(resultSet.getString(8));     
        appreciation.setLoginEmployeAppreciate(new Employe(resultSet.getString(9)));
        appreciation.setModerateAppreciate(resultSet.getString(10));
        appreciation.setDateModerateAppreciate(resultSet.getString(11));
        appreciation.setStatusAppreciate(resultSet.getInt(12));
        return appreciation;
    }

    @Override
    protected String getSelectAllSqlStatementByChamp(String column, String champ) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " , BOOK "
                + "WHERE NUMISBNBOOK = NUMISBNBOOKAPPRECIATE"
                + " AND " + column + " = '" + champ + "'";

        return sql;
    }

    protected String getNonModerate() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE LOGINEMPLOYEAPPRECIATE IS NULL ";
        return sql;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {

            
            prestmt.setString(1, ((Appreciation) object).getLoginCustomerAppreciate().getId());
            prestmt.setString(2, ((Appreciation) object).getIdOrderlineAppreciate());
            prestmt.setString(3, ((Appreciation) object).getNumIsbnBookAppreciate());           
            prestmt.setString(4, ((Appreciation) object).getDateAppreciate());
            prestmt.setString(5, ((Appreciation) object).getIpAppreciate());
            prestmt.setString(6, ((Appreciation) object).getCommentAppreciate());
            prestmt.setString(7, ((Appreciation) object).getRatingAppreciate());
            prestmt.setString(8, ((Appreciation) object).getLoginEmployeAppreciate().getId());
            prestmt.setString(9, ((Appreciation) object).getModerateAppreciate());
            prestmt.setString(10, ((Appreciation) object).getDateModerateAppreciate());
            prestmt.setInt(11, ((Appreciation) object).getStatusAppreciate());
            prestmt.setString(12, ((Appreciation) object).getIdAppreciate());

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

    public Collection selectAllNonModerate() throws ObjectNotFoundException {
        final String mname = "selectAll";
        Trace.entering(getCname(), mname);
        ResultSet resultSet = null;
        final Collection objects = new ArrayList();
        // Gets a database connection
        try (Connection connection = getConnection();
                Statement statement = connection.createStatement()) {

            // Select a Row
            resultSet = statement.executeQuery(getNonModerate());

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

}
