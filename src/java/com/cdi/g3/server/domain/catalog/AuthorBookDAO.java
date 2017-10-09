/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author youssef
 */
public class AuthorBookDAO extends AbstractDataAccessObject{
    
    
    @Override
    protected String getCounterName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String getInsertSqlPreparedStatement() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected String getSelectAllSqlStatement() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected DomainObject transformResultset2DomainObject(ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
