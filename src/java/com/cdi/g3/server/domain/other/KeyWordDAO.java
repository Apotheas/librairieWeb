/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.other;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.common.exception.DuplicateKeyException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author youssef
 */
public class KeyWordDAO extends AbstractDataAccessObject {

    private static final String TABLE_KEYWORDBOOK = " KeyWord ";
    private static final String COLUMNS_PREP8_KB = " nameKeyWord ";

    private static final String TABLE = " KeyWord ";
    private static final String COLUMNS = " nameKeyWord ";
    private static final String COLUMNS_PREP = "nameKeyWord";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "KeyWord";

    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE + "(" + COLUMNS_PREP + ") VALUES(?)";
        return sql;
    }

    /**
     * ***************************************************************************************
     */

    protected String getInsertKeyWordBookSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE_KEYWORDBOOK + "(" + COLUMNS_PREP8_KB + ") VALUES(?,?,?)";

        return sql;
    }

    /**
     * ******************************************************************************************
     */

    @Override
    protected String getDeleteSqlStatement(String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE nameKeyWord = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;
        sql = "UPDATE " + TABLE + " SET nameKeyWord = ? ";
        return sql;
    }

    
    
    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE nameKeyWord = '" + id + "' ";
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
        final KeyWord keyWord;
        keyWord = new KeyWord(resultSet.getString(1));

        return keyWord;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {

            prestmt.setString(1, ((KeyWord) object).getNameKeyWord());
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

    ////********//////////*************////////////***********////////////************///////////
    ////********//////////*************////////////***********////////////************///////////
    String getInsertKeyWordBookSqlStatement(String ISBN, String keyWord) {
        final String sql;
        sql = "INSERT INTO KEYWORDBOOK (IDKEYWORDBOOK,NUMISBNBOOKKB, NAMEKEYWORDKB) values (?,?,?)";
        return sql;
    }

    public final void associateBookKeyWord(String ISBN, String keyWord) throws DuplicateKeyException {

        // Gets a database connection
        try (Connection connection = getConnection();
             PreparedStatement prstatement = connection.prepareStatement(getInsertKeyWordBookSqlStatement(ISBN, keyWord))) {
           // Sets the object Id if necessary

            String idKeyWordBookKB = this.getUniqueId("KEYWORDBOOK");
            // Inserts a Row      
            prstatement.setString(1, idKeyWordBookKB);
            prstatement.setString(2, ISBN);
            prstatement.setString(3, keyWord);

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
// update **************************************************************************************************
////********//////////*************////////////***********////////////************///////////
////********//////////*************////////////***********////////////************///////////
String getUpdateKeyWordBookSqlStatement(String ISBN, String keyWord) {
        final String sql;
        sql = "Update INTO KEYWORDBOOK (IDKEYWORDBOOK,NUMISBNBOOKKB, NAMEKEYWORDKB) values (?,?,?)"
                + " where namekeyWordKB = '" + keyWord + "'"
                 ;

        return sql;
    }

    public final void updateKeyWordIntoKeyWordBook(String ISBN, String keyWord) throws DuplicateKeyException {

        // Gets a database connection
        try (Connection connection = getConnection();
                PreparedStatement prstatement = connection.prepareStatement(getUpdateKeyWordBookSqlStatement(ISBN, keyWord))) {
           // Sets the object Id if necessary

            String idKeyWordBookKB = this.getUniqueId("KEYWORDBOOK");
            // Inserts a Row      
            prstatement.setString(1, idKeyWordBookKB);
            prstatement.setString(2, ISBN);
            prstatement.setString(3, keyWord);

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

}
