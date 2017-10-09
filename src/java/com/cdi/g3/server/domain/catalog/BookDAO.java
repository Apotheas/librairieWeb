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
import com.cdi.g3.server.domain.other.CodeTVA;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class BookDAO extends AbstractDataAccessObject {
    private static final String TABLE_SUBTHEMEBOOK = "SUBTHEMEBOOK";
    private static final String TABLE_SUBTHEME = "SUBTHEME";
    private static final String TABLE_THEME = "THEME";
    private static final String TABLE_KEYWORD = "KEYWORD";
    private static final String TABLE_KEYWORDBOOK = "KEYWORDBOOK";
    private static final String TABLE = "BOOK";
    private static final String TABLE_EDITOR = "EDITOR";
    private EditorDAO editorDAO = new EditorDAO();
    private static final String TABLE_AUTHOR = "AUTHOR";
    private static final String TABLE_AUTHORBOOK = "AUTHORBOOK";
    private static final String COLUMNS = "NUMISBNBOOK, IDEDITORBOOK, TYPETVABOOK, TITREBOOK, UNITCOSTBOOK"
            + ", STOCKBOOK, STATUSBOOK, SUBTITREBOOK, SYNOPSISBOOK, PATHICONBOOK, WEIGHTBOOK, SIZELARGEBOOK"
            + ", SIZELONGBOOK, COMMENTBOOK";
    private static final String COLUMNS_PREP = " IDEDITORBOOK, TYPETVABOOK, TITREBOOK, UNITCOSTBOOK"
            + ", STOCKBOOK, STATUSBOOK, SUBTITREBOOK, SYNOPSISBOOK, PATHICONBOOK, WEIGHTBOOK, SIZELARGEBOOK"
            + ", SIZELONGBOOK, COMMENTBOOK, NUMISBNBOOK ";
    private static final String COUNTER_NAME = "BOOK";

    @Override
    protected String getCounterName() {
        return COUNTER_NAME;
    }

    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE + "(" + COLUMNS_PREP + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return sql;
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE NUMISBNBOOK = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;
        sql = "UPDATE " + TABLE + " SET IDEDITORBOOK = ?, TYPETVABOOK = ?, TITREBOOK = ?"
                + ", UNITCOSTBOOK = ?, STOCKBOOK = ?, STATUSBOOK = ?, SUBTITREBOOK = ?, SYNOPSISBOOK = ?"
                + ", PATHICONBOOK = ?, WEIGHTBOOK = ?, SIZELARGEBOOK = ?,SIZELONGBOOK = ?, COMMENTBOOK = ?"
                + " WHERE NUMISBNBOOK = ?";
        return sql;
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE NUMISBNBOOK = '" + id + "' ";
        return sql;
    }

    @Override
    protected String getSelectSqlStatementByChamp(String column, String champ) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " ," + TABLE_AUTHOR + " ," + TABLE_AUTHORBOOK + " , " + TABLE_EDITOR
                + " WHERE  NUMISBNBOOK = NUMISBNBOOKAB "
                + "and IDAUTHORAB = IDAUTHOR "
                + " and IDEDITORBOOK = IDEDITOR "
                + "and " + column + " = '" + champ + "'";

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
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " ," + TABLE_AUTHOR + " ," + TABLE_AUTHORBOOK + " , " + TABLE_EDITOR
                + " WHERE  NUMISBNBOOK = NUMISBNBOOKAB "
                + "and IDAUTHORAB = IDAUTHOR "
                + " and IDEDITORBOOK = IDEDITOR "
                + "and " + column + " = '" + champ + "'";

        return sql;
    }
    protected String getBooksByKeyword(String column, String champ){
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE  +" ,"+TABLE_KEYWORD+ " ,"+ TABLE_KEYWORDBOOK +
                " WHERE  NUMISBNBOOK = NUMISBNBOOKKB " +
                "and NAMEKEYWORDKB = NAMEKEYWORD " +                
                "and "+column +" = '"+ champ+ "'" ;
        
        return sql;
    }
    protected String getSelectBookByTitreSqlStatement(String titre) {
       final String sql;
       sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE TITREBOOK like  '%" + titre + "%'";
       return sql;
   }
   public Collection selectBooksByTitre(String titre) throws ObjectNotFoundException {
       final String mname = "selectAll";
       Trace.entering(getCname(), mname);

       
       ResultSet resultSet = null;
       final Collection objects = new ArrayList();
        // Gets a database connection
       try (Connection connection = getConnection();
           Statement statement = connection.createStatement()) {
       
           // Select a Row
           resultSet = statement.executeQuery(getSelectBookByTitreSqlStatement( titre));

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
    public Collection selectBooksByKeyWord(String column, String champ) throws ObjectNotFoundException {
        final String mname = "selectAll";
        Trace.entering(getCname(), mname);

        
        ResultSet resultSet = null;
        final Collection objects = new ArrayList();
         // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
        
            // Select a Row
            resultSet = statement.executeQuery(getBooksByKeyword( column, champ));

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
   

     protected String getBooksBySubTheme(String champ, String champ1){
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE  +" ,"+TABLE_SUBTHEMEBOOK+ " ,"+ TABLE_SUBTHEME + " ,"+ TABLE_THEME +
                " WHERE  NUMISBNBOOK = NUMISBNBOOKSB " +
                "and IDSUBTHEMESB = IDSUBTHEME " +
                "and NAMETHEME = NAMETHEMESB " +     
                "and NAMESUBTHEME = '"+ champ+ "'" +
                " and NAMETHEMESB = '"+ champ1+ "'" ;
        
        return sql;
    }
     protected String getBooksByTheme( String theme){
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE  +" ,"+TABLE_SUBTHEMEBOOK+ " ,"+ TABLE_SUBTHEME + 
                " WHERE  NUMISBNBOOK = NUMISBNBOOKSB " +
                "and IDSUBTHEMESB = IDSUBTHEME " +                          
                " and NAMETHEMESB = '"+ theme + "'" ;
        
        return sql;
    }
     
     public Collection selectBooksByTheme( String theme) throws ObjectNotFoundException {
        final String mname = "selectAll";
        Trace.entering(getCname(), mname);

        
        ResultSet resultSet = null;
        final Collection objects = new ArrayList();
         // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
        
            // Select a Row
            resultSet = statement.executeQuery( getBooksByTheme(theme));

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
      public Collection selectBooksBySub(String column, String champ) throws ObjectNotFoundException {
        final String mname = "selectAll";
        Trace.entering(getCname(), mname);

        
        ResultSet resultSet = null;
        final Collection objects = new ArrayList();
         // Gets a database connection
        try (Connection connection = getConnection(); 
            Statement statement = connection.createStatement()) {
        
            // Select a Row
            resultSet = statement.executeQuery(getBooksBySubTheme(column, champ));

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
        final Book book;
        book = new Book(resultSet.getString(1), new Editor(resultSet.getString(2)), new CodeTVA(resultSet.getString(3)), resultSet.getString(4), resultSet.getFloat(5), resultSet.getInt(6));
        book.setStatusBook(resultSet.getInt(7));
        book.setSubTitleBook(resultSet.getString(8));
        book.setSynopsisBook(resultSet.getString(9));
        book.setPathIconBook(resultSet.getString(10));
        book.setWeightBook(resultSet.getFloat(11));
        book.setSizeLargeBook(resultSet.getFloat(12));
        book.setSizeLongBook(resultSet.getFloat(13));
        book.setCommentBook(resultSet.getString(14));

        return book;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {

            prestmt.setString(1, ((Book) object).getEditor().getId());
            prestmt.setString(2, ((Book) object).getCodeTva().getId());
            prestmt.setString(3, ((Book) object).getTitleBook());
            prestmt.setFloat(4, ((Book) object).getUnitCostBook());
            prestmt.setInt(5, ((Book) object).getStockBook());
            prestmt.setInt(6, ((Book) object).getStatusBook());
            prestmt.setString(7, ((Book) object).getSubTitleBook());
            prestmt.setString(8, ((Book) object).getSynopsisBook());
            prestmt.setString(9, ((Book) object).getPathIconBook());
            prestmt.setFloat(10, ((Book) object).getWeightBook());
            prestmt.setFloat(11, ((Book) object).getSizeLongBook());
            prestmt.setFloat(12, ((Book) object).getSizeLargeBook());
            prestmt.setString(13, ((Book) object).getCommentBook());
            prestmt.setString(14, ((Book) object).getNumISBNBook());

            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get dataBook from the database: " + e.getMessage(), e);
        }
        return retour;
    }

}
