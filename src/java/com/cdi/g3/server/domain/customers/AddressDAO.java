/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.customers;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.domain.company.Company;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author youssef
 */
public class AddressDAO extends AbstractDataAccessObject {

    private static final String TABLE = "Adress";
    private static final String COLUMNS = "idAdress, loginCustomerShipAdress, loginCustomerBillAdress,"
            + " nameReceiverAdress, typeStreetAdress, numAdress, nameStreetAdress, NAMESTEET2ADRESS,"
            + "zipcodeAdress, cityAdress, countryAdress,nameCompanyReceiverAdress  ";

    private static final String COLUMNS_PREP = "loginCustomerShipAdress, loginCustomerBillAdress,"
            + " nameReceiverAdress, typeStreetAdress, numAdress, nameStreetAdress, NAMESTEET2ADRESS,"
            + " zipcodeAdress, cityAdress, countryAdress,nameCompanyReceiverAdress, idAdress";

    @Override
    protected String getInsertSqlPreparedStatement() {
        final String sql;
        sql = "INSERT INTO " + TABLE + "(" + COLUMNS_PREP + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        return sql;
    }

    @Override
    protected String getDeleteSqlStatement(String id) {
        final String sql;
        sql = "DELETE FROM " + TABLE + " WHERE idAdress = '" + id + "'";
        return sql;
    }

    @Override
    protected String getUpdateSqlPreparedStatement() {
        final String sql;

        sql = "UPDATE " + TABLE + " SET loginCustomerShipAdress = ?, loginCustomerBillAdress = ?, nameReceiverAdress = ?,"
                + " typeStreetAdress = ?, numAdress = ?, nameStreetAdress = ?, NAMESTEET2ADRESS = ?, zipcodeAdress = ?,"
                + " cityAdress = ?, countryAdress = ?, nameCompanyReceiverAdress = ? WHERE idAdress = ?";
        System.out.println(sql);

        return sql;
    }

    @Override
    protected String getSelectSqlStatement(String id) {
        final String sql;
        sql = "SELECT " + COLUMNS + " FROM " + TABLE + " WHERE idAdress = '" + id + "' ";
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
        sql = "SELECT " + COLUMNS + " FROM " + TABLE
                + " WHERE " + column + " = '" + champ + "'";
        return sql;
    }

    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "Adress";

    @Override
    protected DomainObject transformResultset2DomainObject(ResultSet resultSet) throws SQLException {
        final Address adress;
        adress = new Address(resultSet.getString(1));

        if (resultSet.getString(2) != null) {
            adress.setCustomerShipAdress(new Customer(resultSet.getString(2)));
        } else {
            adress.setCustomerShipAdress(null);
        }
        if (resultSet.getString(3) != null) {
            adress.setCustomerBillAdress(new Customer(resultSet.getString(3)));
        } else {
            adress.setCustomerBillAdress(null);
        }
        adress.setNameReceiverAdress(resultSet.getString(4));
        adress.setTypeStreetAdress(resultSet.getString(5));
        adress.setNumAdress(resultSet.getString(6));
        adress.setNameStreetAdress(resultSet.getString(7));
        adress.setNameStreet2Adress(resultSet.getString(8));
        adress.setZipcodeAdress(resultSet.getString(9));
        adress.setCityAdress(resultSet.getString(10));
        adress.setCountryAdress(resultSet.getString(11));
        if (resultSet.getString(12) != null) {
        adress.setNameCompanyReceiverAdress(new Company(resultSet.getString(12)));
        } else {
            adress.setNameCompanyReceiverAdress(null);
        }
        return adress;
    }

    @Override
    protected int executePreparedSt(PreparedStatement prestmt, DomainObject object) {
        int retour = 0;
        try {

            if (((Address) object).getCustomerShipAdress() != null) {
                prestmt.setString(1, ((Address) object).getCustomerShipAdress().getId());
            } else {
                prestmt.setString(1, null);
            }

            if (((Address) object).getCustomerBillAdress() != null) {
                prestmt.setString(2, ((Address) object).getCustomerBillAdress().getId());
            } else {
                prestmt.setString(2, null);
            }
            prestmt.setString(3, ((Address) object).getNameReceiverAdress());
            prestmt.setString(4, ((Address) object).getTypeStreetAdress());
            prestmt.setString(5, ((Address) object).getNumAdress());
            prestmt.setString(6, ((Address) object).getNameStreetAdress());
            prestmt.setString(7, ((Address) object).getNameStreet2Adress());
            prestmt.setString(8, ((Address) object).getZipcodeAdress());
            prestmt.setString(9, ((Address) object).getCityAdress());
            prestmt.setString(10, ((Address) object).getCountryAdress());

            if (((Address) object).getNameCompanyReceiverAdress() != null) {
                prestmt.setString(11, ((Address) object).getNameCompanyReceiverAdress().getId());
            } else {
                prestmt.setString(11, null);
            }

            prestmt.setString(12, ((Address) object).getId());

            retour = prestmt.executeUpdate();

        } catch (SQLException e) {
            // A Severe SQL Exception is caught
            displaySqlException(e);
            throw new DataAccessException("executePreparedSt : Cannot get data from the database: " + e.getMessage(), e);
        } catch (Exception ex) {
            ex.getStackTrace();
//       throw new Exception("executePreparedSt : Cannot get data from the database: " + ex.getMessage());            
        }

        return retour;
    }

    @Override
    protected String getCounterName() {
        return COUNTER_NAME;
    }

}
