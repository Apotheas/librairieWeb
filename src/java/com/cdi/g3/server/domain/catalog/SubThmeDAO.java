/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.common.exception.DuplicateKeyException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.DomainObject;

import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.getConnection;
import static com.cdi.g3.server.util.persistence.DataAccessConstants.DATA_ALREADY_EXIST;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubThmeDAO extends AbstractDataAccessObject {

    private static final String TABLE = "SubTheme";
    private static final String TABLE_SBB = "SubThemeBook";
    private static final String COLUMNS = "idSubTheme, nameSubTheme, nameThemeSB";
    private static final String COLUMNS_PREP = " nameSubTheme, nameThemesB, idSubTheme";
    private static final String COUNTER_NAME = "SubTheme";

    protected String getInsertBookInSub(String ISBN, String sub) {
        final String sql;
        sql = "INSERT INTO " + TABLE_SBB + "(IDSUBTHEMEBOOK, NUMISBNBOOKSB, IDSUBTHEMESB) VALUES(?,?,?)";
        return sql;
    }

    protected String getDeleteBookInSub(String ISBN, String sub) {
        final String sql;
        sql = "DELETE FROM  " + TABLE_SBB + " WHERE NUMISBNBOOKSB = '" + ISBN + "'  AND IDSUBTHEMESB = '" + sub + "' ";
        return sql;
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
        sql = "DELETE FROM " + TABLE + " WHERE idSubTheme = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;
        sql = "UPDATE " + TABLE + " SET nameSubTheme = ?, nameThemeSB = ?, WHERE idSubTheme = ?";
        return sql;
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE idSubTheme = '" + id + "' ";
        return sql;
    }

    @Override
    protected String getSelectAllSqlStatement() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE;
        return sql;
    }

    @Override
    protected String getSelectAllSqlStatementByChamp(String column, String champ) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE " + column + " = '" + champ + "' ";
        return sql;
    }

    @Override
    protected DomainObject transformResultset2DomainObject(ResultSet resultSet) throws SQLException {
        final SubTheme subTheme;
        subTheme = new SubTheme(resultSet.getString(1));
        subTheme.setNameSubTheme(resultSet.getString(2));
        subTheme.setNameTheme(resultSet.getString(3));

        return subTheme;
    }

    protected String getVerifiedSqlStatementByChamp(String idSub, String nameTheme) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE NAMESUBTHEME  = '" + idSub + "' "
                + " AND NAMETHEMESB = '" + nameTheme + "' ";
        return sql;
    }

    protected String getSelectSubOFBook(String isbn, String nameTheme) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " , SUBTHEMEBOOK  "
                + " WHERE IDSUBTHEME  = IDSUBTHEMESB "
                + " AND NAMETHEMESB = '" + nameTheme + "' "
                + " AND NUMISBNBOOKSB = '" + isbn + "' ";
        return sql;
    }

    protected String getVerifiedSubBookSqlStatementByChamp(String idSub, String ISBN) {
        final String sql;
        sql = "SELECT IDSUBTHEMEBOOK , NUMISBNBOOKSB , IDSUBTHEMESB  FROM " + TABLE_SBB + " WHERE IDSUBTHEMESB  = '" + idSub + "' "
                + " AND NUMISBNBOOKSB = '" + ISBN + "' ";

        return sql;
    }

    public DomainObject selectSubOfBook(String idSub, String ISBN) throws ObjectNotFoundException {
        final String mname = "select";
        Trace.entering(getCname(), mname, ISBN);

        ResultSet resultSet = null;
        DomainObject object;
        // Gets a database connection
        try (Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            // Select a Row
            resultSet = statement.executeQuery(getVerifiedSubBookSqlStatementByChamp(idSub, ISBN));
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

    public DomainObject VerifiedByChampSubBook(String idSub, String ISBN) throws ObjectNotFoundException {
        final String mname = "select";
        Trace.entering(getCname(), mname, ISBN);

        ResultSet resultSet = null;
        DomainObject object;
        // Gets a database connection
        try (Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            // Select a Row
            resultSet = statement.executeQuery(getVerifiedSubBookSqlStatementByChamp(idSub, ISBN));
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

    public DomainObject VerifiedByChamp(String column, String champ) throws ObjectNotFoundException {
        final String mname = "select";
        Trace.entering(getCname(), mname, champ);

        ResultSet resultSet = null;
        DomainObject object;
        // Gets a database connection
        try (Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            // Select a Row
            resultSet = statement.executeQuery(getVerifiedSqlStatementByChamp(column, champ));
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

    public final void associateSubBook(String ISBN, String idSub) throws DuplicateKeyException {

        // Gets a database connection
        try (Connection connection = getConnection();
                PreparedStatement prstatement = connection.prepareStatement(getInsertBookInSub(ISBN, idSub))) {
            // Sets the object Id if necessary

            String idSubthemeBook = this.getUniqueId("SUBTHEMEBOOK");
            // Inserts a Row      
            prstatement.setString(1, idSubthemeBook);
            prstatement.setString(2, ISBN);
            prstatement.setString(3, idSub);

            prstatement.executeUpdate();
//        executePreparedSt(prstatement, object);
        } catch (SQLException e) {
            // The data already exists in the database
            if (e.getErrorCode() == DATA_ALREADY_EXIST) {
                throw new DuplicateKeyException();
            } else {
                // A Severe SQL Exception is caught
                displaySqlException(e);
                throw new DataAccessException("Cannot insert data into the database", e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void DeleteBookFromSub(String ISBN, String idSub) throws DuplicateKeyException {

        try (Connection connection = getConnection();
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(getDeleteBookInSub(ISBN, idSub));
        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("Cannot remove data into the database", e);

        }
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {

            prestmt.setString(1, ((SubTheme) object).getNameSubTheme());
            prestmt.setString(2, ((SubTheme) object).getNameTheme());
            prestmt.setString(3, ((SubTheme) object).getId());

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
