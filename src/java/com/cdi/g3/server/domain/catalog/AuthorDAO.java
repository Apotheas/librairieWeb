/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.common.exception.DuplicateKeyException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.DomainObject;


import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.getConnection;
import static com.cdi.g3.server.util.persistence.DataAccessConstants.DATA_ALREADY_EXIST;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthorDAO extends AbstractDataAccessObject {
   
    private static final String TABLE = "AUTHOR";
    private static final String TABLE_BOOK = "BOOK";
    private static final String TABLE_AUTHORBOOK = "AUTHORBOOK";
    private static final String COLUMNS = "IDAUTHOR, LASTNAMEAUTHOR, FIRSTNAMEAUTHOR, BIOGRAPHYAUTHOR, BIRTHDATEAUTHOR"
            + ", DIEDATEAUTHOR, COMMENTAUTHOR ";
    private static final String COLUMNS_PREP = " LASTNAMEAUTHOR, FIRSTNAMEAUTHOR, BIOGRAPHYAUTHOR, BIRTHDATEAUTHOR"
            + ", DIEDATEAUTHOR, COMMENTAUTHOR, IDAUTHOR ";    
    private static final String COUNTER_NAME = "AUTHOR";
    
    
    @Override
    protected String getCounterName() {
        return COUNTER_NAME;
    }
    
    protected String getInsertAuthorBookSqlPrSt(String isbn, String idAuthor){
        final String sql;
        sql = " INSERT INTO AUTHORBOOK (IDAUTHORBOOK, NUMISBNBOOKAB, IDAUTHORAB) VALUES(?,?,?)";
             
        return sql;
    }
    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE + "(" + COLUMNS_PREP + ") VALUES(?,?,?,?,?,?,?)";
        return sql;
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE IDAUTHOR = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;
        sql = "UPDATE " + TABLE + " SET LASTNAMEAUTHOR = ?, FIRSTNAMEAUTHOR = ?, BIOGRAPHYAUTHOR = ?,"
                + " BIRTHDATEAUTHOR = ?, DIEDATEAUTHOR = ?, COMMENTAUTHOR = ?   WHERE IDAUTHOR = ?";
        return sql;
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE IDAUTHOR = '" + id + "' ";
        return sql;
    }

    @Override
    protected String getSelectAllSqlStatement() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " ORDER BY lastnameauthor";
        return sql;
    }
    @Override
    protected String getSelectSqlStatementByChamp(String column, String champ){
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE  +" ,"+TABLE_BOOK+" ,"+TABLE_AUTHORBOOK+
                " WHERE  NUMISBNBOOK = NUMISBNBOOKAB " +
                "and IDAUTHORAB = IDAUTHOR " +                
                "and "+column +" = '"+ champ+"'";
        
        return sql;
    }   
    @Override
    protected String getSelectAllSqlStatementByChamp(String column, String champ){
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE  +" ,"+TABLE_BOOK+" ,"+TABLE_AUTHORBOOK+
                " WHERE  NUMISBNBOOK = NUMISBNBOOKAB " +
                "and IDAUTHORAB = IDAUTHOR " +                
                "and "+column +" = '"+ champ+"'";
        
        return sql;
    }       
    
    public final void associateAuthorBook(String ISBN, String idAuthor) throws DuplicateKeyException {

       // Gets a database connection
       try (Connection connection = getConnection();
               PreparedStatement prstatement = connection.prepareStatement( getInsertAuthorBookSqlPrSt(ISBN, idAuthor))) {
          // Sets the object Id if necessary

           String idAuthorBook = this.getUniqueId("AUTHORBOOK");
           // Inserts a Row      
           prstatement.setString(1, idAuthorBook);
           prstatement.setString(2, ISBN);
           prstatement.setString(3, idAuthor);

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
    @Override
    protected DomainObject transformResultset2DomainObject(ResultSet resultSet) throws SQLException {
        final Author author;
        author = new Author(resultSet.getString(1), resultSet.getString(2));
        author.setFirstNameAuthor(resultSet.getString(3));
        author.setBiographyAuthor(resultSet.getString(4));
        author.setBirthDateAuthor(resultSet.getDate(5));
        author.setDieDateAuthor(resultSet.getDate(6));
        author.setCommentAuthor(resultSet.getString(7));
        return author;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {
            
            prestmt.setString(1, ((Author) object).getLastNameAuthor());
            prestmt.setString(2, ((Author) object).getFirstNameAuthor());
            prestmt.setString(3, ((Author) object).getBiographyAuthor());
            prestmt.setDate(4, (Date) ((Author) object).getBirthDateAuthor());
            prestmt.setDate(5, (Date) ((Author) object).getDieDateAuthor());
            prestmt.setString(6, ((Author) object).getCommentAuthor());
            prestmt.setString(7, ((Author) object).getIdAuthor());

            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        }
        return retour;
    }
   
  
   
    
    

}
