/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.company;

import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.domain.company.Company;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author youssef
 */
public class CompanyDAO extends AbstractDataAccessObject{
    
    
    // ======================================
    // =             Attributes             =
    // ======================================
    private static final String TABLE = "Company";  
    
    private static final String COLUMNS = "SIRETCOMPANY, NAMECOMPANY, LOGOCOMPANY, TELEPHONECOMPANY, FAXCOMPANY"
            + ", MAILCOMPANY";
    private static final String COLUMNS_PREP= "  NAMECOMPANY, LOGOCOMPANY, TELEPHONECOMPANY, FAXCOMPANY"
            + ", MAILCOMPANY, SIRETCOMPANY";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "COMPANY";
    
    
     // ======================================
    // =           Business methods         =
    // ======================================
    protected String getInsertSqlPreparedStatement() {        
        final String sql;        
        sql =   "INSERT INTO " + TABLE + "(" +COLUMNS_PREP+ ") VALUES(?,?,?,?,?,?)";
        return sql;
    }

    protected String getDeleteSqlStatement(final String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE SIRETCOMPANY = '" + id + "'";
        return sql;
    }

    protected String getUpdateSqlPreparedStatement() {        
        final String sql;        
        sql = "UPDATE " + TABLE + " SET NAMECOMPANY = ?, LOGOCOMPANY = ?, TELEPHONECOMPANY = ?,"
                + " FAXCOMPANY = ?, MAILCOMPANY = ? WHERE SIRETCOMPANY = ?" ;
        return sql;
        
    }

    protected String getSelectSqlStatement(final String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE SIRETCOMPANY = '" + id + "' ";
        return sql;
    }

    protected String getSelectAllSqlStatement() {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE;
        return sql;
    }

  
    protected DomainObject transformResultset2DomainObject(final ResultSet resultSet) throws SQLException {
        final Company company;
        company = new Company(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
        company.setTelephoneCompany(resultSet.getString(4));
        company.setFaxCompany(resultSet.getString(5));
        company.setMailCompany(resultSet.getString(6));
      
        return company;
    }

	protected String getCounterName() {
		return COUNTER_NAME;
	}
        
        
       @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {
            prestmt.setString(1, ((Company) object).getNameCompany());
            prestmt.setString(2, ((Company) object).getLogoCompany());
            prestmt.setString(3, ((Company) object).getTelephoneCompany());
            prestmt.setString(4, ((Company) object).getFaxCompany());
            prestmt.setString(5, ((Company) object).getMailCompany());
            prestmt.setString(6, ((Company) object).getId());
         
            
            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        }
        return retour;
    }
     
        
        
}