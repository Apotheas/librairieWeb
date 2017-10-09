/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.company;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.domain.company.Employe;
import com.cdi.g3.server.domain.orders.InfoStatus;
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
 * @author Izet
 */
public class EmployeDAO extends AbstractDataAccessObject {

    // ======================================
    // =             Attributes             =
    // ======================================
    private static final String TABLE = "EMPLOYE";

    private static final String COLUMNS = "LOGINEMPLOYE, IDEMPLOYERIGHTEMP, FIRSTNAMEEMPLOYE, LASTNAMEEMPLOYE, EMAILEMPLOYE"
            + ", PASSWORDEMPLOYE, STATUSEMPLOYE";
    private static final String COLUMNS_PREP = "  IDEMPLOYERIGHTEMP, FIRSTNAMEEMPLOYE, LASTNAMEEMPLOYE, EMAILEMPLOYE"
            + ", PASSWORDEMPLOYE,STATUSEMPLOYE, LOGINEMPLOYE";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "EMPLOYE";

    private static final String TABLE_INFOSTATUS = "INFOSTATUS";
    private static final String TABLE_EMPLOYERIGHT = "EMPLOYERIGHT";

    // ======================================
    // =           Business methods         =
    // ======================================
    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE + "(" + COLUMNS_PREP + ") VALUES(?,?,?,?,?,?,?)";
        return sql;
    }
    @Override
    protected String getDeleteSqlStatement(final String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE LOGINEMPLOYE = '" + id + "'";
        return sql;
    }
    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;
        sql = "UPDATE " + TABLE + " SET IDEMPLOYERIGHTEMP = ?, FIRSTNAMEEMPLOYE = ?, LASTNAMEEMPLOYE = ?,"
                + " EMAILEMPLOYE = ?, PASSWORDEMPLOYE = ?, STATUSEMPLOYE = ? WHERE LOGINEMPLOYE = ?";
        return sql;

    }

    @Override
    protected String getSelectAllSqlStatementByChamp(String column, String champ) {
        final String sql;

        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " ," + TABLE_EMPLOYERIGHT
                + " WHERE  IDEMPLOYERIGHTEMP = IDEMPLOYERIGHT "
                + "and " + column + " = '" + champ + "'";
        return sql;
    }

    protected String getSelectAllSqlStatementByStatus(String column, String champ) {
        final String sql;

        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " ," + TABLE_INFOSTATUS
                + " WHERE  STATUSEMPLOYE = NAMEINFOSTATUS "
                + "and " + column + " = '" + champ + "'";
        return sql;
    }

    protected String getSelectLoginCheck(String login, String password) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE LOGINEMPLOYE = '" + login + "' "
                + "AND  PASSWORDEMPLOYE = '" + password + "' ";
        return sql;
    }

    @Override
    protected String getSelectSqlStatement(final String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE LOGINEMPLOYE = '" + id + "' ";
        return sql;
    }

    @Override
    protected String getSelectAllSqlStatement() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE;
        return sql;
    }

    @Override
    protected DomainObject transformResultset2DomainObject(final ResultSet resultSet) throws SQLException {
        final Employe employe;
        employe = new Employe(resultSet.getString(1));
        employe.setEmployeRight(new EmployeRight(resultSet.getString(2)));
        employe.setFirstNameEmploye(resultSet.getString(3));
        employe.setLastNameEmploye(resultSet.getString(4));
        employe.setEmailEmploye(resultSet.getString(5));
        employe.setPasswordEmploye(resultSet.getString(6));
        if (resultSet.getString(7) != null) {
            employe.setInfoStatus(new InfoStatus(resultSet.getString(7)));
        }

        return employe;
    }

    @Override
    protected String getCounterName() {
        return COUNTER_NAME;
    }

    public Collection findAllByStatus(String column, String champ) throws ObjectNotFoundException {
        final String mname = "selectAll";
        Trace.entering(getCname(), mname);

        ResultSet resultSet = null;
        final Collection objects = new ArrayList();
        // Gets a database connection
        try (Connection connection = getConnection();
                Statement statement = connection.createStatement()) {

            // Select a Row
            resultSet = statement.executeQuery(getSelectAllSqlStatementByStatus(column, champ));

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

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {
            prestmt.setString(1, ((Employe) object).getEmployeRight().getId());
            prestmt.setString(2, ((Employe) object).getFirstNameEmploye());
            prestmt.setString(3, ((Employe) object).getLastNameEmploye());
            prestmt.setString(4, ((Employe) object).getEmailEmploye());
            prestmt.setString(5, ((Employe) object).getPasswordEmploye());
            prestmt.setString(6, ((Employe) object).getInfoStatus().getId());

            prestmt.setString(7, ((Employe) object).getId());

            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        }
        return retour;
    }

}
