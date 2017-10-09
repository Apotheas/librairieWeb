/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.company;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author youssef
 */
public class InfoCompanyDAO extends AbstractDataAccessObject{
    
  
    // ======================================
    // =             Attributes             =
    // ======================================
    private static final String TABLE = "InfoCompany";  
    
    private static final String COLUMNS = "NAMEINFOCOMPANY, DESCRIPTIONINFOCOMPANY";
    private static final String COLUMNS_PREP= "  DESCRIPTIONINFOCOMPANY, NAMEINFOCOMPANY";
    // Used to get a unique id with the UniqueNameGenerator
    private static final String COUNTER_NAME = "INFOCOMPANY";
    
    
     // ======================================
    // =           Business methods         =
    // ======================================
    protected String getInsertSqlPreparedStatement() {        
        final String sql;
        
        sql =   "INSERT INTO " + TABLE + "(" +COLUMNS_PREP+ ") VALUES(?,?)";//                
        return sql;
    }

    protected String getDeleteSqlStatement(final String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE NAMEINFOCOMPANY = '" + id + "'";
        return sql;
    }

    protected String getUpdateSqlPreparedStatement() {        
        final String sql;        
        sql = "UPDATE " + TABLE + " SET DESCRIPTIONINFOCOMPANY = ? WHERE NAMEINFOCOMPANY = ?" ;
        return sql;
        
    }

    protected String getSelectSqlStatement(final String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE NAMEINFOCOMPANY = '" + id + "' ";
        return sql;
    }

    protected String getSelectAllSqlStatement() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE;
        return sql;
    }

  
    protected DomainObject transformResultset2DomainObject(final ResultSet resultSet) throws SQLException {
        final InfoCompany infocompany;
        infocompany = new InfoCompany(resultSet.getString(1), resultSet.getString(2));
     
      
        return infocompany;
    }

	protected String getCounterName() {
		return COUNTER_NAME;
	}
        
        
       @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {
            prestmt.setString(1, ((InfoCompany) object).getDescriptionInfoCompany());
            prestmt.setString(2, ((InfoCompany) object).getId());
            
         
            
            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        }
        return retour;
    }
     
        
        
}